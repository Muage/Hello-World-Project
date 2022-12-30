<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 글쓰기 - 결과 화면</title>
</head>
<body>
	<h2>글쓰기</h2>
	<%
		request.setCharacterEncoding("euc-kr");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = new Date();
		Long time = date.getTime();
		String fileName = time + ".txt";
		String result;
		PrintWriter writer = null;
		try {
			String filePath = application.getRealPath("/WEB-INF/" + fileName);
			//writer = new PrintWriter(filePath);
			writer.printf("제목: %s %n", title);
			writer.printf("글쓴이: %s %n", name);
			writer.println(content);
			//out.println(filePath);	// 파일 Path를 출력해 파일 생성 확인
			//out.println("저장되었습니다.");
			result = "SUCCESS";
			writer.close();
		} catch(Exception e) {
			result = "FAIL";
			out.println("파일에 데이터를 쓸 수 없습니다.");
		}
		response.sendRedirect("BBSPostResult.jsp?result=" + result);
	%>
</body>
</html>