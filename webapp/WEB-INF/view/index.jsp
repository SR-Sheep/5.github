<%@page import="com.ktx.ddep.vo.Member"%>
<%@page import="com.ktx.ddep.vo.Point"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.ktx.ddep.dao.RcpRvsDAOImpl"%>
<%@page import="com.ktx.ddep.dao.MembersDAO"%>
<%@page import="com.ktx.ddep.dao.RcpsSavedDAO"%>
<%@page import="com.ktx.ddep.dao.RcpsDAOImpl"%>
<%@page import="com.ktx.ddep.vo.Rcp"%>
<%@page import="java.util.List"%>
<%@page import="com.ktx.ddep.vo.PageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%--
    /* ==========장터 카드에서 사용============  */
            	
           		int no = 2;
            	
            	//파라미터 no 받기
        	   	String noStr=request.getParameter("no");
            
            	if(noStr != null) {
            			//int형으로 형변환
        	   		 no = Integer.parseInt(noStr);
        	   		
            	} else {
            		no = 2;
            		//no로 member 정보 받기
            	}
        	 
        	   		Member member = membersDAO.selectOne(no);
            
            	/* ==========레시피 카드에서 사용============  */
            	
            	//기본값 1
        		int pageNo = 1;		
        		//한 페이지당 보여줄 게시물
        		int numPage = 12;		
        	 	//pageVO 객체 생성 -> start, end 값
        		PageVO pageVO = new PageVO (pageNo,numPage);	
        		// 모든 레시피 목록 불러오기
        		List<Rcp> rcps = rcpsDAO.selectList(pageVO);	
        		//모든 레시피 수 불러오기
        		int rcpsNum = rcpsDAO.countRcps();
        		
        		/* ==========랭킹 카드에서 사용============  */
        		
        		//저번주 날짜 가져오기
        		Calendar cal = Calendar.getInstance();
        		cal.add(Calendar.DATE, -7);
        		SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");		
        		//저번주 토요일 얻기
        		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        		String sat = dateFmt.format(cal.getTime()).toString();		
        		//저번주 일요일 얻기
        		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        		String sun = dateFmt.format(cal.getTime()).toString();		
        		//주간 랭킹을 위한 객체 생성, 원래는 시작시간을 mon으로 넣어야 하지면 현재 데이터를 가져오기 위해 강제로 210101로 설정
        		Point point =new Point("2021-01-01",sat);
        		//객체 생성
        		List<Member> members = membersDAO.selectWeeklyRankList(point);
        		//순위 마지막을 가져오기
        		int lastRanking;
        		//100명이 넘으면 최대 사이즈 100명, 나머지 경우 멤버 최대한 보여주기
        		if(members.size()>13){
        	lastRanking=12;
        		}else{
        	lastRanking=members.size();
        		}//if~else end
    --%>
   
    <!-- 21-02-12 이소현 _ 메인 페이지 (시작)  -->
<!DOCTYPE html>
<html>
<head>
  
