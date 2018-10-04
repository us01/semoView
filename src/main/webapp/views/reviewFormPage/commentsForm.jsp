<%@page import="com.chain.triangleView.review.review.vo.Form"%>
<%@page import="com.chain.triangleView.review.review.vo.RwComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	HashMap<String, Object> reviewForm = (HashMap<String, Object>)request.getAttribute("reviewForm");
	Form form  = null;
	ArrayList<RwComment> rwComment = null;
	int rwNo = -1;
	
	if(reviewForm != null){
		Iterator<String> keys = reviewForm.keySet().iterator();
		
		while(keys.hasNext()){
			String key = keys.next();
			if(key.equals("form")){
				form = (Form)reviewForm.get(key);
				rwNo = ((Form)reviewForm.get(key)).getRwNo();
			}else if(key.equals("rwComment")){
				rwComment = (ArrayList<RwComment>)reviewForm.get(key);
			}
		}
	}else{
		rwComment = (ArrayList<RwComment>)request.getAttribute("rwComment");
		rwNo = Integer.parseInt((request.getAttribute("rwNo").toString()));
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/triangleView/css/reviewForm.css">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function addCommentAreaDisplay(rwNo){
		var display = $('.addchlidCommentArea'+rwNo).css('display');
		
		if(display == "none"){
			$('.addchlidCommentArea').css('display', 'none');
			document.getElementById('addchlidCommentArea'+rwNo).style.display = 'block';
		}else{
			document.getElementById('addchlidCommentArea'+rwNo).style.display = 'none';
		}
	}
	
	$(function(){
		$('.parentCommentInsertInputArea input').keypress(function(key) {
			if(key.which == 13){
				<% if(loginUser != null){ %>
					var userNo = '<%= loginUser.getUserNo() %>';
				<% } %>
				var commentContent = $(this).val();
				var commentNo = -1;
				
				$.ajax({
					url : '/triangleView/addComment',
					type : 'get',
					data : {
						rwNo : <%= rwNo %>, 
						commentNo : commentNo,
						userNo : userNo,
						commentContent : commentContent
					},
					success : function(data){
						$('.rwCommentArea').empty();
						
						$('.rwCommentArea').html(data);
					}
				});
			}
		});
		
		$('.childCommentInsertInputArea input').keypress(function(key) {
			if(key.which == 13){
				<% if(loginUser != null){ %>
					var userNo = '<%= loginUser.getUserNo() %>';
				<% } %>
				var commentContent = $(this).val();
				var commentNo = $(this).attr('id');
				
				$.ajax({
					url : '/triangleView/addComment',
					type : 'get',
					data : {
						rwNo : <%= rwNo %>,
						commentNo : commentNo,
						userNo : userNo,
						commentContent : commentContent
					},
					success : function(data) {
						$('.rwCommentArea').empty();
						
						$('.rwCommentArea').html(data);
					}
				});
			}
		});
	})
</script>
</head>
<body>
	<div>
		
		<div class="contentinfo-comment">
			<% if(rwComment != null){ %>
				<% for(int i = 0; i < rwComment.size(); i++){ %>
					<% if(!rwComment.get(i).getParentCommentNo()){ %>
						<div class="addParentComment">
							<div class="parentComment-insertArea">
								<div class="parentCommentProfileImageArea">
									<img src="/triangleView/profileImg_upload/<%= rwComment.get(i).getThumbnail() %>">
								</div>
								<div>
									<div class="parentCommentArea">
										<a class="parentComment_Id"><%= rwComment.get(i).getNick() %></a>
										<%= rwComment.get(i).getCommentContent() %>
									</div>
									<div class="parentCommentSubArea">
										<% if(loginUser != null){ %>
											<span class="parentComment_apply" onclick="addCommentAreaDisplay(<%= rwComment.get(i).getCommentNo() %>)">답글 달기</span>
											<span class="parentComment_apply"><%= rwComment.get(i).getRwDate() %></span>
										<% }else{ %>
											<span class="parentComment_apply"><%= rwComment.get(i).getRwDate() %></span>
										<% } %>
									</div>
								</div>
							</div>
							<% if(loginUser != null){ %>
								<div class="addchlidCommentArea addchlidCommentArea<%= rwComment.get(i).getCommentNo() %> " id="addchlidCommentArea<%= rwComment.get(i).getCommentNo() %>">
									<div class="childCommentInsert">
										<div class="childCommentInsertProfileImageArea">
											<img src="/triangleView/profileImg_upload/<%= loginUser.getThumbnail() %>">
										</div>
										<div class="childCommentInsertInputArea" id="<%= i %>">
											<input id='<%= rwComment.get(i).getCommentNo() %>' type="text" placeholder='등록'>
										</div>
									</div>
								</div>
							<% } %>
						</div>
					<% }else{ %>
						<div class="addChildComment">
							<div class="childComment-insertArea">
								<div class="childCommentProfileImageArea">
									<img src="/triangleView/profileImg_upload/<%= rwComment.get(i).getThumbnail() %>">
								</div>
								<div>
									<div class="childCommentArea">
										<a class="childComment_Id"><%= rwComment.get(i).getNick() %></a>
										<%= rwComment.get(i).getCommentContent() %>
									</div>
									<span class="childComment_apply"><%= rwComment.get(i).getRwDate() %></span>
								</div>
							</div>
						</div>
					<% } %>
				<% } %>
			</div>
		<% } %>
		<!--코멘트  -->
		<% if(loginUser != null){ %>
			<div>
				<div class="parentCommentInsert">
					<div class="parentCommentInsertProfileImageArea">
						<img src="/triangleView/profileImg_upload/<%= loginUser.getThumbnail() %>">
					</div>
					<div class="parentCommentInsertInputArea">
						<input id='parentComment<%= rwNo %>' type="text" placeholder="댓글">
					</div>
				</div>
			</div>
		<% }else{ %>
			<div class="commentLoginInfoArea">댓글은 로그인 후 이용하세요</div>
		<% } %>
	</div>
</body>
</html>