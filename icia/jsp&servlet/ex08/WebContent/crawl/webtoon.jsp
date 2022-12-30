<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#container {overflow: hidden;}
	#arr1, #arr2, #arr3 {float:left;}
	.box {overflow:hidden; width: 200px; padding: 0 10px; margin: 0 100px 50px 0;}
	.image {float: left; margin-right: 5px;}
	.user {font-size: 12px}
</style>
<h1 id="middleTitle">추천웹툰</h1>
<div id="container"></div>
<div id="arr1"></div>
<div id="arr2"></div>
<div id="arr3"></div>
<script id="temp" type="text/x-handlebars-template">
	{{#each .}}
	<div class="box">
		<div class="image"><img src="{{image}}"></div>
		<div class="content">
			<div><a href="https://comic.naver.com/{{link}}">{{title}}</a></div>
			<div class="user">{{user}}</div>
			<div>{{summary}}</div>
		</div>
	</div>
	{{/each}}
</script>
<script>
	getList();
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/crawl/naver/webtoon.json",
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				//$("#arr1").html(temp(data.arr1));
				//$("#arr2").html(temp(data.arr2));
				//$("#arr3").html(temp(data.arr3));
				
				$("#arr1").html("<h4>에피소드</h4>");
				$("#arr1").append(temp(data.arr1));
				$("#arr2").html("<h4>옴니버스</h4>");
				$("#arr2").append(temp(data.arr2));
				$("#arr3").html("<h4>스토리</h4>");
				$("#arr3").append(temp(data.arr3));
			}
		});
	}
</script>