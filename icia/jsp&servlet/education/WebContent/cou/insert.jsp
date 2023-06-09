<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">강좌등록</h1>
<form name="frm" method="post">
	<table id="tbl">
		<tr>
			<td>강좌번호</td>
			<td><input type="text" name="lcode" value="${code}" readonly></td>			
		</tr>
		<tr>
			<td>강좌이름</td>
			<td><input type="text" name="lname"></td>			
		</tr>
		<tr>
			<td>담당교수</td>
			<td>
				<select name="instructor" id="plist"></select>
			</td>
		</tr>
		<tr>
			<td>강좌시수</td>
			<td>
				<input type="radio" name="hours" value="1">1시간&nbsp;&nbsp;&nbsp;
				<input type="radio" name="hours" value="2" checked>2시간&nbsp;&nbsp;&nbsp;
				<input type="radio" name="hours" value="3">3시간
			</td>
		</tr>
		<tr>
			<td>강의실</td>
			<td><input type="text" name="room" size=5> 호</td>
		</tr>
		<tr>
			<td class="lastTd">수강최대인원</td>
			<td class="lastTd"><input type="text" name="capacity" size=3> 명</td>
		</tr>
	</table>
	<div class="buttons">
		<button>강좌등록</button>&nbsp;&nbsp;&nbsp;
		<button type="reset">등록취소</button>
	</div>
</form>
<script id="temp" type="text/x-handlebars-template">
	{{#each array}}
		<option value="{{pcode}}">{{pname}}({{dept}}:{{pcode}})</option>
	{{/each}}
</script>
<script>
	changeDept();
	
	//전체교수목록
	$.ajax({
		type: "get",
		url: "/pro/list.json",
		dataType: "json",
		data: { key: "pcode", word: "", per: 100, order: "pcode", desc: "asc", page: 1 },
		success: function(data) {
			var temp = Handlebars.compile($("#temp").html());
			$("#plist").html(temp(data));
		}
	});

	function changeDept() {
		var dept = $(frm.dept).val();
		$.ajax({
			type: "get",
			url: "/pro/list.json",
			dataType: "json",
			data: { key: "dept", word: dept, per: 100, order: "pname", desc: "", page: 1 },
			success: function(data) {
				var temp = Handlebars.compile($("#temp").html());
				$("#plist").html(temp(data));
			}
		})
	}
	
	$(frm).on("submit", function(e) {
		e.preventDefault();
		var lname = $(frm.lname).val();
		
		if(lname == "") {
			alert("강좌이름을 입력해주세요.");
			$(frm.lname).focus();
			return;
		}
		
		if(!confirm("새로운 강좌를 등록하시겠습니까?")) return;
		frm.submit();
	});
</script>