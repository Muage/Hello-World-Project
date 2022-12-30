<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 id="middleTitle">학생정보</h1>
<form name="frm" method="post">
	<table id="tbl">
		<tr style="border: 1px solid gray;">
			<td width="100" class="title">학생번호</td>
			<td width="100"><input type="text" name="scode" value="${vo.scode}" size=9 readonly></td>
			<td width="100" class="title">학생학과</td>
			<td width="150">
				<select name="dept" disabled>
					<option value="전산" <c:out value="${vo.dept == '전산' ? 'selected' : ''}" />>컴퓨터정보공학과</option>
					<option value="전자" <c:out value="${vo.dept == '전자' ? 'selected' : ''}" />>전자공학과</option>
					<option value="건축" <c:out value="${vo.dept == '건축' ? 'selected' : ''}" />>건축공학과</option>
				</select>
			</td>
			<td width="100" class="title">생년월일</td>
			<td width="280"><input type="date" name="birthday" value="${vo.birthday}" readonly></td>
		</tr>
		<tr style="border: 1px solid gray;">
			<td class="title">학생이름</td>
			<td><input type="text" name="sname" value="${vo.sname}" size="5"></td>
			<td class="title">지도교수</td>
			<td>
				<select name="advisor" id="advisor"></select>
			</td>
			<td class="title">학생학년</td>
			<td>
				<input type="radio" name="year" value="1" <c:out value="${vo.year == '1' ? 'checked' : ''}" />>1학년
				<input type="radio" name="year" value="2" <c:out value="${vo.year == '2' ? 'checked' : ''}" />>2학년
				<input type="radio" name="year" value="3" <c:out value="${vo.year == '3' ? 'checked' : ''}" />>3학년
				<input type="radio" name="year" value="4" <c:out value="${vo.year == '4' ? 'checked' : ''}" />>4학년
			</td>
		</tr>
	</table>
	<div class="buttons">
		<button>정보수정</button>
		<button type="reset">수정취소</button>
	</div>
</form>
<!-- 학생학과에 해당하는 교수목록 -->
<script id="temp" type="text/x-handlebars-template">
	{{#each array}}
		<option value="{{pcode}}" {{selected pcode}}>{{pname}}({{dept}}:{{pcode}})</option>
	{{/each}}
</script>
<script>
	var advisor = "${vo.advisor}";
	Handlebars.registerHelper("selected", function(pcode) {
		if(advisor == pcode) return "selected";
		else return "";
	});
</script>
<h2 class="middleTitle">수강신청</h2>
<div>
	수강신청 과목:
	<select id="alist"></select>
	<button id="register">수강신청</button>
</div>
<script id="atemp" type="text/x-handlebars-template">
	{{#each .}}
		<option value="{{lcode}}">{{lcode}}:{{lname}}:{{pname}}(<b>{{persons}}/{{capacity}}</b>)</option>
	{{/each}}
</script>
<!-- 수강신청한 강좌목록 -->
<table id="clist"></table>
<script id="ctemp" type="text/x-handlebars-template">
	<tr class="title">
		<td width=100>강좌번호</td>
		<td width=200>강좌이름</td>
		<td width=100>담당교수</td>
		<td width=100>강의실</td>
		<td width=100>강의시수</td>
		<td width=150>신청일</td>
		<td width=100>수강인원</td>
		<td width=100>수강취소</td>
	</tr>
	{{#each .}}
	<tr class="row">
		<td>{{lcode}}</td>
		<td>{{lname}}</td>
		<td>{{pname}}</td>
		<td>{{room}}</td>
		<td>{{hours}}</td>
		<td>{{edate}}</td>
		<td>{{persons}}/{{capacity}}</td>
		<td><button lcode="{{lcode}}">수강취소</button></td>
	</tr>
	{{/each}}
</script>

<script>
	var scode = "${vo.scode}";
	getClist();
	getAlist();
	
	// 학생정보 수정취소
	$(frm).on("reset", function(){
		if(!confirm("수정을 취소하시겠습니까?")) return;
		location.href="/stu/list";
	});
	
	// 학생정보 수정
	$(frm).on("submit", function(e){
		e.preventDefault();
		if(!confirm("학생 정보를 수정하시겠습니까?")) return;
		frm.action = "/stu/update";
		frm.submit();
	});
	
	// 수강취소 버튼 클릭
	$("#clist").on("click", ".row button", function() {
		var lcode = $(this).attr("lcode");
		if(!confirm(lcode + "강좌를 수강취소 하시겠습니까?")) return;
		$.ajax({
			type: "post",
			url: "/enroll/delete",
			data: { lcode: lcode, scode: scode },
			success: function() {
				alert("수강취소가 완료되었습니다.");
				getClist();
				getAlist();
			}
		});
	});

	// 수강신청 버튼 클릭
	$("#register").on("click", function() {
		var lcode = $("#alist").val();
		// 중복체크
		$.ajax({
			type: "get",
			url: "/enroll/check",
			dataType: "json",
			data: { lcode: lcode, scode: scode },
			success: function(data) {
				if(data.count == 1) {
					alert("이미 수강신청된 강좌입니다.");
				} else {
					if(!confirm(lcode + "강좌를 수강신청하시겠습니까?")) return;
					$.ajax({
						type: "post",
						url: "/enroll/insert",
						data: { lcode: lcode, scode: scode },
						success: function() {
							alert("수강신청이 완료되었습니다.");
							getClist();
							getAlist();
						}
					});
				}
			}
		});
	});
	
	// 강의목록	
	function getAlist() {
		$.ajax({
			type: "get",
			url: "/enroll/alist.json",
			dataType: "json",
			data: { scode: scode },
			success: function(data) {
				var temp = Handlebars.compile($("#atemp").html());
				$("#alist").html(temp(data));
			}
		});
	}
	
	// 수강신청한 강의목록
	function getClist() {
		$.ajax({
			type: "get",
			url: "/enroll/clist.json",
			dataType: "json",
			data: { scode: scode },
			success: function(data) {
				var temp = Handlebars.compile($("#ctemp").html());
				$("#clist").html(temp(data));
				
				if(data.length == 0) {
					$("#clist").append("<tr><td colspan=8 style='color: red; border: none;'>수강신청한 강좌가 없습니다.</td></tr>");
				}
			}
		});
	}
	
	// 같은 학과 지도교수 목록
	var dept = $(frm.dept).val();
	$.ajax({
		type: "get",
		url: "/pro/list.json",
		dataType: "json",
		data: { key: "dept", word: dept, per: 100, order: "pname", desc: "", page: 1 },
		success: function(data) {
			var temp = Handlebars.compile($("#temp").html());
			$("#advisor").html(temp(data));
		}
	})

</script>