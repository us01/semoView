<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@page import="com.chain.triangleView.review.review.vo.Review"%>
<%@page import="java.util.*, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	ArrayList<HashMap<String, Object>> noticeList = (ArrayList<HashMap<String, Object>>)request.getAttribute("noticeList");
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
	body {
		font-family:'맑은고딕';
	}
	.contentsAear {
		margin:0 auto;
		width:900px;
	}
	.hotLivewList {
		background:white;
		margin:0 auto;
		height:318px;
		border:1px solid #dbdbdb;
	}
	.contentsAear ul{
		list-style:none;
		padding-left:0px;
		margin:0 auto;
		width:900px;
	}
	.contentsAear ul li {
		text-align:left;
	}
	.viewForm{
		width:213px;
		display:inline-block;
		float:left;
		margin:4px;
		margin-top:7px;
		position:relative;
		border:1px solid #dbdbdb;
		height:300px;
	}
	
	.viewForm:first-child{
		margin-left:7px;
	}
	.viewMainImage img{
		width:213px;
		height:221px;
		cursor:pointer;
	}
	.viewForm div:nth-of-type(6) p{
		font-size:8px;
		margin:0px;
	}
	.formType{
		top:0px;
		left:0px;
		position:absolute;
		z-index:2;
	}
	.formType img{
		width:25px;
	}
	.viewTitle {
		width:99%;
		display:inline-block;
		text-align: left;
		margin-left : 3px;
	}
	.viewTitle p {
		font-size:12px;
		font-weight:bold;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		padding-left:10px;
		margin-top:5px;
		margin-bottom:5px;
	}
	.viewSearchImage, .viewLikeImage{
		width:45%;
		float:left;
		display:table;
		text-align:left;
		padding-left: 10px;
		margin-top : 5px;
	}
	.viewSearchImage p, .viewLikeImage p{
		display:table-cell;
		font-size:13px;
		text-align:left;
		vertical-align:middle;
		margin:0px;
		color:darkgray;
		padding-bottom:6px;
	}
	
	.viewSearchImage img, .viewLikeImage img{
		margin-right:7px;
	}
	
	.viewSearchImage div, .viewLikeImage div{
		display:inline;
	}
	
	.reviewWriter {
		float:right;
		font-size:12px;
		cursor:pointer;
		color:#4F4F4F;
	}
	
	.reviewWriter p{
		display:inline;
		padding-right:5px;
		font-size:12px;
		font-weight:bold;
		margin:0px;
	}
	.eyeImage{
		width:29px;
		height:29px;
	}
	.likeImage{
		width:29px;
		height:29px;
	}
	.reviewerRecruitmentListArea {
		background:white;
		margin:0 auto;
		height:320px;
		border:1px solid #dbdbdb;
	}
	.recruitmentForm {
		width:213px;
		display:inline-block;
		float:left;
		margin:4px;
		margin-top:7px;
		position:relative;
		border:1px solid #dbdbdb;
		height:301px;
	}
	.recruitmentForm:first-child{
		margin-left:7px;
	}
	.recruitmentCategoryArea {
	    display: inline-block;
	    position: relative;
	    width: 100%;
		z-index:1;
		height:215px;
		text-align:center;
	}
	.recruitmentCategoryArea div:first-child{
	    display: inline;
	    position: relative;
	    background:black;
	    width: 40px;
	    float: left;
	    top: 5px;
	    left: 5px;
		z-index:1;
		height:20px;
		text-align:center;
	}
	.recruitmentCategoryArea label{
		font-size:9px;
		font-family:'맑은고딕';
		color:white;
		line-height:19px;
	}
	.recruitmentImageArea img{
		width:213px;
		height:215px;
	}
	.recruitmentImageArea{
		position:absolute;
	}
	.recruitmentTitleArea{
		width:194px;
		height:58px;
		padding-left:5px;
		padding-right:5px;
		display:inline-block;
	}
	.recruitmentTitleArea label{
		display:grid;
		font-size:12px;
		font-weight:bold;
		padding-top:11px;
		padding-bottom:4px;
	}
	.recruitmentTitleArea p{
		display:table-cell;
		font-size:11px;
		padding-top:4px;
		padding-bottom:11px;
		margin:0px;
	}
	.recruitmentStrengthArea{
		width:204px;
		height:25px;
		padding-left:5px;
		padding-right:5px;
		display:table;
		position:relative;
		text-align:center;
	}
	.recruitment_state_area{
		top:5px;
		left:160px;
		position:absolute;
		z-index:1;
		background:green;
		width:40px;
		height:15px;
		border-radius:2px;
		text-align:center;
	}
	.recruitment_state_area label{
		font-size:11px;
		color:white;
	}
	
	.noticeEventArea {
		background:white;
		margin:0 auto;
		margin-top:60px;
		border:1px solid #dbdbdb;
	}
	.noticeEventArea div{
		margin:9px;
		width:432px;
		height:180px;
		display:inline-block;
		border:1px solid #dbdbdb;
	}
	.noticeEventArea div:first-child{
		width:430px;
		margin-right:4px;
	}
	.noticeEventArea div:last-child{
		width:431px;
		margin-left:5px;
	}
	.noticeEventArea div:first-child img{
		width:430px;
		height:180px;
	}
	.noticeEventArea div:last-child img{
		width:431px;
		height:180px;
	}
	
	.title {
		margin-top:30px;
		color:gray;
		margin-bottom:10px;
	}
	.formArea {
		z-index: 300;
   		position: fixed;
   		left: 50%;
   		margin-left:-500px;
    	top: 80px;
	}
	@media all and (max-width:768px) {
		.centents {
			width:100%;
		}
		.contentsAear {
			margin:0 auto;
			width:95%;
		}
		.contentsAear ul{
			width:100%;
		}
		.hotLivewList {
			width:100%;
			display:inline-table;
		}
		.reviewerRecruitmentListArea {
			width:100%;	
			display:inline-table;
		}
		.noticeEventArea{
			width:100%;
			text-align:-webkit-center;
		}
		..noticeEventArea div {
			width:431px;
		}
		.noticeEventArea div:first-child{
			margin:5px;
			margin-bottom:0px;
		}
		.noticeEventArea div:last-child{
			margin:5px;
		}
	}
	
	.recruitBottom{
	
		width : 48%;
		display : inline-block;
		text-align : left;
	}
	
	.recruitBottom img{
		width : 20px;
		height : 20px;
	}
	
	.noticeDate{
		position: relative;
	    display: inline-block;
	    right: 5px;
	    top: 5px;
	    width: 40px;
	    float: right;
		background: #f7323f;
	    border-radius: 8px;
	    height: 17px;
	    color:white;
	    font-weight : bold;
	    font-size : 7px;
	    text-align : center;
	}
