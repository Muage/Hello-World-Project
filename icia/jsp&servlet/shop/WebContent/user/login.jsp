<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="frm">
    <div id="login">
    	<h2>로그인</h2>
        <div class="inner">
            <ul class="listInput">
                <li><input id="loginId" type="text" name="uid" placeholder="아이디"></li>
                <li><input id="loginPassword" type="password" name="pass" placeholder="비밀번호"></li>
            </ul>
        </div>
        <div>
            <button>로그인</button>
        </div>
    </div>
</form>
<script>
	$(frm).on("submit", function(e) {
		e.preventDefault();
		var uid = $(frm.uid).val();
		var pass = $(frm.pass).val();
		
		if(uid == "") {
			alert("아이디를 입력해주세요.");
			$(frm.uid).focus();
			return;
		}
		
		if(pass == "") {
			alert("비밀번호를 입력해주세요.");
			$(frm.pass).focus();
			return;
		}
		
		// 로그인체크
		$.ajax({
			type: "get",
			url: "/user/login.json",
			data: { uid: uid },
			dataType: "json",
			success: function(data) {
				if(data.uid == null) {
					alert("아이디가 존재하지 않습니다.");
					$(frm.uid).focus();
				} else if(data.pass != pass) {
					alert("비밀번호가 일치하지 않습니다.");
					$(frm.pass).focus();
				} else {
					//alert("성공");
					location.href = '/';
				}
			}
		});
	});
</script>
