<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">게시글 정보</h1>
<form name="frm" method="post">
	<input type="hidden" name="page" value="${cri.pageNum}">
	<table width=800>
		<tr>
			<td><b>[${vo.no}]</b> : ${vo.title}</td>
		</tr>
		<tr>
			<td><b>${vo.wdate}</b> : ${vo.writer}</td>
		</tr>
		<tr>
			<td>${vo.content}</td>
		</tr>
	</table>
	<div class="buttons">
		<button onclick="location.href='/bbs/update?no=${vo.no}'">게시글수정</button>
		<button id="delete">게시글삭제</button>
	</div>
</form>
<script>
	$("#delete").on("click", function() {
		var no = "${vo.no}";
		if(!confirm(no + "번을 삭제하시겠습니까?")) {
			return;
		} else {
			location.href="/bbs/delete?no=" + no;
			history.back();
			history.go();
			history.go(0);
			
		}
	});
</script>