</style>
<script>
	function goHome(word){
		var goUser = $(word).attr("id");
		var goMe = '';
		<% if(loginUser != null){ %>
			goMe = '<%= loginUser.getUserId() %>';
		<% } %>
		
		if(goMe != goUser){
			location.href='<%= request.getContextPath()%>/userHome?goUser=' + goUser + '&goMe=' + goMe;
		}else{
			location.href='<%= request.getContextPath()%>/myHome';
		}
	}
	
	function loadReivewForm(rwNo, rwContentType, userNo){
		$.ajax({
			url : "/triangleView/loadOneReviewForm.rf",
			type : "GET",
			data : {
				rwNo : rwNo,
				rwContentType : rwContentType,
				userNo : userNo
			},
			success : function(data) {
				$(".formArea").html(data);
				document.getElementById('formAreaArea').style.display = 'inline-block';
				document.getElementById('formArea').style.display = 'inline-block';
			}
		});
	}

	function formDisplayNone() {
		document.getElementById('formArea').style.display = 'none';
		document.getElementById('formAreaArea').style.display = 'none';
	}
	
	function loginGo(){
		$(".insertMemberTypeArea").css("margin-left", "-150px");
		$.ajax({
			url : "/triangleView/views/member/loginOrInsertMemberType.jsp",
			data : "html",
			success : function(data) {
				$(".insertMemberTypeArea").html(data);
				document.getElementById('insertMemberTypeAearArea').style.display = 'block';
				document.getElementById('insertMemberTypeArea').style.display = 'block';
			}
		});
		
	}
