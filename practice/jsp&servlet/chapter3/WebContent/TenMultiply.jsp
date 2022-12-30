<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>1부터 10까지의 곱</title>
</head>
<!--  이건은 JSP에 의해 생성된 HTML 문서입니다. -->
<body>
<%
	int result = 1;	// 곱을 저장할 변수
	
	for(int cnt = 1; cnt <= 10; cnt++) {	//1부터 10까지 곱하는 반복문
		result *= cnt;
	}
%>
	1부터 10까지 곱한 값은? <%= result %>
</body>
</html>