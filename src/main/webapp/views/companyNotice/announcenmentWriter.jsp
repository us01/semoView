<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<title>Insert title here</title>
<style>
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
	margin-top: 70px;
	width: 100%;
}

.writerBox {
	width: 1000px;
	margin-top: 100px;
	margin: 0 auto;
}

.noticeForm {
	margin: 0 auto;
	width: 600px;
	height: 1000px;
} 

.mainbox {
	color: #f7323f;
}

.noticeTable {
	width: 950px;
    margin-top: 47px;
    margin-left: -190px;
    margin-bottom: 50px;
    border: solid 1px gray;
}

#writer {
	font-weight: bold;
	width: 100px;
	height: 50px;
	position: relative;
	left: 20px;
}

#noticeTitle {
	width: 760px;
    margin-left: -110px;
}

#serchCategory {
	margin-left: 71px;
    width: 178px;
    margin-right: 50px;
    font-weight: 100;
}

#productArea {
	width: 170px;
    margin-left: 20px;
    margin-right: 40px;
    font-weight: 100;
}

#deadlinePerson {
	width: 170px;
    margin-left: 20px;
    font-weight: 100;
}

#productName {
	width: 760px;
    margin-left: -110px;
}

#offerProduct {
	width: 760px;
    margin-left: -110px;
}

#caution {
	width: 760px;
    margin-left: -110px;
}

#noticeStartDate {
	margin-left: 69px;
    width: 239px;
}

#noticeEndDate {
	width: 239px;
    margin-left: 203px;
}

#contentImg1 {
    position: relative;
    bottom: 20px;
    left: -24px;
}

.noticeEnd {
	margin: 0;
    display: inline-block;
    position: relative;
    left: 160px;
}

#noticeContent {
	width: 770px;
    margin-left: -120px;
}

#File1 {
	position: relative;
	left: 200px;
	visibility: hidden;
}

#File {
	position: relative;
    left: 100px;
    visibility: hidden;
}

.mainImgP {
	margin: 0;
    display: inline-block;
    position: relative;
    left: 153px;
}

.mainWriter {
	position: relative;
    width: 300px;
}

#titleImgArea {
	width: 350px;
	height: 200px;
	border: 2px dashed darkgray;
	text-align: center;
	display: table-cell;
	vertical-align: middle;
}

#contentImgArea1 {
	width: 120px;
    height: 100px;
    text-align: center;
    display: table-cell;
    vertical-align: middle;
    position: relative;
    left: 170px;
}

#contentImgArea2 {
	width: 120px;
    height: 100px;
    text-align: center;
    display: table-cell;
    vertical-align: middle;
    position: relative;
    left: 510px;
}
#btn {
    color: white;
    width: 340px;
    height: 30px;
    background: #ec4a55;
    margin-left: 113px;
    margin-right: -22px;
    border-radius: 8px;
}
.mainWriter{
	height: 50px;
    font-size: 26px;
    color: #ec4a55;
    font-weight: bold;
}
#contentImg2{
	margin-left: -100px;
    position: relative;
    bottom: 23px;
    right: 14px;
}
</style>
<script>
	//막기
	function check() {
		if ($("#serchCategory").val() == "------") {
			alert("카테고리 입력해주세요!");
			return false;
		} else if ($("#serchCategory").val() == "") {
			alert("카테고리를 입력해주세요!");
			return false;
		} else if ($("#noticeTitle").val() == "") {
			alert("제목을 다시 입력해주세요!");
			$("#noticeTitle").focus();
			return false;
		} else if ($("#productName").val() == "") {
			alert("상품명을 다시 입력해주세요!");
			$("#productName").focus();
			return false;
		} else if ($("#offerProduct").val() == "") {
			alert("제공상품명을 다시 입력해주세요!");
			$("#offerProduct").focus();
			return false;
		} else if ($("#productArea").val() == "") {
			alert("지역을 다시 입력해주세요!");
			$("#productArea").focus();
			return false;
		} else if ($("#caution").val() == "") {
			alert("주의사항 다시입력!");
			$("#caution").focus();
			return false;
		} else if ($("#deadlinePerson").val() == "") {
			alert("제한인원 다시 입력!");
			$("#deadlinePerson").focus();
			return false;
		} else if ($("#noticeStartDate").val() == "") {
			alert("공고시작 일짜를 입력해주세요!");
			return false;
		} else if ($("#noticeStartDate").val() > $("#noticeEndDate").val()) {
			alert("공고 날짜가 잘못되었습니다.");
			return false;
		} else if ($("#File").val() == "") {
			alert("제목 파일을 넣어주세요!");
			return false;
		} else if ($("#File1").val() == "") {
			alert("본문 파일을 넣어주세요!");
			return false;
		} else if ($("#noticeContent").val() == "") {
			alert("내용 다시 작성해주세요!");
			return false;
		}
	}
	function backNotice(){
		location.href="<%=request.getContextPath() %>/noticeSelect";
	}
