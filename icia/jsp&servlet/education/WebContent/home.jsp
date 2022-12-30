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
	<title>학사관리시스템</title>
</head>
<body>
	<div id="top">
		<img src="/img/label.png" width=960>
	</div>
	<div id="menu">
		<span class="item"><a href="/">Home</a></span>
		<span class="item"><a href="/pro/list">교수관리</a></span>
		<span class="item"><a href="/stu/list">학생관리</a></span>
		<span class="item"><a href="/cou/list">강좌관리</a></span>
	</div>
	<div id="middle">
		<jsp:include page="${pageName}"></jsp:include>
	</div>
	<div id="bottom">
		<h5>Copyright 2022. 인천일보아카데미 All right Reserved.</h5>
	</div>
</body>
</html>
