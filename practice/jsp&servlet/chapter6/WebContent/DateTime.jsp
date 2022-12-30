<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%!
	private PrintWriter logFile;
	public void jspInit() {
		String fileName = "c:/data/datetime_log.txt";
		try {
			logFile = new PrintWriter(new FileWriter(fileName, true));
		} catch(Exception e) {
			System.out.printf("%TT - %s 파일을 열 수 없습니다. %n", new Date(), fileName);
		}
	}
%>
<html>
	<body>
	<%
		Date now = new Date();
		String date = String.format("현재날짜: %TY년 %Tm월 %Td일", now, now, now);
		String time = String.format("현재시각: %TI시 %TM분 %TS초", now, now, now);
		out.println(date + "<br>");
		out.println(time + "<br>");
		if(logFile != null) {
			logFile.printf("%TF %TT에 호출되었습니다. %n", now, now);
		}
	%>
	</body>
</html>
<%!
	public void jspDestroy() {
		if(logFile != null) {
			logFile.close();
		}
	}
%>