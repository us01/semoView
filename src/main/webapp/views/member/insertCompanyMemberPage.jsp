<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CompanyUser</title>
<!-- w3 혁동 밤길조심해... -->
<link rel="stylesheet" href="/triangleView/css/w3.css" media="screen" title="no title" charset="utf-8">
<link rel="stylesheet" href="/triangleView/css/font-awesome.min.css" media="screen" title="no title" charset="utf-8">
<link rel="stylesheet" href="/triangleView/css/style.css" media="screen" title="no title" charset="utf-8">

<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
body {
	margin: 0px;
	/* background: #fafafa; */
	font-family: '맑은고딕';
}
.everyThing1 {
	width: 1000px;
	margin: 0 auto;
	border:1px solid black;
	position: relative;
}

p{
    float: left;
}
.JoinForm{
	text-align:center;
	margin: 0 auto;
}

.subButton {
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
}

.btn-success {
	
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
	width: 70px;
    height: 40px;
}



.w3-change {
	display: inline-block;
	width: 300px;
}



.JoinForm {
	background: white;
	width: 550px;
}

#imgInput {
	width: 150px;
	height: 100px;
	display: visible;
	margin-top: 54px;
}

.ico_test1 {
	background: url(/triangleView/img/member/profile.png) 0 20 no-repeat;
	background-size: 100px;
	width: 74px;
	height: 90px;
	display: inline-block;
	position: absolute;
	top: 0;
	left: 230px;
	border: 1px solid;
}

#icon_test1 {
	border: 1px solid white;
	width: 151px;
	height: 151px;
	margin-top: 70px;
}

#sendVertify{
	margin-left: 350px;
    margin-top: -25px;
}

#vertifyNum{
	display: block;
    margin-top: -25px;
    margin-left: 360px;
}

#nickCheck{
	margin-left: 360px;
    margin-top: -30px;
    display: block;
}

.w3-tag{
    position: absolute;
    margin-top: 10px;
    background-color: white;
    color: black;
}


</style>

