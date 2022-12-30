<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웹 애플리케이션 데이터 조회하기</title>
	</head>
	<body>
		이름: <%= application.getAttribute("name") %>
	</body>
</html>