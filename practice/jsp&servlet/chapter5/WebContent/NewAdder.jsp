<%@ page contentType="text/html;charset=euc-kr" errorPage="DataError.jsp" %>
<%
	String str1 = request.getParameter("num1");
	String str2 = request.getParameter("num2");
	int num1 = Integer.parseInt(str1);
	int num2 = Integer.parseInt(str2);
	int result = num1 + num2;
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>µ¡¼ÀÇÁ·Î±×·¥</title>
	</head>
	<body>
		<%= num1 %> + <%= num2 %> = <%= result %>
	</body>
</html>