<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">영화등록</h1>
<form name="frm" method="post" enctype="multipart/form-data">
	<table id="tbl">
		<tr>
			<td>영화제목</td>
			<td><input type="text" name="title" size="70"></td>
		</tr>
		<tr>
			<td>영화배우</td>
			<td><input type="text" name="actor" size="70"></td>
		</tr>
		<tr>
			<td>영화감독</td>
			<td><input type="text" name="director" size="70"></td>
		</tr>
		<tr>
			<td>제작년도</td>
			<td><input type="text" name="pubDate" value="2022" size="70"></td>
		</tr>
		<tr>
			<td class="lastTd">포스터</td>
			<td class="lastTd">
				<img id="image" src="https://dummyimage.com/110x157/bab6ba/FFFFFF" width="110">
				<input type="file" name="image" style="display: none;">
			</td>
		</tr>
	</table>
	<div class="buttons">
		<button>영화등록</button>
		<button type="reset">등록취소</button>
	</div>
</form>
<script>
	$("#image").on("click", function() {
		$(frm.image).click();
	});
	
	// 이미지 미리보기
	$(frm.image).on("change", function(e) {
		var reader = new FileReader();
		reader.readAsDataURL(this.files[0]);
		reader.onload = function(e) {
			$("#image").attr("src", e.target.result);
		}
	});

	$(frm).on("submit", function(e) {
		e.preventDefault();
		var title = $(frm.title).val();
		var image = $(frm.image).val();
		
		if(title == "") {
			alert("제목을 입력해주세요.");
			$(frm.title).focus();
			return;
		}
		if(image == "") {
			alert("포스터를 선택해주세요.");
			$(frm.image).focus();
			return;
		}
		if(!confirm("영화를 등록하시겠습니까?")) return;
		// 영화 등록
		frm.submit();
		
	});
</script>