<%@ page contentType="text/html; charset=euc-kr" isErrorPage="true" %>
<% response.setStatus(200); %>
<html>
	<head><title>산술 연산 에러</title></head>
	<body>
		산술 연산 도중에 에러가 발생했습니다.<br><br>
		상세에러메시지: <%= exception.getMessage() %>
	</body>
</html>