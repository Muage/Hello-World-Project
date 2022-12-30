<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>사용자정보</title>
</head>
<body>
	<h1>보낸메시지</h1>
	<h4>아이디: ${uid}</h4>
	<h4>성명: </h4>
	<h4></h4>
	<h4>포인트: </h4>
	<h4 id="point" width=100></h4>
	<h4 width=100>받은메시지수: </h4>
	<h4 id="receivecnt" width=100></h4>
	<h4 width=100>보낸메시지수: </h4>
	<h4 id="sendcnt" width=100></h4>
	
	<hr/>
	<a href="/user/list"><button>목록으로</button></a>
</body>
<script>
	var uid = "${uid}";
	
	$.ajax({
		type: "get",
		url: "/api/user/read/" + uid,
		success: function(data) {
			$("#uname").html(data.uname);
			$("#point").html(data.point);
			$("#receivecnt").html(data.receivecnt);
			$("#sendcnt").html(data.sendcnt);
		}
	});
</script>
</html>