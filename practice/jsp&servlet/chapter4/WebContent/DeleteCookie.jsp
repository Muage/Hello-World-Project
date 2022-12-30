<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("gender", "");
	cookie.setMaxAge(0);	//1시간 후 쿠키가 지워지도록 하기 위한 명령어 : cookie.setMaxAge(3600), 초단위로 입력
	response.addCookie(cookie);
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>쿠키 삭제하기</title>
	</head>
	<body>
		GENDER 쿠키가 삭제되었습니다.
	</body>
</html>