</head>
<body>
<jsp:include page="../main/header/headerNav.jsp" flush="true" />
<br>
<br>
<br>
<div class="everyThing1">

   <form class="JoinForm" id="form" name="testGo" action="" method="post" encType="multipart/form-data" >

      <div id="container" class="w3-container">
         <div class="page-header">
            <h2 style="text-align:center;"><img src="/triangleView/img/member/reviewer.png" style="width:80px; margin-top: -15px;">기업회원가입</h2>
         </div>

         <div class="profileImage" style="align:center; ">
            <p style="text-align: -webkit-left;">
               <span class="tag" style="margin-left:3px;background-color: white; color: black; margin-top: 57px;">프로필 이미지</span> 
               <input type='file' id="imgInput" name="imgInput" accept="image/gif, image/jpeg, image/png" style="margin-left: 220px; visibility: hidden;" /> 
               <label for="imgInput" class="ico_test1" id="icon_test1">
               <img id="image_section" src="/triangleView/img/member/profile.png" width="150px" height="150px" alt="이미지 파일이 아닙니다." class="w3-circle"
               style="position: absolute; left: 50%; margin-left: 135px;" />
               </label>
            </p>
         </div>

         <div class="w3-container w3-form" id="mail1">
            <p>
            <span class="tag" style="background-color: white; color:black; margin-top:20px; margin-left:-10px">아이디(이메일)</span></p>
            <div class="input-group" style="text-align: center;">
               <input type="email" class="w3-input w3-change myInt" id="userId" name="userId"
                  placeholder="아이디(이메일형식)" style="width:270px; margin-left: -50px; display: inline-block; margin-top: 3px;"> <span class="input-group-btn">
			<input type="button" class="btn-success" id="sendVertify" value="전송" style="margin-top: -35px;margin-right: -26px;"></input>
               </span>
               
                <p id="p2" style="width: 100px; height: 20px; /* display:none; */">
                
            </div>
         </div>

         <div class="w3-container" id="mail2">
            <p><span class="tag" style="background-color: white; color:black; margin-top:20px; margin-left:-10px">인증번호입력</span></p>
            <div class="input-group" style="text-align: center;">
               <input type="text" id="checkNum" class="w3-input w3-change" placeholder="인증번호"
               style="width:270px; margin-left: -50px; margin-top: 3px; display: inline-block;">
		<input type="button" class="btn-success" id="vertifyNum" value="인증" style="margin-top: -44px; margin-right: -26px; display: inline-block;"></input>
		<br><label id="checkVerify"></label>
              
            </div>
         </div>

		<div class="w3-container">
				<p>
					<span class="tag" style="background-color: white; color:black;margin-top: 20px; margin-left:-10px">기업이름</span>
				</p>
				<div style="text-align: center; width:600px;">
					<input type="text" class="w3-input w3-change" id="copName" name="copName"
						placeholder="기업이름을 입력해 주세요"  style="width:270px; margin-left: -136px; margin-top: 3px; display: inline-block;">
				</div>
			</div>

			<div class="w3-container">
				<p>
					<span class="tag" style="background-color: white; color:black;margin-top: 20px; margin-left:-10px">담당자이름</span>
				</p>
				<div style="text-align: center; width:600px;">
					<input type="text" class="w3-input w3-change" id="personName" name="personName"
						placeholder="담당자이름을 입력해 주세요"  style="width:270px; margin-left: -155px; margin-top: 3px; display: inline-block;">
				</div>
			</div>

         <div class="w3-container" id="nickname">
            <p><span class="tag" style="background-color: white; color:black;margin-top: 20px; margin-left:-10px">닉네임</span></p>
            <div class="input-group" style="text-align: center; width:600px;">
               <input type="text" class="w3-input w3-change" id="nick" name="nick" 
                  placeholder="닉네임을 입력해 주세요" style="width:270px; margin-left: -126px; margin-top: 3px; display: inline-block;"> 
			<input type="button" class="btn-success" id="nickCheck" value="중복검사" style="margin-top: -36px; margin-left: 441px;"></input>
               <label id="nickResult"></label>
            </div>
         </div>


         <div class="w3-container">
            <p><span class="tag" style="background-color: white; color:black;margin-top: 20px; margin-left: -10px;">비밀번호</span></p>
            <div style="text-align: center;">
               <input type="password" class="w3-input w3-change" 
               id="userPwd" name="userPwd" placeholder="비밀번호" style="width:270px; display: inline-block; margin-left: -27px;">
            </div>
         </div>

         <div class="w3-container" style="display:inline-block;">
            <p><span class="tag" style="background-color: white; color:black; margin-left: -102px; display: inline-block;">비밀번호확인</span></p>
            <div style="text-align: center;">
               <input type="password" class="w3-input w3-change" name="userPwdCheck" id="userPwdCheck" placeholder="비밀번호 확인" style="margin-top: 2px; margin-left: 26px; display: inline-block; width:270px;">
               <br><label id="pwdresult"></label>
            </div>
         </div>

		<div class="w3-container">
				<p>
				<span class="tag" style="background-color: white; color:black;margin-top: 20px; margin-left:-10px">사업자번호</span>
				</p>
				<div style="text-align: center; width:600px;">
					<input type="text" class="w3-input w3-change" id="businessNo"
						name="businessNo" placeholder="사업자등록번호를 입력해주세요"
						style="width:270px; margin-left: -46px; margin-top: 3px; display: inline-block;" maxlength="10">
					<input type="button" class="btn-success" id="checkCompany" value="번호검사" style="margin-top: -36px; margin-left: 43px;" onclick="onopen();" ></input>
				</div>
			</div>

			<div class="w3-container">
				<p>
					<span class="tag" style="background-color: white; color:black; margin-left: -10px; display: inline-block;">담당자번호</span>
				</p>
				<div style="text-align: center;">
					<input type="text" class="w3-input w3-change" id="phone" name="phone"
						placeholder="담당자전화번호를 입력해주세요" style="margin-top: 2px; margin-left: -48px; display: inline-block; width:270px;" maxlength="11">
				</div>
			</div>
			

             <div class="w3-container" style="margin-top: 20px;">
            <p><span class="tag" style="background-color: white; color:black; margin-top: -20px;     margin-left: -8px;">주소</span></p>
            <input type="button" onclick="sample4_execDaumPostcode()" 
               value="우편번호 찾기" class="btn-success" style="width: 120px; margin-left: -300px;">
            
            <br> 
            <input type="text" id="sample4_postcode" placeholder="우편번호" 
            class="w3-input w3-change" name="sample4_postcode" style="width:300px; display: inline-block; margin-left: -186px;">
            <br> 
            <input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="w3-input w3-change" name="sample4_roadAddress"> 
            <input type="text" id="sample4_jibunAddress" placeholder="지번주소" class="w3-input w3-change" name="sample4_jibunAddress"> 
            <br><span id="guide" style="color: #999"></span><br/>
         </div>


         <div class="w3-container">
            <p>
               <span class="tag" style="background-color: white; color:black; margin-top: -30px; margin-left: -5px;">관심사</span>
            </p>
            <input type="checkbox" class="w3-check" name="category" value="1">자유
            <input type="checkbox" class="w3-check" name="category" value="2">IT/가전
            <input type="checkbox" class="w3-check" name="category" value="3">음악
            <input type="checkbox" class="w3-check" name="category" value="4">뷰티 
            <input type="checkbox" class="w3-check" name="category" value="5">스포츠
            <br>
            <input type="checkbox" class="w3-check" name="category" value="6" style="margin-left: -78px;">금융 
            <input type="checkbox" class="w3-check" name="category" value="7">게임
            <input type="checkbox" class="w3-check" name="category" value="8" style="margin-left: 18px;">취미 
            <input type="checkbox" class="w3-check" name="category" value="9">인생 
           
         </div>

         <div class="w3-container" style="margin-top: 20px;">
            <p>
               <span class="tag" style="background-color: white; color:black;margin-top: -25px; margin-left: -5px;">자기소개</span>
            </p>
            <textarea id="intro" rows="5" style="width: 490px; resize: none;" name="intro" ></textarea>
            <!-- <span id="text_counter"></span> -->
         </div>

         <div class="w3-container" style="text-align: center; height: 80px; margin-top: 20px;">
            <input type="button" class="subButton" id="newMember" value="기업회원가입" disabled="disabled" onclick="youHaveTo()" style="height:30px;"></input>
			<input type="reset" class="subButton" onclick="end();" value="가입취소" style=" height:30px;   margin-left: 20px;"></input>
         </div>
        

		</div>
   </form>
   </div>

	<script>
			//가입취소버튼
				function end() {
					location.href="/triangleView/";
				}
				
			//아이디 체크
				$("#sendVertify").click(function(){
					var id = $("#userId").val();
					
					$.ajax({
						url : "/triangleView/sendVerify.no",
						type : "post",
						data : {
							id : id
						},
						success : function(data) {
							console.log("성고오오오오옹!");
							if(data== 0){
							alert("중복된 이메일로 계정이 존재합니다. 다른 이메일을 입력해주세요 ");
							
							}else{
							$("#p2").text(data);
							var num = data;
							}
						},
						error : function() {
							console.log("실패ㅠㅠ");
						}

					});
				});
				
				//인증번호 확인
				$("#vertifyNum").click(function(event) {
					event.preventDefault();
					var num2 = $("#checkNum").val() * 1;
					var num1 = $("#p2").text() * 1;
		

					if ($("#p2").text() != num2) {
						$("#checkVerify").text("인증번호가 일치하지 않습니다").css("color", "red");
						$('#newMember').attr("disabled", true);
					} else {
						$("#checkVerify").text("인증번호가 일치합니다").css("color", "green");
						$('#newMember').attr("disabled", false);
					}

				});

				//null값이 있을때 회원가입취소
			function youHaveTo(){
					theForm = document.testGo;
					if(theForm.userId.value==""){
			            alert("아이디를 입력하지 않았습니다.")
			            theForm.userId.focus();
			            return false;
					} else if(theForm.copName.value==""){
			            alert("기업이름을 입력하지 않았습니다.")
			            theForm.copName.focus();
			            return false;
					} else if(theForm.personName.value==""){
			            alert("담당자이름을 입력하지 않았습니다.")
			            theForm.personName.focus();
			            return false;
					} else if(theForm.nick.value==""){
			            alert("닉네임을 입력하지 않았습니다.")
			            theForm.nick.focus();
			            return false;
					} else if(theForm.userPwd.value==""){
			            alert("비밀번호를 입력하지 않았습니다.")
			            theForm.userPwd.focus();
			            return false;
			        }else if(theForm.businessNo.value==""){
				        alert("사업자등록번호를 입력하지 않았습니다.")
				        theForm.businessNo.focus();
				        return false;
				    }else if(theForm.phone.value==""){
			            alert("전화번호를 입력하지 않았습니다.")
			            theForm.phone.focus();
			            return false;
					} else if(theForm.sample4_postcode.value==""){
				        alert("우편번호를 입력하지 않았습니다.")
				        theForm.sample4_postcode.focus();
				        return false;
					} else if(theForm.sample4_roadAddress.value==""){
				        alert("도로명을 입력하지 않았습니다.")
				        theForm.sample4_roadAddress.focus();
				        return false;
					} else if(theForm.sample4_jibunAddress.value==""){
				        alert("지번주소를 입력하지 않았습니다.")
				        theForm.sample4_jibunAddress.focus();
				        return false;
					} else{
						var form = document.getElementById("form");
						form.action = "<%=request.getContextPath() %>/insertCompanyMember.me";
						form.submit();
					}
				}

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#image_section').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#imgInput").change(function() {
			readURL(this);
		});

		//비밀번호체크
		$("#userPwdCheck").change(function() {
			if ($("#userPwd").val() != $(this).val()) {
				$("#pwdresult").html("비밀번호가 일치하지 않습니다").css("color", "red");
				$("#userPwdCheck").val('');
				$(this).select();
				$('#newMember').attr("disabled", true);
			} else {
				$("#pwdresult").html("비밀번호가 일치합니다").css("color", "green");
				$('#newMember').attr("disabled", false);
			}
		})

		//나이는 숫자값만 입력
		$(document).ready(function() {
			$("#age").keyup(function() {
				$(this).val($(this).val().replace(/[^0-9]/g, ""));
			});

		});

		//핸드폰번호는 숫자값만
		$(document).ready(function() {
			$("#phone").keyup(function() {
				$(this).val($(this).val().replace(/[^0-9]/g, ""));
			});

		});

		//성별은 하나만 체크가능하게
		function doOpenCheck(chk) {
			var obj = document.getElementsByName("gender");
			for (var i = 0; i < obj.length; i++) {
				if (obj[i] != chk) {
					obj[i].checked = false;
				}
			}
		}

		function sample4_execDaumPostcode() {

			daum.postcode
					.load(function() {
						new daum.Postcode(
								{
									oncomplete : function(data) {
										// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

										// 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
										// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
										var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
										var extraRoadAddr = ''; // 도로명 조합형 주소 변수

										// 법정동명이 있을 경우 추가한다. (법정리는 제외)
										// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
										if (data.bname !== ''
												&& /[동|로|가]$/g.test(data.bname)) {
											extraRoadAddr += data.bname;
										}
										// 건물명이 있고, 공동주택일 경우 추가한다.
										if (data.buildingName !== ''
												&& data.apartment === 'Y') {
											extraRoadAddr += (extraRoadAddr !== '' ? ', '
													+ data.buildingName
													: data.buildingName);
										}
										// 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
										if (extraRoadAddr !== '') {
											extraRoadAddr = ' ('
													+ extraRoadAddr + ')';
										}
										// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
										if (fullRoadAddr !== '') {
											fullRoadAddr += extraRoadAddr;
										}

										// 우편번호와 주소 정보를 해당 필드에 넣는다.
										document
												.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
										document
												.getElementById('sample4_roadAddress').value = fullRoadAddr;
										document
												.getElementById('sample4_jibunAddress').value = data.jibunAddress;

										// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
										if (data.autoRoadAddress) {
											//예상되는 도로명 주소에 조합형 주소를 추가한다.
											var expRoadAddr = data.autoRoadAddress
													+ extraRoadAddr;
											document.getElementById('guide').innerHTML = '(예상 도로명 주소 : '
													+ expRoadAddr + ')';

										} else if (data.autoJibunAddress) {
											var expJibunAddr = data.autoJibunAddress;
											document.getElementById('guide').innerHTML = '(예상 지번 주소 : '
													+ expJibunAddr + ')';

										} else {
											document.getElementById('guide').innerHTML = '';
										}
									}
								}).open();
					});

		}

		//intro 작성글자수
		$(document).ready(function() {
			var left = 140
			$('#text_counter').text('작성할 수 있는 글자수: ' + left);

			$('#intro').keyup(function() {

				left = 140 - $(this).val().length;

				if (left < 0) {
					$('#text_counter').addClass("overlimit");
					$('#newMember').attr("disabled", true);
					alert("글자수 초과입니다. 수정해주세요.");
				} else {
					$('#text_counter').removeClass("overlimit");
					$('#newMember').attr("disabled", false);
				}

				$('#text_counter').text('작성할 수 있는 글자수: ' + left);
			});
		});

			//사업자등록번호는 숫자만 입력받게
	$(document).ready(function() {
		$("#businessNo").keyup(function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});

	});

	//사업자등록번호체크
	function onopen()
	{
		var biz = $("#businessNo").val();
		var bizID= biz.toString();
		var checkID = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5, 1);
		var tmpBizID, i, chkSum = 0, c2, remander;
		bizID = bizID.replace(/-/gi, '');

		for (i = 0; i <= 7; i++)
			chkSum += checkID[i] * bizID.charAt(i);
			
		c2 = "0" + (checkID[8] * bizID.charAt(8));
		c2 = c2.substring(c2.length - 2, c2.length);
		chkSum += Math.floor(c2.charAt(0)) + Math.floor(c2.charAt(1));
		remander = (10 - (chkSum % 10)) % 10;

		if (Math.floor(bizID.charAt(9)) == remander){
			alert('인증되었습니다.회원가입을 진행해주세요.');
			$('#newMember').attr("disabled", false);

			//110111006243
			//1108141272
			//8642700283
		}else{
			alert('사업자등록번호 오류입니다. 다시 입력해주세요.')
			$('#newMember').attr("disabled", true);
		}

	}

		//왜안되
		$("#nickCheck").click(
				function() {
					var nick = $("#nick").val();
					$.ajax({

						url : "/triangleView/nickCheck.do",
						data : {
							nick : nick
						},
						type : "post",
						success : function(data) {
							var num = data;
							if (num == 0) {
								$("#nickResult").text("사용가능한 닉네임입니다.").css(
										"color", "green");
								$('#newMember').attr("disabled", false);
							} else {

								$("#nickResult").text("중복되는 닉네임입니다.").css(
										"color", "red");
								$('#newMember').attr("disabled", true);
							}
						},
						error : function() {
							console.log("서버 전송 실패");
						}

					});

				});
	</script>
</body>
</html>