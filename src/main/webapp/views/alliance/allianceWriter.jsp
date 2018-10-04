<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int rwNo = Integer.parseInt(request.getParameter("rwNo"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

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
	margin-top: 70px;
	width: 100%;
}

.writerBox {
	width: 1000px;
	margin-top: 100px; margin : 0 auto; position : relative;
	top: 80px;
	margin: 0 auto;
	position: relative;
}

form {
	margin: 0 auto;
    width: 760px;
}
.allianForm{
	width: 830px;
    height: 380px;
    border: solid 1px gainsboro;
    position:relative;
    left:-30px;
    top:20px;
}
.mainAllian {
    width: 270px;
}
#coorLink {
    position: relative;
    left: 100px;
    width: 460px;
}
#coorEnd {
    width: 190px;
    margin-left: 20px;
    margin-right: -90px;
}
#coorStart {
    margin-left: -120px;
    width: 180px;
}
#coorStart {
    margin-left: -110px;
    width: 170px;
}
.mainAllian{
	margin-left: -40px;
    position: relative;
    left: -30px;
}
.allianStart {
	position: relative;
    right: 131px;
}
.alianLink{
	position: relative;
    left: 96px;
}
.allianCam{
    font-size: 23px;
    position: relative;
    bottom: 10px;
    left: 353px;
    color: #ec4a55;
}
.payBtn1{
	width:300px;
	background: #ec4a55;
	color:white;
	border-radius:8px;
}
.payBtn2{
	background: #ec4a55;
    color: white;
    border-radius: 8px;
    width: 300px;
    margin-right: 40px;
}
</style>
<script>
	//입력방지막기
	function check(){	
		//제휴링크 입력방지
		if($("#coorLink").val() == ""){
			alert("제휴링크입력해주세요")
			$("#coorLink").focus();
			return false;
		//시작날짜입력방지	
		}else if($("#coorStart").val() == ""){
			alert("제휴 시작 날짜를 입력해주세요.")
			return false;
		//제휴 시작일짜가 잘못되었을경우
		}else if($("#coorStart").val() > $("#coorEnd").val()){
			alert("제휴 기간이 잘못되엇습니다.")
			return false;
		//제휴 마감일짜가 잘못되엇을경우	
		}else if($("#coorEnd").val() < $("#coorStart").val()){
			alert("제휴 기간이 잘못되었습니다.")
			return false;
		//마감날짜입력방지	
		}else if($("#coorEnd").val() == ""){
			alert("제휴 마감 날짜를 입력하세요.")	
			return false;
	
		}	
		}
	function backNotice(){
		location.href="<%=request.getContextPath()%>/noticeList";
	}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="body1">
		<div class="writerBox">
			<form id="notice" action="<%=request.getContextPath()%>/allian.vo"
				method="post" onsubmit="return check()">
				<table class="allianForm">
					<tr alian="center">
						<td colspan="2">
							<div class="mainAllian">
								<p class="allianCam">리뷰 제휴 캠패인 작성</p>
							</div>
							<hr>
						</td>
						</tr>
					<tr>
					<tr>
						<td align="center" ><span class="alianLink">제휴링크</span></td>
						<td><input type="text" id="coorLink" name="coorLink"
							size="50" maxlength="50"></td>
					</tr>
					<tr>
						<td align="center" colspan="2"><span class="allianStart">제휴시작</span>
						<input type="date" id="coorStart" name="coorStart">
						제휴마감
						<input type="date" id="coorEnd" name="coorEnd"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input class="payBtn1" type=submit value="리뷰 제휴 캠패인 작성" id="btn">
							<input type=button class="payBtn2" value="돌아가기" onclick="backNotice()">
					</tr>
					<tr>
						<td><input type="hidden" name="rwNo" value="<%= rwNo %>"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>