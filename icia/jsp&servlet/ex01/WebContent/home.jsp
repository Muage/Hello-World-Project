<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<link rel="stylesheet" href="/style/home.css" type="text/css"/>
	<meta charset="UTF-8">
	<title>주소관리</title>
	
</head>
<body>
	<div id="top">
		<img src="https://via.placeholder.com/960x200">
	</div>
	<div id="menu">
		<span class="item"><a href="/">Home</a></span>
		<span class="item"><a href="/list">주소관리</a></span>
	</div>
	<div id="middle">
		<jsp:include page="${pageName}"/>
	</div>
	<div id="bottom">
		<h4>Copyright 2022. 인천일보아카데미 All right Reserved.</h4>
	</div>
</body>
</html>