<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<title>Insert title here</title>
<style>
	.choiseLoginOrMemberTypeArea {
		width:300px;
		height:255px;
		background:white;
		margin:0 auto;
		border-radius:10px;
		position:fixed;
		padding:10px;
	}
	.choiseMemberTypeArea > p {
		text-align:center;
	}
	.generalMemberBtn {
		display:inline-block;
		width:150px;
		height:100px;
		background:blue;
	}
	.copMemberBtn{
		display:inline-block;
		width:150px;
		height:100px;
		background:red;
	}
	.divisionTop {
		margin-top:15px;
		margin-bottom:15px;
	}
	.divisionBottom {
		margin-top:10px;
	}
	.divisionLine {
		background-color:#efefef;
		height:1px;
		width:108px;
		display:inline-block;
		margin-bottom:6px;
	}
	.divisionLineLeftTop {
		background-color:#efefef;
		height:1px;
		width:108px;
		display:inline-block;
		margin-top:10px;
		float:left;
	}
	.divisionLineRightTop {
		background-color:#efefef;
		height:1px;
		width:108px;
		display:inline-block;
		margin-top:10px;
		float:right;
	}
	.divisionLineLeftBottom {
		background-color:#efefef;
		height:1px;
		width:280px;
		display:inline-block;
		margin-top:10px;
		float:center;
	}
	.divisionTitle {
		display:inline-block;
		font-size:13px;
		width: 64px;
    	text-align: center;
	}
	.loginInputArea {
		text-align:center;
	}
	.loginIdArea, .loginPwdArea {
		display:inline-block;
		margin-top:3px;
		margin-bottom:3px;
		border:1px solid #EFEFEF;
		padding:7px;
		background:#FAFAFA;
	}
	.loginInputArea input[type='text']{
		width:265px;
		background:#FAFAFA;
		border:0px;
		outline:none;
	}
	
	.loginInputArea input[type='password']{
		width:265px;
		background:#FAFAFA;
		border:0px;
		outline:none;
	}
	.memberInfoArea {
		text-align:center;
		margin-top:10px;
	}
	.memberInfoArea p {
		display:inline-block;
		width:70px;
		font-size:11px;
	}
	.memberInfoArea p:hover {
		cursor:pointer;
		color:#f8585b;
	}
	.memberInfoArea p:last-child {
		display:inline-block;
		width:50px;
		font-size:11px;
	}
	.submitBtn {
		width: 280px;
		background-color: #f8585b;
		border: none;
		color: #FDEBEC;
		padding: 6px 0;
		text-align: center;
		text-decoration: none;
		font-size: 14px;
		margin-top: 4px;
		margin-bottom: 4px;
		cursor: pointer;
		border-radius:5px;
	}
</style>
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
	function login(){
		$(".submitBtn").submit();
	}
	function findId(){
		document.getElementById('insertMemberTypeArea').style.display = 'none';
		$(".insertMemberTypeArea").css("margin-left", "-175px");
		$(".insertMemberTypeArea").css("background-color", "white" );
		$(".insertMemberTypeArea").css("width", "380px" );
		$(".insertMemberTypeArea").css("border-radius ", "10px" );
		
		$.ajax({
			url : "/triangleView/views/member/findId.jsp",
			data : "html",
			success : function(data) {
				$(".insertMemberTypeArea").html(data);
				document.getElementById('insertMemberTypeAearArea').style.display = 'block';
				document.getElementById('insertMemberTypeArea').style.borderRadius = '15px'; 
				document.getElementById('insertMemberTypeArea').style.display = 'block';
			}
		});
	}
	function findPwd(){
		document.getElementById('insertMemberTypeArea').style.display = 'none';
		$(".insertMemberTypeArea").css("margin-left", "-175px");
		$(".insertMemberTypeArea").css("background-color", "white" );
		$(".insertMemberTypeArea").css("width", "380px" );
		$.ajax({
			url : "/triangleView/views/member/findPass.jsp",
			data : "html",
			success : function(data) {
				$(".insertMemberTypeArea").html(data);
				document.getElementById('insertMemberTypeArea').style.borderRadius = '15px';
				document.getElementById('insertMemberTypeAearArea').style.display = 'block';
				document.getElementById('insertMemberTypeArea').style.display = 'block';
			}
		});
	}
	function insertMember(){
		location.href="";
	}
</script>
</head>
<body>
	<div class="choiseLoginOrMemberTypeArea">
		<div class="divisionTop">
			<div class="divisionLineLeftTop"></div>
			<div class="divisionTitle">로그인</div>
			<div class="divisionLineRightTop"></div>
		</div>
		
		<form action="<%= request.getContextPath() %>/login.me" method="post">
			<div class="loginInputArea">
				<div class="loginIdArea"><input type="text" name="userId" placeholder="아이디"></div>
				<div class="loginPwdArea"><input type="password" name="userPwd" placeholder="비밀번호"></div>
				<input class="submitBtn" type="submit" value="로그인">
			</div>
		</form>
		<div class="divisionBottom">
			<div class="divisionLineLeftBottom"></div>
		</div>
		<div class="memberInfoArea">
			<p onclick="findId();">아이디 찾기</p>/
			<p onclick="findPwd()">비밀번호 찾기</p> /
			<p onclick="choiseInsertMemberPageMove()">회원가입</p>
		</div>
	</div>
</body>
</html>