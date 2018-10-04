<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/views/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세모뷰 마이 페이지</title>
<style>
body {
	margin: 0px;
	background: #fafafa;
	font-family: '맑은고딕';
}

.myHomeArea {
	margin: 0 auto;
	width: 1000px;
	text-align: left;
	margin-top: 10px;
}

@media all and (max-width:768px) {
	.myHomeArea {
		width: 100%;
	}
}

.body1 {
	width: 100%;
}

.box { /*그래프 박스  */
	position: relative;
	top: 5%;
	margin: 0 auto;
	background: white;
	width: 1000px;
}

@media all and (max-width:965px) {
	#boxHeader1 {
		width: 200px;
	}
}

#boxHeader { /*그래프 해더  */
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	left: 6%;
	text-align: center;
}

#boxHeader1 {
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	top: 5%;
	left: 12%;
}

#boxHeader2 {
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	top: 5%;
	left: 18%;
	text-align: center;
}

p { /*그래프 글씨  */
	color: white;
	display: inline-block;
}

#a { /*그래프 사진  */
	width: 100%;
	height: 100%;
	position: relative;
	top: 5px;
}

div#reviewCount {
	position: relative;
	top: 10%;
	left: 69%;
	width: 8%;
	background: red;
	text-align: center;
}

#ac { /*제휴,공고 버튼 사이즈, 링크  */
	width: 100px;
	height: 30px;
}

.acan { /*공고,제휴 버튼 위치  */
	width: 950px;
	position: relative;
	margin: 0 auto;
	text-align: center;
}

a {
	color: white;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: none;
}
</style>
<script>
	$(function(){
		var msg = '<%=msg%>';
		if(msg != 'null'){
			alert(msg);
		}
	})
	
	function noticeList(){
		

		
		
		location.href="<%=request.getContextPath()%>/noticeList";

	}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="myHomeArea">
		<jsp:include page="./myHomeHeader.jsp" flush="true" />
	</div>
	<div class="body1">
		<div class="box">
			<div id="boxHeader">
				<!--그래프 위에 해더  -->
				<p>종합 좋아요 데이터</p>
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
					id="a">
			</div>
			<div id="boxHeader1">
				<p>종합 조회수 데이터</p>
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
					id="a">
			</div>
			<div id="boxHeader2">
				<p>성별,연령별 데이터</p>
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
					id="a">
			</div>
			<div class="acan">
				<div class="btnbox">
				<!--공고 제휴 버튼  -->
				<input type="button" value="공고" id="ac" onclick="noticeList()">
				<input type="button" value="제휴" id="ac"
					onclick="window.open('./alliance.jsp')">
				</div>
			</div>
		</div>
	</div>
	<%-- <% }else{
		response.sendRedirect("/views/index.jsp");}
	%> --%>
</body>
</html>