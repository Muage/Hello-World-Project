<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품등록</title>
</head>
<body>
	<h1>상품등록</h1>
	<form name="frm">
		<input name="title" placeholder="상품명"/>
		<hr/>
		<input name="price" placeholder="가격"/>
		<hr/>
		<input type="file" name="file"/>
		<hr/>
		<button>상품등록</button>
	</form>
</body>
<script>
	$(frm).on("submit", function(e) {
		e.preventDefault();
		
		if(!confirm("상품을 등록하시겠습니까?")) return;
		
		var formData = new FormData();
		formData.append("file", $(frm.file)[0].files[0]);
		formData.append("title", $(frm.title).val());
		formData.append("price", $(frm.price).val());
		
		$.ajax({
			type: "post",
			url: "/api/shop/insert",
			data: formData,
			processData: false,
			contentType: false,
			success: function() {
				alert("등록성공");
			}
		});
	});
</script>
</html>