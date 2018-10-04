<%@page import="com.chain.triangleView.allian.allian.vo.AllianData"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chain.triangleView.notice.notice.vo.notice.Notice"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.SimpleDateFormat"%>
<%
	HashMap<String,Object> noticeAllianForm = (HashMap<String,Object>)request.getAttribute("noticeAllianForm");

	Iterator<String> keys = noticeAllianForm.keySet().iterator();
	
	ArrayList<Notice> list = null;
	
	ArrayList<AllianData> list1 = null;
	
	ArrayList<Notice> list3 = null;
	
	ArrayList<Notice> list4 = null;
	
	while(keys.hasNext()){
		String key = keys.next();
		if(key.equals("list")){
			list = (ArrayList<Notice>)noticeAllianForm.get(key);		
		}else if(key.equals("list1")){
			list1 = (ArrayList<AllianData>)noticeAllianForm.get(key);
		}else if(key.equals("list3")){
			list3 = (ArrayList<Notice>)noticeAllianForm.get(key);
		}else if(key.equals("list4")){
			list4 =  (ArrayList<Notice>)noticeAllianForm.get(key);
		}
	}
		System.out.print("list확인:" +list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<!--구글 폰트  -->
<link href="https://fonts.googleapis.com/css?family=Poor+Story"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 아이콘  -->
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
.bodyMain{
	width:100%;
	margin: 0 auto;
}
.body1 {
	width: 100%;
	margin-top: 50px;
}

.box { /*그래프 박스  */
	margin: 0 auto;
	background: white;
	width: 1000px;
	margin-top: 70px;
}

@media all and (max-width:965px) {
	#boxHeader1 {
		width: 200px;
	}
}
div#reviewCount {
	position: relative;
	top: 10%;
	left: 69%;
	width: 8%;
	background: red;
	text-align: center;
}



.reviewbox {
	width: 100%;

}

.reviewmain { /*공고 가장 큰틀  */
	width: 1020px;
	margin: 0 auto;
}

.reviewmain1 { /*공고 가장 큰틀  영역1 */
	width: 70%;
	height: 340px;
	margin: 0 auto;
	margin-top: 2%;
}

.reviewmain2 { /*공고 가장 큰틀  영역2 */
	width: 70%;
	height: 340px;
	margin: 0 auto;
	margin-top: 2%;
}

.reviewmain3 { /*공고 가장 큰틀  영역3 */
	width: 70%;
	height: 340px;
	margin: 0 auto;
	margin-top: 2%;
}

.review { /*공고 div 박스 영역  */
	width: 309px;
    height: 335px;
    display: inline-block;
    margin: 2px;
    bottom: 65px;
    border-style: ridge;
    background: white;
}

.review { /*공고 div 박스 영역  */
	width: 309px;
	height: 335px;
	display: inline-block;
	margin: 2px;
	bottom: 65px;
	border-style: ridge;
}

.review2 {
	width: 24%;
	height: 100%;
	position: relative;
	bottom: 100%;
	left: 25%;
}

/*이미지*/
.reviewImagebox { /* 이미지틀 */
	width: 310px;
	height: 250px;
}

.reviewImg {
	width: 310px;
    height: 250px;
}

.reviewCatagory { /*카테고리  */
	width: 60px;
	height: 27px;
	background: #484949;
	position: relative;
	bottom: 255px;
	left: 8px;
	border-radius: 5px;
}

p.catagoryName { /*카테고리안 내용글씨 */
	font-size: 15px;
	font-family: '맑은고딕';
	color: white;
	line-height: 28px;
	text-align: center;
}

.reviewProduct { /* 상품명 div  */
	width: 95%;
    display: inline-block;
    text-align: left;
    margin-left: 3px;
    position: relative;
    bottom: 35px;
}

p.productName { /* 상품명 글귀 */
	font-size: 17px;
    font-weight: bold;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    padding-left: 5px;
    margin-top: 13px;
    margin-bottom: 5px;
    position: relative;
    left: 5px;
    bottom: 12px;
}

.reviewName { /*공고 상세틀  */
	width: 100%;
	height: 6%;
	position: relative;
	bottom: 22%;
}