<meta charset="UTF-8">
<title>아나바다</title>

 	<c:import url="/WEB-INF/template/link.jsp"/> 	
    <link rel="stylesheet" href="css/paginate.css">
	<style>
		body {
			font-family:"Noto Sans KR", sans-serif;
		}
	   #msg {
			position:fixed;
			top:0;		
			width: 100%;		
			background-color: rgba(0,0,0,.6);
			font-size: 50px;
			text-align:center;
			color:#fff;
		}		
		
		/* 전체 감싸는 wrap*/
        .contents_wrap {
            /* 자식(히어로 이미지) 가운데 정렬 */
            text-align: center;
        }

        /* =============================히어로 이미지 + 소개글 부분=============================*/
        .hero_img_content {
            position: relative;

            width: 1100px;
            margin: 0 auto 60px auto;
        }
        #heroImg {
			width: 1100px;
			margin: auto;
		}
        /* 소개글 wrap */
        .introduction_wrap {
            position: absolute;
            width: 385px;
            height: 215px;
            line-height: 150%;
            text-align: left;
            background-color: rgba(0,0,0,.75);
            bottom: 10px;
            left: 20px;
            color: #fff;
            font-size: 36px;
            font-weight: 700;
            padding-left: 10px;
        }
        /* 소개글 포인트 글자  */
        .introduction_point_text {
            color: #b89878;
            text-shadow: 2px 2px #e0e0e0;
        }

        /* ============================장터 / 레시피 / 랭킹 공통 css===============================*/

        .content_title{
            font-size: 24px;
            font-weight: 600;
            padding:12px 15px;
            float: left;
        }
        .view_more {
            float: right;
            padding: 15px 10px;
            cursor: pointer;
        }
        .view_more:hover {
            color: #b89878;
        }
        /* 화살표 버튼 공통 css */
        .btn {
            width: 40px;
            height: 40px;
            font-size: 30px;
            position: absolute;

            background-color: transparent;
            cursor: pointer;
        }
        .prev_btn {
            left: 10px;
        }
        .next_btn {
            right: 5px;
        }


        /* ======================================장터======================================== */
        .market_wrap {
            width: 1100px;
            height: 405px;
            background-color: #f3f3f3;
            margin: auto;
            position: relative;
        }
        .market_contents {
            width: 1000px;
            height: 400px;
            overflow: hidden;
            margin: auto;
            position: relative;

        }
        .market_content_head {
            overflow: hidden;
        }
        .market_content_body {
            margin: auto;
            width: 3000px;
            left: 0;
            /*background-color: orange;*/
            transition: .2s ease;
            position: absolute;
        }
        .btn.market {
        	top: 200px;
        }
        /*------------마켓 네임카드------------*/
        .market_card {
            width: 316px;
            height: 318px;
            background-color: white;
            margin: 20px 12px 25px 13px;
            float: left;
            cursor: pointer;
            transition: .2s ease;
        }
        .market_card:hover {         
            box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            transform : scale(1.01);
        }
        /*네임카드 이미지*/
        .market_card_img {
            width: 316px;
            height: 180px;
        }
        /*네임카드 장소 이름*/
        .market_card_name {
            /**/
            font-size: 25px;
            font-weight: 600;
            text-align: center;
            margin: 5px 0;
            height: 38px;
            /*background-color: green;*/
            line-height: 38px;
        }
        .market_card_market_time_wrap {
        	text-align:center;
        }
        /*네임카드 장터 시간대*/
        .market_card_market_time {
            height:34px;
            line-height: 34px;
            text-align: center;
            /*background-color: white;*/
            color: #cca872;
            display:inline-block;
        }
        /*네임카드 장터지기 정보*/
        .market_card_marketkeeper {
            width: 215px;
            height: 42px;
            line-height: 42px;
            /*background-color: orange;*/
            margin: auto;
            text-align: center;
            display: flex;
        }
        /*유저 프로필 이미지*/
        .user_profile_img {
            width: 35px;
            height: 35px;
            border-radius: 100%;
            padding-top: 1px; 
            /*top: -5px;*/
        }
        /*유저 닉네임*/
        .user_nick_name {
            width: 132px;
            height: 42px;
            line-height: 42px;
            text-align: center;
            font-size: 18px;
        }
        /*장터지기 서비스 지수*/
        .marketkeeper_service_idx{
            width: 52px;
            height: 42px;
            /*text-align: center;*/
            margin: 2px auto 0 auto;
            float: right;
            /*background-color: orange;*/
        }
        .service_idx_name {
            font-size: 10px;
            width: 49px;
            height: 10px;
            line-height: 10px;
            text-align: center;
            border-bottom: 2px solid #3d3222;
        }
        .service_idx_value {
            width: 36px;
            height: 25px;
            /*text-align: center;*/
            line-height: 25px;
            font-size: 25px;
            /* 서비스 지수 값 가운데 정렬*/
            margin: auto;
        }
        .market_card_a {
            text-decoration: none;
            color: #3d3222;
        }
        /*===============================================레시피 part==============================================*/
                
        .recipe_wrap {
            margin: 55px auto;
            width: 1100px;
            height: 360px;
            background-color:#f3f3f3;
            position: relative;                  
        }
        .recipe_contents {
        	width: 1000px;
            height: 350px;
            overflow: hidden;
            margin: auto;
            position: relative;
        }
        .recipe_content_head {
        	overflow: hidden;
        }
         .recipe_content_body {
        	width:3195px;
        	height: 300px;
        	margin:auto;
        	position:absolute;
        	left: 0;
        	clear:both;
        }
        .btn.recipe {
        	top: 160px;
        }
        /* ----------------레시피 네임 카드 + 관련 친구들------------------ */
		
		.recipe_wrap .recipe_box {
			display: inline-block;
			position : relative;
			margin: 20px 10px;
			width: 225px;
			box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);
			transition : .2s ease;
			background-color: #fff;	
		}
		
		.recipe_box:hover {
			box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 10px 10px 0 rgba(0, 0, 0, 0.12);
			transform : scale(1.01);
		}				
		.recipe_img {
			width: 225px;
			height: 180px;
		}		
		.recipe_box>h3 {
			font-size: 14px;
		}		
		.recipe_box>h3>img {
			width: 25px;
			height: 25px;
			border-radius: 50%;
		}		
		.recipe_number, .recipe_price {
			margin-right: 30px;
			float: left;
			height: 40px;
		}
		.recipe_title_wrap, .recipe_box .profile_wrap {
			position : relative;
			display:table;
			width: 225px;
			overflow: hidden;
			height: 42px;
		}		
		.title_area, .profile_area {
			width:130px;
			display:table-cell;
			padding: 10px 0 10px 10px;
		}
		
		.subtitle {
			font-size: 12px;
			margin-bottom: 5px;
			color : #424242;
		}
		
		.title {
			font-size: 15px;
			font-weight: 600;
		}		
		.rate_area, .recipe_area {
			display:table-cell;
			vertical-align : middle;
			text-align:center;
			padding: 5px;
		}		
		.rate_area img {
			width: 30px;
			float: left;
		}	
		.rate_point {
			color: goldenrod;
			line-height: 25px;
		}		
		.profile_img {
			border: 1px solid #b89878;
			width: 28px;
			border-radius: 50%;
			float: left;
			position: relative;
		}		
		.profile_name {
			font-size: 12px;
			line-height: 30px;
			margin-left: 5px;
		}
		/* 리본 안 글씨 */
		.ribbon_font {
			font-size: 10px;
			width: 30px;
			height: 30px;
			line-height: 10px;
			/*background-color: yellow;*/
			text-align: center;
			position: absolute;
			/*top: 10%;*/
			/*left: 0;*/
			color: #fff;
			top: 0px;
			left: -15px;
		}
		/* 리본 */
		/* 양 수정 */
		.cheap3 {
			position: relative;
			margin-left: 30px;
		}		
		.cheap3 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}
		/* 양 수정 부분 끝 */
		.cheap2 {
			position: relative;
			margin-left: 30px;
		}		
		.cheap2 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}	
		.cheap1 {
			position: relative;
			margin-left: 30px;
		}		
		.cheap1 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}		
		.comfort3 {
			position: relative;
			margin-left: 30px;
		}		
		.comfort3 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}		
		.comfort2 {
			position: relative;
			margin-left: 30px;
		}		
		.comfort2 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}		
		.comfort1 {
			position: relative;
			margin-left: 30px;
		}		
		.comfort1 img {
			position: absolute;
			top: -10px;
			left: -15px;
			width: 30px;
			height: 60px;
		}	
		.ribbon{
		    display: inline-block;
		    position: relative;
		    float: right;
		}
		
		.ribbon img{
		    width: 40px;
		}
		
		.ribbon_wrap{
		    position : absolute;
		    right: 0;
		    top:0;
		}
		
		.view_area, .scrap_area{
			display: table-cell;
			vertical-align:middle;
			font-size: 12px;
			text-align: center;		
		}
		
		.view_area i, .scrap_area i{
			color :  #cca872		
		}
		
		.view_area div, .scrap_area div{
			margin: 5px;
		}
		
		.profile_area a:hover{
			text-decoration: underline;
			font-weight: 700;
		}
        /* ===========================================랭킹 part=================================================== */
        .ranking_wrap {
            margin: auto;
            width: 1100px;
            height: 280px;
            background-color: #f3f3f3;
            font-weight: 700;
            position: relative;
        }
        
        .ranking_contents{
        	width: 1000px;
            height: 280px;
            overflow: hidden;
            margin: auto;
            position: relative;
        }
        .ranking_content_head {
        	overflow: hidden;
        }
        .ranking_content_body {
        	position:absolute;
        	left: 0;
        }
         .btn.ranking {
        	top: 140px;
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
			background-color: #fff;
			transition: .2s ease;
		}
		.ranking_card:hover {
			transform : scale(1.01);	
		}
		.ranking_card.me {
			border: 5px solid #424242;
			margin:12px;
			border-image: linear-gradient(to right, #ffeb24 0%, #cca872 100%);
			border-image-slice: 1;
			border-image-width: 5px;
			background-image: linear-gradient(-45deg, #ffee89, #ffee89, #ffee89, #fff, #ffee89, #ffee89, #ffee89);
		}			
		.ranking_profile_img {
			margin-top: 25px;
		}		
		.ranking_profile_img img {
			width: 100px;
			height: 100px;
			border: 2px solid #cca872;
			border-radius: 100px;
			object-fit: cover;
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
	</style>
</head>
<body>

	<c:import url="WEB-INF/template/header.jsp"/>

	

	<!-- ========================히어로 이미지 + 소개글 part==================================== -->
    <div class="contents_wrap">
        <div class="hero_img_content">
            <img id="heroImg" src="img/mainImg/mainImg.jpg">

            <div class="introduction_wrap">
                <p><span class="introduction_point_text">아</span>까운 재료</p>
                <p>남은 재료는 <span class="introduction_point_text">나</span>눠 갖고</p>
                <p>포인트는 <span class="introduction_point_text">바</span>꿔 쓰고</p>
                <p>요리는 <span class="introduction_point_text">다</span>양하게 해 먹자</p>
            </div><!-- .introduction end-->
        </div><!-- .hero_img_content end-->

    </div><!-- .contents_wrap end-->

    <!-------------------------장터 네임카드 part-------------------------------->
    <div class="market_wrap">
        <button class="btn market prev_btn"><i class="fas fa-chevron-left"></i></button>
        <button class="btn market next_btn"><i class="fas fa-chevron-right"></i></button>

        <div class="market_contents">
            <div class="market_content_head">
                <div class="content_title">장터</div>
                <div class="market view_more" onclick="location.href='/marketList.jsp';">더보기</div>
            </div>

            <div class="market_content_body">

            	<!-- 장터 네임 카드 -->
           	 	<script type="text/template" id="marketCardTmpl">
        		<@ _.each(marketCardList,function(marketCard) { @>
				<div class="market_card">
					<div class="market_card_container"> 
						<input type="hidden" id="marketNo" value="<@=marketCard.MARKETNO@>"/>
               	 		<img class="market_card_img" src="img/marketImg/<@=marketCard.IMG@>"/>
                		<div class="market_card_name"><@=marketCard.NAME@></div>
						<div class="market_card_market_time_wrap">
							<@ _.each(marketCard.TIMES,function(time) { @>
                			<div class="market_card_market_time"><@=time.perfectTime@> </div>
							<@})@>
						</div><!-- .market_card_market_time_wrap end-->
                		<div class="market_card_marketkeeper">
                    		<img src="img/<@=marketCard.PROFILEIMG@>" class="user_profile_img">
                    		<span class="user_nick_name"><@=marketCard.NICKNAME@></span>
                    		<dl class="marketkeeper_service_idx">
                        		<dt class="service_idx_name">서비스 지수</dt>
                        		<dd class="service_idx_value"><@=marketCard.SERVICEIDX@></dd>
					 		</dl><!-- .marketkeeper_service_idx end-->
                		</div><!-- .market_card_marketkeeper end-->  
					</div><!--.market_card_container end--> 	
				</div><!--.market_card_a end-->			
   			<@ })@>             
        	</script>
        	
	 		</div><!-- .market_content_body end-->
        </div><!-- .market_contents end-->
    </div><!-- .market_wrap end-->


	<!-- =========================================레시피 part======================================== -->

    <div class="recipe_wrap">
     	<button class="btn recipe prev_btn"><i class="fas fa-chevron-left"></i></button>
        <button class="btn recipe next_btn"><i class="fas fa-chevron-right"></i></button>
    	<div class="recipe_contents">
	        <div class="recipe_content_head">
	            <div class="content_title">레시피</div>
	            <div class="recipe view_more" onclick="location.href='/recipeListPage.jsp';">더보기</div>
	        </div><!-- .recipe_content_head end-->
	        <div class="recipe_content_body">
	        		
			<%--
	        					for(Rcp rcp : rcps){
	        							    //210129 레시피 작성자 정보 불러오기
	        								Member writer= membersDAO.selectOne(rcp.getMemberNo());
	        							    //210130 레시피 요리후기 갯수 불러오기
	        							    int recipeRv = rcpRvsDAOImpl.countSelectRv(rcp.getNo());
	        					--%>
				<div class="recipe_box">
					<%--<a href="/recipeDetail.jsp?no=<%=rcp.getNo()%>">
						<img class="recipe_img" src="/img/recipeImg/<%=rcp.getImg() %>" />
						<div class="recipe_title_wrap">					
							<div class="title_area">
								<p class="subtitle">8200p로 만드는</p>
								<h3 class="title"><%=rcp.getTitle() %></h3>
							</div><!--title_area end-->								
							<div class="rate_area">
								<img src="/img/golden_egg.png" />
								<span class="rate_point"><%=rcp.getRcpsAvg() %>%</span>
							</div><!--rate_area end-->
						</div><!--.recipe_title_wrap end-->
					</a>					
					<div class="profile_wrap">
						<div class="profile_area">
							<a href="/mypageHeader.jsp?no=<%=rcp.getMemberNo()%>">
								<img src="/img/profileImg/<%=writer.getProfileImg()%>" class="profile_img"> 
								<span class="profile_name"><%=writer.getNickname() %></span>
							</a>
						</div><!-- profile_area end -->
						<div class="view_area">
							<i class="fas fa-eye"></i><span><%=rcp.getViewCount() %></span>
						</div><!-- view_area end -->
						<div class="scrap_area">
							<i class="fas fa-bookmark"><%=rcpsSavedDAO.count(rcp.getNo()) %></i>
						</div><!-- scrap_area end -->
					</div><!-- profile_wrap end -->
					<div class="ribbon_wrap">
						<div class="easy ribbon">--%>
						<%-- if(rcp.getItemCount()<4) { --%>
							<img src="img/ribbon4Easy3.png">						
						<%-- } else if(rcp.getItemCount()<6) { --%>
							<img src="img/ribbon5Easy2.png">
						<%-- } else if(rcp.getItemCount()<8) { --%>
							<img src="img/ribbon6Easy1.png">						
						<%-- } //if~else if~else if end --%>
	                     </div><!--easy ribbon end-->
	                 </div><!--ribbon_wrap end-->				
				</div><!-- .recipe_box end -->
				<%-- } //for end --%>
	        
	        </div><!-- .recipe_content_body end-->
        </div><!-- .recipe_contents end-->
    </div><!-- .recipe_wrap end-->

    <!-- ============================================랭킹 part=============================================== -->
    <div class="ranking_wrap">
    	<button class="btn ranking prev_btn"><i class="fas fa-chevron-left"></i></button>
        <button class="btn ranking next_btn"><i class="fas fa-chevron-right"></i></button>
    	<div class="ranking_contents">
	        <div class="ranking_content_head">
	            <div class="content_title">랭킹</div>
	            <div class="ranking view_more" onclick="location.href='/rankingWeekly.jsp';">더보기</div>
	        </div><!-- .ranking_content_head end-->
	        <div class="ranking_content_body">
				<%--
				<% for (int j = 0; j < lastRanking; j++) {	%>
				<a href="/mypageHeader.jsp?no=<%=members.get(j).getNo()%>">
					<div class="ranking_card">						
						<div class="ranking_num">
							<%=members.get(j).getRankNum()%>
						</div><!-- ranking_num end-->
						<div class="ranking_profile_img">
							<img src="/img/profileImg/<%=members.get(j).getProfileImg()%>"
								alt="<%=members.get(j).getRankNum()%>등">
						</div><!-- ranking_profile_img end-->
						<div class="member_info">
							<span class="member_grade"> <%=members.get(j).gradeImg()%></span>
							 <span class="member_nick"> <%=members.get(j).getNickname()%></span>
							 <span class="member_point"> <%=members.get(j).getSumPoint()%>p</span>							
						</div><!-- member_info end-->
					</div><!-- ranking_card end-->
				</a>
				<% } // for end %>
				--%>	
	        </div><!-- .ranking_content_body end-->
        </div><!-- .ranking_contents end-->
    </div><!-- .ranking_wrap end-->
	 
<!-- ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■여기서부터는 자바스크립트 구역■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■  -->
	<c:import url="WEB-INF/template/footer.jsp"/>
<c:if test="${msg!=null}">
<!-- msg 있으면 출력 -->	
<div id="msg">${msg}</div>
</c:if>
<script>

	// 언더스코어는 기본적으로 %을 사용하는데 %는  jsp에서 사용할 수 없기 때문에 % -> @ 로변경하는 코드가 필요함
	_.templateSettings = {interpolate : /\<\@\=(.+?)\@\>/gim, evaluate : /\<\@([\s\S]+?)\@\>/gim, escape : /\<\@\-(.+?)\@\>/gim};

	/* ==================================메세지 구역========================================== */
		
		<!-- 헤더에서 자바스크립트 불러와서 딱히 제이쿼리 데려오지는 않음 -->		
		
		<c:if test="${msg!=null}">
		
			const wHeight=$(window).height();	
			
			//line-height에 브라우저의 height 값 지정
			$("#msg").css("line-height",wHeight+"px");
			
			//0.9초동안 msg 보여줌
			setTimeout(function(){
				$("#msg").fadeOut(100);	
			},900);
			
		</c:if>
	
	 /* ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇장터 구역 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ */
	
	 //21-02-13 이소현
    /* ------------------화살표 누르면 이동 - 장터 구역----------------------*/

    let left = 0;

	/* 오른쪽 화살표 버튼 클릭 시  */
    $(".market.next_btn").on("click",function () {
        //alert("됐다");

        left -= 1030;

        if(left==-3090) {
            left = 0;
        }//if end
        
        $(".market_content_body").css("left",left);

    });//.market.next_btn click() end

    /* 왼쪽 화살표 버튼 클릭 시 */
    $(".market.prev_btn").on("click",function () {
        //alert("됐다");

        //여기 문제점이 맨 left 가 0일 때 왼쪽으로 가면 안되는데, 가버려ㅠㅠㅠㅠㅠㅠㅠㅠ

        if(left>0) {
            left=0

        } else {
            left += 1030;

            $(".market_content_body").css("left",left);
        }
    });//.market.prev_btn click() end
    
    /* =============================장터 네임카드 템플릿======================================== */
       
		const $marketContentBody = $(".market_content_body");
		const $marketCardContainer = $(".market_card_container");
		const $marketCard = $(".market_card");
		const marketCardTmpl = _.template($("#marketCardTmpl").html());
		
		/* 함수 호출 */
		getMaketList();
		
		/* ------------유저의 정보로, ajax 를 이용해서 같은 지역의 장터 목록 나타냄-----  */
		function getMaketList() {
			console.log("함수까지는 들어왓니?");
			$.ajax({
				url : "/ajax/getMarketList.json",
				dataType : "json",
				type : "get",
				data : {
					<%--
					sido : "<%=member.getSido()%>",
					gugun : "<%=member.getGugun()%>",
					dong : "<%=member.getDong()%>"
					--%>
				},
				error : function(xhr) {
					alert("서버 점검 중입니다.");
				}, //error end
				success : function(json) {	

					//장터 네임카드 값 비우기
					$marketContentBody.empty();
						
					//장터 네임카드 템플릿 적용
					$marketContentBody.append(marketCardTmpl({marketCardList : json.marketList}));
																					
				} //success end
			});//$.ajax() end
		}//getMarketList() end	
		

	/* ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇레시피 구역 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ */
	
	  /* ------------------화살표 누르면 이동 - 레시피 구역----------------------*/

       let rLeft = 0;

	/* 오른쪽 화살표 버튼 클릭 시  */
    $(".recipe.next_btn").on("click",function () {
        //alert("됐다");
 		
    
 		
        rLeft -= 995;

        if(rLeft==-2985) {
        	rLeft = 0;
        }//if end
        
        $(".recipe_content_body").css("left",rLeft);

    });//.market.next_btn click() end

    /* 왼쪽 화살표 버튼 클릭 시 */
    $(".recipe.prev_btn").on("click",function () {

        if(rLeft>0) {
        	rLeft=0

        } else {
        	rLeft += 995;

            $(".recipe_content_body").css("left",rLeft);
        }
    });//.market.prev_btn click() end
    
    
    /* ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇랭킹 구역 ◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇◇ */
	
     /* ------------------화살표 누르면 이동 - 랭킹 구역----------------------*/

    let rankingLeft = 0;

	/* 오른쪽 화살표 버튼 클릭 시  */
    $(".ranking.next_btn").on("click",function () {
        //alert("됐다");

        rankingLeft -= 975;

        if(rankingLeft==-2925) {
        	rankingLeft = 0;
        }//if end
        
        $(".ranking_content_body").css("left",rankingLeft);

    });//.market.next_btn click() end

    /* 왼쪽 화살표 버튼 클릭 시 */
    $(".ranking.prev_btn").on("click",function () {

        if(rankingLeft>0) {
        	rankingLeft=0

        } else {
        	rankingLeft += 975;

            $(".ranking_content_body").css("left",rankingLeft);
        }
    });//.market.prev_btn click() end
	
   
</script>
</body>
</html>