<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웹 애플리케이션의 초기화 파라미터</title>
	</head>
	<body>
		데이터베이스이름: <%= application.getInitParameter("DB_NAME") %><br>
	</body>
</html>