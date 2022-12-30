<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>상품목록</title>
</head>
<body>
	<h1>상품목록</h1>
	<table id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">
		{{#each .}}
		<tr class="row">
			<td><img src="api/display?fileName={{image}}" width=100/></td>
			<td>
				<a href="/read/{{code}}">
					{{title}} ({{price}})
				</a>
			</td>
		</tr>
		{{/each}}
	</script>
</body>
<script>
	getList();
	
	//리스트 출력
	function getList() {		
		$.ajax({
			type: "get",
			url: "/api/shop/list",
			success: function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
			}
		});
	}
</script>
</html>