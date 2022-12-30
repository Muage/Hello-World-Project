<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%
	String agree = request.getParameter("agree");
	String result = null;
	
	if(agree.equals("yes")) {
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("password");
		String name = (String)session.getAttribute("name");
		PrintWriter writer = null;
		try {
			String filePath = application.getRealPath("/WEB-INF/" + id + ".txt");
			writer = new PrintWriter(filePath);
			writer.println("아이디:" + id);
			writer.println("패스워드:" + password);
			writer.println("이름:" + name);
			result = "SUCCESS";
			writer.close();
		} catch(Exception e) {
			result = "FAIL";
		}
	}
	session.invalidate();	//세션 종료
	response.sendRedirect("Result.jsp?result=" + result);
%>