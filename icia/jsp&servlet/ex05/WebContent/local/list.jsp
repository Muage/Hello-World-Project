<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<h1 id="middleTitle">지역목록</h1>
<div>
	전체데이터수: <spqn>${count}건</spqn>
</div>
<table id="tbl">
	<tr class="title">
		<td width="120">No.</td>
		<td width="200">Name</td>
		<td width="250">Address</td>
		<td width="130">Phone</td>
		<td width="100">Keyword</td>
		<td width="110">Date</td>
	</tr>
	<c:forEach items="${array}" var="vo">
		<tr class="row">
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.address}</td>
			<td>${vo.phone}</td>
			<td>${vo.keyword}</td>
			<td><fmt:formatDate value="${vo.wdate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</c:forEach>
</table>
<div class="buttons">
	<form name="frm">
		<button id="prev" <c:out value="${page == 1 ? 'disabled' : ''}" />>이전</button>
		<input type="hidden" value="${page}" name="page">
		<span>${page} / ${last}</span>
		<button id="next" <c:out value="${page == last ? 'disabled' : ''}" />>다음</button>
	</form>
</div>

<script>
	$("#next").on("click", function() {
		var page = $(frm.page).val();
		page++;
		$(frm.page).val(page);
	});
	
	$("#prev").on("click", function() {
		var page = $(frm.page).val();
		page--;
		$(frm.page).val(page);
	});
	
</script>