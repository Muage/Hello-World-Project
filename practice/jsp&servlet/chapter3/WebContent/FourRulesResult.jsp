<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>사칙연산</title>
</head>
<body>
	덧셈의 결과는 <%= request.getAttribute("sum") %> <br>
	뺄셈의 결과는 <%= request.getAttribute("difference") %> <br>
	곱셈의 결과는 <%= request.getAttribute("product") %> <br>
	나눗셈의 결과는 <%= request.getAttribute("quotient") %> <br>
</body>
</html>