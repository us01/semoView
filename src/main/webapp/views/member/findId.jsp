<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.chain.triangleView.SNS.SNScheck"%>
<%
	String snsRan= (String)request.getAttribute("ran");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<title>findId</title>


<!-- w3 혁동 밤길조심해... -->
<link rel="stylesheet" href="/triangleView/css/w3.css" media="screen"
	title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="/triangleView/css/font-awesome.min.css"
	media="screen" title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="/triangleView/css/style.css" media="screen"
	title="no title" charset="utf-8">

<script src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>

<!-- CSS -->
<style>
/* body {
	font-family: '맑은고딕';
}

div {
	display: inline-block;
}

button {
	width: 180px;
	background-color: #f8585b;
	border: none;
	color: #FDEBEC;
	padding: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-top: 4px;
	margin-bottom: 4px;
	cursor: pointer;
	border-radius: 5px;
} */

.btn-success {
	width: 120px;
	background-color: #F7323F;
	border: none;
	color: #FDEBEC;
	padding: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-top: 4px;
	margin-bottom: 4px;
	cursor: pointer;
	border-radius: 5px;
}

.subButton {
	width: 120px;
	background-color: #F7323F;
	border: none;
	color: #FDEBEC;
	padding: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-top: 4px;
	margin-bottom: 4px;
	cursor: pointer;
	border-radius: 5px;
}

.w3-card {
	width: 50%;
}

.w3-change {
	display: inline-block;
	width: 300px;
}

.howToUse {
	margin-left: 10px;
	text-align: center;
}

#personalnum{
	background-image: url(/triangleView/img/member/phone.png);
    background-position: 0px 5px;
    background-size: 30px;
    background-repeat: no-repeat;
    height: 25px;

}

#sendVertify{
	width: 318px;
    height: 30px;
    margin-left: 15px;
    border-radius:0px;
}

#checkNum:focus {
    outline: none;
}

#personalnum:focus{
	outline: none;
}

#checkNum{
    width: 300px;
    margin-left: 15px;
    border: 1px solid red;
}

#howTo{
    font-size: 14px;
   
}

#vertifyNum{
    display: block;
    position: absolute;
    left: 300px;
    top: 255px;
    width: 70px;
    height: 40px;
}
</style>
<script>

$('#personalnum').keypress(function (event) { 
	if (event.which && (event.which <= 47 || event.which >= 58) && event.which != 8) { 
		event.preventDefault();
		} 
	});

$('#checkNum').keypress(function (event) { 
	if (event.which && (event.which <= 47 || event.which >= 58) && event.which != 8) { 
		event.preventDefault();
		} 
	});

</script>
</head>

<body>
<div class="holder">
	<div class="page-header" style="text-align:center; display: block; margin-top: 20px;">
		<h2 style="font-size: 25px;"><img src="/triangleView/img/member/idFind.png" style="width:50px; margin-top:-10px;">아이디 찾기</h2>
	</div>
	
	<div class="howToUse">
		<p id="howTo">회원가입 시 등록한 전화번호를 입력하시면<br><br>
아이디를 확인 할 수 있는 인증번호를 전송해드립니다.</p>
	</div>

	<div class="w3-container" id="phoneNum">
		<!-- <p>
			<span class="w3-tag w3-red">등록한 핸드폰 번호로 인증</span>
		</p> -->
		<div class="input-group" style="text-align: -webkit-center;">
		
			<input type="text" class="w3-input" id="personalnum" name="phone" placeholder="     전화번호를 입력해주세요" 
			 style="width: 300px; margin-left: 15px; border: 1px solid red;"onFocus="this.style.backgroundImage='url(none)';"> 
				<input type="submit" class="btn-success" id="sendVertify" value="인증번호 전송" onclick="change();"></input>
			<p id="p2" style="width: 100px; height: 20px; display:none; "></p>
		</div>
		<br>
			<script>
				function change(){
					
					$("#checkNum").css("display","block");
					$("#vertifyNum").css("display","block").css("align","center");
				}
			</script>
		<div class="input-group" id="changeNumberBlock" style="text-align: -webkit-center; display:none; height: 40px;">
			<input type="text" name="checkNum" id="checkNum" class="w3-input w3-change" 
			placeholder="인증번호를 입력해주세요" style="width: 240px; margin-left:-45px; display: none;">
			 <label id="pwdresult"></label><br> 
			 <input type="button" class="btn-success" name ="changePosi" id="vertifyNum" value="인증" style="display: none; margin-top: -20px;"><br>
		</div>
	</div>
	
	<br>
	<div id="field3" style="text-align:center; display:none;">
		<p id="p3" style="width: 350px; height:20px; display:none;"></p>
	</div>

	<script>
	<%-- location.href='<%=request.getContextPath()%>/findId.no?num='val() --%>
			
	$("#vertifyNum").click(function(){
			var phone = $("#personalnum").val();
			<%-- location.href="<%=request.getContextPath()%>/findId.no?phone="+ phone; --%>
			
			$.ajax({
				url : "findId.no",
				type : "post",
				data : {
					phone : phone
				},
				success : function(data) {
				/* 	$("#p3").text(data);
					var num = data;
					var resultText = "아이디 : " + num;
					alert(resultText);
					$("#p4").val(resultText).css("color", "red").css("font-size","20px"); */
					 
					 $("#p3").text("아이디 : " + data).css("color", "red").css("font-size","20px").css("text-align","center"); 
				},
				error : function() {
					console.log("실패!");
				}
			});
		});


		$("#sendVertify").click(function() {

			var phone = $("#personalnum").val();
			$("#changeNumberBlock").css("display","block");
			$.ajax({
				url : "snscheck.sns",
				type : "post",
				data : {
					phone : phone
				},
				success : function(data) {
					$("#p2").text(data);
					var num = data;
					
				},
				error : function() {
					console.log("실패!");
				}

			});

		});

		$("#vertifyNum").click(function(event) {
			event.preventDefault();
			var num2 = $("#checkNum").val() * 1;
			var num1 = $("#p2").text() * 1;

			if ($("#p2").text() != num2) {
				$("#pwdresult").text("인증번호가 일치하지 않습니다").css("color", "red");
/* 				$('#findId').attr("disabled", true);
				$("#findId").css("display","none"); */
				$("#cancel").css("display","none");
			} else {
				$("#pwdresult").text("인증번호가 일치합니다").css("color", "green");
	/* 			$('#findId').attr("disabled", false);
				$("#findId").css("display","block"); */
				$("#cancel").css("display","block");	
				$("#field3").css("display","block");
				$("#p3").css("display","block");
			}

		});
	</script>


	<script>
		function end() {
			document.getElementById('insertMemberTypeArea').style.display = 'none';
			document.getElementById('insertMemberTypeAearArea').style.display = 'none';
		}
	</script>


</div>
</body>
</html>