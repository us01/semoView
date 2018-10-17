<%@page import="java.util.Iterator"%>
<%@page import="com.chain.triangleView.notice.notice.vo.notice.Application"%>
<%@page import="com.chain.triangleView.notice.notice.vo.notice.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HashMap<String,Object> noticeDetailsForm = (HashMap<String,Object>)request.getAttribute("noticeDetailsForm");

	Iterator<String> keys = noticeDetailsForm.keySet().iterator();
	
	
	ArrayList<Notice> list = null;
	
	ArrayList<Application> list1 = null;
	
	ArrayList<Application> list2 = null;
	
	while(keys.hasNext()){
		String key = keys.next();
		if(key.equals("list")){
			list = (ArrayList<Notice>)noticeDetailsForm.get(key);	
		}else if(key.equals("list1")){
			list1 = (ArrayList<Application>)noticeDetailsForm.get(key);
		}else if(key.equals("list2")){
			list2 = (ArrayList<Application>)noticeDetailsForm.get(key);
		}
	}
		System.out.print("테스트1" +list);
		System.out.print("테스트2" + list1);
		System.out.print("테스트3" + list2);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

.mainbox{
	width:100%;
	margin:0 auto;	
}

.mainheader { /*메인 헤더  가져온거 */
	width: 100%;
	background: #F7323F;
	align-text: center;
}

.header {
	width: 100%;
}

.mainmenu { /*가장 큰 틀  */
	position: relative;
	bottom: 102px;
	left: 28.5%;
}

.mainmenu { /*  div 형식으로 만든 카테 고리 버튼  */
	width: 60%;
	height: 50px;
}

.catagoryBtn { /*  카테고리 10개  */
	width: 7.5%;
	heigth: 10px;
	background: white;
	text-align: center;
	float: left;
	background: black;
	border: 1px solid white;
}

label { /* 가테고리 안에 있는 라벨  */
	font-size: 11px;
	color: white;
}

.body {
	width: 100%;
	margin: 0 auto;
}

.details {
	width: 1000px;
	height: 2000px;
	background: gray;
	margin: 0 auto;
	margin-top: 20%;
}

.reviewbody {
	width: 100%;
}

.reviewbar {
	width: 1000px;
	position: relative;
	margin: 0 auto;
	top: 30px;
}

.reviewbox {
	width: 80%;
	height: 1600px;
	position: relative;
	margin-left: 10%;
	top: 2%;
	background: gray;
}

.reviewbar3 {
	width: 1000px;
	margin: 0 auto;
}

.productbox {
	width: 1000px;
    height: 400px;
    margin-top: 70px;
}

.productImage { /*이미지 들어가는 기본틀  */
	width: 350px;
    height: 350px;
    background: white;
}

img.productTitle { /*상품 맨 위에 보이는 메인 이미지  */
	width: 100%;
	height: 100%;
}

.productCotent { /*상품명 모집인원등 상세 정보를 보여주는 기본틀  */
    width: 640px;
    height: 270px;
    position: relative;
    bottom: 270px;
    left: 320px;
    display: inline-table;
}


.productBtn { /*신청하기 버튼  */
	position: relative;
	bottom: 100px;
	width: 20%;
	height: 10%;
	background: #f7323f;
	text-align: center;
	font-size: 0.9em;
	color: white;
	margin-left: 100px;
	margin-top: 40px;
	border-radius: 5px;
}
.mainPosts p{
	background: white;
    font-size: 13px;
    font-weight: 400;
}
.NoticeYN {		
    width: 1000px;
    display: inline-flex;
}
.noticeN {
    width: 439px;
    height: 300px;
    display: block;
    border: solid 1px #cacaca;
    border-radius: 22px;
    background: white;
    overflow-y: scroll;
}
.noticeY {
    width: 439px;
    height: 300px;
    margin-left: 120px;
    display: block;
    border: solid 1px #cacaca;
    border-radius: 22px;
    background: white;
    overflow-y: scroll;
}
p.nReview {
    font-weight: bold;
}




