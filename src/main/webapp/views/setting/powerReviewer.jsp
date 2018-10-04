<%@page import="com.chain.triangleView.member.member.vo.PowerReviewer"%>
<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
	PowerReviewer pr = (PowerReviewer)request.getAttribute("pr");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<style>
.containChange {
    width: 1275px;
    height: 1000px;
	text-align: center;
	font-size: 1.5em;
	float: right;

}

.btn-success {
	background-color: #f8585b;
	border: none;
	color: #FDEBEC;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	border-radius: 5px;
}

.noticeTo{
    width: 600px;
    height: 200px;
    margin-left: 330px;
    margin-top: 80px;
}

h3{
display: inline-block;
}

h2{
color:#f8585b;
}
</style>

</head>
<body>
	<form class="changeForm" id="form" name="powerReviewer" action="" method="post">
		<div class="containChange">
		<input type="text" name="userNo" value="<%=loginUser.getUserNo()%>" style="display:none;">
			<div class="noticeTo">
				<h2>파워리뷰어를 신청하기 위해서는</h2><h2>리뷰 작성 10개 이상, 총 조회수 1,000회 </h2><h2>이상되어야 합니다.</h2>
			</div>
		
			<div>
				<h3><%=loginUser.getNick() %> 님의  리뷰 수 : </h3> <h2 style="color:#f8585b; display:inline-block;"><%=pr.getReviewCount() %> </h2> <h3>개</h3>
				<br>
				<h3>총 조회수 : </h3> <h2 style="color:#f8585b; display:inline-block;"><%=pr.getSearchNum() %> </h2> <h3>회</h3>
			</div>
			
			<div class="" style="text-align: center; height: 40px; margin-top: 35px; display: inline-block;">
				<input type="button" class="btn-success" id="updatePoint" style="width: 250px; height: 50px;"
					value="파워리뷰어등업" onclick="youHaveTo()"></input>		
			</div>
		</div>
	</form>
	
	<script>
	function youHaveTo(){
		var rwCount = <%=pr.getReviewCount() %> * 1;
		var rwSearch = <%=pr.getSearchNum() %> * 1;
		/* alert(rwCount);
		alert(rwSearch); */
		if(rwCount >=10 && rwSearch >= 1000){
			var form = document.getElementById("form");
			form.action = "<%=request.getContextPath() %>/updatePowerReviewer.me"; 
			form.submit(); 
		}else{
			alert("조건을 충족하지 못하셨습니다!");
		}
	}
	</script>
</body>
</html>