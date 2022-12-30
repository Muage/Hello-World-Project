<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">상품검색</h1>
<div id="middleTop">
	<button id="save">선택저장</button>
	<form name="frm" id="right">
		<input type="text" value="노트북" name="query">
		<button class="middleButton">검색</button>
	</form>
</div>
<table id="tbl"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td><input type="checkbox" id="chkAll"></td>
		<td width="80">No.</td>
		<td width="100">상품이미지</td>
		<td width="300">상품명</td>
		<td width="100">상품가격</td>
		<td width="100">브랜드</td>
	</tr>
	{{#each items}}
	<tr class="row">
		<td><input type="checkbox" class="chk"></td>
		<td class="id">{{productId}}</td>
		<td><img src="{{image}}" width="70"></td>
		<td class="name">{{{title}}}</td>
		<td class="price">{{lprice}}</td>
		<td class="brand">{{brand}}</td>
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
	
	// 선택저장 클릭
	$("#save").on("click", function() {
		var chk = $("#tbl .row .chk:checked").length;
		if(chk == 0) {
			alert("저장할 항목들을 선택해주세요.");
			return;
		}
		if(!confirm(chk + "개 상품을 저장하시겠습니까?")) return;
		$("#tbl .row .chk:checked").each(function() {
			var row = $(this).parent().parent();
			var id = row.find(".id").html();
			var title = row.find(".name").text();
			
			var url = row.find("img").attr("src");
			var price = row.find(".price").html();
			var brand = row.find(".brand").html();
			
			// alert(id + "\n" + title + "\n" + price + "\n" + brand + "\n" + url);
			$.ajax({
				type: "post",
				url: "/shop/insert",
				data: { id: id, title: title, url: url, price: price, brand: brand },
				success: function() {}
			});
		});
		alert(chk + "개 상품이 저장되었습니다.");
		getList();
	});
	
	// 전체 체크박스 선택
	$("#tbl").on("click", "#chkAll", function() {
		if($(this).is(":checked")) {
			$("#tbl .chk").each(function() {
				$(this).prop("checked", true);
			})
		} else {
			$("#tbl .chk").each(function() {
				$(this).prop("checked", false);
			})
		}
	});
	
	// 각 행의 체크박스 선택
	$("#tbl").on("click", ".row .chk", function() {
		var all = $("#tbl .row .chk").length;
		var chk = $("#tbl .row .chk:checked").length;
		
		if(all == chk) $("#chkAll").prop("checked", true);
		else $("#chkAll").prop("checked", false);
	});
	
	// 각 행의 이미지 클릭
	$("#tbl").on("click", ".row img", function() {
		var url = $(this).attr("src");
		if(!confirm("상품이미지를 다운로드 하시겠습니까?")) return;
		// 이미지 다운로드
		$.ajax({
			type: "get",
			url: "/download",
			data: { url: url },
			success: function() {
				alert("다운로드가 완료되었습니다.");
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
	
	// 검색 버튼 클릭
	$(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getList();
	});
	
	function getList() {
		var query = $(frm.query).val();
		$.ajax({
			type: "get",
			url: "/shop/search.json",
			data: { query: query, page: page },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				
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