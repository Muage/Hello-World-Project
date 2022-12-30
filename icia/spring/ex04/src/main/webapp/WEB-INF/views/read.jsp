<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품정보</title>
</head>
<body>
	<h1>상품정보</h1>
	<div id="shop"></div>
	<script id="temp" type="text/x-handlebars-template">
		<h3>code: {{code}}</h3>
		<h3>title: {{title}}</h3>
		<h3>price: {{price}}</h3>
		<div><img src="/api/display?fileName={{image}}" width=200/></div>
	</script>
	<hr/>
	<div id="attach"></div>
	<script id="temp1" type="text/x-handlebars-template">
		{{#each .}}
			<a href="{{id}}" image="{{image}}">X</a>
			<img src="/api/display?fileName={{image}}" width=200>
		{{/each}}
	</script>
	<hr/>
	<form name="frm">
		<input type="file" name="files" multiple/>
		<button>첨부파일 업로드</button>
	</form>
</body>
<script>
	var code = "${code}";
	
	getRead();
	
	$("#attach").on("click", "a", function(e) {
		e.preventDefault();
		
		var id = $(this).attr("href");
		var image = $(this).attr("image");
		
		if(!confirm(id + ": " + image + "를 삭제하시겠습니까?")) return;
		
		$.ajax({
			type: "post",
			url: "/api/shop/delAttach",
			data: { id: id, image: image },
			success: function() {
				alert("삭제되었습니다.");
				getRead();
			}
		});
	});
	
	// 파일 업로드
	$(frm).on("submit", function(e) {
		e.preventDefault();
		
		if(!confirm("첨부파일을 업로드 하시겠습니까?")) return;
		
		var formData = new FormData();
		formData.append("code", code);
		
		var files = $(frm.files)[0].files;
// 		alert(files.length);

		for(var i = 0; i < files.length; i++) {
			formData.append("files", files[i]);
		}
		
		$.ajax({
			type: "post",
			url: "/api/shop/attach",
			data: formData,
			processData: false,
			contentType: false,
			success: function() {
				alert("등록성공");
				getRead();
			}
		});
	});
	
	//리스트 출력
	function getRead() {		
		$.ajax({
			type: "get",
			url: "/api/shop/read/" + code,
			success: function(data){
// 				alert(JSON.stringify(data, null, 4));
				var temp = Handlebars.compile($("#temp").html());
				$("#shop").html(temp(data.shop));
				
				var temp1 = Handlebars.compile($("#temp1").html());
				$("#attach").html(temp1(data.attach));
			}
		});
	}
</script>
</html>