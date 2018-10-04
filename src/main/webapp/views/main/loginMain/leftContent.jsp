<%@page import="com.chain.triangleView.member.member.vo.MemberInterestCategory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<MemberInterestCategory> loginUserInterestCategory = (ArrayList<MemberInterestCategory>)session.getAttribute("loginUserInterestCategory");
	Member followCountMember = (Member)request.getAttribute("followCountMember");
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
	.leftContent {
		display: inline-block;
		border:1px solid #E5E5E5;
		float: left;
		width: 15%;
		border-radius:10px;
		margin-top:9px;
		background:white;
		text-align:center;
	}
	
	.leftProfile {
		width: 96%;
		list-style: none;
		padding-left: 0px;
		margin-bottom:5px;
		display:inline-block;
		vertical-align:top;
		text-align:center;
	}
	.leftProfile li{
		width: 100%;
		padding-left: 0px;
	}
	
	.leftProfile li hr {
		width: 70%;
		height: 1px;
		margin:15px;
		margin-left:21px;
	}
	.leftProfile li h6 {
		margin:0 auto;
	}
	
	.leftProfile .leftProfileImage {
		width: 120px;
		height: 120px;
		background: #C5CCE9;
		border-radius: 50%;
		margin-left:12px;
	}
	.introduction {
		margin-top:10px;
	    padding-left: 6px;
	    padding-right: 8px;
	    width: 95%;
	    color: gray;
	    font-weight: bold;
	    font-size: 12px;
	}
	.leftProfile li:nth-of-type(2){
		margin-top:10px;
	}
	.nickNameArea{
		font-size:13px;
		color:#F7323F;
		font-weight: bold;
	}
	.leftProfile li:nth-of-type(3){
		margin-bottom:30px;
	}
	.leftProfile li .follow, .leftProfile li .follower{
		color: black;
		font-size:17px;
		margin-top:5px;
		margin-bottom:9px;
		font-weight:bold;
		cursor:pointer;
		display:inline;
	}
	.leftProfile li:nth-of-type(5){
		margin-top:10px;
		margin-bottom:40px;
	}
	.interestArea {
		width: 137px;
		text-align:center;
		border-color: #ffdbdd;
		padding:0px;
		margin:3px;
		margin-left:5px;
	}
	.interestAreaTitle {
		background: #F7323F;
	    border-radius: 3px;
	    font-size: 13px;
	    width: 75px;
	    height: 22px;
	    color: white;
	    padding-top: 4px;
	    margin-bottm:5px;
	}
	.category {
		display: inline-block;
		height:111px;
		padding:0px;
		padding-top:5px;
		padding-bottom:5px;
	}
	.category img{
		margin:2px;
		width:33px;
		height:33px;
		cursor:pointer;
		user-select:none;
	}
	.logoutleftArea {
		margin-top:216px;
		margin-bottom:240px;
		font-size:12px;
		color : white;
	}
	.followUserArea {
		z-index: 300;
   		position: absolute;
   		left: 50%;
   		margin-left:-150px;
    	top: 150px;
	}
	@media all and (max-width:768px) {
		.leftContent {
			display: none;
		}
	}
	
	.logoutInBtn{
		border-radius : 5px;
		background: white;
    	color: #f7323f;
		width : 100px;
		height : 35px;
		margin-top : 15px;
		margin-left : auto;
		margin-right : auto;
		text-align : center;
		line-height : 35px;
	}
	
	.logoutInBtn:hover{
		cursor : pointer;
	}
	
	#writeReviewBtn:hover{
		cursor : url('cursor_PNG46.png') 4, 12;
	}
