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
<script src="/views/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/views/css/w3.css">
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<title>Insert title here</title>
<style>
	.myHomeHeaderArea {
		margin:0 auto;
		margin-top:70px;
		display:inline-block;
		width:100%;
	}
	.myHomeHeaderArea .MyHomeProfileImageArea {
		width: 140px;
		height: 140px;
		background: #C5CCE9;
		border-radius: 50%;
		margin-left:120px;
		margin-bottom:50px;
		display:inline-block;
		overflow:hidden;
	}
	.MyHomeProfileImageArea img {
		width:100%;
		height:100%;
	}
	.myHomeHeaderArea .MyHomeProfileinformation {
		width:450px;
		list-style:none;
		padding-left:0px;
		margin-left:130px;
		display:inline-block;
		text-align:center;
	}
	.myHomeHeaderArea .MyHomeProfileinformation li{
		text-align:left;
		height:0 auto;
		display:table;
		vertical-align:middle;
		position:relative;
	}
	.myHomeHeaderArea .MyHomeProfileinformation li button{
		position:absolute;
		right:5px;
		width: 87px;
		background-color: #f8585b;
		border: none;
		color: #FDEBEC;
		padding: 7px 0;
		text-align: center;
		text-decoration: none;
		font-size: 14px;
		cursor: pointer;
		border-radius:5px;
	}
	.myHomeHeaderArea .MyHomeProfileinformation li .MyHomenickNameArea {
		font-size:25px;
		margin-bottom:30px;
		margin-right:110px;
		font-weight:200;
	}
	.myHomeHeaderArea .MyHomeProfileinformation li h6 {
		font-size:17px;
		display:inline-block;
		margin:0px;
		margin-right:5px;
		font-weight:unset;
	}
	.myHomeHeaderArea .MyHomeProfileinformation li .MyHomefollow, 
	.myHomeHeaderArea .MyHomeProfileinformation li .MyHomefollower,
	.myHomeHeaderArea .MyHomeProfileinformation li .MyHomeMyReview {
		font-size:16px;
		font-weight:600;
		display:inline-block;
		margin:0px;
		margin-bottom:30px;
		margin-right:15px;
	}
	.myHomeHeaderArea .MyHomeProfileinformation .MyHomeIntroduction{
		width: 80%;
		font-size:12px;
		margin-top:0px;
		margin-bottom:0px;
	}
	.settingArea {
		z-index: 300;
   		position: absolute;
   		left: 50%;
   		margin-left:-125px;
    	top: 200px;
	}
	@media all and (max-width:769px) {
		.myHomeHeaderArea {
			text-align:center;
		}
		
		.myHomeHeaderArea .MyHomeProfileImageArea { 
			width:150px;
			margin-left:146px;
			margin-right:146px;
			margin-bottom:0px;
		}
		.myHomeHeaderArea .MyHomeProfileinformation { 
			width:400px;
			margin-left:20px;
			margin-right:20px;
			text-align:center;
		}
		.myHomeHeaderArea .MyHomeProfileinformation li{ 
			width:100%;
			text-align:center;
		}
		.myHomeHeaderArea .MyHomeProfileinformation li p{ 
			text-align: center;
    		display: table-cell;
		}
	}
</style>
<script>
	$(function(){
		$(".myInfoModifyBtn").click(function(){
			$.ajax({
				url:"../setting/setting.jsp",
				data:"html",
				success:function(data){	
					$(".settingArea").html(data);
					document.getElementById('settingBoardArea').style.display='block';
					document.getElementById('settingArea').style.display='block';
				}
			});
		});
	})
	
	function displayNone(){
		document.getElementById('settingArea').style.display='none';
		document.getElementById('settingBoardArea').style.display='none';
	}
</script>
</head>
<body>
	<div class="myHomeHeaderArea">
		<div class="MyHomeProfileImageArea">
			<img src="/views/img/mypage/defaultProfileImage.jpg">
		</div>
		<ul class="MyHomeProfileinformation">
			<li>
				<%-- <h6 class="MyHomenickNameArea"><%= loginUser.getUserId() %></h6> --%>
				<button class="myInfoModifyBtn">프로필 편집</button>
			</li>
			<li>
				<h6>게시뷰 </h6>
				<p class="MyHomeMyReview"> 27</p>
				<h6>팔로우 </h6>
				<p class="MyHomefollow"> 102</p>
				<h6>팔로워 </h6>
				<p class="MyHomefollower"> 291</p>
			</li>
			<li>
				<%-- <p class="MyHomeIntroduction">
					<%= loginUser.getIntro() %>
				</p> --%>
			</li>
		</ul>
	</div>
	
	<div id="settingArea" class="settingArea"></div>
	<div id="settingBoardArea" class="w3-modal" onclick="displayNone();"></div>
</body>
</html>