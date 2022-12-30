<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1 class="middleTitle">주소목록</h1>
<a href="/insert">주소등록</a>
<table id="list" border=1></table>
<script id="temp" type="text/x-handlebars-template">
{{#each array}}
	<tr class="row">
		<td width=100>{{id}}</td>
		<td width=100><a href="/read?id={{id}}">{{name}}</a></td>
		<td width=200>{{tel}}</td>
		<td width=300>{{address}}</td>
		<td><button id="{{id}}">삭제</button></td>
	</tr>
{{/each}}
</script>

<script>
	getList();
	
	// 삭제 버튼 클릭
	$("#list").on("click", ".row button", function() {
		var id = $(this).attr("id");
		if(!confirm(id + "번을 삭제하시겠습니까?")) return;
		//삭제
		$.ajax({
			type: "post",
			url: "/delete",
			data: { id: id },
			success: function() {
				alert("삭제되었습니다.");
				getList();
			}
		})
	});
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/list.json",
			dataType: "json",
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#list").html(temp(data));
			}
		})
	};
</script>