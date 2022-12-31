<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h2>내 학습</h2>
<div id="list">
	<form name="frm" id="sort">
		<span>정렬 기준</span>
		<select id="order" name="order">
			<option value="learndate">최근 공부</option>
			<option value="signup">최근 수강신청</option>
			<option value="lecturename" selected>제목순</option>
		</select>
		<span>진행률</span>
		<select id="filter" name="filter">
			<option value="all">모두보기</option>
			<option value="learning">학습중</option>
			<option value="finish">학습완료</option>
		</select>
		<button id="btnSearch" class="right">검색</button>
		<input type="text" id="word" class="right" placeholder="강의명 또는 지식공유자 이름으로 검색" size="40">
	</form>
</div>
<div id="own"></div>
<script id="ownTemp" type="text/x-handlebars-template">
			{{#each array}}
			<div class="box">
				<img src="/img/div/{{lectureimage}}" width=280/>
				<div class="title ellipsis">{{lecturename}}</div>
				<div>
					<progress class="progress" max="100" value={{progress}}></progress>
				</div>
				<h5 class="lblProgress"> 진행률: {{progress}}%</h5>
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
	var per = 3;
	var userid = "${userid}";
	
	getList();
	
	function getList() {
		var key = $(frm.filter).val() == "all" ? "userid" :	// 모두보기
				$(frm.filter).val() == "learning" ? "progress != 100 and userid" :	// 학습중
				"progress = 100 and userid";	// 학습완료
		// var word = $(frm.word).val();
		var order = $(frm.order).val();
		var desc = order == "lecturename" ? "asc" : "desc";
		// alert(key + "\n" + word + "\n" + order + "\n" + desc+ "\n" + per);
		
		$.ajax({
			type: "get",
			url: "/learn.json",
			dataType: "json",
			data: { key: key, word: userid, order: order, desc: desc, page: page, per: per},
			// data: { key: key, order: order, desc: desc, page: page, per: per},
			success: function(data) {
				// console.log(JSON.stringify(data));
				var temp = Handlebars.compile($("#ownTemp").html());
				$("#own").html(temp(data));
				
				if(data.total == 0) {
					$("#own").append("<h2>수강신청된 강의가 없습니다.</h2>");
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
	}
	
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
	$("#order, #filter").on("change", function() {
		page = 1;
		getList();
	});
	
	// 검색
	$("#word").keyup("submit", function(e) {
		var val = $(this).val();
		if(val == "") {
			$(".box").show();
		} else {
			$(".box").hide();
			$(".box:contains('" + val + "')").show();
		}
	})
	
	/* $(frm).on("submit", function(e) {
		e.preventDefault();
		page = 1;
		getList();
	}) */
</script>