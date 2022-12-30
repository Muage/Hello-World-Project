<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#products {
		overflow: hidden;
	}
	#products .box {
		width: 200px;
		float: left;
		margin: 10px;
		padding: 10px;
		cursor: pointer;
	}
	#products .box .name {
		width: 200px;
		font-size: 15px;
	}
	.ellipsis {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
	}
	
	#new, #best {
		overflow: hidden;
	}
	
	#new .box, #best .box {
		width: 150px;
		float: left;
		margin: 11px;
		padding: 10px;
		cursor: pointer;
	}
	
	#new .box .name, #best .box .name {
		width: 150px;
		font-size: 15px;
	}
	
	h2 {
		margin-top: 20px;
		margin-bottom: 0;
		padding: 10px;
		color: black;
		font-family: SCDream4;
	}
	
	h2:after {
        content: "";
        display: block;
        width: 15%;
        margin-top: 10px;
        border-bottom: 1px solid black;
    }
    
	.status {
		color: red;
		font-weight: bold;
		font-size: 14px;
	}
</style>
<h1>회사소개</h1>
<div id="condition">
	<form name="frm">
		<select id="key">
			<option value="prod_name">상품명</option>
			<option value="company">제조사</option>
			<option value="mall_name">판매처</option>
		</select>
		<input type="text" id="word" placeholder="검색어">
		<button>검색</button>
		검색수: <span id="total"></span>건
	</form>
	<div id="right">
		<select id="order">
			<option value="price1">상품가격</option>
			<option value="prod_name">상품명</option>
			<option value="prod_id">상품코드</option>
		</select>
		<select id="desc">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
	</div>
</div>
<!-- 상품검색목록 -->
<div id="products"></div>
<script id="ptemp" type="text/x-handlebars-template">
	{{#each array}}
	<div class="box" onclick="location.href='/pro/info?prod_id={{prod_id}}'">
		<img src="/image/shop/{{image}}" width=200>
		<div class="id">
			{{prod_id}}
			<span class="status">{{status del}}</span>
		</div>
		<div class="name ellipsis">{{prod_name}}</div>
		<div class="price">{{fprice}}</div>
	</div>
	{{/each}}
</script>
<script>
	Handlebars.registerHelper("status", function(del) {
		if(del == '1') return "판매중지";
	});
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>
<!-- 최근상품 5개 출력 -->
<h2>최신상품</h2>
<div id="new"></div>
<script id="ntemp" type="text/x-handlebars-template">
	{{#each array}}
	<div class="box" onclick="location.href='/pro/info?prod_id={{prod_id}}'">
		<img src="/image/shop/{{image}}" width=150>
		<div class="name ellipsis">[{{prod_id}}] {{prod_name}}</div>
		<div class="price">{{fprice}}</div>
	</div>
	{{/each}}
</script>

<!-- 베스트상품 5개 출력 -->
<h2>베스트상품</h2>
<div id="best"></div>
<script id="ntemp" type="text/x-handlebars-template">
	{{#each array}}
	<div class="box" onclick="location.href='/pro/info?prod_id={{prod_id}}'">
		<img src="/image/shop/{{image}}" width=150>
		<div class="name ellipsis">[{{prod_id}}] {{prod_name}}</div>
		<div class="price">{{fprice}}</div>
	</div>
	{{/each}}
</script>

<script>	
	var page = 1;
	getProducts();
	
	// 다음 버튼 클릭
	$("#next").on("click", function() {
		page++;
		getProducts();
	});
	
	// 이전 버튼 클릭
	$("#prev").on("click", function() {
		page--;
		getProducts();
	});
	
	// 검색 버튼 클릭
	$(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getProducts();
	});
	
	$("#order, #desc").on("change", function() {
		page = 1;
		getProducts();
	});
	
	// 베스트상품5개
	getBest();
	
	function getBest() {
		$.ajax({
			type: "get",
			url: "/pro/list.json",
			data: { key: "prod_id", word: "", per: 5, order: "price1", desc: "asc", page: 1 },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#ntemp").html());
				$("#best").html(temp(data));
			}
		});
	}
	
	// 최신상품5개
	getNew();
	
	function getNew() {
		$.ajax({
			type: "get",
			url: "/pro/list.json",
			data: { key: "prod_id", word: "", per: 5, order: "prod_id", desc: "desc", page: 1 },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#ntemp").html());
				$("#new").html(temp(data));
			}
		});
	}
	
	// 상품검색목록
	function getProducts() {
		var key = $("#key").val();
		var word = $("#word").val();
		var per = 8;
		var order = $("#order").val();
		var desc = $("#desc").val();
		
		$.ajax({
			type: "get",
			url: "/pro/list.json",
			data: { key: key, word: word, per: per, order: order, desc: desc, page: page },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#ptemp").html());
				$("#products").html(temp(data));
				$("#total").html(data.total);
				if(data.total == 0) {
					var str = "<div style='text-align: center; padding: 30px;'><h3>일치하는 검색결과가 없습니다.</h3></div>";
					$("#products").append(str);
					$(".buttons").hide();
				} else {
					$("#page").html(page + "/" + data.last);
				
					if(page == 1) $("#prev").attr("disabled", true);
					else $("#prev").attr("disabled", false);
					
					if(page == data.last) $("#next").attr("disabled", true);
					else $("#next").attr("disabled", false);
					$(".buttons").show();
				}
			}
		});
	}
</script>