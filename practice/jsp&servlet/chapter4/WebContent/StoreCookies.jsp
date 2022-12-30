<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Cookie[] cookies = request.getCookies(); %>
<%
	response.addCookie(new Cookie("name", "John"));
	response.addCookie(new Cookie("gender", "Male"));
	response.addCookie(new Cookie("age", "15"));
%>
<html>
	<head>
		<title>쿠키 데이터 저장하기</title>
	</head>
	<body>
		쿠키 데이터가 저장되었습니다.
	</body>
</html>