.mainPosts { /* 공고 내용  */
    height: 200px;
    margin: 0 auto;
    margin-top: 50px;
    border-radius: 10px;
    border: solid 1px #e0dcdc;
    background: white;
}
.mainPosts p{
	background:white;
}

p.mainPost1 { /*공고 핵심내용  */
	font-weight: bold;
}

p.mainPost2 { /*공고 핵심내용  */
	font-weight: bold;
}

p.mainPost3 { /*공고 핵심내용  */
	font-weight: bold;
}

p.mainPost4 { /*공고 핵심내용  */
	font-weight: bold;
}

p.maincontents1 { /*글씨크기  */
	font-size: 0.7em;
	background:white;
}

p.maincontents2 {
	font-size: 0.7em;
	background:white;
}

p.maincontents3 {
	font-size: 13px;
    color: red;
    background: white;
}

.contentImage1 {
	width: 100%;
    height: 400px;
    background: white;
    margin: 0 auto;
    margin-top: 40px;
}

.contentImage2 {
	width: 80%;
	height: 400px;
	margin: 0 auto;
	margin-top: 40px;
	background: gainsboro;
}

.contentImage3 {
	width: 80%;
	height: 400px;
	margin: 0 auto;
	margin-top: 40px;
	background: gainsboro;
}

.contentImage4 {
	width: 80%;
	height: 400px;
	margin: 0 auto;
	margin-top: 40px;
	background: gainsboro;
}

.contentImage5 {
	width: 80%;
	height: 400px;
	margin: 0 auto;
	margin-top: 40px;
	background: gainsboro;
}
.productArea {
  	width: 590px;
    height: 167px;
    margin: 0 auto;
    margin-left: 40px;
    border-radius: 14px;
    margin-top: -60px;
    border: solid 1px #c1c1c1;
    background: white;
}
.ImageMaintitle {
	width: 1000px;
}
p.productName{
	font-size: 22px;
    font-weight: bold;
    margin: 0 auto;
    position: relative;
    bottom: 70px;
    margin-left: 40px;
    font-family: '맑은고딕';
}
p.productIntroduce{
	margin:0;
}
img.productBar{
    margin-left: 42px;
    margin-top: 10px;
    width: 590px;
    height: 52px;
}
img.noticePointer {
    width: 90px;
    position: relative;
    left: 42px;
}
.productPost3{
	background:white;
	display: contents;
}
.cam{
	margin: 0;
    font-weight: bold;
    position: relative;
    top: 40px;
}
p.yReview {
   float: right;
   margin-right: 354px;
   color: rgb(247, 50, 63);
   font-weight: bold;
}
.userN{
	width: 290px;
    height: 100px;
    display: table;
    margin-left: 50px;
    margin-top: 30px;
}
.userImg {
    width: 80px;
    height: 80px;
    background: #2c8ac1;
    border-radius: 50px;
    margin-left: 10px;
    margin-top: 0px;
}
p.userNick {
    margin: 0;
    text-align: center;
    position: relative;
    bottom: 60px;
    font-weight: bold;
    margin-left: 90px;
}
p.userIntro {
    margin: 0;
    text-align: center;
    position: relative;
    bottom: 50px;
    color: gray;
    margin-left: 100px;
}
.userY{
	width: 290px;
    height: 100px;
    display: table;
    margin-left: 50px;
    margin-top: 30px;
}
.userImg1 {
    width: 80px;
    height: 80px;
    background: #2c8ac1;
    border-radius: 50px;
    margin-left: 10px;
    margin-top: 0px;
}
p.userNick1 {
    margin: 0;
    text-align: center;
    position: relative;
    bottom: 60px;
    font-weight: bold;
    margin-left: 100px;
}
p.userIntro1 {
    margin: 0;
    text-align: center;
    position: relative;
    bottom: 50px;
    color: gray;
    margin-left: 100px;
}
.productArea p{
	display: table;
    margin-left: 20px;
    font-weight: bold;
    background: white;
}
.productArea1{
	margin-left: 190px;
    display: table-caption;
}
.productArea1 p{
	margin: 0;
    position: relative;
    bottom: -6px;
}
.productArea span{
	display: flex;
    margin-top: -37px;
    margin-left: 120px;
    background: white;
}
.userImgBox{
	width:100%;
	height:100%;
	border-radius: 45px;
}
.userImgBox1{
	width:100%;
	height:100%;
	border-radius: 45px;
}
.mainPosts p{
	margin-left:10px;
}
img.noticePointer:hover{
	cursor:pointer;
}
.noticeN:hover{
	cursor:pointer;
}
.noticeY:hover{
	cursor:pointer;
}


