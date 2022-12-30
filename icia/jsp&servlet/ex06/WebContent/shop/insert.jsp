<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">상품등록</h1>
<form name="frm" method="post" enctype="multipart/form-data">
	<table id="tbl">
		<tr>
			<td>상품아이디</td>
			<td><input type="text" name="id" value="${newId}" readonly size="50"></td>
		</tr>
		<tr>	
			<td>상품이름</td>
			<td><input type="text" name="title" size="50"></td>
		</tr>
		<tr>
			<td>상품가격</td>
			<td><input type="text" name="price" size="50"></td>
		</tr>
		<tr>	
			<td>상품브랜드</td>
			<td><input type="text" name="brand" size="50"></td>
		</tr>
		<tr>	
			<td>상품이미지</td>
			<td>
				<img id="image" src="https://dummyimage.com/150x120/bab6ba/ffffff" width="150">
				<input type="file" name="image" style="display: none;">
			</td>
		</tr>
	</table>
	<div class="buttons">
		<button>상품등록</button>
		<button type="reset">등록취소</button>
	</div>
</form>
<script>
	$("#image").on("click", function() {
		$(frm.image).click();
	});
	
	$(frm).on("submit", function(e) {
		e.preventDefault();
		
		var title = $(frm.title).val();
		var price = $(frm.price).val();
		var brand = $(frm.brand).val();
		var image = $(frm.image).val();
		
		if(title == "") {
			alert("상품이름을 입력해주세요.");
			$(frm.title).focus();
			return;
		}
		if(price == "") {
			alert("상품가격을 입력해주세요.");
			$(frm.price).focus();
			return;
		}
		if(brand == "") {
			alert("상품브랜드를 입력해주세요.");
			$(frm.brand).focus();
			return;
		}
		if(image == "") {
			alert("상품이미지를 입력해주세요.");
			$(frm.image).focus();
			return;
		}
		
		if(!confirm("상품을 등록하시겠습니까?")) return;
		frm.action = "/shop/register";
		frm.submit();
		
	});
	
	// 이미지 미리보기
	$(frm.image).on("change", function(e) {
		var reader = new FileReader();
		reader.readAsDataURL(this.files[0]);
		reader.onload = function(e) {
			$("#image").attr("src", e.target.result);
		}
	});
</script>