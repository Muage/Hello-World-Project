<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.addCookie(new Cookie("age", "16")); %>
<html>
	<head>
		<title>쿠키 데이터 수정하기</title>
	</head>
	<body>
		AGE 쿠키에 새로운 값이 저장되었습니다.
	</body>
</html>