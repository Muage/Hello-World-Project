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
	<title>내 학습</title>
</head>
<body>
	<div id="top">
		<img src="/image/label.png" width=300>
	</div>
	<div id="middle">
		<jsp:include page="${pageName}"></jsp:include>
	</div>
	<div id="bottom">
		<h5>Copyright 2022. 인천일보아카데미 All right Reserved.</h5>
	</div>
</body>
</html>