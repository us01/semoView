<%@page import="java.util.Iterator"%>
<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.chain.triangleView.userHome.userHome.vo.HomeReview"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	HashMap<String, Object> userHome = (HashMap<String, Object>)request.getAttribute("userHome");
	ArrayList<HomeReview> reviews = (ArrayList<HomeReview>)userHome.get("reviews");
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
	body{
		font-family:'맑은고딕';
	}
	.myHomeListArea {
		margin:0 auto;
		display:inline-block;
		width:100%;
		text-align:center;
	}
	.lodingList {
		height:100px;
		text-align:center;
	}
	.viewForm{
		background:white;
		width:234px;
		height:287px;
		margin:7px;
		margin-top:10px;
		position:relative;
		display:inline-block;
		float:left;
		border:1px solid #E5E5E5;
	}
	.viewMainImage img{
		width:234px;
		height:210px;
		cursor:pointer;
	}
	.formType{
		top:10px;
		left:195px;
    	opacity: 0.9;
		position:absolute;
		z-index:2;
	}
	.viewTitle {
		width:100%;
		display:inline-block;
		text-align: left;
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
		display:inline-block;
		margin-left:5%;
		text-align:left;
	}
	.viewSearchImage > img, .viewLikeImage > img{
		width:30px;
		height:25px;
	}
	.viewSearchImage p, .viewLikeImage p{
		display:inline-block;
		font-size:13px;
		margin:0px;
		margin-left:5px;
		color:darkgray;
	}
	.reviewWriter {
		text-align:right;
		font-size:12px;
		font-weight:bold;
		padding-top:31px;
		color:#4F4F4F;
	}
	.reviewWriter p{
		display:inline;
		padding-right:8px;
		font-size:12px;
		margin:0px;
	}
	.formArea {
		display:inline-block;
		z-index: 300;
   		position: fixed;
   		left: 50%;
   		margin-left:-500px;
    	top: 80px;
	}
	@media all and (max-width:768px) {
		.centerContent { width:100%; }
	}
