<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<body>
		<% String dbName = getInitParameter("DB_NAME"); %>
		데이터베이스 이름: <%= dbName %><br>
	</body>
</html>