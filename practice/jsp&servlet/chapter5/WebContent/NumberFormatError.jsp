<%@ page contentType="text/html; charset=euc-kr" isErrorPage="true" %>
<% response.setStatus(200); %>
<html>
	<head><title>���� ���� ����</title></head>
	<body>
		�߸��� �����Ͱ� �ԷµǾ����ϴ�.<br><br>
		�� ���� �޽���: <%= exception.getMessage() %>
	</body>
</html>