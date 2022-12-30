<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	td {
		text-align: center;
	}
	
	#total {
		font-weight: 900;
	}
	
	#tbl2 {
		border: 1px solid rgb(150, 150, 150);
	}
	
	#tbl2 td {
		text-align: left;
	}
	
	#add1 {
	 margin-bottom: 5px;
	}
</style>
<div id="divCart">
	<h1>장바구니</h1>
	<table id="tbl">
		<tr class="title">
			<td width=""><input type="checkbox" id="all"></td>
			<td width="100">상품코드</td>
			<td width="300">상품이름</td>
			<td width="150">상품가격</td>
			<td width="150">상품수량</td>
			<td width="150">상품금액</td>
			<td width="100">삭제</td>
		</tr>
		<c:forEach items="${carts}" var="vo">
		<tr class="row" pid="${vo.prod_id}" pname="${vo.prod_name}" price="${vo.price1}" qnt="${vo.qnt}">
			<td><input type="checkbox" class="chk"></td>
			<td class="id">${vo.prod_id}</td>
			<td class="name">${vo.prod_name}</td>
			<td class="price"><fmt:formatNumber value="${vo.price1}" pattern="#,###원"/></td>
			<td>
				<input class="qnt" type="text" value="${vo.qnt}" size=2>
				<button class="update">변경</button>
			</td>
			<td>
				<fmt:formatNumber value="${vo.sum}" pattern="#,###원"/>
				<span class="sum" style="display: none;">${vo.sum}</span>
			</td>
			<td><button class="delete" id="${vo.prod_id}">삭제</button></td>
		</tr>
		</c:forEach>
		<c:if test="${carts.size() > 0}">
		<tr>
			<td class="total" colspan=7>합계 : <span id="total"></span>원</td>
		</tr>
		</c:if>
		<c:if test="${carts.size() == 0 || carts == null}">
			<tr><td colspan="7" style="text-align: center;">장바구니가 비어있습니다.</td></tr>
		</c:if>
	</table>
	<div class="buttons">
		<button id="btnAll">전체상품주문</button>
		<button id="btnChk">선택상품주문</button>
	</div>
