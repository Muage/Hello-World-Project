<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>인사하기</title>
	</head>
	<body>
		안녕하세요, <%= request.getParameter("NAME") %>님
		<% application.log("[인사하기] JSP 페이지가 호출되었습니다."); %>
	</body>
</html>