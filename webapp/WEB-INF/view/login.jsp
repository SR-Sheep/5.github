<%@page import="com.ktx.ddep.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	Member loginMember = (Member)session.getAttribute("loginMember");
	//msg 저장하기
	String msg = (String)session.getAttribute("msg");
	//session에 msg 삭제
	session.removeAttribute("msg");
--%>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>로그인페이지</title>
    <c:import url="/WEB-INF/view/template/link.jsp"/>
    <style>
        body{
            font-family: "Noto Sans KR",sans-serif;
            /*(조에서) 지정한 폰트 색상*/
            color:  rgb(61, 50, 34);
        }
        #contents{
            width: 1100px;
            margin: auto;
            text-align: center;
        }
        #logo img{
            width:300px;
            
        }
        #id,#password{
            width: 350px;
            height: 40px;
        }
        #loginId{
            margin-top: 20px;
            margin-bottom: 20px;
        }
        button{
            border: white;

            font-size: 15px;
            width: 350px;
        }
        #logIn{
            color: white;
            height: 50px;
            background-color: rgb(204, 168, 114);
        }
        #register{
            height: 40px;
        }
        .login{
            margin: 20px;
            align-content: center;
        }
        .btn{
            margin-top: 5px;
        }
        #logIng{
            margin-right: 130px;
        }
        #resultLogin,.check{
            color: red;
        }
        
        
    </style>
</head>
<body>
<div id="contents">
    <div id="logo">
        <img src="img/logo.png"/>
    </div>
    <form action="/login" method="post">
    <!-- msg가 있으면 출력 -->
    <c:if test="${msg!=null}">
    <p id="resultLogin">${msg}</p>
    </c:if>
        <p id="loginId">
            <input type="text"  id="id" name="email" placeholder="ktganzi@gmail.com"/><br/>
            <span class="check_id check"></span>
        </p>
        <p>
            <input type="password" id="password"  name="password" placeholder="비밀번호를 입력해주세요"/><br />
            <span class="check_pass check"></span>
        </p>
        <p class="check">
        	
        </p>
        <p class="login" >
            <span id="logIng"><input type="checkbox" id="logging"/>로그인 상태 유지</span>
            <a href="passwordSearch.html">비밀번호 찾기</a>
        </p>
        
        
        <p class="btn"  >
            <button id="logIn" type="submit" class="btn btn-info" >로그인</button>
        </p>
        <p class="btn" >
            <button id="register" type="submit" class="btn btn-info" >회원가입</button>
        </p>
    </form>
</div>
</body>
<script src="js/jquery.js"></script>
<script>
    $("#id").on("blur",function (){
        idCheck();
    })

    $("#password").on("blur",function (){
        passCheck();
    })
    function idCheck() {
        const id = $("#id").val();
        if (id == "") {
            $(".check_id").text("아이디을 입력하세요.");            
            $("#logIn").attr("disabled",true);
        }
        else{
            $(".check_id").text("");
            $("#logIn").attr("disabled",false);
        }
    }
    function passCheck() {
        const password = $("#password").val();
        if (password == "") {
            $(".check_pass").html("비밀번호를 입력해주세요")            
            $("#logIn").disabled = true;
        }
        else{
            $(".check_pass").html("")
            $("#logIn").disabled = false;
        }
    }
    
    <%--메세지가 있을 시 출력--%>
    

</script>
</html>