<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head>
	<title>1���� 100������ ��</title>
</head>
<body>
<%
	int total = 0;
	for(int cnt = 1; cnt <= 100; cnt++) {
		total += cnt;
	}
%>
	1���� 100���� ���� ����? <%= total %>
<%
	total = 0;
	for(int cnt = 0; cnt <= 100; cnt = cnt+2) {
		total += cnt;
	}
%>
	1���� 100���� ¦���� ���� ����? <%= total %>
</body>
</html>