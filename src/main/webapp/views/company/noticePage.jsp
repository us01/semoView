<%@page import="com.chain.triangleView.notice.notice.vo.notice.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.chain.triangleView.notice.notice.vo.notice.Application"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
 	HashMap<String,Object> noticeForm = (HashMap<String,Object>)request.getAttribute("noticeForm");

	Iterator<String> keys = noticeForm.keySet().iterator();
	
	ArrayList<Application> a = null;
	
	ArrayList<Notice> list = null;
	
	while(keys.hasNext()){
		String key = keys.next();
		if(key.equals("a")){
			a = (ArrayList<Application>)noticeForm.get(key);
		}else if(key.equals("list")){
			list = (ArrayList<Notice>)noticeForm.get(key);
		}
	}


%>
<html>
<head>

<title>Insert title here</title>
<style>
.modal {
	text-align: center;
}

@media screen and (min-width: 768px) {
	.container {
		display: inline-block;
		vertical-align: middle;
		content: " ";
		height: 100%;
	}
}

.modal-body {
	position: relative;
	padding: 15px;
	width: 640px !important;
	height: 500px;
	overflow: scroll;
	margin: 0 auto;
}

.container {
	display: flex;
	width: 1000px;
	margin: 0 auto;
}

.modal-body {
	background: white;
}

.imageBox {
	width: 220px;
    height: 220px;
    display: -webkit-inline-box;
}

img.productImg {
	width: 220px;
	height: 220px;
}

.reviewbody {
	width: 410px;
    height: 260px;
}

.reviewSelect {
	display: table;
	position: relative;
	bottom: 7px;
}

.reviewSelect p {
	font-size: 12px;
    font-weight: bold;
    color: black;
    margin-left: 31px;
}

.review13 {
	width: 120px;
	height: 175px;
	right: 110px;
	display: inline-block;
	margin-left: 60px;
	margin-top: -146px;
}

.review13 p {
	font-size: 10px;
	bottom: 31px;
	color: black;
}

.reviewCount { /*좋아요 조회수 틀  */
	width: 370px;
    height: 90px;
    bottom: 160px;
    border-top: 1px solid #cacaca;
    display: table;
    margin-left: 30px;
}

p.like { /*좋아요 갯수 */
	margin: 0 auto;
	float: right;
	margin-left: 10px;
	margin-top: 5px;
	font-size: 0.7em;
	font-weight: bold;
}

p.content { /*조회 수  */
	margin: 0 auto;
	float: right;
	margin-left: 10px;
	margin-top: 5px;
	font-size: 0.7em;
	font-weight: bold;
}

.reviewBody1 { /*리뷰 본체  */
	width: 620px;
    height: 463px;
    margin-top: 40px;
}

.reviewBox1 {
	width: 80%;
	height: 430px;
	margin: 0 auto;
	margin-top: 1%;
	position: relative;
	top: 3%;
}

.btn1 {
	width: 90px;
    height: 30px;
    background: #f7323f;
    text-align: center;
    font-size: 1em;
    color: white;
    border-radius: 8px;
    line-height: 2;
    display: inherit;
    margin-left: 200px;
    margin-top: 10px;
    float: right;
}

.ReviewerTotal {
	width: 100%;
	height: 37%;
	position: relative;
	top: 20px;
}