</script>
</head>
<body>
	<jsp:include page="./mainCategory.jsp"></jsp:include>
	<div class="contentsAear">
		<ul>
			<li>
				<h2 class="title">인기리뷰</h2>
				<div class="hotLivewList">
					<%for(int i = 0; i < reviewList.size(); i++){%>
						<div class="viewForm">
							<% if(loginUser != null){ %>
								<div class="viewMainImage" onclick="loadReivewForm(<%= reviewList.get(i).getRwNo() %>, <%= reviewList.get(i).getRwContentType() %>, <%= loginUser.getUserNo() %>)">
							<% }else{ %>
								<div class="viewMainImage" onclick="loadReivewForm(<%= reviewList.get(i).getRwNo() %>, <%= reviewList.get(i).getRwContentType() %>, -1)">
							<% } %>
								<img src="/triangleView/review_upload/<%= reviewList.get(i).getThumbnail() %>">
							</div>
							<div class="formType">
								<% if(reviewList.get(i).getRwContentType() == 0){ %>
									<img src="/triangleView/img/viewList/text.png" style="position:absolute; margin-left : 180px; margin-top : 10px; opacity:0.9;">
								<% }else if(reviewList.get(i).getRwContentType() == 1){ %>
									<img src="/triangleView/img/viewList/card.png" style="position:absolute; margin-left : 180px; margin-top : 10px; opacity:0.9;">
								<% }else{ %>
									<img src="/triangleView/img/viewList/video.png" style="position:absolute; margin-left : 180px; margin-top : 10px; opacity:0.9;">
								<% } %>
							</div>
							<div class="viewTitle">
								<p><b><%= reviewList.get(i).getRwTitle() %></b></p>
							</div>
							<div style="align:center;">
								<div class="viewSearchImage">
									<img src="/triangleView/img/viewList/view.png" style="width:30px; height:25px;">
									<div><p><%= reviewList.get(i).getRwCount() %></p></div>
								</div>
								<div class="viewLikeImage">
									<img src="/triangleView/img/viewList/love.png" style="width:30px; height:25px;">
									<div><p><%= reviewList.get(i).getLikeCount() %></p></div>
								</div>
							</div>
							<div class="reviewWriter">
								@<p onclick="goHome(this)" id="<%= reviewList.get(i).getUserId() %>"><%= reviewList.get(i).getNick() %></p>
							</div>
						</div>
					<% } %>
				</div>
			</li>
			<li>
				<h2 class="title">리뷰체험단</h2>
				<div class="reviewerRecruitmentListArea">
            	<%for(int i = 0; i < 4 && noticeList.size() != 0; i++){
					
					HashMap<String, Object> hmap = noticeList.get(i);
				%>
					<div class="recruitmentForm">
						<div class="recruitmentImageArea">
							<img src="<%= request.getContextPath() %>/notice_upload/<%=hmap.get("filename")%>">
						</div>
						<div class="recruitmentCategoryArea">
							<div style="display:inline-block;">
								<label>
									   <% if((Integer)hmap.get("categorycode") == 1) {%>자유<%} %>
									   <% if((Integer)hmap.get("categorycode") == 2) {%>게임<%} %>
									   <% if((Integer)hmap.get("categorycode") == 3) {%>취미<%} %>
									   <% if((Integer)hmap.get("categorycode") == 4) {%>IT<%} %>
									   <% if((Integer)hmap.get("categorycode") == 5) {%>인생<%} %>
									   <% if((Integer)hmap.get("categorycode") == 6) {%>금융<%} %>
									   <% if((Integer)hmap.get("categorycode") == 7) {%>스포츠<%} %>
									   <% if((Integer)hmap.get("categorycode") == 8) {%>뷰티<%} %>
									   <% if((Integer)hmap.get("categorycode") == 9) {%>뮤직<%} %>
								</label>
							</div>
								<%
										
									Date currentTime = new Date ();
									String endString = (String)hmap.get("noticeenddate");
									Date endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endString);
									long diff = endTime.getTime() - currentTime.getTime();
									long diffDays = diff / (24 * 60 * 60 * 1000);
									    
									if(diffDays > 0){%>
									    <td><div class="noticeDate">D-<%= diffDays %></div></td>
									<%}else {%>
										<td><div class="noticeDate">D-DAY</div></td>
									<%} %>
						</div>
						<div class="recruitmentTitleArea">
							<label><b style="width:200px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis;"><%= hmap.get("noticetitle") %></b></label>
							<p>문제적남자 뇌색캔디 _ 뇌색겸 제고</p>
						</div>
						<div class="recruitmentStrengthArea">
							<div class="recruitBottom">
								<img src="/triangleView/img/company/location2.png">
								<label style="font-size : 12px;"><%= hmap.get("productarea") %></label>
							</div>
							<div class="recruitBottom" style="text-align: center;">
								<img src="/triangleView/img/company/user.png">
								<label style="font-size : 12px;"><%= hmap.get("person") %> / <%= hmap.get("deadlineperson") %></label>
							</div>
						</div>
					</div>
				<%} %>
				</div>
			</li>
			<li>
				<div class="noticeEventArea">
					<div>
						<a href="#" onclick="loginGo();"><img src="/triangleView/img/main/testevent10.png"></a>
					</div>
					<div>
						<a href=""><img src="/triangleView/img/main/testevent11.png"></a>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<div id="formArea" class="formArea"></div>
	<div id="formAreaArea" class="w3-modal" onclick="formDisplayNone();"></div>
</body>
</html>