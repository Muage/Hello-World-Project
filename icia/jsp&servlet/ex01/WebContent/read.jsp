<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1 class="middleTitle">주소정보</h1>
<form name="frm" method="post">
	<input type="hidden" name="id" value="${addressVO.id}">
	이름 : <input type="text" name="name" value="${addressVO.name}">
	<hr>
	번호 : <input type="text" name="tel" value="${addressVO.tel}">
	<hr>
	주소 : <input type="text" name="address" value="${addressVO.address}">
	<hr>
	<button type="submit">주소수정</button>
	<button type="reset">수정취소</button>
</form>
	
<script>
	$(frm).on("submit", function(e) {
		e.preventDefault();
		if(!confirm("주소를 수정하시겠습니까?")) return;
		//수정
		frm.action = "/update";
		frm.submit();
	})
</script>