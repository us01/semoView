<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.chain.triangleView.userHome.userHome.vo.HomeMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	HashMap<String, Object> userHome = (HashMap<String, Object>)request.getAttribute("userHome");
	HomeMember member = (HomeMember)userHome.get("member");
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
	.myHomeHeaderArea {
		margin:0 auto;
		margin-top:70px;
		margin-bottom:50px;
		display:inline-block;
		width:100%;
	}
	.myHomeHeaderArea .MyHomeProfileImageArea {
		width: 140px;
		height: 140px;
		background: #C5CCE9;
		border-radius: 50%;
		margin-left:120px;
		margin-top:40px;
		margin-bottom:10px;
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
	.myInfoModifyBtn {
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
	.homeFollowTrueBtn {
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
	.homeFollowFalseBtn {
		position:absolute;
		right:5px;
		width: 87px;
		background-color: lightgray;
		border: none;
		color: white;
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
	.MyHomefollow, .MyHomefollower{
		cursor:pointer;
	}
	.myHomeHeaderArea .MyHomeProfileinformation .MyHomeIntroduction{
		width: 450px;
		font-size:12px;
		margin-top:0px;
		margin-bottom:0px;
		display:inline-block;
	}
	.settingArea {
		z-index: 300;
   		position: absolute;
   		left: 50%;
   		margin-left:-125px;
    	top: 200px;
	}
	.followUserArea {
		z-index: 300;
   		position: absolute;
   		left: 50%;
   		margin-left:-200px;
    	top: 150px;
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
	function followFalse(userNo, meNo){
		$.ajax({
			url:'<%= request.getContextPath() %>/followFalse',
			type:'get',
			data:{
				meNo:meNo,
				userNo:userNo
			},
			success:function(data){
				if(data == '팔로우'){
					$('.homeFollowTrueBtn').remove();
					
					$button = '<button class="homeFollowFalseBtn" onclick="followTrue(' + userNo + ', ' + meNo + ')">팔로우 취소</button>';
					
					$('.MyHomeProfileinformation li:first-child').append($button);
				}else if(data == '팔로우 실패'){
					alert('팔로우 실패, 고객센터로 문의 주세요');
				}
			}
		});
	}
	
	function followTrue(userNo, meNo){
		$.ajax({
			url:'<%= request.getContextPath() %>/followTrue',
			type:'get',
			data:{
				meNo:meNo,
				userNo:userNo
			},
			success:function(data){
				if(data == '팔로우 취소'){
					$('.homeFollowFalseBtn').remove();
					
					$button = '<button class="homeFollowTrueBtn" onclick="followFalse(' + userNo + ', ' + meNo + ')">팔로우</button>';
					
					$('.MyHomeProfileinformation li:first-child').append($button);
				}else if(data == '팔로우 취소 실패'){
					alert('팔로우 실패, 고객센터로 문의 주세요');
				}
			}
		});
	}
	
	function myInfoModify(){
		$.ajax({
			url:"/triangleView/views/setting/setting.jsp",
			data:"html",
			success:function(data){	
				$(".settingArea").html(data);
				document.getElementById('settingBoardArea').style.display='block';
				document.getElementById('settingArea').style.display='block';
			}
		});
	}
	
	function displayNone(){
		document.getElementById('settingArea').style.display='none';
		document.getElementById('settingBoardArea').style.display='none';
	}
	
	function followListBlock(userNo, meNo){
		$.ajax({
			url : '<%= request.getContextPath()%>/followUserList',
			data : {
				userNo : userNo,
				meNo : meNo
			},
			success : function(data) {
				$('.followUserArea').html(data);
				document.getElementById('followUserAreaArea').style.display = 'block';
				document.getElementById('followUserArea').style.display = 'block';
			}
		});
	}
	
	function followingListBlock(userNo, meNo){
		$.ajax({
			url : '<%= request.getContextPath()%>/followingUserList',
			data : {
				userNo : userNo,
				meNo : meNo
			},
			success : function(data) {
				$('.followUserArea').html(data);
				document.getElementById('followUserAreaArea').style.display = 'block';
				document.getElementById('followUserArea').style.display = 'block';
			}
		});
	}
	
	function followgListBlock() {
		document.getElementById('followUserArea').style.display = 'none';
		document.getElementById('followUserAreaArea').style.display = 'none';
	}
</script>
</head>
<body>
	<div class="myHomeHeaderArea">
		<div class="MyHomeProfileImageArea">
			<% if(member.getThumbnail() != null){  %>
				<img src="/triangleView/profileImg_upload/<%= member.getThumbnail() %>">
			<% }else{ %>
				<img src="/triangleView/img/mypage/defaultProfileImage.jpg">
			<% } %>
		</div>
		<ul class="MyHomeProfileinformation">
			<li>
				<h6 class="MyHomenickNameArea"><%= member.getNick() %></h6>
				<% if(loginUser != null){ %>
					<% if(loginUser.getUserId().equals(member.getUserId())){ %>
						<button class="myInfoModifyBtn" onclick="myInfoModify()">프로필 편집</button>
					<% } else{ %>
						<% if(member.getFollowTF() > 0){ %>
							<button class="homeFollowTrueBtn" onclick="followFalse(<%= member.getUserNo() %>, <%= loginUser.getUserNo() %>)">팔로우</button>
						<% }else{ %>
							<button class="homeFollowFalseBtn" onclick="followTrue(<%= member.getUserNo() %>, <%= loginUser.getUserNo() %>)">팔로잉 취소</button>
						<% } %>
					<% } %>
				<% } %>
			</li>
			<li>
				<h6>게시뷰</h6>
				<p class="MyHomeMyReview"><%= member.getReviewCount() %></p>
				<% if(loginUser != null){ %>
					<h6 onclick="followingListBlock(<%= member.getUserNo() %>)">팔로워</h6>
					<p class="MyHomefollower" onclick="followingListBlock(<%= member.getUserNo() %>, <%= loginUser.getUserNo() %>)"><%= member.getFollowCount() %></p>
					<h6 onclick="followListBlock(<%= member.getUserNo()%> )">팔로잉</h6>
					<p class="MyHomefollow" onclick="followListBlock(<%= member.getUserNo()%> ,<%= loginUser.getUserNo() %>)"><%= member.getFollowingCount() %></p>
				<% }else{ %>
					<h6 onclick="followingListBlock(<%= member.getUserNo() %>)">팔로워</h6>
					<p class="MyHomefollower" onclick="followingListBlock(<%= member.getUserNo() %>, -1)"><%= member.getFollowCount() %></p>
					<h6 onclick="followListBlock(<%= member.getUserNo()%> )">팔로잉</h6>
					<p class="MyHomefollow" onclick="followListBlock(<%= member.getUserNo()%> ,-1)"><%= member.getFollowingCount() %></p>
				<% } %>
			</li>
			<li>
				<p class="MyHomeIntroduction">
					<%= member.getIntro() %>
				</p>
			</li>
		</ul>
	</div>
	<div id="followUserArea" class="followUserArea"></div>
	<div id="followUserAreaArea" class="w3-modal" onclick="followgListBlock()"></div>
	<div id="settingArea" class="settingArea"></div>
	<div id="settingBoardArea" class="w3-modal" onclick="displayNone();"></div>
</body>
</html>