<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Member loginUser = (Member)session.getAttribute("loginUser");
    String[] address = loginUser.getAddress().split("-");
    
    
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>
<script src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<style>

span {
	display: inline-block;
}

/* div {
	display: inline-block;
} */


.containProfile {
	display: inline-block;
    width: 1275px;
    height: 1000px;
	text-align: left;
	margin-left: 150px;
	font-size: 13px;
	
}

.profileImage {
	margin: 20px 0 0;
	display: -webkit-inline-box;
}

.changeForm {
	width: 1000px;
	height: 1000px;
	font-size: 2em;
	font-family: '맑은고딕';
}

.imageSpan {
	background-color: white;
	color: black;
}

.profileOut {
	width: 200px;
	height: 200px;
	border-radius: 200px;
	margin-left: -345px;
}

.nickName {
	margin-top: 10px;
}

.phoneNumber {
	width: 500px;
	margin-top: 20px;
}

.btn-success {
	background-color: #f8585b;
	border: none;
	color: #FDEBEC;
	text-align: center;
	text-decoration: none;
	cursor: pointer;
	border-radius: 5px;
	width: 150px;
}
</style>
</head>

<body>
<div class = "containProfile">
<form class="changeForm" id="form" name="profileUpdate" action="" method="post" encType="multipart/form-data">

			<input type="hidden" value="<%=loginUser.getUserNo()%>" name="userNo">
         <div class="profileImage" style="display: inline-block; width:800px;">
               <span class="imageSpan">프로필 이미지</span> 
               <input type='file' id="imgInput" name="imgInput" accept="image/gif, image/jpeg, image/png" style="visibility: hidden;" /> 
               <label for="imgInput" class="ico_test1" id="icon_test1">
               <img class="profileOut" id="image_section" src="<%=request.getContextPath()%>/thumbnail_upload/<%=loginUser.getThumbnail() %>"  />
               </label>
         </div>
       

         <div class="nickName" id="nickname" style="display: inline-block; width: 800px;">
           	<span class="showNick" style="background-color: white; color:black;">닉네임</span>
               <input type="text" class="" id="nick" name="nick" style="width:500px;" value="<%=loginUser.getNick()%>"> 
			<input type="button" class="btn-success" id="nickCheck" value="중복검사" ></input>
               <br><label id="nickResult"></label>
         </div>

			<div class="" style= "display: inline-block; width: 800px;" >
					<span class="" style="background-color: white; color:black;">핸드폰</span>
				<div style="text-align: center; display: inline-block;">
					<input type="text" class="phoneNumber" id="phone" name="phone" value="<%=loginUser.getPhone()%>" placeholder="번호를 입력해주세요" maxlength="11" >
				</div>
			</div>
			
         <div class="" style="display: inline-block; width: 800px;">
               <span class="" style="background-color: white; color:black;">나이</span>
            <div style="text-align: center; display: inline-block;">
               <input type="text" class="" id="age" value="<%=loginUser.getPhone()%>"
               name="age" placeholder="만 나이를 입력해주세요" style="width:500px; margin-top: 20px; margin-left:26px;" maxlength="3">
            </div>
         </div>

             <div class="" style="margin-top: 20px; display: inline-block; width: 800px;">
            <span class="" style="background-color: white; color:black; margin-top: -20px;">주소</span>
            <input type="button" onclick="sample4_execDaumPostcode()" 
               value="우편번호 찾기" class="btn-success" style="width: 120px; margin-left: 12px;">

            <input type="text" id="sample4_postcode" placeholder="우편번호" value="<%=loginUser.getPostNo()%>"
            class="" name="sample4_postcode" style="width:800px;     margin-top: 10px;">
             
            <input type="text" id="sample4_roadAddress" placeholder="도로명주소" class="" name="sample4_roadAddress" value="<%=address[0]%>"
            style=" margin-top: 5px; width:800px; "> 
            <input type="text" id="sample4_jibunAddress" placeholder="지번주소" class="" name="sample4_jibunAddress"
            value="<%=address[1]%>" style="margin-top:7px; width:800px; "> 
            <br><span id="guide" style="color: #999"></span><br/>
         </div>


<!--          <div class="" style="margin-top: 10px; height:40px; display: inline-block;">
               <span class="" style="background-color: white; color:black;">관심사</span>
            <input type="checkbox" class="" name="category" value="1">자유
            <input type="checkbox" class="" name="category" value="2">IT/가전
            <input type="checkbox" class="" name="category" value="3">음악
            <input type="checkbox" class="" name="category" value="4">뷰티 
            <input type="checkbox" class="" name="category" value="5">스포츠&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="checkbox" class="" name="category" value="6">금융 
            <input type="checkbox" class="" name="category" value="7">게임
            <input type="checkbox" class="" name="category" value="8">취미 
            <input type="checkbox" class="" name="category" value="9">인생 
            
         </div> -->

         <div class="" style="margin-top:30px; display: inline-block; width:800px;">
               <span class="" style="background-color: white; color:black;margin-top: -20px; ">자기소개</span>
            <textarea id="intro" rows="5" style="width: 800px; height:140px; resize: none;" name="intro"><%=loginUser.getIntro()%></textarea>
            <!-- <span id="text_counter"></span> -->
         </div>
         

 			<div class="" style="text-align: center; height: 40px; margin-top: 10px; display: inline-block; width: 800px;">
            <input type="button" class="btn-success" id="updateMember" value="제출" disabled="disabled" onclick="youHaveTo()"></input>
			<input type="reset" class="btn-success" onclick="end();" value="취소"></input>
         </div>
        </div>

<script>

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

						$("#nickResult").text("사용가능한 닉네임입니다.").css("color","green");
						$('#updateMember').attr("disabled", false);
					} else {
						var test = $("#nick").val();
						var test1 = "<%=loginUser.getNick()%>";
						if(test == test1){
							$("#nickResult").text("같은 닉네임을 사용합니다.").css("color","green");
							$('#updateMember').attr("disabled", false);
						}else{
						$("#nickResult").text("중복되는 닉네임입니다.").css("color","red");
						$('#updateMember').attr("disabled", true);							
						}
					}
				},
				error : function() {
					console.log("서버 전송 실패");
				}

			});

		});
		
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

function sample4_execDaumPostcode() {

	daum.postcode.load(function() {
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
									extraRoadAddr = ' (' + extraRoadAddr
											+ ')';
								}
								// 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
								if (fullRoadAddr !== '') {
									fullRoadAddr += extraRoadAddr;
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								document.getElementById('sample4_postcode').value = data.zonecode; //5자리 새우편번호 사용
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

function youHaveTo(){
	
	theForm = document.profileUpdate;
	if(theForm.nick.value==""){
        alert("닉네임을 입력하지 않았습니다.")
        theForm.nick.focus();
        return false;
	} else if(theForm.phone.value==""){
        alert("핸드폰번호를 입력하지 않았습니다.")
        theForm.phone.focus();
        return false;
	} else if(theForm.age.value==""){
        alert("나이를 입력하지 않았습니다.")
        theForm.age.focus();
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
		form.action = "<%=request.getContextPath() %>/updateMember.me"; 
		form.submit();
	}
}

function end(){
	location.href="/triangleView/myHome";
	
}
</script>
</form>
</body>
</html>