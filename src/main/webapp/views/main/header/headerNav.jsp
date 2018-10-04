<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/triangleView/css/w3.css">
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<title>Insert title here</title>
<style>
	body{
		margin:0px;
	}
	.navWrap {
		width: 100%;
		position: fixed;
		background: #F7323F;
		align-text: center;
		position-top:0px;
		z-index:899;
		top:0px;
		user-select:none;
	}
	.deskNav {
		width: 1000px;
		height: 70px;
		margin: auto;
		clear: both;
		position: relative;
	}
	
	.deskNav ul {
		list-style: none; 
		padding-left: 0px;
		width: 100%;
		display: inline-block;
	}
	
	.deskNav ul li {
		display: inline;
	}
	
	.deskNav ul li:nth-of-type(1) {
		float: left;
		width: 220px;
	}
	.deskNav ul li:nth-of-type(1) img{
		width:110px;
	}
	
	.deskNav ul li:nth-of-type(2) {
		float: left;
		width: 480px;
		text-align: center;
		vertical-align: center;
	}
	
	.deskNav ul li:nth-of-type(2) div {
		background: white; 
		box-shadow: 0px 1px 1px 1px rgba(0, 0, 0, 0.3);
	}
	
	.deskNav ul li:nth-of-type(2) div img {
		vertical-align: top;
		width: 7%;
		cursor: pointer;
	}
	
	.deskNav ul li:nth-of-type(2) div input {
		border: none;
		padding-left: 15px;
		box-sizing: border-box;
		height: 35px;
		width: 90%;
		font-size: 11pt;
		font-family: "맑은고딕";
		outline: none;
	}
	
	.deskNav ul li:nth-of-type(2) div input::placeholder {
		font-size: 14pt;
		font-weight: normal;
		color: #ABABAB;
	}
	
	.deskNav ul li:nth-of-type(3) {
		color: white;
		padding-left: 10px;
		padding-bottom: 12px;
		line-height: 35px;
	}
	.deskNav ul li:nth-of-type(3) div{
		display:inline;
		padding-top:4px;
	}
	.deskNav ul li:nth-of-type(3) img {
		cursor: pointer;
		width:25.5px;
		height:25.5px;
	}
	
	.deskNav ul li:nth-of-type(3) ul {
		color: black;
		display: none;
	}
	
	.deskNav ul li:nth-of-type(3):hover ul {
		display: block;
		width: 420px;
		height: 300px;
		background: white;
		position: absolute;
		list-style: none;
		margin-left: 525px;
		margin-top: 3px;
		box-shadow: 0px 1px 1px 1px rgba(0, 0, 0, 0.3);
		border-radius: 1%;
	}
	
	.deskNav ul li:nth-of-type(4) {
		margin-left: 100px;
		width: 80px;
		color: white;
		line-height: 35px;
		padding-bottom: 12px;
	}
	
	.deskNav ul li:nth-of-type(4) span {
		font-size: 9pt;
		cursor: pointer;
	}
	
	.deskNav ul li:nth-of-type(4) span:hover {
		font-size: 14px;
		font-weight: bold;
	}
	
	.deskNav ul li:nth-of-type(4) ul {
		color: black;
		display: none;
	}
	
	.deskNav ul li:nth-of-type(4):hover ul {
		display: block;
		width: 180px;
		height: 195px;
		background: white;
		position: absolute;
		list-style: none;
		margin-left: 770px;
		margin-top: 3px;
		box-shadow: 0px 1px 1px 1px rgba(0, 0, 0, 0.3);
		border-radius: 1%
	}
	
	.deskNav ul li:nth-of-type(4) ul div {
		padding: 28px;
	}
	
	.deskNav ul li:nth-of-type(4) ul div a {
		font-size: 15px;
	}
	
	.deskNav ul li:nth-of-type(4) ul div a:hover {
		color: #f8585b;
		font-weight: bold;
		font-size: 18px;
		cursor: pointer;
	}
	
	.deskNav ul li:nth-of-type(5) {
		margin-left: 30px;
		width: 80px;
		color: white;
		line-height: 35px;
	}
	
	.deskNav ul li:nth-of-type(5) span {
		font-size: 9pt;
		cursor: pointer;
	}
	
	.deskNav ul li:nth-of-type(5) span:hover {
		font-size: 14px;
		font-weight: bold;
	}
	
	.detailTable {
		width: 410px;
		height: 235px;
		margin: 5px;
		border-spacing: 0;
		font: normal 12px Arial, sans-serif;
	}
	.detailTable input[type='checkbox'], .detailTable input[type='radio']{
		display:none;
	}
	.detailTable label:hover{
		cursor:pointer;
		font-weight: bold;
		color: #f8585b;
	}	
	.detailTable tr td:first-child {
		text-align: center;
		width: 25%;
		font-size:11px;
		font-weight:bold;
	}
	
	.detailTable tr td:last-child {
		text-align: left;
		width: 75%;
		font-size:13px;
	}
	.detailTable tr td {
		border-top: solid 1px #957030;
		height:55px;
	}
	.detailTable tr:last-child td {
		text-align:center;
	}
	.applyDetail {
		width: 410px;
		height: 40px;
		padding-top: 6px;
		text-align: center;
	}
	
	.applyDetail button {
		width: 70px;
		background-color: #f8585b;
		border: none;
		color: #FDEBEC;
		padding: 6px 0;
		text-align: center;
		text-decoration: none;
		font-size: 14px;
		margin: 4px;
		cursor: pointer;
		border-radius:5px;
	}
	
	.mobileNav {
		display:none;
		text-align: left;
		margin-left: auto;
		margin-right: auto;
		position: relative;
		padding-top: 14px;
		width: 100%;
		height: 44px;
	}
	.insertMemberTypeArea {
		z-index: 301;
   		position: absolute;
   		left: 50%;
   		margin-left:-150px;
    	top: 150px;
	}
	@media all and (max-width:768px) {
		.mobileWrap {
			height: 44px;
		}
	}