p.reviews { /*공고 상세 글귀  */
	display: table-cell;
    font-size: 11px;
    padding-top: 4px;
    padding-bottom: 11px;
    margin: 0px;
    position: relative;
    bottom: 51px;
    left: 13px;
}

.reviewDetail { /*상세 정보틀  */
	width: 310px;
	height: 40px;
	margin-top: -62px;
	float: left;
}

.reviewBtn { /* 마감일시버튼 */
	width: 60px;
    height: 27px;
    font-size: 15px;
    font-family: '맑은고딕';
    line-height: 28px;
    text-align: center;
    border-radius: 6px;
    color: white;
    background: #f7323f;
    position: relative;
    float: right;
    bottom: 281px;
    right: 10px;
}

.location { /* 위치 */
	position: relative;
	margin-left: 36px;
	bottom: 13px;
}

p.Location1 { /* 위치 글귀  */
	display: table-cell;
    font-size: 15px;
    padding-top: 4px;
    padding-bottom: 11px;
    margin: 1px;
    position: relative;
    top: 21px;
    left: -24px;
}


p.person { /* 현재 인원 */
	display: table-cell;
    font-size: 15px;
    padding-top: 4px;
    padding-bottom: 11px;
    margin: 0px;
    position: relative;
    bottom: 47px;
    left: 237px;
}
img.userIcon {
	width: 20px;
    margin-right: 10px;
    margin-top: -2px;
}
.reviewbar3 {
	margin: 0 auto;
}

.formArea {
	z-index: 300;
	position: fixed;
	top: 120px;
}


.noticeInformation {
	width: 1000px;
	margin: 0 auto;
	margin-top: 100px;
}

.InformationImg {
	width: 200px;
    height: 200px;
    background: white;
    border-radius: 100px;
    margin-right: 0px;
    position: relative;
    left: 100px;
}

.inforBox {
	display: -webkit-inline-box;
}


.noticeBtnBox {
	height: 50px;
	width: 300px;
	margin-top: 110px;
	position: relative;
	right: 220px;
}

button.noticeBtn1 {
	margin-left: 10px;
	margin-top: 20px;
	font-size: 16px;
	border-radius: 7px;
}

button.noticeBtn2 {
	border-radius: 7px;
}
.InforImg{
	width: 100%;
    height: 100%;
    border-radius: 100px;

}
/* 공고부분 display 나오게 설정  */
.notice {
	display: block;
}

.allian {
	display:none;
}
.noticeN{
	display:none;
}
</style>
<!--제휴 그래프  -->
<style type="text/css"> /*그래프  */
tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #bbb;
}
.tg .tg-7ru9 {
    font-size: 20px;
    background-color: #efefef;
    border-color: inherit;
    text-align: center;
}
.tg td {
	font-family: Arial, sans-serif;
	font-size: 20px;
	padding: 10px 10px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #bbb;
	color: #594F4F;
	background-color: #E0FFEB;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 20px;
	font-weight: normal;
	padding: 10px 10px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #bbb;
	color: #493F3F;
	background-color: #9DE0AD;
}

