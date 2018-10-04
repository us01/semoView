<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/triangleView/css/w3.css">

<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>

<style>
	.button {
		background-color: #db8e1f;
		border: none;
		color: white;
		padding: 80px 40px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 18px;
		margin: 4px 2px;
		cursor: pointer;
		width: 200px;
		height: 200px;
	}
	
	.button1{
		background: url(/triangleView/img/writeForm/cardReview.png) 0 0 no-repeat;
		background-size: 200px;
		width: 200px;
		height: 200px;
		display: inline-block;
		border: 1px solid white;
		left: 120px;
	    top: 50px;
	}
	
	.button2 {
		background: url(/triangleView/img/writeForm/textReview.png) 0 0 no-repeat;
		background-size: 200px;
		width: 200px;
		height: 200px;
		display: inline-block;
		border: 1px solid white;
		left: 320px;
	    top: 50px;
	} 
	.button3 {
		background: url(/triangleView/img/writeForm/movieReview.png) 0 0 no-repeat;
		background-size: 200px;
		width: 200px;
		height: 200px;
		display: inline-block;
		border: 1px solid white;
		left: 520px;
	    top: 50px;
	} 
	
	#settingArea {
		z-index: 300;
		position: absolute;
		left: 30%;
		margin-left: -175px;
		top: -25px;
	}
</style>
<script>
	function write1PageMove() {
		location.href = "/triangleView/views/writeForm/write1.jsp";
	}

	function write2PageMove() {
		location.href = "/triangleView/views/writeForm/write2.jsp";
	}
	
	function write3PageMove() {
		location.href = "/triangleView/views/writeForm/write3.jsp";
	}
</script>
<body>
	<div style="text-align:center; height:300px; width:700px; background-color: white; margin-left: -100px;
    margin-top: 200px; border-radius: 23px;" id="settingArea" >
		<div class="buttonFreind">
			<p style="text-align: center; font-weight: bold; margin: 25px 0 10px; font-size: 18px;">리뷰 형태를 선택하세요</p>
			<button id="write1" class="button button1" onclick="write1PageMove()">
			</button>
			<button id="write2" class="button button2" onclick="write2PageMove()">
			</button>
			<button id="write3" class="button button3" onclick="write3PageMove()">
			</button>
		</div>	
	</div>
</body>
</html>