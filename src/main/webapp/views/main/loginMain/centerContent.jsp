<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@page import="com.chain.triangleView.review.review.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Review> interestReviewList = (ArrayList<Review>)request.getAttribute("interestReviewList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/triangleView/css/w3.css">
<title></title>
<style>
	.viewForm{
		width:220px;
		height:287px;
		margin:5px;
		margin-top:8px;
		position:relative;
		display:inline-block;
		float:left;
		border:1px solid #E5E5E5;
		background:white;
	}
	.viewMainImage img{
		width:220px;
		height:210px;
		cursor:pointer;
	}
	.formType{
		top:0px;
		left:10px;
		position:absolute;
		z-index:2;
	}
	.viewTitle {
		width:99%;
		display:inline-block;
		text-align: left;
		margin-left : 5px;
	}
	.viewTitle p {
		font-size:12px;
		font-weight:bold;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		padding-left:5px;
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
	.viewSearchImage img, .viewLikeImage img{
		margin-right:7px;
	}
	.viewSearchImage div, .viewLikeImage div{
		display:inline;
	}
	.viewSearchImage p, .viewLikeImage p{
		display:table-cell;
		font-size:13px;
		text-align:left;
		margin:0px;
		color:darkgray;
	}
	.reviewWriter {
		float:right;
		font-size:12px;
		font-weight:bold;
		cursor:pointer;
		color:#4F4F4F;
	}
	.reviewWriter p{
		display:inline;
		padding-right:5px;
		font-size:12px;
		font-weight:bold;
		margin:0px;
		margin-top: -5px;
	}
	.formArea {
		display:inline-block;
		z-index: 300;
   		position: fixed;
   		left: 50%;
   		margin-left:-500px;
    	top: 90px;
	}
	@media all and (max-width:768px){
		.centerContent { 
			width:100%; 
			display:inline-table;
		}
	}
</style>
<script>
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
</script>
</head>
<body>
	<div class="centerContent">
		<% for(int i = 0; i < interestReviewList.size(); i++){ %>
			<% if(i <8){ %>
				<div class="viewForm" >
			<% }else{ %>
				<div class="viewForm" id="viewForm<%= i %>" style="display:none;">
			<% } %>
				<% if(loginUser != null){ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= interestReviewList.get(i).getRwNo() %>, <%= interestReviewList.get(i).getRwContentType() %>, <%= loginUser.getUserNo() %>)">
				<% }else{ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= interestReviewList.get(i).getRwNo() %>, <%= interestReviewList.get(i).getRwContentType() %>, -1)">
				<% } %>
					<img src="<%= request.getContextPath() %>/review_upload/<%= interestReviewList.get(i).getThumbnail() %>">
				</div>
				<div class="formType">
					<% if(interestReviewList.get(i).getRwContentType() == 0){ %>
							<img src="/triangleView/img/viewList/text.png" style="position:absolute; margin-left : 170px; margin-top : 10px; opacity:0.9;">
					<% }else if(interestReviewList.get(i).getRwContentType() == 1){ %>
						<img src="/triangleView/img/viewList/card.png" style="position:absolute; margin-left : 170px; margin-top : 10px; opacity:0.9;">
					<% }else{ %>
						<img src="/triangleView/img/viewList/video.png" style="position:absolute; margin-left : 170px; margin-top : 10px; opacity:0.9;">
					<% } %>
				</div>
				<div class="viewTitle">
					<p><b><%= interestReviewList.get(i).getRwTitle() %></b></p>
				</div>
				<div style="align:center;">
					<div class="viewSearchImage">
						<img src="/triangleView/img/viewList/view.png" style="width:30px; height:25px;">
						<div><p><%= interestReviewList.get(i).getRwCount() %></p></div>
					</div>
					<div class="viewLikeImage">
						<img src="/triangleView/img/viewList/love.png" style="width:30px; height:25px;">
						<div><p><%= interestReviewList.get(i).getLikeCount() %></p></div>
					</div>
				</div>
				<div class="reviewWriter" style="padding-right:3px;">
					@<p onclick="goHome(this)" id="<%= interestReviewList.get(i).getUserId() %>"><%= interestReviewList.get(i).getNick() %></p>
				</div>
			</div>
		<% } %>
	</div>
	<div id="formArea" class="formArea"></div>
	<div id="formAreaArea" class="w3-modal" onclick="formDisplayNone();"></div>
	<script>
		var $element = $('.centerContent');
		var element = $element[0];
		var doc = element.ownerDocument;
		var win = doc.defaultView || doc.parentWindow;
		
		var startNo = 8;
		var endNo;
		
		
		$(win).scroll(function(){
			if ($(window).scrollTop() == ($(document).height() - $(window).height())) {
				
				endNo = startNo + 8;
				
				setTimeout(function(){
					jQuery.fn.exists = function(){return this.length>0;}
					
					for(var i = startNo; i < endNo && $('#viewForm' + i).exists(); i++){
						if($('#viewForm' + i) != null){
							$('#viewForm' + i).css('display', 'inline-block');
						}
					}
					
					startNo += 8;
					}, 300);
			}
		})
	</script>
</body>
</html>