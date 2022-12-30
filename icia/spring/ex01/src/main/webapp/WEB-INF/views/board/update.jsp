<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Board Modify</title>
</head>
<body>
	<h1>Board Modify</h1>
	<form method="post" name="frm">
		<input type="hidden" name="bno" value="${vo.bno}"/>
		<input type="text" name="title" size=50 value="${vo.title}"/>
		<hr/>
		<input type="text" name="writer" value="black" readonly/>
		<hr/>
		<textarea rows="10" cols="50" name="content">${vo.content}</textarea>
		<hr/>
		<button type="submit" id="update">Modify</button>
		<button type="button" id="delete">Delete</button>
		<button type="reset">Reset</button>
		<button type="button" id="list">List</button>
	</form>
</body>
<script>
	// Modify 버튼 클릭
	$("#update").on("click", function(e) {
		e.preventDefault();
		if(!confirm("수정하시겠습니까?")) return;
		frm.action="/board/update";
		frm.method="post";
		frm.submit();
	});
	
	// Delete 버튼 클릭
	$("#delete").on("click", function() {
		if(!confirm("삭제하시겠습니까?")) return;
		frm.action="/board/delete";
		frm.method="post";
		frm.submit();
	});
	
	
	// List 버튼 클릭
	$("#list").on("click", function() {
		location.href="/board/list";
	});
	
	
	
</script>
</html>