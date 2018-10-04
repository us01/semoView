<%@page import="com.chain.triangleView.notice.notice.vo.notice.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, java.text.SimpleDateFormat"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans"
	rel="stylesheet">
<!--구글 폰트  -->
<link href="https://fonts.googleapis.com/css?family=Poor+Story"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 아이콘  -->

<meta charset="UTF-8">
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

.mainPage {
	margin: 0 auto;
}

.mainheader { /*메인 헤더  가져온거 */
	width: 100%;
	background: #F7323F;
	align-text: center;
}

.header {
	width: 100%;
}

.mainWriter { /* 카테고리 버튼  가장큰 틀 div  */
	width: 1000px;
	margin-top: 70px;
	margin-left: auto;
	margin-right: auto;
}

h2.Reviewer {
	float: right;
	font-weight: bold;
	color: #fd5f6a;
}

p.Campaign {
	float: right;
	margin-right: 50px;
	position: relative;
	top: 10px;
	color: #fd5f6a;
}

img.ReviewerMain {
	width: 960px;
}

img.Reviewrbar {
	width: 429px;
	height: 42px;
	float: right;
	margin-right: 40px;
	position: relative;
	bottom: 17px;
}

.mainmenu {
	width: 100%;
}

.menu {
	width: 1000px;
	position: relative;
	bottom: 17px;
}

.categoryBtn { /*  카테고리 10개  */
	width: 48px;
	text-align: center;
	background: white;
	border: 1px solid white;
	display: table-cell;
}

label { /* 가테고리 안에 있는 라벨  */
	font-size: 11px;
	color: white;
}

.postlabel {
	background: #bbbaba;
	width: 4.5%;
	height: 30px;
	position: relative;
	bottom: 87%;
	left: 28.5%;
	border-radius: 15px;
}

.post2 {
	color: white;
	font-size: 10%;
	text-align: center;
	position: relative;
	display: block;
	top: 7px;
}

.Selectbox {
	position: fixed;
	width: 70%;
	height: 100px;
	display: block;
	top: 180px;
	margin-left: 43.9%;
}

.select {
	float: left;
	font-size: 12px;
}

.reviewbar {
	width: 1020px;
	margin: 0 auto;
}

.footer {
	background: #F5F5F5;
	width: 101%;
	text-align: center;
	margin: 0 auto;
	margin-top: 90px;
	clear: both;
	position: relative;
	top: 980px;
}

.reviewmain { /*공고 가장 큰틀  */
	width: 70%;
	height: 340px;
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

.review1 {
	width: 24%;
	height: 100%;
	background: gray;
	position: relative;
	bottom: 100%;
	left: 25%;
}

/*이미지*/
.reviewImagebox { /* 이미지틀 */
	width: 310px;
	height: 250px;
}

}
img { /*이미지  */
	width: 100%;
	height: 100%;
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
	margin-top: 5px;
	margin-bottom: 5px;
	position: relative;
	left: 8px;
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
	bottom: 43px;
	left: 15px;
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
	bottom: 284px;
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
	top: 25px;
	left: -22px;
}

p.maxperson { /* 총인원  */
	position: relative;
	bottom: 164%;
	font-size: 11px;
	left: 59%;
}

p.person { /* 현재 인원 */
	display: table-cell;
	font-size: 15px;
	padding-top: 4px;
	padding-bottom: 11px;
	margin: 0px;
	position: relative;
	bottom: 43px;
	left: 230px;
}

.reviewbar3 {
	margin: 0 auto;
}

.pageBtnbox {
	width: 30%;
	height: 6%;
	position: relative;
	bottom: 65%;
	margin: 0 auto;
}

.writerbtn {
	width: 1000px;
	text-align: center;
	position: relative;
	bottom: 80%;
	left: 43%;
}

.reviewbody {
	width: 100%;
}

.reviewImg {
	width: 100%;
	height: 260px;
	vertical-align: middle;
	background: white;
}

img.locationIcon {
	width: 20px;
	right: 30px;
	top: 9px;
	margin-right: 10px;
	margin-top: -3px;
}

img.userIcon {
	width: 20px;
	margin-right: 10px;
	margin-top: -2px;
}

.personBox {
	display: table-cell;
	font-size: 11px;
	padding-top: 4px;
	padding-bottom: 11px;
	margin: 0px;
	position: relative;
	top: 15px;
	left: -24px;
}

