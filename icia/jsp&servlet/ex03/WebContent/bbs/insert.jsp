<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">글쓰기</h1>
<form name="frm" method="post">
	<table id="insert">
		<tr>
			<td>
				<input type="text" name="title" size=80 placeholder="제목">
			</td>
		</tr>
		<tr>
			<td>
				<textarea rows="10" cols="79" name="content" placeholder="내용을 입력해주세요."></textarea>
			</td>
		</tr>
	</table>
	<div class="buttons">
		<button type="submit">저장</button>
		<button type="reset">취소</button>
	</div>
</form>
<script>
	$(frm).on("submit", function(e) {
		e.preventDefault();
		//유효성체크
		var title = $(frm.title).val();
		var content = $(frm.content).val();
		
		if(title == "") {
			alert("제목을 입력해주세요.");
			$(frm.title).focus();
			return;
		}
		if(content == "") {
			alert("내용을 입력해주세요.");
			$(frm.content).focus();
			return;
		}
		
		if(!confirm("저장하시겠습니까?")) return;
		frm.submit();
	});
</script>