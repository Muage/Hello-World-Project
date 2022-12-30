<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<link rel="stylesheet" href="/css/home.css">
	<link rel="stylesheet" href="/css/lightbox.css">
	<title>홍길동의 쇼핑몰</title>
</head>
<body>
	<div id="top">
		<img src="/img/label.png" width=960>
	</div>
	<div id="menu">
		<span class="item"><a href="/">Home</a></span>
		<span class="item"><a href="/cart/list">장바구니</a></span>
		<c:if test="${uid == null}">
			<span class="item right"><a href="/user/login">로그인</a></span>
		</c:if>
		<c:if test="${uid != null}">
			<span class="item"><a href="/mall/list">업체목록</a></span>
			<span class="item"><a href="/pro/list">상품관리</a></span>
			<span class="item"><a href="/order/list">주문관리</a></span>
			<span class="item right">
				<span>${uid}님 환영합니다.</span>
				<a href="/user/logout">로그아웃</a>
			</span>
		</c:if>
	</div>
	<div id="middle">
		<jsp:include page="${pageName}"></jsp:include>
	</div>
	<div id="bottom">
		<h5>Copyright 2022. 인천일보아카데미 All right Reserved.</h5>
	</div>
</body>
</html>
