<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	#tbl1 td {
		border: 1px solid rgb(150, 150, 150);
	}
	
	#tbl2 td {
		text-align: center;
	}
</style>
<h1>주문목록</h1>
<div id="condition">
	<form name="frm">
		<select id="key">
			<option value="order_id">주문번호</option>
			<option value="name" selected>주문자명</option>
			<option value="address">주문자주소</option>
			<option value="tel">전화번호</option>
			<option value="status">주문상태</option>
		</select>
		<input type="text" id="word" placeholder="검색어">
		<select id="per">
			<option value="2">2행</option>
			<option value="3">3행</option>
			<option value="5">5행</option>
			<option value="10">10행</option>
		</select>
		<button>검색</button>
		&nbsp;&nbsp;&nbsp;&nbsp;검색수: <span id="count"></span>건
	</form>
	<div id="right">
		<select id="order">
			<option value="order_id">주문번호</option>
			<option value="name">주문자명</option>
			<option value="address">주문자주소</option>
			<option value="tel">전화번호</option>
		</select>
		<select id="desc">
			<option value="asc">오름차순</option>
			<option value="desc" selected>내림차순</option>
		</select>
	</div>
</div>
<table id="tbl"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td width=80>주문번호</td>
		<td width=90>주문자명</td>
		<td width=300>주문자주소</td>
		<td width=180>전화번호</td>
		<td width=200>구매일</td>
		<td width=100>구매정보</td>
	</tr>
	{{#each array}}
	<tr class="row">
		<td>{{order_id}}</td>
		<td>{{name}}</td>
		<td>{{address}}</td>
		<td>{{tel}}</td>
		<td>{{pdate}}</td>
		<td><button id="{{order_id}}">구매정보</button></td>
	</tr>
	{{/each}}
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>
<!-- 구매자정보 -->
<div id="tbl1"></div>
<script id="temp1" type="text/x-handlebars-template">
<h2>구매자정보</h2>
	<table>
		<tr>
			<td class="title" width=70>이름</td>
			<td width=130>{{pur.name}}(<b>{{pur.order_id}}</b>)</td>
			<td class="title" width=70>전화</td>
			<td width=170>{{pur.tel}}</td>
			<td class="title" width=70>이메일</td>
			<td width=170>{{pur.email}}</td>
			<td class="title" width=70>주문일</td>
			<td width=200>{{pur.pdate}}</td>
		</tr>
		<tr>
			<td class="title">주소</td>
			<td colspan=3>{{pur.address}}</td>
			<td class="title">결제</td>
			<td>{{outPayType pur.payType}}</td>
			<td class="title">상태</td>
			<td>
				<select id="status">
					<option value="0">주문확인중</option>
					<option value="1">배송준비중</option>
					<option value="2">배송완료</option>
				</select>
				<button id="btnStatus" order="{{pur.order_id}}">수정</button>
			</td>
		</tr>
	</table>
	<table id="tbl2">
		<tr class="title">
			<td width=100>이미지</td>
			<td width=100>상품코드</td>
			<td width=250>상품명</td>
			<td width=100>제조사</td>
			<td width=100>가격</td>
			<td width=50>수량</td>
			<td width=100>금액</td>
		</tr>
		{{#each array}}
		<tr class="row">
			<td>
				<a href="/pro/info?prod_id={{prod_id}}">
				<img src="/image/shop/{{image}}" width=50>
			</td>
			<td>{{prod_id}}</td>
			<td>{{prod_name}}</td>
			<td>{{company}}</td>
			<td>{{price}}원</td>
			<td>{{qnt}}</td>
			<td>{{sum}}원</td>
			
		</tr>
		{{/each}}
		<tr class="title">
			<td colspan=7>합계 : <b>{{total}}</b>원</td>
		</tr>
	</table>
</script>
<script>
	Handlebars.registerHelper("outPayType", function(payType) {
		if(payType == '0') return "무통장";
		else return "카드";
	});
</script>
<script>
	var page = 1;
	getList();
	
	$("#tbl1").on("click", "#btnStatus", function() {		
		var order_id = $(this).attr("order");
		var status = $("#status").val();
		if(!confirm(order_id + "번 주문의 상태를 " + status + "로 변경하시겠습니까?")) return;
		$.ajax({
			type: "get",
			url: "/update/status",
			data: { id: order_id, status: status },
			success: function() {
				alert("상태가 변경되었습니다.");
			}
		});
	});
	
	// 구매정보 버튼 클릭
	$("#tbl").on("click", ".row button", function() {
		var id = $(this).attr("id");
		$.ajax({
			type: "get",
			url: "/order/read.json",
			data: { id: id },
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp1").html());
				$("#tbl1").html(temp(data));
				$("#status").val(data.pur.status).prop("selected", true);
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
	
	// 검색
	$(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getList();
	});
	
	$("#per, #order, #desc").on("change", function() {
		page = 1;
		getList();
	});
	
	function getList(){
		var key = $("#key").val();
		var word = $("#word").val();
		var per = $("#per").val();
		var order = $("#order").val();
		var desc = $("#desc").val();
		
		$.ajax({
			type: "get",
			url: "/order/list.json",
			data: { key: key, word: word, per: per, order: order, desc: desc, page: page },
			dataType: "json",
			success: function(data){
				var temp = Handlebars.compile($("#temp").html());
				$("#tbl").html(temp(data));
				$("#count").html(data.total);
				
				if(data.total == 0) {
					$("#tbl").append("<tr><td colspan=6 style='color: red; border: none;'>주문 내역이 없습니다.</td></tr>");
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