.tg .tg-axis {
	font-size: 20px;
	background-color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-7ru9 {
	font-size: 20px;
	background-color: #efefef;
	border-color: inherit;
	text-align: center
}

.tg .tg-6iur {
	font-size: 20px;
	background-color: #ffffff;
	color: #656565;
	border-color: inherit;
	text-align: center
}

.tg .tg-azch {
	font-weight: bold;
	font-size: 30px;
	font-family: Impact, Charcoal, sans-serif !important;;
	background-color: #f7323f;
	color: #ffffff;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-j9lp {
	font-weight: bold;
	font-size: 30px;
	font-family: "Arial Black", Gadget, sans-serif !important;;
	background-color: #f7323f;
	color: #ffffff;
	border-color: #000000;
	text-align: center
}

.tg .tg-u01n {
	font-weight: bold;
	font-size: 30px;
	background-color: #f7323f;
	color: #ffffff;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-2qjj {
	font-weight: bold;
	font-size: 30px;
	background-color: #f7323f;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-6kia {
	font-size: 30px;
	background-color: #efefef;
	border-color: inherit;
	text-align: center
}

.tg .tg-3etr {
	font-size: 30px;
	background-color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-8rzn {
	font-size: 30px;
	background-color: #efefef;
	color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-rkeo {
	font-size: 30px;
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-l0dw {
	font-size: 30px;
	background-color: #efefef;
	color: #343434;
	text-align: center;
	vertical-align: top
}

.tg .tg-op2s {
	font-size: 30px;
	background-color: #efefef;
	color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-7t59 {
	font-size: 20px;
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}

#test {
	width: 100%;

}
.noticeMain{
	width: 550px;
    height: 150px;
    margin-top: 50px;
    border: solid 1px gray;
    border-radius: 21px;
    background: white;
    margin-left: 140px;
}
.noticeMain p{
    color: black;
    font-size: 17px;
    display: table;
    position: relative;
    bottom: 17px;
    left: 10px;
    font-weight: bold;
    margin: 0;
}
.noticeMain span{
	display: -webkit-inline-box;
    margin-top: -7px;
    margin-left: 120px;
    position: relative;
    bottom: 32px;
    left: 30px;
    background: white;
}
.noticeNames1{
	margin: 0;
    position: relative;
    bottom: 50px;

}
.inforBox{
	width:1000px;
}
.btnArea{
	width: 1000px;
    position: relative;
    top: 30px;
}
.noticeBtnBox{
	margin: 0 auto;
}
.noticeBtnBox p{
	font-size: 22px;
    float: right;
    margin-left: 31px;
    text-align: center;
    position: relative;
    left: 180px;
    font-weight: bold;
}
img.locationIcon {
	width: 20px;
    right: 30px;
    top: 9px;
    margin-right: 10px;
    margin-top: -3px;
}
.personBox{
	display: table-cell;
	font-size: 11px;
	padding-top: 4px;
	padding-bottom: 11px;
	margin: 0px;
	position: relative;
	top: 15px;
	left: -24px;
}
.noticeBtn{
	color:#f7323f;
}
.noticeDate {
	width: 60px;
    height: 27px;
    font-size: 15px;
    font-family: '맑은고딕';
    line-height: 28px;
    text-align: center;
    border-radius: 6px;
    color: white;
    background: #f7323f;
    position: relative;
    float: right;
    bottom: 291px;
    right: 10px;
}
.review:hover{
	cursor:pointer;
}
.noticeBtnBox p:hover{
	cursor:pointer;
}
.noticeBtnBox p:hover{
	cursor:pointer;
}
.annHr{
	border: 0;
    border-top: 1px solid #eee;
    margin: 20px 0;
    margin-top: 40px;
}
</style>

<script>
	function LoadNoticeForm(userId,noticeNo){
		$.ajax({
			url:"/triangleView/loadNoticeForm.rf",
			type: "GET",
			data : {
				'userId':userId,
				'noticeNo':noticeNo
			},
			success: function(data){
				$(".formArea").html(data);
				document.getElementById('formAreaArea').style.display = 'block';
				document.getElementById('formArea').style.display = 'block';
				
			}
		});
		
	}


	function formDisplayNone() {
		document.getElementById('formArea').style.display = 'none';
		document.getElementById('formAreaArea').style.display = 'none';
	}
	function allianView(){
		document.getElementById('allianView').style.color="#f7323f";
		document.getElementById('noticeNView').style.color= 'black';
		document.getElementById('noticeView').style.color= 'black';
		document.getElementById('allian').style.display = 'block';
		document.getElementById('notice').style.display = 'none';
		document.getElementById('noticeN').style.display = 'none';
	}
	function noticeView(){
		document.getElementById('noticeView').style.color= '#f7323f';
		document.getElementById('noticeNView').style.color= 'black';
		document.getElementById('allianView').style.color='black';
		document.getElementById('notice').style.display = 'block';
		document.getElementById('allian').style.display = 'none';
		document.getElementById('noticeN').style.display = 'none';
	}
	function noticeNView(){
		document.getElementById('noticeNView').style.color= '#f7323f';
		document.getElementById('allianView').style.color='black';
		document.getElementById('noticeView').style.color= 'black';
		document.getElementById('noticeN').style.display = 'block';
		document.getElementById('allian').style.display = 'none';
		document.getElementById('notice').style.display = 'none';
	}
	function loadPay(serviceNo){
		
		var serviceNo;
		
		
		if(serviceNo != null){
			location.href='<%=request.getContextPath()%>/noticeYPay?serviceNo=' + serviceNo;
		}
	}
	function noticeY(noticeCode,nick){
		var noticeCode;
		var nick
		
		alert(noticeCode);
		alert(nick);
		
		if(noticeCode != null){
			location.href='<%=request.getContextPath()%>/noticeY?noticeCode=' + noticeCode + '&nick=' + nick;
		}
	}
	
	function annLogout(){
		location.href='<%= request.getContextPath() %>/logout.me';
	}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<%-- <div class="myHomeArea">
		<jsp:include page="./myHomeHeader.jsp" flush="true" />
	</div> --%>
	<div class="bodyMain">
	<div class="noticeInformation">
		<div class="inforBox">
			<div class="InformationImg"><img class="InforImg"src="<%=request.getContextPath()%>/profileImg_upload/<%=list3.get(0).getFileName()%>">
			</div>
			<div class="noticeMain">
				<div></div>
				<h2 class="noticeNames1" onclick="annLogout()"><%=loginUser.getCopName() %></h2>
				<p class="noticeNames">담당자</p><span><%=loginUser.getNick() %></span>
				<p class="noticeNames1">전화 번호</p><span><%=loginUser.getPhone() %></span>
				<p class="noticeNumber">사업자 등록번호</p><span><%=loginUser.getBusinessNo() %></span>
			</div>
		</div>
			<div class="btnArea">
			<div class="noticeBtnBox">
				<p clsss="nNoticeBtn" id="noticeNView" onclick="noticeNView();">미결제 공고</p>
				<p class="allianBtn" id="allianView" onclick="allianView();">제휴</p>
				<p class="noticeBtn" id="noticeView" onclick="noticeView();">공고</p>
			</div>
			</div>
	</div>
	<hr class="annHr">
	<div class="body1">
		<div class="notice" id="notice">
				<div class="reviewbox">
					<div class="reviewmain">
						<%
							for (int i = 0; i < list.size(); i++) {
						%>
						<div class="review">
							<!--공고틀  -->
							<div class="reviewImagebox"
								onclick="LoadNoticeForm(<%=list.get(i).getNoticeWriter()%>,<%=list.get(i).getNoticeNo()%>)">
								<!--이미지 틀  -->
								<img class="reviewImg" src="<%=request.getContextPath()%>/notice_upload/<%=list.get(i).getFileName()%>">
								<!--이미지  -->
							</div>
							<div class="reviewCatagory">
								<p class="catagoryName"><%=list.get(i).getCategoryCodeName()%></p>
								<!--카테고리 이름  -->
							</div>
							<div class="view2">
							<div class="reviewProduct">
								<!--상품 이름  -->
								<p class="productName"><%=list.get(i).getNoticeTitle()%></p>
							</div>
							<div class="reviewName">
								<!-- 상세 내역  -->
								<p class="reviews"><%=list.get(i).getOfferProduct()%></p>
							</div>
							<div class="reviewDetail">
								<!--마감날짜  -->
							<%
								Date currentTime = new Date();
									Date endDate = list.get(i).getNoticeEndDate();
									long diff = endDate.getTime() - currentTime.getTime();
									long diffDays = diff / (24 * 60 * 60 * 1000);

									if (diffDays > 0) {
							%>
							<td><div class="noticeDate">
									D-<%=diffDays%></div></td>
							<%
								} else {
							%>
							<td><div class="noticeDate">D-DAY</div></td>
							<%
								}
							%>
							<div class="location">
									<p class="Location1">
										<img class="locationIcon"
										src="/triangleView/img/notice/location.png"><%=list.get(i).getProductArea()%>
									</p>
								</div>	
								<div class="personBox">
								<p class="person">
									<img class="userIcon" src="/triangleView/img/notice/user.png"><%=list.get(i).getNoticeYPerson()%>명/<%=list.get(i).getDeadlinePerson()%>명
								</p>
								</div>
								</div>
						</div>
							</div>
						<%
							}
						%>
						<div class="area5">
							<div id="formArea" class="formArea"></div>
							<div id="formAreaArea" class="w3-modal"
								onclick="formDisplayNone();"></div>
						</div>
						<%-- <div class="body4">
						<%@ include page="./alliance.jsp"%>
					</div> --%>
					</div>
			</div>
		</div>
		<div class="allian" id="allian">
			<div id="test">
				<table class="tg"
					style="table-layout: fixed; width: 1000px; margin: 0 auto; margin-top: 3%;">
					<colgroup>
						<col style="width: 120px">
						<col style="width: 230px">
						<col style="width: 300px">
						<col style="width: 100px">
						<col style="width: 100px">
					</colgroup>
					<tr>
						<th class="tg-j9lp">제휴번호</th>
						<th class="tg-azch">아이디</th>
						<th class="tg-u01n">리뷰제목</th>
						<th class="tg-2qjj"><span style="color: rgb(255, 255, 255)">조회수</span></th>
						<th class="tg-u01n">좋아요</th>
					</tr>
					<%for(int i= 0; i < list1.size();i++){ %>
					<tr>
						<td class="tg-6kia"><%=list1.get(i).getCoorCode()%></td>
						<td class="tg-7ru9"><%=list1.get(i).getUserId()%></td>
						<td class="tg-7ru9"><%=list1.get(i).getRwTitle() %></td>
						<td class="tg-7ru9"><%=list1.get(i).getRwCount() %></td>
						<td class="tg-7ru9"><%=list1.get(i).getLikeCount() %></td>
					</tr>
					<% } %>
				</table>
			</div>
		</div>
		<div class="noticeN" id="noticeN">
			<div class="reviewbox">
					<div class="reviewmain">
						<%
							for (int i = 0; i < list4.size(); i++) {
						%>
						<div class="review">
							<!--공고틀  -->
							<div class="reviewImagebox"
								onclick="loadPay(<%=list4.get(i).getServiceNo()%>)">
								<!--이미지 틀  -->
								<img class="reviewImg" src="<%=request.getContextPath()%>/notice_upload/<%=list4.get(i).getFileName()%>">
								<!--이미지  -->
							</div>
							<div class="reviewCatagory">
								<p class="catagoryName"><%=list4.get(i).getCategoryCodeName()%></p>
								<!--카테고리 이름  -->
							</div>
							<div class="view3">
							<div class="reviewProduct">
								<!--상품 이름  -->
								<p class="productName"><%=list4.get(i).getNoticeTitle()%></p>
							</div>
							<div class="reviewName">
								<!-- 상세 내역  -->
								<p class="reviews"><%=list4.get(i).getOfferProduct()%></p>
							</div>
							<div class="reviewDetail">
								<!--마감날짜  -->
							<%
								Date currentTime = new Date();
									Date endDate = list4.get(i).getNoticeEndDate();
									long diff1 = endDate.getTime() - currentTime.getTime();
									long diffDays1 = diff1 / (24 * 60 * 60 * 1000);

									if (diffDays1 > 0) {
							%>
							<td><div class="noticeDate">
									D-<%=diffDays1%></div></td>
							<%
								} else {
							%>
							<td><div class="noticeDate">D-DAY</div></td>
							<%
								}
							%>
							<div class="location">
									<p class="Location1">
										<img class="locationIcon"
										src="/triangleView/img/notice/location.png"><%=list4.get(i).getProductArea()%>
									</p>
								</div>	
								<div class="personBox">
								<p class="person">
									<img class="userIcon" src="/triangleView/img/notice/user.png"><%=list4.get(i).getNoticeYPerson()%>명/<%=list4.get(i).getDeadlinePerson()%>명
								</p>
								</div>
								</div>
						</div>
							</div>
						<%
							}
						%>
					</div>
			</div>
		</div>
	</div>
</body>
</html>