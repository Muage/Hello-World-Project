<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">게시판 목록</h1>
<div id="listTop">
	<span id="listCount">게시글 수: <span id="count"></span></span>
	<button class="listButton" onclick="location.href='/bbs/insert'">글쓰기</button>
	<div id="listRead">
		<select id="type">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>
		<input id="query" type="text" placeholder="검색어">
		<button id="search">검색</button>
	</div>
</div>

<table id="list"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td width=50>No.</td>
		<td width=300>제목</td>
		<td width=200>날짜</td>
		<td width=100>글쓴이</td>
	</tr>
	{{#each array}}
	<tr class="row" onclick="location.href='/bbs/read?no={{no}}'">
		<td>{{no}}</td>
		<td>{{title}}</td>
		<td>{{wdate}}</td>
		<td>{{writer}}</td>
	</tr>
	{{/each}}
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>
<script>
	var page = 1;
	
	getList();
	
	$("#search").on("click", function() {
		page = 1;
		getList();
	});
	
	$("#query").on("keydown", function(e) {
		if(e.keyCode == 13) $("#search").click();
	});
	
	//이전 버튼 클릭
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	//다음 버튼 클릭
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	function getList() {
		var type = $("#type").val();
		var query = $("#query").val();
		
		// alert(type + "-" + query + "-" + page);
		
		$.ajax({
			type: "get",
			url: "/bbs/list.json",
			data: { page: page, type: type, query: query },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#list").html(temp(data));
				$("#count").html(data.count);
				
				var last = Math.ceil(data.count / 5);
				$("#page").html(page + "/" + last);
				
				if(page == 1) $("#prev").attr("disabled", true);
				else $("#prev").attr("disabled", false);
				
				if(page == last) $("#next").attr("disabled", true);
				else $("#next").attr("disabled", false);
			}
		})
	}
</script>