</style>
<script>
	var scrollReaction = true;
	var scrollY = $(window).scrollTop();
	
	$(function(){
		resizeTopNav($(window).innerWidth());
	})
	
	$(window).resize(function(){
		resizeTopNav($(window).innerWidth());
	})
	
	$(window).scroll(function(){
		scrollTopNav($(window).innerWidth());
	})
	
	$(function(){
		$(".detailTable label").on("click", function(){
			var chk = $(this).find("input").is(":checked");
			
			if($(this).find("input").attr("type") == "checkbox"){
				var chkName = $(this).find("input").attr("name");
				
				if(chkName == "recent" || chkName == "like" || chkName == "hits"){
					if($(this).find("input").is(":checked")){
						$(".detailTable tr:nth-of-type(2) label").css("font-weight", "unset").css("color", "black");
						$(".detailTable label").find("input[name='recent']").prop("checked", false);
						$(".detailTable label").find("input[name='like']").prop("checked", false);
						$(".detailTable label").find("input[name='hits']").prop("checked", false);
					}else{
						$(".detailTable tr:nth-of-type(2) label").css("font-weight", "unset").css("color", "black");
						$(".detailTable label").find("input[name='recent']").prop("checked", false);
						$(".detailTable label").find("input[name='like']").prop("checked", false);
						$(".detailTable label").find("input[name='hits']").prop("checked", false);
						$(this).find("input[name=" + chkName + "]").prop("checked", true);
						$(this).css("font-weight", "bold").css("color", "#f8585b");
					}
				}else{
					if(chk){
						$(this).css("font-weight", "bold").css("color", "#f8585b");
					}else{
						$(this).css("font-weight", "unset").css("color", "black");
					}
				}
			}else if($(this).find("input").attr("type") == "radio"){
				$(".searchDate").css("font-weight", "unset").css("color", "black");
				$(this).css("font-weight", "bold").css("color", "#f8585b");
				$(this).prop("checked", true);
			}else if($(this).find("input").attr("type") == "date"){
				$(".searchDate").find("input[type='radio']").prop("checked", false);
				$(".searchDate").css("font-weight", "unset").css("color", "black");
			}
		})
	})
	
	function detailReset(){
		$(".detailTable label").css("font-weight", "unset").css("color", "black");
	}
	
	function resizeTopNav(width){
		if(width < 752){
			if($(".navWrap").css("position") == "absolute" || $(".navWrap").css("position") == "fixed"){
				$(".navWrap").css("position","absolute").css("width", "100%").css("background", "white");
				$(".deskNav").css("display","none");
				$(".mobileNav").css("display","block");
			}
		}else{
			scrollY = $(window).scrollTop();
			
			if($(".navWrap").css("position") == "absolute"){
				scrollReaction = true;
			}
			
			if(scrollY < 2){
				$("#main_Logo").attr("src", "/triangleView/img/main/main_logo_white.png");
				$(".navWrap").css("background","#F7323F").css("box-shadow","0px 0px 0px 0px rgba(0,0,0,0)");
				$(".deskNav").css("display","block");
				$(".mobileNav").css("display","none");
				$(".mainNavLi").css("color","white");
				$(".openDetail").attr("src", "/triangleView/img/main/detail_search_white.png");
				scrollReaction = true;
			}else{
				if(scrollReaction){
					$("#main_Logo").attr("src", "/triangleView/img/main/main_logo_red.png");
					$(".navWrap").css("background","white").css("position","fixed").css("border-style", "hidden").css("box-shadow", "0px 2px 3px 0px rgba(0,0,0,0.1)");
					$(".deskNav").css("display","block");
					$(".mobileNav").css("display","none");
					$(".mainNavLi").css("color","black");
					$(".openDetail").attr("src", "/triangleView/img/main/detail_search_red.png");
				}
				scrollReaction = false;
			}
		}
	}
	
	function scrollTopNav(width){
		scrollY = $(window).scrollTop();
		
		if(width < 752){
			if($(".navWrap").css("position") == "absolute" || $(".navWrap").css("position") == "fixed"){
				$(".navWrap").css("width", "100%").css("position", "absolute").css("background", "white");
				$(".deskNav").css("display","none");
				$(".mobileNav").css("display","block");
			}
		}else{
			if(scrollY < 2){
				$("#main_Logo").attr("src", "/triangleView/img/main/main_logo_white.png");
				$(".navWrap").stop().animate({
					"backgroundColor":"#F7323F"
				}, 200);
				$(".navWrap").css("box-shadow","0px 0px 0px 0px rgba(0,0,0,0)");
				$(".deskNav").css("display","block");
				$(".mobileNav").css("display","none");
				$(".mainNavLi").css("color","white");
				$(".openDetail").attr("src", "/triangleView/img/main/detail_search_white.png");
				scrollReaction = true;
			}else{
				if(scrollReaction){
					$("#main_Logo").attr("src", "/triangleView/img/main/main_logo_red.png");
					$(".navWrap").css("position","fixed").css("border-style", "hidden").css("box-shadow", "0px 2px 3px 0px rgba(0,0,0,0.1)");
					$(".navWrap").stop().animate({
						"backgroundColor":"white"
					}, 200);
					$(".deskNav").css("display","blcok");
					$(".mobileNav").css("display","none");
					$(".mainNavLi").css("color","black");
					$(".openDetail").attr("src", "/triangleView/img/main/detail_search_red.png");
				}
				scrollReaction = false;
			}
		}
	}
	
	function insertMemberTypeDisplayBlock(){
		$(".insertMemberTypeArea").css("margin-left", "-150px");
		$.ajax({
			url : "/triangleView/views/member/loginOrInsertMemberType.jsp",
			data : "html",
			success : function(data) {
				$(".insertMemberTypeArea").html(data);
				document.getElementById('insertMemberTypeAearArea').style.display = 'block';
				document.getElementById('insertMemberTypeArea').style.display = 'block';
			}
		});
	}

	function insertMemberTypeDisplayNone() {
		document.getElementById('insertMemberTypeArea').style.display = 'none';
		document.getElementById('insertMemberTypeAearArea').style.display = 'none';
	}
	function myHome(){
		location.href='<%= request.getContextPath()%>/myHome';
	}
	
	function myComp(){
		location.href="<%=request.getContextPath()%>/noticeList";
	}
	
	function myAdmin(){
		location.href="/triangleView/views/admin/main/mainpage2.jsp";
	}
	
	function openqna(){
		location.href="/triangleView/views/etc/qna.jsp";
	}
	
	function openboard(){
		location.href="/triangleView/views/etc/board.jsp";
	}
	
	function openprovision(){
		location.href="/triangleView/views/etc/provision.jsp";
	}
