<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">도서검색</h1>
<div id="listTop">
		<button id="save" class="listButton">선택저장</button>
		<form name="frm">
		<div id="listCount">
			검색수: <span id="count"></span>권
			<input  id="query" type="text" name="query" value="자바">
			<button id="search">검색</button>
		</div>
	</form>
</div>
<table id="tbl"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td><input type="checkbox" id="chkAll"></td>
		<td width=90>이미지</td>
		<td width=350>제목</td>
		<td width=80>저자</td>
		<td width=80>가격</td>
		<td width=150>출판사</td>
	</tr>
	{{#each documents}}
	<tr class="row" isbn="{{isbn}}">
		<td><input type="checkbox" class="chk"></td>
		<td><img src="{{image thumbnail}}" contents="{{contents}}" width=70 class="thum"></td>
		<td class="subject">{{title}}</td>
		<td class="authors">{{authors}}</td>
		<td class="price">{{price}}</td>
		<td class="publisher">{{publisher}}</td>
	</tr>
	{{/each}}
</script>
<script>
	Handlebars.registerHelper("image", function(thum) {
		if(thum) return thum;
		else return "https://via.placeholder.com/70x100";
		
	})
</script>

<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>

<!-- 라이트 박스 -->
<div id="background">
	<div id="lightbox">
		<div>
			<img src="" id="image" width=300>
			<p id="contents"></p>
		</div>
		<div>
			<button id="close">닫기</button>
		</div>
	</div>
</div>

<script>
	var page = 1;
	var size = 5;
	var query = "박태희";
	
	//닫기 버튼 클릭
	$("#close").on("click", function() {
		$("#background").hide();
	});
	
	//각 행의 이미지 클릭
	$("#tbl").on("click", ".row .thum", function() {
		var thum = $(this).attr("src");
		var contents = $(this).attr("contents");
		
		$("#image").attr("src", thum);
		$("#contents").html(contents);
		$("#background").show();
	});
	
	//선택 저장 버튼 클릭
	$("#save").on("click", function() {
		var chk = $("#tbl .row .chk:checked").length;
		if(chk == 0) {
			alert("저장할 도서를 선택해주세요.");
			return;
		}
		
		if(!confirm(chk + "권의 도서를 저장하시겠습니까?")) return;
		
		//반복저장
		$("#tbl .chk:checked").each(function() {
			var row = $(this).parent().parent();
			var thum = row.find(".thum").attr("src");
			var title = row.find(".subject").html();
			var authors = row.find(".authors").html();
			var price = row.find(".price").html();
			var publisher = row.find(".publisher").html();
			var contents = row.find(".thum").attr("contents");
			var isbn = row.attr("isbn");
			
			//저장
			$.ajax({
				type: "post",
				url: "/book/insert",
				data: {
					title: title,
					authors: authors,
					image: thum,
					price: price,
					publisher: publisher,
					contents: contents,
					isbn: isbn },
				success: function() {}
			});
		});
	});
	
	//전체 선택 체크박스 클릭
	$("#tbl").on("click", "#chkAll", function() {
		if($(this).is(":checked")) {	//checked 되어있는 상태
			$("#tbl .chk").each(function() {
				$(this).prop("checked", true);
			})
		} else {	//checked 되어있지 않은 는 상태
			$("#tbl .chk").each(function() {
				$(this).prop("checked", false);
			})
		}
	});
	
	//각 행의 체크박스 클릭
	$("#tbl").on("click", ".chk", function() {
		var all = $("#tbl .row .chk").length;
		var chk = $("#tbl .row .chk:checked").length;
		if(all == chk) $("#chkAll").prop("checked", true);
		else $("#chkAll").prop("checked", false);
	});
	
	$(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getList();
	});
	
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	getList();
	
	function getList() {
		query = $(frm.query).val();
		$.ajax({
			type: "get",
			url: "https://dapi.kakao.com/v3/search/book?target=title",
			dataType: "json",
			headers: {"Authorization":"KakaoAK 02f3207773863b462be00c93c2734f81"},
			data: { page: page, size: size, query: query },
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				$("#count").html(data.meta.pageable_count);
				var last = Math.ceil(data.meta.pageable_count/5);
				$("#page").html(page);
				
				if(page == 1) $("#prev").attr("disabled", true);
				else $("#prev").attr("disabled", false);
				
				if(data.meta.is_end == true) $("#next").attr("disabled", true);
				else $("#next").attr("disabled", false);
			}
		});
	}
</script>
