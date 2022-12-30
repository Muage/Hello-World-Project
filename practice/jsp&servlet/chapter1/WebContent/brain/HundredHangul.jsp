<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head>
	<title>1부터 100까지의 합</title>
</head>
<body>
<%
	int total = 0;
	for(int cnt = 1; cnt <= 100; cnt++) {
		total += cnt;
	}
%>
	1부터 100까지 더한 값은? <%= total %>
<%
	total = 0;
	for(int cnt = 0; cnt <= 100; cnt = cnt+2) {
		total += cnt;
	}
%>
	1부터 100까지 짝수를 더한 값은? <%= total %>
</body>
</html>