</style>
<script>
	var currentPage = 2;
	
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
	
	$(window).scroll(function(){
		if ($(window).scrollTop() == ($(document).height() - $(window).height())) {
			var url;
			
			<% if(loginUser != null){ %>
				url : '/triangleView/myHome';
			<% }else{ %>
				url : '/triangleView/userHome';
			<% } %>
			
			$.ajax({
				url : url,
				type : 'get',
				data : {
					currentPage : currentPage
				},
				beforeSend : function(){
					$myHomeListArea = $('.lodingList');
					
					$img = $('<img>');
					$img.attr('src', '/triangleView/img/mypage/userReviewListLoading.gif');
					$img.attr('class', 'userReviewListLoading');
					$img.width('50px').height('50px');
					
					$('.lodingList').append($img);
				},
				success : function(data){
					currentPage = data['currentPage'] + 1;
					$myHomeListArea = $('.myHomeListArea');
					$addMyHomeListArea = $('<div>');
					
					for(var key in data){
						if(key == 'reviews'){
							for(var i = 0; i < data['reviews'].length; i++){
								$viewForm = $('<div class="viewForm">');
								var $viewMainImage;
								
								<% if(loginUser != null){ %>
								$viewMainImage = $('<div class="viewMainImage" onclick=loadReivewForm(' + data.reviews[i].rwNo + ',' + data.reviews[i].rwContentType + ',' + <%= loginUser.getUserNo() %> +')>');
								<% }else{ %>
								$viewMainImage = $('<div class="viewMainImage" onclick=loadReivewForm(' + data.reviews[i].rwNo + ',' + data.reviews[i].rwContentType + ',' + '-1)>');
								<% } %>
								
								$mainImage = $('<img>');
								$mainImage.attr('src', '<%= request.getContextPath() %>/review_upload/' + data.reviews[i].thumbnail);
								
								$formType = $('<div class="formType">');
								$type = $('<img>');
								
								if(data.reviews[i].rwContentType == 0){
									$type.attr('src', '/triangleView/img/viewList/text.png');	
								}else if(data.reviews[i].rwContentType == 1){
									$type.attr('src', '/triangleView/img/viewList/card.png');
								}else{
									$type.attr('src', '/triangleView/img/viewList/vedio.png');
								}
								
								$viewTitle = $('<div class="viewTitle">');
								$viewTitleP = $('<p>');
								$viewTitleP.append(data.reviews[i].rwTitle);
								
								$viewSearchImage = $('<div class="viewSearchImage">');
								$searchImage = $('<img>');
								$searchImage.attr('src', '/triangleView/img/viewList/view.png');
								$viewSearchImageP = $('<p>');
								$viewSearchImageP.append(data.reviews[i].rwCount);
								
								$viewLikeImage = $('<div class="viewLikeImage">');
								$likeImage = $('<img>');
								$likeImage.attr('src', '/triangleView/img/viewList/love.png');
								$viewLikeImageP = $('<p>');
								$viewLikeImageP.append(data.reviews[i].likeCount);
								
								$reviewWrite = $('<div class="reviewWriter">')
								$reviewWriteP = $('<p>');
								$reviewWriteP.append('@');
								$reviewWriteP.append(data.reviews[i].nick);
								
								$viewMainImage.append($mainImage);
								$formType.append($type);
								$viewTitle.append($viewTitleP);
								$viewSearchImage.append($searchImage);
								$viewSearchImage.append($viewSearchImageP);
								$viewLikeImage.append($likeImage);
								$viewLikeImage.append($viewLikeImageP);
								$reviewWrite.append($reviewWriteP);
								
								$viewForm.append($viewMainImage);
								$viewForm.append($formType);
								$viewForm.append($viewTitle);
								$viewForm.append($viewSearchImage);
								$viewForm.append($viewLikeImage);
								$viewForm.append($reviewWrite);
								$addMyHomeListArea.append($viewForm);
							}
						}
					}
					
					$('.userReviewListLoading').remove();
					$myHomeListArea.append($addMyHomeListArea);
					$('html, body').animate({ scrollTop: ($(document).height() - 750)},400);
				}
			});
		}
	})
</script>
</head>
<body>
	<div class="myHomeListArea">
		<% for(int i = 0; i < reviews.size(); i++){ %>
			<div class="viewForm">
				<% if(loginUser != null){ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= reviews.get(i).getRwNo() %>, <%= reviews.get(i).getRwContentType() %>, <%= loginUser.getUserNo() %>)">
				<% }else{ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= reviews.get(i).getRwNo() %>, <%= reviews.get(i).getRwContentType() %>, -1)">
				<% } %>
					<img src="<%= request.getContextPath() %>/review_upload/<%= reviews.get(i).getThumbnail() %>">
				</div>
				<div class="formType">
					<% if(reviews.get(i).getRwContentType() == 0){ %>
						<img src="/triangleView/img/viewList/text.png">
					<% }else if(reviews.get(i).getRwContentType() == 1){ %>
						<img src="/triangleView/img/viewList/card.png">
					<% }else{ %>
						<img src="/triangleView/img/viewList/video.png">
					<% } %>
				</div>
				<div class="viewTitle">
					<p><%= reviews.get(i).getRwTitle() %></p>
				</div>
				<div class="viewSearchImage">
					<img src="/triangleView/img/viewList/view.png">
					<p><%= reviews.get(i).getRwCount() %></p>
				</div>
				<div class="viewLikeImage">
					<img src="/triangleView/img/viewList/love.png">
					<p><%= reviews.get(i).getLikeCount() %></p>
				</div>
				<div class="reviewWriter">
					@<p><%= reviews.get(i).getNick()%></p>
				</div>
			</div>
		<% } %>
	</div>
	<div class="lodingList"></div>
	<div id="formArea" class="formArea"></div>
	<div id="formAreaArea" class="w3-modal" onclick="formDisplayNone();"></div>
</body>
</html>