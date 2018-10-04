<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>findPass</title>

	<!-- w3 혁동 밤길조심해... -->
	<link rel="stylesheet" href="/triangleView/css/w3.css" media="screen" title="no title" charset="utf-8">
    <!-- font awesome -->
    <link rel="stylesheet" href="/triangleView/css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="/triangleView/css/style.css" media="screen" title="no title" charset="utf-8">
    
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    
<script
   src="https://code.jquery.com/color/jquery.color-2.1.2.js"
   integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
   crossorigin="anonymous">
</script>
    <!-- CSS -->
<style>

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
	margin-left: -10px;
	text-align: center;
}

#howTo{
    font-size: 14px;
    margin-left: 10px;
}

#personMail{
	background-image: url(/triangleView/img/member/email.png);
    background-position: 5px 8px;
    background-size: 40px;
    background-repeat: no-repeat;
    height: 10px;
}

#checkNum{
    width: 300px;
    margin-left: 15px;
    border: 1px solid red;
}

#checkNum:focus {
    outline: none;
}

#personMail:focus{
	outline: none;
}

#sendVertify{
	width: 318px;
    height: 30px;
    margin-left: 15px;
    border-radius:0px;
}

#vertifyNum{
    display: block;
    position: absolute;
	left: 290px;
    top: 266px;
    width: 70px;
    height: 38px;
}
</style>
</head>
<body>
	<div class="page-header" style="text-align:center; display: block;  margin-top: 20px;">
		<h2 style="font-size: 25px;"><img src="/triangleView/img/member/passFind.png" style="width:45px; margin-top:-10px">비밀번호 찾기</h2>
	</div>
	
	<div class="howToUse">
		<p id="howTo">회원가입 시 등록한 이메일 주소를 입력하시면<br><br>
			비밀번호를 재설정 할 수 있는 인증번호를 전송해드립니다.</p>
	</div>

	<div class="input-group" style="text-align: -webkit-center;">
		
			<input type="text" class="w3-input w3-change" id="personMail" name="email" placeholder="           이메일을 입력해주세요" 
			 style="width: 300px; margin-left: 15px; border: 1px solid red; height:25px;"onFocus="this.style.backgroundImage='url(none)';"> 
				<input type="submit" class="btn-success" id="sendVertify" value="인증번호 전송" onclick="change();"></input>
			<p id="p2" style="width: 100px; height: 20px; display:none;"></p>
		</div>
		<br>
		
		<script>
				function change(){
					$("#checkNum").css("display","block");
					$("#vertifyNum").css("display","block").css("align","center");
				}
		</script>
		
		<div class="input-group" id="changePassBlock" style="text-align: -webkit-center; display: none;">
			<input type="text" name="checkNum" id="checkNum" class="w3-input w3-change" 
			placeholder="인증번호를 입력해주세요" style="width:230px; margin-left:-55px; display:none;">
			 <label id="pwdresult"></label><br> 
			 <input type="button" class="btn-success" id="vertifyNum" value="인증" style="display: none; margin-top: -33px;"><br>
		</div>

	<div id="field3" style="text-align:center; display:none;">
		<p id="p3" style="width: 350px; height:20px; display:none;"></p>
	</div>

			<script>
				//이메일인증
				$("#sendVertify").click(function(){
					var id = $("#personMail").val();
					$("#changePassBlock").css("display","block");
					
					$.ajax({
						url : "sendPass.no",
						type : "post",
						data : {
							id : id
						},
						success : function(data) {
							console.log("성고오오오오옹!");
							$("#p2").text(data);
							var num = data;
							
						},
						error : function() {
							console.log("실패ㅠㅠ");
						}

					});
				});


				$("#vertifyNum").click(function(event) {
					event.preventDefault();
					var num2 = $("#checkNum").val() * 1;
					var num1 = $("#p2").text() * 1;

					if ($("#p2").text() != num2) {
						$("#pwdresult").text("인증번호가 일치하지 않습니다").css("color", "red");
					} else {
						$("#pwdresult").text("임시 비밀번호를 메일로 전송합니다.").css("color", "green");
						$("#p3").css("display","block");
						var id = $("#personMail").val();

						$.ajax({
							url : "sendNewPass.no",
							type : "post",
							data : {
								id : id
							},
							success : function(data) {
								console.log("성고오오오오옹!");
								$("#p3").text(data);
								var num = data;
								
							},
							error : function() {
								console.log("실패ㅠㅠ");
							}

						});
					}

				});
			</script>
			<!-- <button type="submit" class="subButton" onclick="javascript:window.close()">취소 </button> -->


</body>
</html>