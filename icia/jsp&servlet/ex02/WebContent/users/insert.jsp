<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 id="middleTitle">사용자등록</h1>
<form name="frm" method="post">
	<table id="insert">
		<tr>
			<td class="insertTableLeft" width=100>아이디</td>
			<td class="insertTableRight">
				<input type="text" name="id">
				<button id="check" type="button">중복확인</button>
			</td>
		</tr>
		<tr>
			<td class="insertTableLeft" width=100>비밀번호</td>
			<td class="insertTableRight">
				<input type="password" name="password">
			</td>
		</tr>
		<tr>
			<td class="insertTableLeft" width=100>이름</td>
			<td class="insertTableRight">
				<input type="text" name="name">
			</td>
		</tr>
	</table>
	<div class="buttons">
		<button type="submit">사용자등록</button>
		<button type="reset">등록취소</button>
	</div>
</form>
<script>
	var check = false;
	
	$(frm.id).on("change", function() {
		check = false;
	})
	
	$("#check").on("click", function() {
		var id = $(frm.id).val();
		if(id == "") {
			alert("아이디를 입력해주세요.");
			$(frm.id).focus();
			return;
		}
		//중복확인
		$.ajax({
			type: "get",
			url: "/idcheck",
			data: { id: id },
			dataType: "json",
			success: function(data) {
				if(data.id == null) {
					alert("사용 가능한 아이디입니다.");
					check = true;
				} else {
					alert("이미 사용중인 아이디입니다.")
				}
			}
		})
	});
	
	$(frm).on("submit", function(e) {
		e.preventDefault();
		var id = $(frm.id).val();
		var password = $(frm.password).val();
		
		var name = $(frm.name).val();
		if(id == "") {
			alert("아이디를 입력해주세요.");
			$(frm.id).focus();
			return;
		}
		if(check == false) {
			alert("중복확인을 해주세요.");
			return;
		}
		if(password == "") {
			alert("비밀번호를 입력해주세요.");
			$(frm.password).focus();
			return;
		}
		if(name == "") {
			alert("이름을 입력해주세요.");
			$(frm.name).focus();
			return;
		}
		if(!confirm("사용자를 등록하시겠습니까?")) return;
		
		//사용자등록
		frm.submit();
	});
</script>