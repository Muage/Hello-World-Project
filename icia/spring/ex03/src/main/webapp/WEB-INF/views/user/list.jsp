<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자 목록</title>
</head>
<body>
	<h1>사용자목록</h1>
	<table id="tbl" border=1></table>
	<script id="temp" type="text/x-handlebars-template">
		{{#each .}}
		<tr class="row">
			<td width=100>{{uid}}</td>
			<td width=100><a href="/user/read/{{uid}}">{{uname}}</a></td>
			<td width=100>{{point}}</td>
			<td width=150>
				<a href="/user/read/{{uid}}">
					<button>보낸메시지{{sendcnt}}</button>
				</a>
			</td>
			<td width=150>
				<a href="/user/read1/{{uid}}">
					<button>받은메시지{{receivecnt}}</button>	
				</a>
			</td>
		</tr>
		{{/each}}
	</script>
</body>
<script>
	getList();
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/api/user/list",
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
			}
		});
	};
</script>
</html>