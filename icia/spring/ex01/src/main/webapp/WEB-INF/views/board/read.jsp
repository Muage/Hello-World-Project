<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board Information</title>
</head>
<body>
	<h1>Board Information</h1>
	<h3>[${vo.bno}] ${vo.title}</h3>
	<h3>작성일: <fmt:formatDate value="${vo.regdate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></h3>
	<h3>수정일: <fmt:formatDate value="${vo.updatedate}" pattern="yyyy년 MM월 dd일 HH:mm:ss"/></h3>
	<p>${vo.content}</p>
	<hr/>
	<button id="update">수정</button>
	<button id="list">목록</button>
</body>
<script>
	// 목록 버튼 클릭
	$("#list").on("click", function() {
		location.href="/board/list";
	});
	
	// 수정 버튼 클릭
	$("#update").on("click", function() {
		location.href="/board/update?bno=" + ${vo.bno};
	});
</script>
</html>