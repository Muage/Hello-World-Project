<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품이미지검색</title>
</head>
<body>
	<h1>상품이미지검색</h1>
	<input type="text" id="query" value="노트북"/>
	<button id="download">선택이미지 다운로드</button>
	<table id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">
		{{#each items}}
		<tr class="row">
			<td><input type="checkbox" class="chk" image="{{image}}"/></td>
			<td><img src="{{image}}" width=100/></td>
			<td>{{image}}</td>
		</tr>
		{{/each}}
	</script>
	<div>
		<button id="prev">이전</button>
		<span id="page"></span>
		<button id="next">다음</button>
	</div>
</body>

<script>
	var page = 1;
	
	getList();
	
	// 검색어 입력
	$("#query").on("keydown", function(e) {
		if(e.keyCode == 13) {
			page = 1;
			getList();
		}
	});
	
	// 다운로드 버튼 클릭
	$("#download").on("click", function() {
		$("#tbl .row .chk:checked").each(function() {
			// alert("...");
			var image = $(this).attr("image");
			// alert(image);
			$.ajax({
				type: "post",
				url: "/api/download",
				data: { image: image },
				success: function() {}
			});
		});
	});
	
	// 페이징
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	// 리스트 출력
	function getList() {
		var query = $("#query").val();
		
		$.ajax({
			type: "get",
			url: "/naver/shop.json",
			data: { query: query, page: page },
			success: function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				$("#page").html(page);
			}
		});
	}
</script>
</html>