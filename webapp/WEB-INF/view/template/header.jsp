<%@page import="com.ktx.ddep.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <div id="header">
        <ul>
            <li><a href="" class="menu <c:if test="${param.type=='market' }">active</c:if>" title="장터" >장터</a></li>
            <li><a href="/recipe" class="menu <c:if test="${param.type=='recipe' }">active</c:if>"  title="레시피" >레시피</a></li>
            <li><a href="/rank/week" class="menu <c:if test="${param.type=='ranking' }"> active</c:if>" title="랭킹" >랭킹</a></li>
            <li><a href="" title="장터지기" class="menu <c:if test="${param.type=='keeper' }">active</c:if>" >장터지기</a></li>
		<div class="right">
		
			<c:choose>
			<c:when test="${loginMember!=null}">
			<a class="circle recipe_regist" title="레시피 작성하기"
				href="/recipeRegisterPage.jsp"><i class="fas fa-pen"></i></a> <span
				class="circle user"><img class="circle_user_img"
				src="/img/profileImg/${loginMember.profileImg}"></span>			
			</c:when>
			<c:otherwise>
			<a id="login" href="/login">로그인</a>
			</c:otherwise>
			</c:choose>
		</div>
	</ul>
        <span class="logo"><a href="/index"><img src="/img/logo.png"/></a></span>
        <c:if test="${loginMember!= null}">
	        <div class="right user_menu hidden">
	            <div class="user_menu_item"><a href="/mypage/${loginMember.no}">마이페이지</a></div>
	            <div class="user_menu_item"><button form="logoutForm">로그아웃</button></div>
	            <form action="/log" method="post" id="logoutForm">
					<input type="hidden" name="_method" value="DELETE"> 
				</form>
	        </div>
        </c:if>
    </div><!-- header end-->
<script src="/js/jquery.js"></script>
<script>

    //유저 프로필을 누르면 메뉴 나오기

    $(".circle.user").on("click",function (){
        $(".user_menu").toggleClass("hidden");
    })//click end

    //메뉴 밖을 누르면 메뉴 사라지기
    $("body").on("click",function (e){
        let $tgPoint = $(e.target);
        const $popCallBtn = $tgPoint.hasClass('circle_user_img');
        const $popArea = $tgPoint.hasClass('user_menu');
        const $popArea2 = $tgPoint.hasClass('user_menu_item');

/*
        console.log(!$popCallBtn && !$popArea)
        console.log("btn : "+$popCallBtn)
        console.log("div : "+$popArea)
        console.log("div : "+$popArea2)
*/
   
         if ( !$popCallBtn && !$popArea && !$popArea2 ) {
             $(".user_menu").addClass('hidden');

         }
     })//click end

</script>
