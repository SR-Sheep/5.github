<%@page import="java.util.ArrayList"%>
<%@page import="java.util.concurrent.ConcurrentHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.ktx.ddep.vo.Point"%>
<%@page import="com.ktx.ddep.dao.PointsDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.ktx.ddep.util.PaginateUtil"%>
<%@page import="com.ktx.ddep.dao.MembersDAO"%>
<%@page import="com.ktx.ddep.vo.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.ktx.ddep.vo.PageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>rank</title>
<c:import url="/WEB-INF/view/template/link.jsp"/>

<style>
.ranking {
	width: 1100px;
	margin: auto;
	font-weight: 700;
}

.ranking_header, .ranking_weekly, .ranking_total {
	position: relative;
	margin: 50px;
}

.ranking_header h3 {
	font-size: 24px;
	font-weight: 900;
}

.ranking_filter {
	position: absolute;
	margin-top: 10px;
	right: 0;
}

a {
	text-decoration: none;
	color: #3d3222;
}

.filter_radio {
	display: none;
}

.ranking_filter input+span {
	display: inline-block;
	border: 1px solid #dfdfdf;
	padding: 0 10px;
	text-align: center;
	width: 100px;
	height: 35px;
	line-height: 33px;
	cursor: pointer;
}

.ranking_filter input:checked+span {
	background-color: #cca872;
	box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	color: #fff;
	transition: .2s ease;
}

.this_week {
	height: 150px;
}

.this_week span {
	position: absolute;
	margin: 30px 0;
	font-size: 21px;
	right: 0;
}

.winnerPodium {
	margin-top: 100px;
	border-bottom: 2px solid #424242;
}

.ranker {
	position: absolute;
	text-align: center;
}

.member_nick {
	display: inline-block;
	margin-bottom: 10px;
}

.profile_img_ranker img {
	width: 150px;
	height: 150px;
	border: 3px solid #cca872;
	border-radius: 80px;
}

.member_info {
	width: 180px;
	background-color: rgba(255, 255, 255, .5);
	transform: translateY(20px);
	font-size: 20px;
}

.member_info .member_grade img {
	transform: translateY(5px);
	width: 30px;
	height: 30px;
}

.first_member {
	top: 45px;
	left: 410px;
	animation: downside 2s ease;
}

.second_member {
	top: 95px;
	left: 165px;
	animation: downside 2.5s ease;
}

.third_member {
	top: 145px;
	left: 655px;
	animation: downside 3s ease;
}

.first_member .symbol {
	background: url("/img/goldSymbol.png") no-repeat;
	background-size: 100%;
	top: -25px;
	left: -37px;
}

.second_member .symbol {
	background: url("/img/silverSymbol.png") no-repeat;
	background-size: 100%;
	top: -25px;
	left: -39px;
}

.third_member .symbol {
	background: url("/img/copperSymbol.png") no-repeat;
	background-size: 100%;
	top: -25px;
	left: -40px;
}

.symbol {
	width: 250px;
	height: 250px;
	position: absolute;
	z-index: -1;
}

.podium {
	background: url("/img/winnerPodium.png") no-repeat;
	background-size: 100%;
	position: relative;
	width: 800px;
	height: 508px;
	margin: 120px auto 0 auto;
	left: 5px;
	z-index: -2;
	transition: 1s ease;
	animation: upside 2s ease;
}

.ranking_card_box {
	position: relative;
	margin: 50px 0;
}

.ranking_card {
	float: left;
	text-align: center;
	position: relative;
	width: 210px;
	height: 210px;
	border: 2px solid #cca872;
	margin: 15px;
}