</script>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="body1">
		<div class="writerBox">
		<hr>
			<form class="noticeForm" id="notice" action="<%=request.getContextPath()%>/notice.vo"
				method="post" encType="multipart/form-data"
				onsubmit="return check()">
				<table class="noticeTable">
					<tr align="center">
						<td colspan="4"><div class="abc"><div class="mainBox"><p class="mainWriter">리뷰어 공고 캠페인 작성</p></div></div><hr></td>
					</tr>
					<tr>
					<tr>
						<td id="writer">제목</td>
						<td><input type="text" id="noticeTitle" name="noticeTitle"
							size="50" maxlength="100"></td>
					</tr>
					<tr>
						<td class="a" id="writer" colspan="3">카테고리 <select
							id="serchCategory" name="category">
								<option></option>
								<option value=1>자유</option>
								<option value=2>It/가전</option>
								<option value=3>뷰티</option>
								<option value=4>금융</option>
								<option value=5>스포츠</option>
								<option value=6>취미</option>
								<option value=7>게임</option>
								<option value=8>음악</option>
								<option value=9>인생</option>
						</select> 지역<input type="text" id="productArea" name="productArea"
							size="50" maxlength="50"> 제한인원<input type="number"
							id="deadlinePerson" name="deadlinePerson" min="1" max="100"></td>
					</tr>


					<tr>
						<td id="writer">상품명</td>
						<td><input type="text" id="productName" name="productName"
							size="50" maxlength="100"></td>
					</tr>
					<tr>
					<tr>
						<td id="writer">제공상품명</td>
						<td><input type="text" id="offerProduct" name="offerProduct"
							size="50" maxlength="100"></td>
					</tr>
					<tr>
						<td id="writer">주의사항</td>
						<td><input type="text" id="caution" name="caution" size="50"
							maxlength="50"></td>
					</tr>
					<tr>
						<td id="writer" colspan="2">공고시작 <input type="date"
							id="noticeStartDate" name="noticeStartDate">
							<p class="noticeEnd">공고마감</p> <input type="date"
							id="noticeEndDate" name="noticeEndDate"></td>
					</tr>


					<tr>
						<div id="fileArea">
						<td id="writer" colspan="2">썸네일 <input type="file" id="File"
							name="File" multiple="multiple" onchange="loadImg(this,1)">
							<p class="mainImgP">본문 이미지</p> <input type="file" id="File1"
							name="File1" multiple="multiple" onchange="loadImg(this,2)"></td>
						</div>
					</tr>
					<td>
						<div id="contentImgArea1">
							<img id="contentImg1" width="262px" height="260px"src="/triangleView/img/notice/imgplus.png">
						</div>
					</td>
					<td>
						<div id="contentImgArea2">
							<img id="contentImg2" width="262px" height="260px"src="/triangleView/img/notice/imgplus.png">
						</div>
					</td>

					<tr>
						<td id="writer">내용</td>
						<td><textarea type="textarea" id="noticeContent"
								name="noticeContent" cols="50" rows="13"></textarea></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="리뷰어 공고 작성" id="btn">
							<input id="btn" type=button value="돌아가기" onclick="backNotice();">
					</tr>
				</table>
			</form>
			<script>
					$(function(){
						$("#fileArea").hide();
						$("#contentImgArea1").click(function(){
							$("#File").click();
						})
						$("#contentImgArea2").click(function(){
							$("#File1").click();
						});
					});
					
					function loadImg(value, num){
						if(value.files && value.files[0]){
							var reader = new FileReader();
							reader.onload = function(e){
								/* $("#titleImg").attr("src", e.target.result); */
								switch(num){
									case 1 : $("#contentImg1").attr("src", e.target.result); break;
									case 2 : $("#contentImg2").attr("src", e.target.result); break;
								}
							}
							reader.readAsDataURL(value.files[0]);
						}
					};
				
				</script>
		</div>
	</div>
</body>
</html>