</div>
<div id="divOrder">
	<h1>주문정보</h1>
	<table id="tbl1"></table>
	<script id="temp1" type="text/x-handlebars-template">
		<tr class="title">
			<td width=100>상품코드</td>
			<td width=400>상품이름</td>
			<td width=100>상품가격</td>
			<td width=100>상품수량</td>
			<td width=100>상품금액</td>
		</tr>
		{{#each .}}
		<tr class="row" pid="{{pid}}" price="{{price}}" qnt="{{qnt}}">
			<td>{{pid}}</td>
			<td>{{pname}}</td>
			<td>{{price}}</td>
			<td>{{qnt}}</td>
			<td>{{sum}}</td>
		</tr>
		{{/each}}
		<tr class="title">
			<td colspan=5 id="total"></td>
		</tr>
	</script>
	<!-- 주문자 정보 -->
	<h2 style="margin: 60px 0 0 30px;">주문자정보</h2>
	<form name="frm" method="post">
		<table id="tbl2">
			<tr>
				<td width=100 class="title">주문자 성명</td>
				<td width=750><input type="text" name="name" value="홍길동"></td>
			</tr>
			<tr>
				<td width=100 class="title">배송지 주소</td>
				<td width=750>
					<input id="add1" type="text" name="address1" size=80 readonly>
					<input type="text" name="address2" size=80 placeholder="나머지주소">
				</td>
			</tr>
			<tr>
				<td width=100 class="title">이메일</td>
				<td width=750><input type="text" name="email" size=20 value="hong@daum.net"></td>
			</tr>
			<tr>
				<td width=100 class="title">전화번호</td>
				<td width=750><input type="text" name="tel" value="010-0000-1111"></td>
			</tr>
			<tr>
				<td width=100 class="title">결제방법</td>
				<td width=750>
					<input type="radio" name="payType" value="0" checked> 무통장
					<input type="radio" name="payType" value="1"> 카드
				</td>
			</tr>
		</table>
		<div class="buttons">
			<button>주문하기</button>
			<button>주문취소</button>
		</div>
	</form>
</div>
<script>
	$("#divCart").show();
	$("#divOrder").hide();
	
	// 주문하기 버튼 클릭
	$(frm).on("submit", function(e) {
		e.preventDefault();
		var name = $(frm.name).val();
		var tel = $(frm.tel).val();
		var address = $(frm.address1).val() + $(frm.address2).val();
		var email = $(frm.email).val();
		var payType = $(frm.payType).val();
		
		if(!confirm("위 상품을 주문하시겠습니까?")) return;
		
		$.ajax({
			type: "get",
			url: "/pur/insert",
			dataType: "json",
			data: { name: name, tel: tel, address: address, email: email, payType: payType },
			success: function(data) {
				//alert(data.code);
				var oid = data.code;
				// 주문상품목록
				$("#tbl1 .row").each(function() {
					var pid = $(this).attr("pid");
					var price = $(this).attr("price");
					var qnt = $(this).attr("qnt");
					//alert(oid + "\n" + pid + "\n" + price + "\n" + qnt);
					$.ajax({
						type: "get",
						url: "/order/insert",
						data: { pid: pid, oid: oid, price: price, qnt: qnt},
						success: function() {
							// 카트 상품 삭제
							$.ajax({
								type: "get",
								url: "/cart/delete",
								data: { id: pid },
								success: function() {}
							});
						}
					});
				});
				alert(oid + " 주문이 완료되었습니다.");
				location.href = "/";
			}
		});
	});
	
	// 주소입력
	$(frm.address1).on("click", function() {
		new daum.Postcode({
			oncomplete: function(data) {
				// console.log(data);
				$(frm.address1).val(data.address);	// data.roadAddress, data.jibunAddress, data.zonecode
			}
		}).open();
	});
	
	$("#btnChk").on("click", function() {
		var chk = $("#tbl .row .chk:checked").length;
		if(chk == 0) {
			alert("주문할 상품을 선택해주세요.");
			return;
		}
		
		$("#divCart").hide();
		$("#divOrder").show();
		
		var total = 0;
		var array = [];
		$("#tbl .row .chk:checked").each(function() {
			var row = $(this).parent().parent();
			var pid = row.attr("pid");
			var pname = row.attr("pname");
			var price = row.attr("price");
			var qnt = row.attr("qnt");
			var sum = parseInt(price) * parseInt(qnt);
			total += sum;
			// alert(pid + "\n" + pname + "\n" + price + "\n" + qnt + "\n" + sum + "\n" + total);
			var data = { pid: pid, pname: pname, price: price, qnt: qnt, sum: sum };
			array.push(data);
		});
		var temp = Handlebars.compile($("#temp1").html());
		$("#tbl1").html(temp(array));
		$("#tbl1 #total").html("합계 : " + total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') + "원");
	});
	
	$("#btnAll").on("click", function() {
		$("#divCart").hide();
		$("#divOrder").show();
		
		var total = 0;
		var array = [];
		$("#tbl .row").each(function() {
			var pid = $(this).attr("pid");
			var pname = $(this).attr("pname");
			var price = $(this).attr("price");
			var qnt = $(this).attr("qnt");
			var sum = parseInt(price) * parseInt(qnt);
			total += sum;
			// alert(pid + "\n" + pname + "\n" + price + "\n" + qnt + "\n" + sum + "\n" + total);
			var data = { pid: pid, pname: pname, price: price, qnt: qnt, sum: sum };
			array.push(data);
		});
		var temp = Handlebars.compile($("#temp1").html());
		$("#tbl1").html(temp(array));
		$("#tbl1 #total").html("합계 : " + total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') + "원");
	});
	
	var total = 0;
	
	// 전체체크박스
	$("#tbl").on("click", "#all", function() {
		if($(this).is(":checked")) {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", true);
			})
		} else {
			$("#tbl .row .chk").each(function() {
				$(this).prop("checked", false);
			})
		}
	});
	
	// 각행체크박스
	$("#tbl").on("click", ".row .chk", function() {
		var all = $("#tbl .row .chk").length;
		var chk = $("#tbl .row .chk:checked").length;
		if(all == chk) $("#tbl #all").prop("checked", true)
		else $("#tbl #all").prop("checked", false)
	});
	
	// 합계 포맷
	$("#tbl .row .sum").each(function() {
		total += parseInt($(this).html());
	});
	$("#total").html(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
	
	// 수정 버튼 클릭
	$("#tbl").on("click", ".row .update", function() {
		var row = $(this).parent().parent();
		var id = row.find(".id").html();
		var qnt = row.find(".qnt").val();
		
		// 숫자 유효성체크
		if(qnt.replace(/[0-9]/g,'') || qnt == "") {
			alert("수량을 숫자로 입력해주세요.");
			row.find(".qnt").val("");
			row.find(".qnt").focus();
			return;
		}
		
		if(!confirm(id + " 상품의 수량을 " + qnt + "로 변경하시겠습니까?")) return;
		$.ajax({
			type: "get",
			url: "/cart/update",
			data: { id: id, qnt: qnt },
			success: function() {
				location.href = "/cart/list";
			}
		});
	});
	
	// 삭제 버튼 클릭
	$("#tbl").on("click", ".row .delete", function() {
		var id = $(this).attr("id");
		if(!confirm(id + " 상품을 장바구니에서 삭제하시겠습니까?")) return;
		$.ajax({
			type: "get",
			url: "/cart/delete",
			data: { id: id },
			success: function() {
				location.href = '/cart/list';
			}
		});
	});
</script>