<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page buffer= "4kb" %>	<!-- 버퍼 거치지 않고 웹브라우저 바로 전송하려면 buffer 애트리뷰트에 none값 저장  -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>출력 버퍼의 크기 지정</title>
</head>
<body>
	출력 버퍼의 크기 : <%= out.getBufferSize() %> 바이트
</body>
</html>