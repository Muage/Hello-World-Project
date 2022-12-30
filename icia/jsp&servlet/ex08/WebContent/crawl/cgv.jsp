<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#container {overflow: hidden; margin: 0 auto;}
	.box {width:200px; height: 280px; float: left; margin: 10px; text-align: center;}
</style>
<h1 id="middleTitle">CGV 무비차트</h1>
<div id="container"></div>
<script id="temp" type="text/x-handlebars-template">
	{{#each .}}
	<div class="box">
		<a href="{{link}}"><img src="{{image}}" width=150></a>
		<div>{{title}}</div>
		<div>{{date}}</div>
		<div>{{percent}}</div>
	</div>
	{{/each}}
</script>
<script>
	getList();
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/crawl/cgv.json",
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#container").html(temp(data));
			}
		});
	}
</script>