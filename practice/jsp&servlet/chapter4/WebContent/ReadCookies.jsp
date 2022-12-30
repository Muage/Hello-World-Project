<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<%
		String name = "";
		String gender = "";
		String age = "";
		
		for(Cookie cookie:request.getCookies()) {
			if(cookie.getName().equals("name")) {
				name = cookie.getValue();
			} else if(cookie.getName().equals("gender")) {
				gender = cookie.getValue();
			} else if(cookie.getName().equals("age")) {
				age = cookie.getValue();
			}
		}
	%>
		이름: <%= name %><br>
		성별: <%= gender %><br>
		나이: <%= age %><br>
	</body>
</html>
