<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>1부터 10까지 순서대로</title>
</head>
<body>
	<h3>1부터 10까지 순서대로</h3>
	<% for(int cnt = 1; cnt <= 10; cnt++) { %>
		<%= cnt %><br>
	<% } %>
	
	<h3>1부터 10까지 순서대로 - out 내장 변수 사용</h3>
	<%
		for(int cnt = 1; cnt <= 10; cnt++) {
		out.println(cnt + "<br>");
		}
	%>
</body>
</html>