.ranking_card.me {
	border: 5px solid #424242;
	margin:12px;
	border-image: linear-gradient(to right, #ffeb24 0%, #cca872 100%);
	border-image-slice: 1;
	border-image-width: 5px;
	background-image: linear-gradient(-45deg, #ffee89, #ffee89, #ffee89, #fff, #ffee89,
		#ffee89, #ffee89);
}



.profile_img {
	margin-top: 25px;
}

.profile_img img {
	width: 100px;
	height: 100px;
	border: 2px solid #cca872;
	border-radius: 100px;
	object-fit: cover;
}

.member_point, .ranker .sum_point {
	font-size: 24px;
	color: #cca872;	
}


.member_point,.sum_point {
	display: block;
}

.ranking_card .ranking_num {
	position: absolute;
	width: 30px;
	height: 30px;
	font: 20px/30px sans-serif;
	color: #fff;
	left: -2px;
	top: -2px;
	background-color: #cca872;
	border: 2px solid #3d3222;
}

.ranking_card .member_info {
	transform: translateY(-5px);
	display: inline-block;
}

@keyframes upside {
 0%{transform: translateY(100px);	opacity: 0}
 100%{transform:translateY(0px);opacity:1}
 }
 
 @keyframes downside {
  0%{transform: translateY(-100px);	opacity: 0}
  100%{transform:translateY(0px);opacity:1}
  }
</style>


</head>
<body>
	<c:import url="/WEB-INF/view/template/header.jsp">
	<c:param name="type" value="ranking"></c:param>
	</c:import>
	<div class="ranking">
		<div class="ranking_header">
			<h3>
			<c:choose>
			  <c:when test="${loginMember!=null}">
				${myRank.nickname}의 랭킹은 ${myRank.rankNum}위 입니다.
	        </c:when>
	        <c:otherwise>
	        	당신의 랭킹은?
	        </c:otherwise>
			</c:choose>
			</h3>
			<div class="ranking_filter">
				<label for="weeklyRanking"> <a href="/rank/week"
					title="주간순"> <input type="radio" checked id="weeklyRanking"
						class="filter_radio" name="ranking" /> <span>주간순</span>
				</a>
				</label> <label for="totalRanking"> <a href="/rank/total/page/1"
					title="전체순"> <input type="radio" id="totalRanking"
						class="filter_radio" name="ranking" /> <span>전체순</span>
				</a>
				</label>
			</div>
			<!--ranking_filter end-->
		</div>
		<!-- ranking_header end-->

		<div class="ranking_weekly">
			<div class="this_week">
				<!-- 오늘이 포함된 주 보여주기 -->
				<span>${sun} ~ ${sat}</span>
			</div>

			<div class="winnerPodium">
				<c:forEach var="i" begin="0" end="2" step="1">				
				<a href="/mypage/${members[i].no}">
				<div
					class="<c:choose><%-- 
					--%><c:when test="${i=='0'}">first</c:when><%--
					--%><c:when test="${i=='1'}">second</c:when><%--
					--%><c:otherwise>third</c:otherwise><%--
				--%></c:choose><%--
					--%>_member ranker">
					<div class="symbol"></div>
						<div class="profile_img_ranker">
							<img src="/img/profileImg/${members[i].profileImg}"
								alt="${members[i].rankNum}등">
						</div>
						<!--profile_img_ranker end-->
	
						<div class="member_info">
							<span class="member_grade"> ${members[i].gradeImg}
							</span> <span class="member_nick"> ${members[i].nickname}
							</span> <span class="sum_point"> ${members[i].sumPoint}
								p
							</span>
						</div>					
					<!--member_info end-->
				</div>
				</a>
								
				</c:forEach><%--//winnerPodium end --%>
				<!--단상 이미지  -->					
				<div class="podium"></div>
			</div>
			<!--//winnerPodium-->
			
			<ul class="ranking_card_box">
				<!--210123 양 카드 정보 가져오기, 우선은 모든 리스트로 작업 -->
				<c:forEach var="j" begin="3" end="${fn:length(members)-1}">
				<a href="/mypage/${members[j].no}">
					<li class="ranking_card <c:if test="${loginMember!=null&&loginMember.no==members[j].no}">me</c:if> ">
						<div class="ranking_num">
							${members[j].rankNum}
						</div>
						<div class="profile_img">
							<img src="/img/profileImg/${members[j].profileImg}"
								alt="${members[j].rankNum}등">
						</div>
						<div class="member_info">
							<span class="member_grade"> ${members[j].getGradeImg()}</span>
							 <span class="member_nick"> ${members[j].nickname}</span>
							 <span class="member_point"> ${members[j].sumPoint}p</span>							
						</div>
						<!-- member_info end-->
					</li>
				</a>
				</c:forEach>				
			</ul>
			<!--//ranking_card_box end-->
		</div>
		<!--ranking_weekly-->
	</div>
	<!--ranking end-->   
	<c:import url="/WEB-INF/view/template/footer.jsp"/>
</body>
</html>

