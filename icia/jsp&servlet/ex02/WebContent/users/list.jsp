<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>.red {background: red;}</style>
<h1 id="middleTitle">사용자목록</h1>
<div id="listCount">
	전체 사용자수: <span id="count"></span>
</div>
<table id="list"></table>
<script id="temp" type="text/x-handlebars-template">
	<tr class="title">
		<td width=150>아이디</td>
		<td width=100>비밀번호</td>
		<td width=100>이름</td>
		<td width=100>수정</td>
		<td width=100>삭제</td>
	</tr>
	{{#each array}}
	<tr class="row">
		<td class="id">{{id}}</td>
		<td>{{password}}</td>
		<td class="name">{{name}}</td>
		<td><button class="update">수정</button></td>
		<td><button class="delete {{color del}}">{{btn del}}</button></td>
	</tr>
	{{/each}}
</script>
<script>
	Handlebars.registerHelper("btn", function(del) {
		if(del == 0) return "삭제";
		else return "복구"
	});
	
	Handlebars.registerHelper("color", function(del) {
		if(del == 1) return "red";
	});
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page">1/4</span>
	<button id="next">다음</button>
</div>
<script>
	var page = 1;
	getList();
	
	//이전 버튼 클릭
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	//다음 버튼 클릭
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/users/list.json",
			dataType: "json",
			data: { page: page },
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#list").html(temp(data));
				var last = Math.ceil(data.count / 3);
				$("#page").html(page + "/" + last);
				
				if(page == 1) $("#prev").attr("disabled", true);
				else $("#prev").attr("disabled", false);
				
				if(page == last) $("#next").attr("disabled", true);
				else $("#next").attr("disabled", false);
				
				$("#count").html(data.count + "명");
			}
		})
	};
	
	//수정 버튼 클릭
	$("#list").on("click", ".row .update", function() {
		var row = $(this).parent().parent();
		var id = row.find(".id").html();
		location.href = "/users/read?id=" + id;
	});
	
	//삭제 버튼 클릭
	$("#list").on("click", ".row .delete", function() {
		var sel = $(this).html();
		var row = $(this).parent().parent();
		var id = row.find(".id").html();
		var name = row.find(".name").html();
		if(!confirm(id +"(" + name + ") 사용자를 " + sel + "하시겠습니까?")) return;
		//사용자삭제
		$.ajax({
			type: "post",
			url: "/users/delete",
			data: { id: id, sel: sel },
			success: function() {
				alert("사용자가 " + sel + "되었습니다.");
				getList();
			}
		})
	});
</script>