</style>
<script>
	function noticeApply(noticeCode){
		
		var noticeCheck = noticeCode;
			if(noticeCheck != null){
				location.href='<%=request.getContextPath()%>/noticeCheck?noticeCheck=' + noticeCheck;
			}
		}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="mainbox">
	<div class="reviewbody">
		<!--	틀     -->
		<div class="reviewbar">
			<!--  바디  -->
			<!-- 바디2 스크롤 내렸을시 유지하기 위해 만듬  -->
			<div class="reviewbar3">
				<div class="productbox">
					<div class="productImage">
						<img class="productTitle"
							src="<%=request.getContextPath()%>/notice_upload/<%=list.get(1).getFileName()%>">
						<!-- 상품 메인에 있는 이미지  -->
					</div>
					<div class="productCotent">
						<p class="productName"><%=list.get(0).getNoticeTitle()%></p>
						<div class="productArea">
							<p class="reviewProduct">리뷰상품</p><span class="a"><%=list.get(1).getOfferProduct() %></span>
							<p class="deadLine">모집인원</p><span class="b"><%=list.get(1).getDeadlinePerson() %></span>
							<p class="campaign">캠패인기간</p><span class="c"><%=list.get(0).getNoticeStartDate() %>,<%=list.get(0).getNoticeEndDate()%></span>
							<p class="area1">지역</p><span class="c"><%=list.get(0).getProductArea() %></span>
						</div>
							<img class="productBar" src="/triangleView/img/notice/back23.png">
						
						
						
						<%if(list.get(0).getNoticeYPerson() < list.get(0).getDeadlinePerson() && loginUser.getUserLevel() == 1){ %>
						 <img class="noticePointer" src="/triangleView/img/notice/writeBtn.png" onclick="noticeApply(<%=list.get(1).getNoticeCode()%>)">
						<% } %>
				
					</div>
				</div>
					<hr>
				<p class="cam">캠패인 안내</p>	
				<div class="mainPosts">
					<div class="productPost3">
						<p class="mainPost3">주의 사항</p>
						<p class="maincontents3"><%=list.get(0).getCaution()%></p>
					</div>
					<div class="productPost4">
						<p class="mainPost4">캠패인 내용</p>
						<p class="maincontents5">
							<%=list.get(0).getNoticeContent()%><br>
						</p>
					</div>
				</div>
					<p class="yReview">선정 리뷰어</p>
					<p class="nReview">신청 리뷰어</p>
				<div class="NoticeYN">
					<div class="noticeN">
					  <%for(int i =0; i <list1.size(); i++){ %>
						<div class="userN">	
						<div class="userImg"><img class="userImgBox" src="<%= request.getContextPath() %>/profileImg_upload/<%=list.get(0).getFileName()%>"></div>
						<p class="userNick"><%=list1.get(i).getNick() %></p>
						<p class="userIntro"><%=list1.get(i).getIntro() %></p>
						</div>
					<% } %>
					</div>
					<div class="noticeY">
						<%for(int i =0; i < list2.size();i++){%>
						<div class="userY">	
						<div class="userImg1"><img class="userImgBox1" src="<%= request.getContextPath() %>/profileImg_upload/<%=list.get(0).getFileName()%>"></div>
						<p class="userNick1"><%=list2.get(i).getNick() %></p>
						<p class="userIntro1"><%=list2.get(i).getIntro() %></p>
						</div>
					<%} %>
				</div>
			</div>
				<div class="contentImage1">
					<img class="ImageMaintitle"
						src="<%=request.getContextPath()%>/notice_upload/<%=list.get(0).getFileName()%>">
				</div>
		</div>
	</div>
</div>
</div>	
</body>
</html>