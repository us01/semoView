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
		<h1 style="color : white; margin-left : 56%;  display: inline-block;"><b>자주 묻는 질문</b></h1>
		<img src="/triangleView/img/etc/qna.png" style="width : 90px; height : 90px; margin-left : 1%;">
	</div>
	<div class="contentsArea">
			<div id="accordian">
			<hr>
			<ul style="padding-left : 0px;">
				<li>
					<h3><span></span><b>[회원등급]</b> 어떻게하면 파워리뷰어가 될 수 있나요?<hr></h3>
					<ul>
						<li><a href="#">파워리뷰어는 세모뷰에서 10개 이상의 리뷰를 작성하고 100개 이상의 좋아요, 1,000개 이상의 조회 수 달성 시 
										<br><br>
										신청할 경우 파워리뷰어가 되실 수 있습니다. 
										<br><br>
																			Update 2018.07.05</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[리뷰공고캠페인]</b> 리뷰 공고(리뷰 체험단)는 무엇인가요?<hr></h3>
					<ul>
						<li><a href="#">리뷰 체험단은 기업에게 리뷰할 상품을 받은 후 해당 상품을 사용한 리얼 리뷰를 작성하는 것입니다. 
										<br><br>
										다만, 리뷰 공고를 신청하기 위해서는 '파워리뷰어' 등급이셔야 하며, 
										<br><br>
										주소가 정확하게 기입이 되있으셔야 합니다.
										<br><br>
																			Update 2018.07.05</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[업데이트]</b> 최신 버전 업데이트가 안돼요.<hr></h3>
					<ul>
						<li><a href="#">해당 사항은 1:1 문의사항으로 연락해 주시면 감사하겠습니다.
										<br><br>
																			Update 2018.07.05</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[리뷰공고캠페인]</b> 리뷰 공고는 어떻게 작성할 수 있나요?<hr></h3>
					<ul>
						<li><a href="#">리뷰 공고는 상품을 제공할 수 있는 기업, 개인 사업자의 기업 회원만 작성할 수 있습니다.
										<br><br>
										또한, 모집 인원, 기간 등에 따라 가격이 측정됩니다.
										<br><br>
																			Update 2018.07.05</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[리뷰제휴]</b> 리뷰 제휴는 무엇인가요?<hr></h3>
					<ul>
						<li><a href="#">리뷰 제휴는 일반 회원이 작성한 리뷰에 기업이 특정 사이트를 연결할 링크를 다는 것입니다.
										<br><br>
										만약, 해당 리뷰를 보고 다르 사용자가 링크를 클릭 시 리뷰 작성자에게 포인트가 지급됩니다.
										<br><br>
																			Update 2018.07.05</a></li>
					</ul>
				</li>
				<li>
					<h3><span></span><b>[세모뷰]</b> 세상의 모든 리뷰의 리뷰를 어떻게 신뢰하죠?</h3>
					<ul>
						<li><a href="#">저희는 자체 알고리즘을 통해 사용자에게 좋은 평가의 리뷰만 보이는 것이 아닌 
										<br><br>
										사용자가 여러개의 리뷰를 통해 판단 할 수 있도록 리뷰를 제공하고 있습니다.
										<br><br>
																			Update 2018.07.05</a></li>
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