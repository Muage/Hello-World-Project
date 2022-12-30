<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">영화검색</h1>
<div id="middleTop">
	<button id="save">선택 저장</button>
	<form name="frm" id="right">
		검색수: <span id="count"></span>건
		<input type="text" name="query" value="마블">
		<button class="middleButton">검색</button>
	</form>
</div>
<table id="tbl"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td><input type="checkbox" id="chkAll"></td>
		<td width="100">포스터</td>
		<td width="250">제목</td>
		<td width="300">출연진</td>
		<td width="150">감독</td>
		<td width="100">개봉연도</td>
	</tr>
	{{#each items}}
	<tr class="row">
		<td><input type="checkbox" class="chk"></td>
		<td><img src="{{printImage image}}" width="80"></td>
		<td><div class="subject info"><a id="aTitle" href="{{link}}">{{{title}}}</a><div></td>
		<td><div class="actor info">{{actor}}<div></td>
		<td><div class="director info">{{director}}<div></td>
		<td class="pubDate">{{pubDate}}</td>
	</tr>
	{{/each}}
</script>
<script>
	Handlebars.registerHelper("printImage", function(image) {
		if(!image) {
			return "https://dummyimage.com/80x100/bab6ba/FFFFFF";
		} else {
			return image;
		}
	});
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>
<script>
	var page = 1;
	var query = "마블";
	
	getList();
	
	// 저장 버튼 클릭
	$("#save").on("click", function() {
		var chk = $("#tbl .row .chk:checked").length;
		if(chk == 0) {
			alert("저장할 영화를 선택해주세요.")
			return;
		}
		
		if(!confirm(chk + "개 영화를 저장하시겠습니까?")) return;
		// 선택 저장
		$("#tbl .row .chk:checked").each(function() {
			var row = $(this).parent().parent();
			var image = row.find("img").attr("src");
			var title = row.find(".subject").text();
			var actor = row.find(".actor").text();
			var director = row.find(".director").text();
			var pubDate = row.find(".pubDate").text();
			var link = row.find("a").attr("href");
			
			//alert(image + "\n" + title + "\n" + actor + "\n" + director + "\n" + pubDate + "\n" + link);
			$.ajax({
				type: "post",
				url: "/movie/register",
				data: { image: image, title: title, actor: actor, director: director, pubDate: pubDate, link: link },
				success: function() {}
			});
		});
		alert(chk + "개 영화가 저장되었습니다.");
		getList();
	});
	
	$("#tbl").on("click", "#chkAll", function() {
		if($(this).is(":checked")) {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", true);
			});
		} else {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", false);
			});
		}
	});
	
	$("#tbl").on("click", ".row .chk", function() {
		var all = $("#tbl .row .chk").length;
		var chk = $("#tbl .row .chk:checked").length;
		
		if(all == chk) {
			$("#chkAll").prop("checked", true)
		} else {
			$("#chkAll").prop("checked", false)
		}
	});
	
	$("#tbl").on("click", ".row img", function() {
		var image = $(this).attr("src");
		if(!confirm(image + "\n이미지를 다운로드 하시겠습니까?")) return;
		
		// 이미지 다운로드
		$.ajax({
			type: "get",
			url: "/download",
			data: { image: image },
			success: function() {
				alert("다운로드가 완료되었습니다.")
			}
		});
	});
	
	// 다음 버튼 클릭
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	// 이전 버튼 클릭
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	$(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getList();
	});
	
	function getList() {
		query = $(frm.query).val();
		$.ajax({
			type: "get",
			url: "/movie/search.json",
			data: { query: query, page: page },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				$("#count").html(data.total);
				
				var last = 0;
				if(data.total >= 100) {
					last = Math.ceil(100 / 5);
				} else {
					last = Math.ceil(data.total / 5);
				}
				
				$("#page").html(page + "/" + last);
				
				if(page == 1) $("#prev").attr("disabled", true);
				else $("#prev").attr("disabled", false);
				
				if(page == last) $("#next").attr("disabled", true);
				else $("#next").attr("disabled", false);
			}
		});
	}
</script>