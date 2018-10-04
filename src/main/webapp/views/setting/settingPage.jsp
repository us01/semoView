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
<title>Insert title here</title>

<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>

<style>
body {
	margin: 0px;
	/* background: #fafafa; */
	font-family: '맑은고딕';
}

.outLine {
	width: 1000px;
	margin: 0 auto;
	text-align: -webkit-center;
	display: block;
}

tr {
	height: 150px;
}

table {
	text-align: center;
}

.container {
    width: 1400px;
    height: 1000px;
    border: 1px solid black;
    text-align: center;
    display: inline-block;
    margin-left: -200px;
	
}

.menu {
	display: inline-block;
	border: 1px solid white;
	width: 120px;
	height: 1000px;
	float:left;
	border: 1px solid black;
}

.show {
	display: inline-block;
	border: 1px solid white;
    width: 1275px;
    height: 1000px;
	float:left;
}


.subMenu1, .subMenu2, .subMenu3,.subMenu4, .subMenu5 {
	width:118px;
	padding: 20px 0;
	border: 1px solid gray;
	background-color: white;
	display:table;
	border-left: 2px solid transparent;
    font-size: 22px;
	line-height: 100px;
	vertical-align:middle;
	height:100px;
	/* 	height:50px; */
   /*  display: block; */
   /*  height: 100%; */
   /* padding: 16px 16px 16px 30px; */
   /*  width: calc(100% - 48px); */
	
}

div.subMenu1:hover, div.subMenu2:hover, div.subMenu3:hover, div.subMenu4:hover, div.subMenu5:hover{
	background-color:#f7edea;
	cursor:pointer;
}

/* .inside1{
border-left: 2px solid transparent;
    display: block;
    font-size: 16px;
   height: 100%; 
    line-height: 20px;
    padding: 16px 16px 16px 30px;
    width: calc(100% - 48px); 
} */

</style>
<script>
$(function(){
	<% if(loginUser != null){ %>
		var level = <%=loginUser.getUserLevel()%>;
		if(level == 1){
			$('#checking').css('display','none');
		}
	<% } %>
})
</script>


</head>
<body>
	<jsp:include page="../main/header/headerNav.jsp" flush="true">
		<jsp:param name="loginUser" value="<%= loginUser %>"/>
	</jsp:include>
	
	<div name="outLine" class="outLine" style="margin-top:90px;">
		<div id="container" class="container">
			<div class="menu">
				<div class="subMenu1" onclick="changeProfile();">
					프로필수정
				</div>
				<div class="subMenu2" onclick="changePassword();">
					비밀번호
				</div>
				<div class="subMenu3" onclick="pointRefunds();">
					포인트	
				</div>
				<div class="subMenu4" id="checking" onclick="powerReviewer();">
					파워리뷰어
				</div>
			</div>
			
			<div class="show">
			
			</div>
		</div>
	</div>

<script>

function changeProfile(){
	
	$.ajax({
		url : "/triangleView/views/setting/profileChange.jsp",
		data : "html",
		success : function(data) {
			$(".show").html(data);
			
		}
	});
}

function changePassword(){
	
	$.ajax({
		url : "/triangleView/views/setting/passwordChange.jsp",
		data : "html",
		success : function(data) {
			
			$(".show").html(data);
			
		}
	});
}

function pointRefunds(){
	
	$.ajax({
		url : "/triangleView/views/setting/pointRefunds.jsp",
		data : "html",
		success : function(data) {		
			$(".show").html(data);
			
		}
	});
}

function powerReviewer(){
	
	$.ajax({
		url : "/triangleView/powerReviewer.me",
		data : "html",
		success : function(data) {		
			
			$(".show").html(data);
			
		}
	});
}

</script>
</body>
</html>