<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<Style>
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

.box { /*그래프 박스  */
	position: relative;
	top: 5%;
	margin: 0 auto;
	background: white;
	width: 1000px;
}

@media all and (max-width:965px) {
	#boxHeader1 {
		width: 200px;
	}
}
</Style>
<!--기업 리뷰 일반리뷰 테이블  -->
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #aaa;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 10px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #aaa;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 10px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #aaa;
	color: #fff;
	background-color: #f38630;
}

.tg .tg-fq1u {
	background-color: #f7323f;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-lbzb {
	background-color:#f7323f;
	text-align: center;
	vertical-align: top
}

.tg .tg-7uja {
	font-size: 18px;
	background-color: #efefef;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-7t59 {
	font-size: 18px;
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-13pz {
	font-size: 18px;
	text-align: center;
	vertical-align: top
}

.body1 {
	width: 100%;
}

.List {
	width: 1000px;
    margin: 0 auto;
}

p#id1 {
    font-size: 30px;
    color: gray;
    font-family: 'Black Han Sans', sans-serif;
    margin: 0 auto;
    position: relative;
    top: 40px;
    display: table;
}

img#mainlogo1 {
	width: 130px;
    margin-left: 250px;
}
</style>
</head>
<body>
	<%@ include file="../main/header/headerNav.jsp"%>
	<div class="myHomeArea">
		<jsp:include page="./myHomeHeader.jsp" flush="true" />
	</div>
	<div class="body2">
		<table class="tg"
			style="table-layout: fixed;width: 1000px;display: block;margin: 0 auto;">
			<div class="body1">
				<div class="List">
					<p id="id1">기업 리뷰 리스트</p>
					<img src="../../img//shin//logo1.png" id="mainlogo1">
				</div>
			</div>
			<colgroup>
				<col style="width: 181px">
				<col style="width: 281px">
				<col style="width: 181px">
				<col style="width: 181px">
				<col style="width: 181px">
			</colgroup>
			<tr>
				<th class="tg-fq1u">상품이름</th>
				<th class="tg-fq1u">리뷰</th>
				<th class="tg-fq1u">작성자</th>
				<th class="tg-fq1u">좋아요</th>
				<th class="tg-lbzb">조회수</th>
			</tr>
			<tr>
				<td class="tg-7uja">갤럭시s8</td>
				<td class="tg-7uja">갤럭시s8 좋아요</td>
				<td class="tg-7uja">A</td>
				<td class="tg-7uja">1100</td>
				<td class="tg-7t59">10000</td>
			</tr>
			<tr>
				<td class="tg-13pz">갤럭시s7</td>
				<td class="tg-13pz">갤럭시 s7 별로네요..</td>
				<td class="tg-13pz">B</td>
				<td class="tg-13pz">300</td>
				<td class="tg-13pz">10000</td>
			</tr>
			<tr>
				<td class="tg-7t59">갤럭시 노트6</td>
				<td class="tg-7t59">이건 꼭 사야해!</td>
				<td class="tg-7t59">C</td>
				<td class="tg-7t59">400</td>
				<td class="tg-7t59">10000</td>
			</tr>
			<tr>
				<td class="tg-13pz">갤럭시 a5</td>
				<td class="tg-13pz">가성비 좋아요</td>
				<td class="tg-13pz">D</td>
				<td class="tg-13pz">700</td>
				<td class="tg-13pz">10000</td>
			</tr>
			<tr>
				<td class="tg-7t59">갤럭시 노트탭</td>
				<td class="tg-7t59">화면이 커서 쓸만해요</td>
				<td class="tg-7t59">E</td>
				<td class="tg-7t59">800</td>
				<td class="tg-7t59">10000</td>
			</tr>
			<tr>
				<td class="tg-13pz">갤럭시s9</td>
				<td class="tg-13pz">최신폰 싸게 구입!</td>
				<td class="tg-13pz">F</td>
				<td class="tg-13pz">900</td>
				<td class="tg-13pz">10000</td>
			</tr>
			<tr>
				<td class="tg-7t59">갤럭시s8</td>
				<td class="tg-7t59">잘 쓰고 있어요</td>
				<td class="tg-7t59">G</td>
				<td class="tg-7t59">250</td>
				<td class="tg-7t59">10000</td>
			</tr>
			<tr>
				<td class="tg-13pz">갤럭시 노트5</td>
				<td class="tg-13pz">생각보다 별로에요</td>
				<td class="tg-13pz">H</td>
				<td class="tg-13pz">700</td>
				<td class="tg-13pz">10000</td>
			</tr>
			<tr>
				<td class="tg-7t59">갤럭시 기어3</td>
				<td class="tg-7t59">운동할떄도 쓸수있어서 좋아요</td>
				<td class="tg-7t59">J</td>
				<td class="tg-7t59">1200</td>
				<td class="tg-7t59">10000</td>
			</tr>
			<tr>
				<td class="tg-13pz">갤럭시 기어2</td>
				<td class="tg-13pz">증정으로 받았어요!</td>
				<td class="tg-13pz">K</td>
				<td class="tg-13pz">2000</td>
				<td class="tg-13pz">10000</td>
			</tr>
			<tr>
				<td class="tg-7t59">갤럭시 s8</td>
				<td class="tg-7t59">내구성 짱짱</td>
				<td class="tg-7t59">L</td>
				<td class="tg-7t59">1300</td>
				<td class="tg-7t59">10000</td>
			</tr>
		</table>
	</div>
</body>
</html>