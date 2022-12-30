<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>파일 읽기</title>
</head>
<body>
<%
	BufferedReader reader = null;
	try {
		String filePath = application.getRealPath("/WEB-INF/input.txt");
		reader = new BufferedReader(new FileReader(filePath));
		while(true) {
			String str = reader.readLine();
			if(str == null) {
				break;
			}
			out.println(str + "<br>");
		}
		reader.close();
	} catch(Exception e) {
		out.println("파일을 읽을 수 없습니다.");
	}
%>
</body>
</html>