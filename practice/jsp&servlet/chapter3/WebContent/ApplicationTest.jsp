<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>application 내장 변수의 사용 예</title>
</head>
<body>
<%
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("/Intro.html");
%>
	웹 애플리케이션의 URL 경로명: <%= appPath %> <br>
	/Intro.html의 파일 경로명: <%= filePath %> <br>
</body>
</html>