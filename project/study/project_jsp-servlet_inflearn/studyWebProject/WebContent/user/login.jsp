<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form name="frm">
    <div id="login">
    	<h1 id="middleTitle">로그인</h1>
        <div class="inner">
            <ul class="listInput">
                <li><input id="loginId" type="text" placeholder="아이디"></li>
                <li><input id="loginPassword" type="password" placeholder="비밀번호"></li>
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
		var userid = $("#loginId").val();
		var userpassword = $("#loginPassword").val();
		
		if(userid == "") {
			alert("아이디를 입력해주세요.");
			$("#loginId").focus();
			return;
		}
		
		if(userpassword == "") {
			alert("비밀번호를 입력해주세요.");
			$("#loginPassword").focus();
			return;
		}
		
		// 로그인체크
		$.ajax({
			type: "get",
			url: "/user/login.json",
			data: { userid: userid },
			dataType: "json",
			success: function(data) {
				if(data.userid == null) {
					alert("아이디가 존재하지 않습니다.");
					$("#loginId").focus();
				} else if(data.userpassword != userpassword) {
					alert("비밀번호가 일치하지 않습니다.");
					$("#loginPassword").focus();
				} else {
					//alert("성공");
					location.href = '/user/ownList';
				}
			}
		});
	});
</script>