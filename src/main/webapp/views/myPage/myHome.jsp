<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HashMap<String, Object> userHome = (HashMap<String, Object>)request.getAttribute("userHome");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세모뷰 마이 페이지</title>
<style>
	body {
		margin:0px;
		background:#fafafa;
		font-family:'맑은고딕';
	}
	.myHomeArea{
		margin:0 auto;
		width:1000px;
		text-align:left;
		margin-top:10px;
	}
	@media all and (max-width:768px) {
		.myHomeArea { 
			width:100%;
		}
	}
</style>
<script>
	$(function(){
		$("#searchHash").keypress(function(key) {
			if(key.which == 13){
				naySearch();
			}
		});
	})
	
	function naySearch(){
		var submitCheck;
		
		if($('#sinceTime').val() != '' || $('#sinceTime').val() != ''){
			if($('#sinceTime').val() != '' && $('#sinceTime').val() != ''){
				submitCheck = 'Y';
				if($('#sinceTime').val() > $('#untilTime').val()){
					submitCheck = 'N';
				}
			}else{
				submitCheck = 'N';
			}
		}
		
		if(submitCheck != 'N'){
			$searchData = $('<input>')
			$searchData.attr('name', 'searchData');
			$searchData.attr('type', 'hidden');
			$searchData.val($('#searchHash').val());
			
			$('#searchForm').append($searchData);
			$('#searchForm').attr('action', '<%= request.getContextPath() %>/searchReview.sr').submit();
		}else{
			alert('                         기간 검색 조건이 잘 못 됐습니다.\n                                   다시 설정해주세요.');
		} 
	}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp" %>
	<div class="myHomeArea">
		<jsp:include page="myHomeHeader.jsp" flush="true">
			<jsp:param name="userHome" value="<%= userHome %>"/>
		</jsp:include>
		<jsp:include page="myHomeList.jsp" flush="true">
			<jsp:param name="userHome" value="<%= userHome %>"/>
		</jsp:include>
	</div>
</body>
</html>