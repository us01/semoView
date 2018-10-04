<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
String rNo=request.getParameter("rwNo");
int rwNo = Integer.parseInt(rNo);
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8">
<style>
body {
	 font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px; 
}
#title{
text-align:center;
}

 
.spacer {
	clear: both;
	height: 1px;
}

/* ----------- My Form ----------- */
.myform {
	margin: 0 auto;
	width: 300px;
	padding: 14px;
	border: 0;
	margin: 0;
	padding: 10 10 10 10px;
	text-algin:center;
}

/* ----------- form-wrapper ----------- */
#form-wrapper {
	background: none repeat scroll 0 0 #C6C6C6;
	border: 2px solid #8B8B8B;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-op-border-radius: 10px;
	-webkit-border-radius: 10px;
}

 #form-wrapper h1 {
	font-weight: bold;
	margin-bottom: 8px;


} 

/* ----------- Form Button ----------- */
#form-wrapper button {
	background: #2c3e4a;
	background: -webkit-gradient(linear, left top, left bottom, from(#919496),
		to(#2c3e4a));
	background: -webkit-linear-gradient(top, #919496, #2c3e4a);
	background: -moz-linear-gradient(top, #919496, #2c3e4a);
	background: -ms-linear-gradient(top, #919496, #2c3e4a);
	background: -o-linear-gradient(top, #919496, #2c3e4a);
	padding: 5px 10px;
	-webkit-border-radius: 15px;
	-moz-border-radius: 15px;
	border-radius: 15px;
	margin-left: 315px;
	color: white;
	font-size: 20px;
	text-decoration: none;
	vertical-align: middle;
	margin-left: 60px;
}

#form-wrapper button:hover {
	background: #3d4b54;
	color: #ccc;
}
</style>
</head>
<body>
	<div id="form-wrapper" class="myform">
		
		<h1 id="title">게시물을 삭제하시겠습니까?</h1>
		<hr>
		<input type="hidden" value="<%=rwNo%>" name="rwNo" id="rwNo">
		<div style="margin-left:35px;">
		<label for="reason">사유:</label> <input type="text" name="reason"
			id="reason" /><br><br>
		</div>
		<button type="reset" id="cancle">취소</button>
		<button type="submit" id="okBtn">확인</button>
		<div class="spacer"></div>
	</div>
	
	
	<script>
	
		$(function() {

			$("#okBtn").click(function() {

				var rwNo = $("#rwNo").val();
				var reason =$("#reason").val();
				$.ajax({
					url : "/triangleView/deleteReview",
					type : "post",
					data : {
						rwNo : rwNo,
						reason : reason
					},
					success : function(data) {
						
						okBtn(rwNo);

					}

				});

			});
		});
		$(function() {
			$("#cancle").click(function() {

				displayNoneCancle();

			});
		});
	</script>
	</body>
</html>