.view {
	border-width: 1px;
	border-style: double;
}

button {
	border-radius: 6px;
	background: #f7323f;
	color: white;
	font-family: '맑은고딕';
}
button {
    margin-left: -20px;
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
	bottom: 284px;
	right: 10px;
}

.btnBox {
	width: 100%;
}

.writerbtn {
	width: 1000px;
    text-align: center;
    margin: 0 auto;
    margin-left: -10px;
}
img.inCateogry:hover{
	cursor:pointer;
}
.noticeBtn:hover{
	cursor:pointer;
}
.review:hover{
	cursor:pointer;
}
</style>
<script>
	function noticWrite(){
		location.href="/triangleView/views/companyNotice/announcenmentWriter.jsp";
	}
	function goNotice(categoryName){
		var categoryName = $(categoryName).find('label').text();
		
		
		if(categoryName != null){
			location.href='<%=request.getContextPath()%>/category?categoryName=' + categoryName;
		}else{
			alert("조회실패!");
		}
	}
	function noticeDetails(){
		location.href="/triangleView/views/companyNotice/announcementDetails.jsp"
	}
	function goDetails(details){
		
		var details;
		var count;
		
	if(details != null){
		location.href='<%=request.getContextPath()%>/details?details=' + details;
		
	}else{
		alert("조회실패!");
	}	
		
		
	}
</script>

</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="mainPage">
		<div class="header">
			<div class="mainWriter">
				<p class="Campaign">Campaign</p>
				<h2 class="Reviewer">리뷰어 공고</h2>
				<img class="ReviewerMain" src="/triangleView/img/notice/back1.png">
				<img class="Reviewrbar" src="/triangleView/img/notice/back23.png">
				<div class="mainmenu">
					<!--카테고리 검색 버튼  -->
					<div class="menu">
						<div class="categoryBtn" id="btn1" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry1.png"><label
								id="inCateogry1">자유</label>
						</div>
						<div class="categoryBtn" id="btn2" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry2.png"><label
								id="inCateogry2">It/가전</label>
						</div>
						<div class="categoryBtn" id="btn3" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry3.png"><label
								id="inCateogry3">뷰티</label>
						</div>
						<div class="categoryBtn" id="btn4" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry4.png"><label
								id="inCateogry4">금융</label>
						</div>
						<div class="categoryBtn" id="btn5" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry5.png"><label
								id="inCateogry5">스포츠</label>
						</div>
						<div class="categoryBtn" id="btn6" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry6.png"><label
								id="inCateogry6">취미</label>
						</div>
						<div class="categoryBtn" id="btn7" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry7.png"><label
								id="inCateogry7">게임</label>
						</div>
						<div class="categoryBtn" id="btn8" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry8.png"><label
								id="inCateogry8">음악</label>
						</div>
						<div class="categoryBtn" id="btn9" onclick="goNotice(this)">
							<img class="inCateogry"
								src="/triangleView/img/notice/category/inCateogry9.png"><label
								id="inCateogry9">인생</label>
						</div>
						<%
							if (loginUser.getUserType() == 1) {
						%>
						<div class="btnBox">
							<div class="writerbtn">
								<button class="noticeBtn" onclick="noticWrite()">공고작성</button>
							</div>
						</div>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
		<div class="reviewbody">
			<!--	틀     -->
			<div class="reviewbar">
				<%
					for (int i = 0; i < list.size(); i++) {
				%>
				<!--  바디  -->

				<div class="review">
					<!--공고틀  -->
					<div class="reviewImagebox"
						onclick="goDetails(<%=list.get(i).getNoticeNo()%>)">
						<!--이미지 틀  -->
						<img class="reviewImg"
							src="<%=request.getContextPath()%>/notice_upload/<%=list.get(i).getFileName()%>">
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
							<!-- 상품내역  -->
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
							<!--위치  -->
							<div class="location">
								<p class="Location1">
									<img class="locationIcon"
										src="/triangleView/img/notice/location.png"><%=list.get(i).getProductArea()%>
								</p>
							</div>
							<!--현재인원  -->
							<div class="personBox">
								<p class="person">
									<img class="userIcon" src="/triangleView/img/notice/user.png"><%=list.get(i).getNoticeYPerson()%>명/<%=list.get(i).getDeadlinePerson()%>명
								</p>
								<!--총 인원  -->
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
</body>
</html>