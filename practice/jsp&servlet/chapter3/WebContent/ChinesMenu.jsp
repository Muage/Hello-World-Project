<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>오늘의 메뉴</title>
</head>
<body>
	<h3>오늘의 메뉴</h3>
	- 짜장면 <br>
	- 볶음밥 <br>
	- 짬뽕 <br>
	<%
		out.flush();	//HTML 코드 올바른 순서로 출력하기 위한 메서드
		RequestDispatcher dispatcher = request.getRequestDispatcher("Now.jsp");
		dispatcher.include(request, response);
	%>
</body>
</html>