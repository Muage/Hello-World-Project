<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Post Information</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>Post Information</h1>
	<form action="/post/update" method="post">
		<input name="id" value="${vo.id}"/>
		<input name="title" value="${vo.title}"/>
		<hr/>
		<textarea rows="10" cols="50" name="body">${vo.body}</textarea>
		<hr/>
		<button>Modify</button>
		<button type="reset">Cancel</button>
		<button type="button" id="btnDelete">Delete</button>
	</form>
</body>
<script>
	$("#btnDelete").on("click", function() {
		if(!confirm("삭제하시겠습니까?")) return;
		
		frm.action = "/post/delete";
		frm.method = "post";
		frm.submit();
	});
</script>
</html>