<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans"
	rel="stylesheet">
<!--구글 폰트  -->
<!--좋아요 버튼  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style>
body {
	margin: 0px;
	background: #fafafa;
	font-family: '맑은고딕';
}

.myHomeArea {
	margin: 0 auto;
	width: 1000px;
	text-align: left;
	margin-top: 10px;
}

@media all and (max-width:768px) {
	.myHomeArea {
		width: 100%;
	}
}

.body1 {
	width: 100%;
}

.mainform {
	width: 1000px;
	margin: 0 auto;
}

#joinImage { /*회원 사진 변경  */
	width: 100px;
	border-radius: 60%;
	margin: 0 auto;
	position: relative;
	top: 0px;
	right: -10px;
}

.body2 {
	width: 100%;
	margin: 0 auto;
}

form {
	width: 1000px;
	height: 63%;
	background: white;
	bottom: 0%;
	margin: 0 auto;
	background: white;
	bottom: 0%;
}

input {
	width: 800px;
}

#changebtn {
	background: red;
    border-radius: 5px;
    width: 80px;
    height: 25px;
    float: left;
}

#mainbtn {
	background: red;
    border-radius: 5px;
    width: 80px;
    height: 25px;
    text-align: center;
    float: left;
}

p {
	font-size: 28px;
	font-family: 'Black Han Sans', sans-serif;
	position: relative;
	color: gray;
	margin: 0;
	text-align: center;
}

img#mainlogo1 { /*로고  */
	width: 10%;
	height: 7%;
	position: fixed;
	top: 8%;
	right: 66%;
}
.btn.box {
    width: 1000px;
    margin-top: 40px;
}
</style>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="myHomeArea">
		<jsp:include page="./myHomeHeader.jsp" flush="true" />
	</div>
	<div id="information">
		<!--정보 수정 폼 div  -->
		<p id="id1">기업 정보 수정</p>
		<hr>
		<div class="body1">
			<div class="mainform">
				<img src="../../img/shin/기본이미지.jpg" id="joinImage">
				<!--이미지 변경  -->
			</div>
		</div>
		<div class="body2">
			<form>
				<hr>
				<label>비민번호 확인</label>
				<div>
					<input type="password" name="userPwd">
				</div>
				<br> <br> <label>비밀번호 변경</label>
				<div>
					<input type="password" name="userPwd">
				</div>
				<br> <br> <label>연락처 변경</label>
				<div>
					<input type="phone" name="phone">
				</div>
				<br> <br> <label>주소 변경</label>
				<div>
					<input type="text" name="buisnessmanNum">
				</div>
				<br> <br> <label>담당자 메일 변경</label>
				<div>
					<input type="email" name="email">
				</div>
				<br> <br> <label>자기 소개 변경</label>
				<div>
					<input type="text" name="AboutMe">
				</div>
				<div class="btn box">
					<div class="btn box1">
						<div class="btn" align="center">
							<div id="changebtn" onclick="">수정하기</div>
						</div>
						<div class="btn1" align="center">
							<div id="mainbtn" onclick="">돌아가기</div>
						</div>
					</div>
				</div>
			</form>

			<br>
		</div>
</body>
</html>