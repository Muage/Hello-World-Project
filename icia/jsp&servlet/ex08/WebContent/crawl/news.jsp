<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#container .box {overflow: hidden; border-bottom: 1px dotted gray;}
	.box .image {width: 100px; float: left;}
	.box .content {width: 800px; float: left;}
	
	.up {color: red;}
	.down {color: blue;}
</style>
<h1 id="middleTitle">증권뉴스</h1>
<table id="tbl"></table>
<script id="temp1" type="text/x-handlebars-template">
	<tr class={{upDown rate}}>
		<td width=300>{{title}}</td>
		<td width=100>{{price}}</td>
		<td width=100>{{rate}}</td>
	</tr>
</script>
<script>
	Handlebars.registerHelper("upDown", function(rate) {
		var upDown = rate.substring(0, 2);
		if(upDown == "상승") {
			return "up";
		} else {
			return "down";
		}
	});
</script>
<div id="container"></div>
<script id="temp" type="text/x-handlebars-template">
	{{#each .}}
	<div class="box">
		<div class="image"><img src="{{image}}"></div>
		<div class="content">
			<h4><a href="https://finance.naver.com/{{link}}">{{title}}</a></h4>
			<p>{{content}}</p>
		</div>
	</div>
	{{/each}}
</script>
<script>
	getList();
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/crawl/naver/news.json",
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#container").html(temp(data));
			}
		});
	}
	
	// 주식정보 1~15위까지 2초 간격으로 보여준다.
	$.ajax({
		type: "get",
		url: "/crawl/naver/top.json",
		dataType: "json",
		success: function(data) {
			var temp = Handlebars.compile($("#temp1").html());
			
			
			var i = 0;
			$("#tbl").html(temp(data[0]));
			var inteval = setInterval(function(){
				$("#tbl").html(temp(data[i % data.length]));
				i++;
			}, 2000);
		}
	});
</script>