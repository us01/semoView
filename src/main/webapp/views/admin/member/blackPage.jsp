<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String uNo=request.getParameter("userNo");
int userNo = Integer.parseInt(uNo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>등록페이지</title>
<meta http-equiv="Content-Type" content="text/jsp; charset=UTF-8">
<style>
body {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
}

/*  h1{
	border: 0;
	margin: 0;
	padding: 0;
	text-algin:center;
}
  */
.spacer {
	clear: both;
	height: 1px;
}

/* ----------- My Form ----------- */
.myform {
	margin: 0 auto;
	width: 300px;
	height:320px;
	padding: 14px;
	border: 0;
	margin: 0;
	padding:10 0 10 0px;
	text-algin: center;
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
	text-align:center;
}

}
#form-wrapper label {
	display: block;
	font-weight: bold;
	text-align: center;
	width: 193px;
	float: left;
	
}

}
#form-wrapper input, #form-wrapper textarea {
	float: left;
	border: solid 1px #aacfe4;
	width: 284px;
	margin: 2px 0 20px 10px;
	border-radius: 15px;
	-moz-border-radius: 15px;
	-op-border-radius: 15px;
	-webkit-border-radius: 15px;
	font-size: 14px;
}

#form-wrapper input {
	height: 25px;
	padding: 4px 10px;
}

#form-wrapper textarea {
	padding: 10px 10px;
	overflow: auto;
	margin-left:28px;
	position:absolute;
	width:182px;
	
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
	margin-left: 40px;
}
#cancle{
	margin-top:115px;
	}
	
#okBtn{
	margin-top:115px;
	
	


}

#form-wrapper button:hover {
	background: #3d4b54;
	color: #ccc;
}
</style>
</head>
<body>
	<div id="form-wrapper" class="myform">
		<%-- <form id="form" name="form" method="post" action="<%=request.getContextPath()%>/enrollBlack"> --%>

		<h1>블랙리스트 등록</h1>
		<hr>

		<input type="hidden" value="<%= userNo %>" name="userNo" id="userNo">
		<label for="rwNo">리뷰번호 </label> <input type="text" name="rwNo"
			id="rwNo" /><br> <label for="cNo">댓글번호</label> <input
			type="text" name="cNo" id="cNo" /><br> <label for="reason">사유</label>
		<textarea name="reason" id="reason" rows="5"></textarea>

		<button type="reset" id="cancle">취소</button>
		<button type="submit" id="okBtn">확인</button>
		<div class="spacer"></div>
	</div>



	<script>
		$(function(){
			
		$("#okBtn").click(function(){
			
			var userNo = $("#userNo").val();
			var rwNo = $("#rwNo").val();
			var cNo = $("#cNo").val();
			var reason = $("#reason").val();
			
			$.ajax({
				url:"/triangleView/enrollBlack",
				type:'post',
				data:{
					userNo:userNo,
					rwNo:rwNo,
					cNo:cNo,
					reason:reason
					
					
					
				},
				success:function(data){
					
					okBtn(userNo);
					
					
				
							
				}				
			});
		});
		
		});
		
		$(function(){
			$("#cancle").click(function(){
				
				displayNoneCancle();
				
			});
			});

		
		</script>








</body>
</html>