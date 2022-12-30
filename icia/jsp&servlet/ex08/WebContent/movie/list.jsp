<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1 id="middleTitle">영화목록</h1>
<div id="middleTop">
	<button id="delete" class="middleButton">선택삭제</button>
	전체영화수: <span>${count}</span>
	<a id="right" href="/movie/insert"><button class="middleButton">영화등록</button></a>
</div>
<table id="tbl">
	<tr class="title">
		<td><input type="checkbox" id="chkAll"></td>
		<td width="100">포스터</td>
		<td width="250">제목</td>
		<td width="300">출연진</td>
		<td width="150">감독</td>
		<td width="100">등록일</td>
	</tr>
	<c:forEach items="${array}" var="vo">
	<tr class="row">
		<td><input type="checkbox" class="chk" id="${vo.id}" image="${vo.image}"></td>
		<td><img src="/image/movie/${vo.image}" width="80"></td>
		<td>${vo.title}</td>
		<td>${vo.actor}</td>
		<td>${vo.director}</td>
		<td><fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	</c:forEach>
</table>
<div class="buttons">
	<form name="frm">
		<button id="prev" <c:out value="${page == 1 ? 'disabled' : ''}" />>이전</button>
		<input type="text" name="page" size=1 value="${page}">/${last}
		<button id="next" <c:out value="${page == last ? 'disabled' : ''}" />>다음</button>
	</form>
</div>
<script>
	var last = "${last}";
	
	$("#delete").on("click", function() {
		var chk = $("#tbl .row .chk:checked").length;
		if(chk == 0) {
			alert("삭제할 영화를 선택해주세요.");
			return;
		}
		if(!confirm(chk + "개 영화를 삭제하시겠습니까?")) return;
		$("#tbl .row .chk:checked").each(function() {
			var id = $(this).attr("id");
			var image = $(this).attr("image");
			$.ajax({
				type: "get",
				url: "/movie/delete",
				data: { id: id, image: image },
				success: function() {}
				
			});
		});
		alert(chk + "개 영화가 삭제되었습니다.");
		location.href = "/movie/list";
	});

	//전체 체크박스 선택
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
	
	// 이전 버튼 클릭
	$("#prev").on("click", function() {
		var page = $(frm.page).val();
		page--;
		$(frm.page).val(page);
		
	});
	
	// 다음 버튼 클릭
	$("#next").on("click", function() {
		var page = $(frm.page).val();
		page++;
		$(frm.page).val(page);
	});
	
	$(frm.page).on("keydown", function(e) {
		if(e.keyCode == 13) {
			var page = $(this).val();
			if(page > last) alert("마지막 페이지가 " + last + "페이지 입니다.");
			else frm.submit();
		}
	});
</script>