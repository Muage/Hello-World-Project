<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<link rel="stylesheet" href="/css/home.css">
	<link rel="stylesheet" href="/css/lightbox.css">
	<title>홍길동의 홈페이지</title>
</head>
<body>
	<div id="top">
		<img src="/image/coupang.jpg" width=960>
	</div>
	<div id="menu">
		<span class="item"><a href="/">Home</a></span>
		<span class="item"><a href="/local/search">지역검색</a></span>
		<span class="item"><a href="/local/list">지역목록</a></span>
	</div>
	<div id="middle">
		<jsp:include page="${pageName}"></jsp:include>
	</div>
	<div id="bottom">
		<h5>Copyright 2022. 인천일보아카데미 All right Reserved.</h5>
	</div>
</body>
</html>
