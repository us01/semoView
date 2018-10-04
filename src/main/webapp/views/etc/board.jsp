<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세모뷰 로그인 전</title>
<style>
	body {
		margin:0px;
		background:white; 
		font-family:'맑은고딕';
		background-color: white;
	}
	
	.contentsArea {
		margin:0 auto;
		width:900px;
		height:700px;
	}
	
	#accordian {
	
		width: 100%;
		margin: 30px auto 0 auto;
		color: black;
	}
	
	/* 메뉴 스타일 */
	#accordian h3 {
		font-size: 18px;
		line-height: 34px;
		padding: 0 0px;
		cursor: pointer;
	}
	#accordian h3:hover {
		text-shadow: 0 0 1px rgba(255, 255, 255, 0.7);
	}
	
	/* 아이콘폰트 스타일 */
	#accordian h3 span {
		font-size: 16px;
		margin-right: 10px;
		background : white;
	}
	#accordian li {
		list-style-type: none;
	}
	
	/* 서브메뉴 스타일 */
	#accordian ul ul li a {
		color: black;
		text-decoration: none;
		font-size: 13px;
		line-height: 27px;
		display: block;
		padding: 0 15px;
		-webkit-transition: all 0.15s;
		-moz-transition: all 0.15s;
		-o-transition: all 0.15s;
		-ms-transition: all 0.15s;
		transition: all 0.15s;
	}
	#accordian ul ul li a:hover {
	
		border-left: 5px solid #f7323f;
	}
	
	/* active 클래스 외에 것은 보이지 않게 하기 */
	#accordian ul ul {
		display: none;
	}
	#accordian li.active ul {
		display: block;
	}
	.top{
		
		width : 100%;
		height : 200px;
		background : #f7323f;
	}  
</style>
</head>
<body>
	<jsp:include page="../main/header/headerNav.jsp" flush="true" />
	<div class="top" >
		<br><br><br><br><br>
		<h1 style="color : white; margin-left : 60%;  display: inline-block;"><b>공지 사항</b></h1>
		<img src="/triangleView/img/etc/board.png" style="width : 90px; height : 90px; margin-left : 1%;">
	</div>
	<div class="contentsArea">
			<div id="accordian">
			<hr>
			<ul style="padding-left : 0px;">
				<li>
					<h3><span></span><b>[점검]</b> 세모뷰 정기 서버 점검 안내입니다.<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[이벤트]</b>  세상의 모든 리뷰 세모뷰를 공유해주세요!<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[공지]</b>  세상의 모든 리뷰 세모뷰 공지 테스트입니다.<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[점검]</b>  세상의 모든 리뷰, 세모뷰 정기 DB 점검안내입니다.<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[공지]</b>  블랙리스트 안내입니다.<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[공지]</b>  리뷰 작성 시 이것만 주의해 주세요.<hr></h3>
					<ul>
						<li><a href="#"> 2018. 10. 05. 그 동안의 노력을 발표하는 날입니다. 우리 모두 끝나고 적십시다!
										<br><br>
										모두 고생하셨습니다.
										<br><br>
																			Update 2018.10.04</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
	<jsp:include page="../main/footer/mainFooter.jsp" flush="true" />
</body>
<script>
	$(function(){
		$("#accordian h3").click(function(){
			$("#accordian ul ul").slideUp();
			if(!$(this).next().is(":visible"))
			{
				$(this).next().slideDown();
			}
		})
	});
</script>
</html>