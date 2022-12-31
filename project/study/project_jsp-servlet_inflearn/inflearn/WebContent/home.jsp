<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<style>
		* {
		    padding: 0px;
		    margin: 0px;
		}
		
		body {
		    width:1265px;
		    margin:0px auto;
		}
		#menu{
			align-content:center;
			position: relative;
			overflow: hidden;
		}
		#menu_login, #menu_button {
		    font-size: 20px;
		}
		#menu_login{
			float: right;
		}
		#menu_login a{
			text-decoration-line: none;
		}
		
		#menu_button{
			float: left;
		}
		#menu img{
			float: left;
		}

		#menu .item {
		    padding:0px 10px;
		}
		
		#menu .item a{
		    text-decoration-line: none;
		    color: #4a4a4a;
		    margin : 0px 10px;
		    font-size: 20px;
		}
		
		#menu .item a:hover{
		    font-weight: bold;
		    cursor: pointer;
		    color: green;
		}
		
	</style>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<link rel="stylesheet" href="/css/home.css">
	<meta charset="UTF-8">
	<title>인프런</title>
</head>
<body>
	<div id="menu">
		<span><img src="/img/Main/chuseok_logo.png" width="140px"></span>
		<span id="menu_button">
			<span class="item"><a href="">버튼1</a></span>
			<span class="item"><a href="">버튼2</a></span>
			<span class="item"><a href="/board/list">게시판</a></span>
			<c:if test="${userid != null}">
				<span class="item"><a href="/learn">내 강의실</a></span>
				
				<span class="item right">
					<span>${userid}님 환영합니다.</span>
					<a href="/logout">로그아웃</a>
				</span>
			</c:if>
			<c:if test="${userid == null}">
				<span id="menu_login">
					<a href="/login" id="login"><span>로그인</span></a>
					<a href="" id="legister"><span>회원가입</span></a>
				</span>
			</c:if>
		</span>
	</div>
	
	<div id="content">
		<jsp:include page="${pageName}"/>
	</div>
</body>
</html>