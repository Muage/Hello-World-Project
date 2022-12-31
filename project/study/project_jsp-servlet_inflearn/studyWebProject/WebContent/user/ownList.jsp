<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="menu">
	<h2>내 학습</h2>
	<c:if test="${userid == null}">
		<div class="item right"><a href="/user/login">로그인</a></div>
	</c:if>
	<c:if test="${userid != null}">
		<span class="item"><a href="/user/ownList">보유한 강의</a></span>
		<span class="item"><a href="/user/learning">학습중인 강의</a></span>
		<span class="item"><a href="/user/finish">완료한 강의</a></span>
		<span class="item right">
			<span>${userid}님 환영합니다.</span>
			<a href="/user/logout">로그아웃</a>
		</span>
	</c:if>
</div>
<div id="list">
	<form name="frm" id="sort">
		<span>정렬 기준</span>
		<select name="key">
			<option value="recent_study">최근 공부</option>
			<option value="recent_course">최근 수강신청</option>
			<option value="title">제목순</option>
		</select>
		<span>진행률</span>
		<select name="per">
			<option value="all">모두보기</option>
			<option value="now_learning">학습중</option>
			<option value="finished">학습완료</option>
		</select>
		<button id="btnSearch" class="right">검색</button>
		<input type="text" name="word" class="right" placeholder="강의명 또는 지식공유자 이름으로 검색" size="40">
	</form>
</div>
<div id="own"></div>
<script id="ownTemp" type="text/x-handlebars-template">
	{{#each .}}
	<div class="box">
		<img src="/image/{{lectureimage}}" width=280/>
		<div class="title ellipsis">{{lecturename}}</div>
	</div>
	{{/each}}
</script>
<div class="buttons">
	<button id="prev">이전</button>
	<span id="page"></span>
	<button id="next">다음</button>
</div>
<script>
	var page = 1;
	var userid = "${userid}";
	
	getList();
	
	function getList() {
		$.ajax({
			type: "get",
			url: "/user/ownList.json",
			dataType: "json",
			data: { userid: userid },
			success: function(data) {
				var temp = Handlebars.compile($("#ownTemp").html());
				$("#own").html(temp(data));
				
			}
		});
	}
	
	/* function getList() {
		//var key = $(frm.key).val();
		//var word = $(frm.word).val();
		//var per = $(frm.per).val();
		//var order = $(frm.order).val();
		//var desc = $(frm.desc).val();
		//alert(key + "\n" + word + "\n" + per + "\n" + order + "\n" + desc);
		$.ajax({
			type: "get",
			url: "/user/ownList.json",
			dataType: "json",
			data: { key: "lecturename", word: "", per: 5, order: "lecturename", desc: "asc", page: page },
			success: function(data) {
				//console.log(JSON.stringify(data));
				var temp = Handlebars.compile($("#ownTemp").html());
				$("#own").html(temp(data));
				
				if(data.total == 0) {
					$("#tbl").append("<tr><td colspan=6 style='color: red; border: none;'>주문 내역이 없습니다.</td></tr>");
					$(".buttons").hide();
				} else {
					$("#page").html(page + "/" + data.last);
				
					if(page == 1) $("#prev").attr("disabled", true);
					else $("#prev").attr("disabled", false);
					
					if(page == data.last) $("#next").attr("disabled", true);
					else $("#next").attr("disabled", false);
					$(".buttons").show();
				}
			}
		});
	} */
	
	// 이전 버튼 클릭
	$("#prev").on("click", function() {
		page--;
		getList();
	});
	
	// 다음 버튼 클릭
	$("#next").on("click", function() {
		page++;
		getList();
	});
	
	// 정렬 기준 바뀔 때마다 반응
	$("#per, #order, #desc").on("change", function() {
		page = 1;
		getList();
	});
</script>