<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Post List</title>
</head>
<body>
	<h1>Post List</h1>
	<a href="/post/insert"><button>글쓰기</button></a>
	<table>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>[${vo.id}] <a href="/post/read?id=${vo.id}">${vo.title}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>