<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			#info{
				overflow: hidden;
				margin-top: 40px;
			}
			#image{
			float: left;
			}
			#content h2{
			text-align: center;
			
			}
			#content .price1{
			margin-top: 20px;
			margin-right: 150px;
			font-size: 30px;
			}
			#content .price2{
			margin-right: 150px;
			font-size: 20px;
			}
			.sold{
				font-weight: bold;
				color: red;
			}
			#mc{
			margin-top: 150px;
			float: right;
			margin-right: 150px;
			}
			#prod{
			margin-right: 200px;
			}
			#buy{
			cursor: pointer;
			}
			#cart{
			cursor: pointer;
			}
		</style>
		<meta charset="EUC-KR">
		<title>read</title>
	</head>
	<body>
		<div id="info">
			<div id="image">
				<img src="https://placeimg.com/200/100/any"width=500>
			</div>
			<div id="content">
				<div id="prod">
					<h2>(${vo.lecturecode })${vo.lecturename}</h2>
					
					<h2>${vo.professorsname }</h2>
				</div>
				<br>
				<div style="float: right;">
					<br>
					<div class="price1"><h4>${vo.lecturecontent }</h4></div>
				</div>
				<div style="margin-top: 100px; float: right; margin-right:200px; font-size: 30px ">
					<div id="buy" style="background-color: black; color: white;">구매하기</div>
					<div id="cart" style="background-color: gray; color: white;">장바구니</div>
				</div>
			</div>
		</div>
	</body>
</html>