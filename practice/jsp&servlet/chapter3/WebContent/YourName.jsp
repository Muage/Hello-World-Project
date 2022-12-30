<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>이름 입력</title>
</head>
<body>
	당신의 이름을 입력하세요.
	<form action="Hi.jsp" method="get">
		이름: <input type="text" name="yourname">
		<input type="submit" value="확인">
	</form>
</body>
</html>