</script>
</head>
<body>
	<div class="navWrap">
		<form id="searchForm" method="POST">	
		  	<input type="text" style="display: none;" />
			<div class="deskNav">
				<ul>
					<li>
						<% if(loginUser != null) { %>
							<a href="<%= request.getContextPath() %>/loginMain">
								<img id="main_Logo" src="/triangleView/img/main/main_logo_white.png">
							</a>
						<% }else { %>
							<a href="/triangleView/index.jsp">
								<img id="main_Logo" src="/triangleView/img/main/main_logo_white.png">
							</a>
						<% } %>
					</li>
					<li>
						<div>
							<input type="text" name="searchHash" id="searchHash"><img onclick="naySearch()" src="/triangleView/img/main/btn_search.png">
						</div>
					</li>
					<li><div><img class="openDetail"></div>
						<ul>
							<li>
								<div>
									<table class="detailTable">
										<tr>
											<td>기간</td>
											<td>
												<label class="searchDate"><input type="radio" name="term" value="oneDay">1일</label>&nbsp;&nbsp;&nbsp; 
												<label class="searchDate"><input type="radio" name="term" value="oneWeek">1주</label>&nbsp;&nbsp;&nbsp; 
												<label class="searchDate"><input type="radio" name="term" value="oneMonth">1개월</label><br>
												<label>
													<input name="sinceTime" id="sinceTime" type="date">~<input name="untilTime" id="untilTime" type="date">
												</label>
											</td>
										</tr>
										<tr>
											<td>조건</td>
											<td>
												<label><input type="checkbox" name="recent" value="recent">최신순</label>&nbsp;&nbsp;&nbsp;
												<label><input type="checkbox" name="like" value="like">좋아요순</label>&nbsp;&nbsp;&nbsp;
												<label><input type="checkbox" name="hits" value="hits">조회순</label>
											</td>
										</tr>
										<tr>
											<td>형태</td>
											<td><label><input type="checkbox" name="text" value="text">텍스트</label>&nbsp;&nbsp;&nbsp; 
												<label><input type="checkbox" name="card" value="card">카드</label>&nbsp;&nbsp;&nbsp; 
												<label><input type="checkbox" name="video" value="video">동영상</label>
											</td>
										</tr>
										<tr>
											<td>Who</td>
											<td>
												<% if(loginUser != null){ %>
													<label><input type="checkbox" name="follower" value="follower">팔로우회원</label>&nbsp;&nbsp;&nbsp;
												<% } %>
												<label><input type="checkbox" name="company" value="company">기업회원제외</label>
											</td>
										</tr>
										<tr>
											<td colspan="2">
												<div class="applyDetail">
													<button type='button'>검색</button>
													<button type="reset" onclick="detailReset();">초기화</button>
												</div>
											</td>
										</tr>
									</table>
								</div>
							</li>
						</ul>
					</li>
					<li class="mainNavLi"><span>더보기</span>
						<ul>
							<li>
								<div>
									<a onclick="openboard();">공지사항</a><br>
									<a onclick="openqna();">자주 묻는 질문</a><br>
									<a href="https://open.kakao.com/o/sGuoSQZ" target="_blank">1:1문의</a><br>
									<a onclick="openprovision();">약관 및 정책</a>
								</div>
							</li>
						</ul></li>
					<li class="mainNavLi">
						<% if(loginUser != null){ %>
							<%if(loginUser.getUserType() == 0) { %>
								<span onclick="myHome()">마이뷰</span>	
							<% } else if(loginUser.getUserType() == 1) {%>
								<span onclick="myComp()">기업뷰</span>	
							<% } else { %>
								<span onclick="myAdmin()">관리자</span>	
							<% } %>
						<% }else{ %>
							<span onclick="insertMemberTypeDisplayBlock()">로그인</span>
						<% } %>
					</li>
				</ul>
			</div>
		</form>
		<div class="mobileNav"></div>
	</div>
	<div id="insertMemberTypeArea" class="insertMemberTypeArea"></div>
	<div id="insertMemberTypeAearArea" class="w3-modal" onclick="insertMemberTypeDisplayNone();"></div>
</body>
</html>