.totalReview {
	width: 100%;
	height: 50%;
	position: relative;
	top: 10%;
}
</style>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
	width: 100%;
	height: 100%;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-uqo3 {
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-s6z2 {
	text-align: center;
	background: #f9f9f9;
}

.tg .tg-baqh {
	text-align: center;
	vertical-align: top
}

.tg .tg-9vn7 {
	font-weight: bold;
	font-size: 15px;
	font-family: serif !important;
	background-color: #f7323f;
	color: #ffffff;
	text-align: center;
}

.tg .tg-j4kc {
	background-color: #efefef;
	text-align: center
}
</style>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-7ank {
	background-color: #f7323f;
	text-align: left
}

.tg .tg-kftd {
	background-color: #efefef;
	text-align: left;
	vertical-align: top
}

.tg .tg-s268 {
	text-align: left
}

.tg .tg-0lax {
	text-align: left;
	vertical-align: top
}

.tg-7ank p {
	font-size: 0.9em;
	text-align: center;
	font-weight: bold;
	color: white;
	margin: 0 auto;
}

.tg-9vn7 p {
	font-size: 17px;
	text-align: center;
	font-weight: bold;
	color: white;
	margin: 0 auto;
}

.modal-body {
	position: relative;
	padding: 15px;
	width: 600px;
	margin: 0 auto;
}

.modal-footer {
	padding: 15px;
	text-align: right;
	width: 600px;
	margin: 0 auto;
}

button {
	color: white;
	border-radius: 6px;
	background: #f7323f;
	float: right;
	margin-right: 15px;
}
.reviewSelect span{
	margin-left: 10px;
    font-weight: 100;
}
.btn1:hover{
	cursor:pointer;
}
button:hover{
	cursor:pointer;
}
</style>
<script>
function goDetails(details){
		
		var details;
		var count;

	if(details != null){
		location.href='<%=request.getContextPath()%>/details?details=' + details;		
	}else{
		alert("조회실패!");
	}	
}
function noticeY(noticeCode,userNo){
	var noticeCode;
	var userNo;
	
	alert(noticeCode);
	alert(userNo);
	
	if(noticeCode != null){
		location.href='<%=request.getContextPath()%>/noticeY?noticeCode=' + noticeCode + '&userNo=' + userNo;
	}
}
</script>
</head>
<body>

	<div class="container">
		<div class="modal-body">
			<div class="imageBox">
				<img class="productImg"
					src="<%=request.getContextPath()%>/notice_upload/<%=list.get(1).getFileName()%>">
				<div class="reviewbody">
					<div class="reviewSelect">
						<p class="proName1">카테코리<span class="productName1"><%=list.get(0).getCategoryCodeName() %></span></p>
						<p class="productReview">제공상품<span class="productReview1"><%=list.get(0).getOfferProduct() %></span></p>
						<p class="userId">제목<span class="userId1"><%=list.get(0).getNoticeTitle() %></span></p>
						<p class="writer1">공고인원<span class="Line"><%=list.get(0).getNoticeYPerson() %>명</span></p>
						<p class="writer1">마감인원<span class="Maxperson"><%=list.get(0).getDeadlinePerson() %>명</span></p>
						<p class="writer">공고일시<span class="writer1"><%=list.get(0).getNoticeStartDate() %>~<%=list.get(0).getNoticeEndDate() %></span></p>
						<p clsss="write-date">작성일시<span class="write-date"><%=list.get(0).getNoticeDate() %></span></p>
					<div class="reviewCount">
						<div class="btn1"
							onclick="goDetails(<%=list.get(0).getNoticeNo()%>)">원문글보기</div>
					</div>
					</div>				
				</div>
			</div>
			<div class="reviewBody1">
				<div class="reviewBox1">
					<div class="ReviewerTotal">
						<table class="tg" style="table-layout: fixed; width: 100%;">
							<colgroup>
								<col style="width: 170px">
							</colgroup>
							<tr>
								<th class="tg-9vn7"><p class="num0">공고리뷰어 신청회원</p></th>
							</tr>
							<%for(int i = 0; i < a.size(); i++){ %>
							<tr>
								<td class="tg-s6z2"><%=a.get(i).getUserId()%>,<%=a.get(i).getNick() %><button
										id="btn" onclick="noticeY(<%=a.get(i).getNoticeCode()%>,'<%=a.get(i).getUserNo()%>')">수락</button></td>
							</tr>
							<%} %>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
<script>







</script>

</body>
</html>