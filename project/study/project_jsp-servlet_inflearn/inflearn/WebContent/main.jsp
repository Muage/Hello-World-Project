<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	*{
		margin: 0px auto;
	}
	#div1 {
		overflow:hidden;
   	}
   	#div1 .box, #div2 .box {
     	width: 230px;
    	float: left;
      	margin: 0px 3px;
      	padding: 8px;
      	cursor: pointer;
   	}
   	#div1 .professorsname {
   		margin: 10px 0px;
   		
   	}
</style>
<div id="slide">
	<img src="/img/Main/banner.png" width="1265px;">
</div>

<h2>강의1</h2>
<div id = "div1" style="overflow: hidden;"></div>
<script id="temp" type="text/x-handlebars-template">
   {{#each array}}
   <div class = "box" onclick="location.href='/rec/read?lecturecode={{lecturecode}}'">
      <img src = "https://via.placeholder.com/230x150" width = 230px;  height="150px;">
      <div class = "lecturename">{{lecturename}}</div>
      <div class = "professorsname">{{professorsname}}</div>
   </div>
   {{/each}}
</script>

<h2>강의2</h2>
<div id = "div2" style="overflow: hidden;"></div>

<script>
getLecture1();
getLecture2();

function getLecture1() {
    $.ajax ({
       type : "get",
       url : "/rec/list.json",
       data:{start:0},
       dataType : "json",
       success : function(data) {
          var temp = Handlebars.compile($("#temp").html());
          $("#div1").html(temp(data));
       }
    });
 }
 
function getLecture2() {
    $.ajax ({
       type : "get",
       url : "/rec/list.json",
       data:{start:5},
       dataType : "json",
       success : function(data) {
          var temp = Handlebars.compile($("#temp").html());
          $("#div2").html(temp(data));
       }
    });
 }
</script>