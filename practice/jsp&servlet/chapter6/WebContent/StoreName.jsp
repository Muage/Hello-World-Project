<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	application.setAttribute("name", name);
%>
<html>
	<head><title>웹 애플리케이션 데이터 저장하기</title></head>
	<body>
		NAME 데이터가 저장되었습니다.
	</body>
</html>