</style>
<script>

	function followListBlock(meNo){
		$.ajax({
			url : '<%= request.getContextPath()%>/followUserList',
			data : {
				userNo : meNo,
				meNo : meNo
			},
			success : function(data) {
				$('.followUserArea').html(data);
				document.getElementById('followUserAreaArea').style.display = 'block';
				document.getElementById('followUserArea').style.display = 'block';
			}
		});
	}
	
	function followingListBlock(meNo){
		$.ajax({
			url : '<%= request.getContextPath()%>/followingUserList',
			data : {
				userNo : meNo,
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
	
	function categoryModify(changeCategory){
		$.ajax({
			url : '/triangleView/categoryModify',
			type : 'get',
			data : {
				changeCategory : changeCategory
			},
			beforeSend : function(){
				$('.category').empty();
				
				$img = $('<img>');
				$img.attr('src', '/triangleView/img/category/categoryLoading.gif');
				$img.width('50px').height('50px');
				$img.css('margin-top', '30px');
				
				$('.category').html($img);
			},
			success : function(data){
				$div = $('<div>');
				
				<% for(int i = 1; i < 10; i++){ %>
					for(var key in data){
						if(<%= i %> == Number(data[key].categoryCode)){
							$img = $('<img>');
							$img.attr('onclick', 'categoryModify(<%= i %>)');
							$img.attr('src', '/triangleView/img/category/inCategory<%= i %>.png');
							
							$div.append($img);
						}	
					}	
				<% } %>
				
				<%for (int i = 1; i < 10; i++) {%>
					var checkTemp = 'Y';
					
					for(var key in data){
						if(<%= i %> == Number(data[key].categoryCode)){
							checkTemp = 'N';
						}
					}
					
					if(checkTemp == 'Y'){
						$img = $('<img>');
						$img.attr('onclick', 'categoryModify(<%= i %>)');
						$img.attr('src', '/triangleView/img/category/category<%= i %>.png');
						
						$div.append($img);
					}
				<%}%>
				
				$('.category').empty();
				$('.category').html($div);
			}
		});
	}
</script>
</head>
<body>
	<div class="leftContent" id="leftContentDiv">
			<div>
			<% if(loginUser != null){ %>
				<ul class="leftProfile">
					<li>
						<div class="leftProfileImage">
							<img src="<%= request.getContextPath() %>/profileImg_upload/<%= loginUser.getThumbnail() %>" style="border-radius:50%; width:120px; height:120px;">
						</div>
					</li>
					<li>
						<h6 class="nickNameArea">@<%= loginUser.getNick()%></h6>
					</li>
					<li>
						<div class="introduction">
							<%= loginUser.getIntro() %>
						</div>
					</li>
					<li>
						<h6 onclick="followListBlock(<%= loginUser.getUserNo()%> )">팔로잉</h6>
						<p class="follow" onclick="followListBlock( <%= loginUser.getUserNo()%> )"><%= followCountMember.getFollowingCount() %></p>
					</li>
					<li>
						<h6 onclick="followingListBlock(<%= loginUser.getUserNo() %>)">팔로워</h6>
						<p class="follower" onclick="followingListBlock(<%= loginUser.getUserNo() %>)"><%= followCountMember.getFollowCount() %></p>
					</li>
					<li>
						<fieldset class="interestArea">
							<legend class="interestAreaTitle">관심주제</legend>
							<div class="category">
								<% for(int i = 1; i < 10; i++){ %>
									<% for(int y = 0; y < loginUserInterestCategory.size(); y++){ %>
										<% if(i == loginUserInterestCategory.get(y).getCategoryCode()){ %>
											<img onclick='categoryModify(<%= i %>)' src='/triangleView/img/category/inCategory<%= i %>.png'>
										<% }
									}
								}
								for(int i = 1; i < 10; i++){
									char temp = 'y';
						 
									for(int y = 0; y < loginUserInterestCategory.size(); y++){
										if(i == loginUserInterestCategory.get(y).getCategoryCode()){
											temp = 'n';
									 	}
									}
									
									if(temp == 'y'){ %>
										<img onclick='categoryModify(<%= i %>)' src='/triangleView/img/category/category<%= i %>.png'>
									<% }
								} %>
							</div>
						</fieldset>
					</li>
				</ul>
			<% }else{ %>
				<script>
					$("#leftContentDiv").css('backgroundImage','url(/triangleView/img/main/loginBack3.png)');
				</script>
				<div class="logoutleftArea">
					<p style="margin-botton : 10px;"><b>회원 전용 <br/><br/>
						서비스입니다. <br/><br/>
						로그인 후 이용해 <br/><br/>
						주세요!</b></p>
					<div class="logoutInBtn" onclick="insertMemberTypeDisplayBlock()"><b>로그인</b></div>
				</div>
			<% } %>
		</div>
		<div onclick="uploadView()" id="writeBtn" style="width:152px; height : 0px;" id="writeReviewBtn">
			<img src="/triangleView/img/main/writeBtn.png">
		</div>
	</div>
	<div id="followUserArea" class="followUserArea"></div>
	<div id="followUserAreaArea" class="w3-modal" onclick="followgListBlock()"></div>
	<script>
		function choiseInsertMemberPageMove(){
			document.getElementById('insertMemberTypeArea').style.display = 'none';
			$(".insertMemberTypeArea").css("margin-left", "-250px");
			$.ajax({
				url : "/triangleView/views/member/choiseInsertMemberPage.jsp",
				data : "html",
				success : function(data) {
					$(".insertMemberTypeArea").html(data);
					document.getElementById('insertMemberTypeAearArea').style.display = 'block';
					document.getElementById('insertMemberTypeArea').style.display = 'block';
				}
			});
		}
	</script>
	
</body>
</html>