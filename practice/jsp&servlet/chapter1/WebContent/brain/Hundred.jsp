<html>
<head>
	<title>Sum of 1 to 100</title>
</head>
<body>
<%
	int total = 0;
	for(int cnt =1; cnt <= 100; cnt++) {
		total += cnt;
	}
%>
	1 + 2 + 3 + ... + 100 = <%= total %>
</body>
</html>