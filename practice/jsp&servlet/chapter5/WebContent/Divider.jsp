<%
	String str1 = request.getParameter("num1");
	String str2 = request.getParameter("num2");
	int num1 = Integer.parseInt(str1);
	int num2 = Integer.parseInt(str2);
	int result = num1 / num2;
%>
<html>
	<head><title>나눗셈 프로그램</title></head>
	<body>
		<%= num1 %> / <%= num2 %> = <%= result %>
	</body>
</html>
