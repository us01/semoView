<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	margin-top: 300px;
}
.box { /*그래프 박스  */
	position: relative;
    background: white;
    width: 1000px;
    margin: 0 auto;
}

.box { /*그래프 박스  */
	position: relative;
	top: 5%;
	margin: 0 auto;
	background: white;
	width: 1000px;
}

@media all and (max-width:965px)
{
#boxHeader1 {
	width: 200px;
}

}
#boxHeader { /*그래프 해더  */
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	left: 6%;
	text-align: center;
}

#boxHeader1 {
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	top: 5%;
	left: 12%;
}

#boxHeader2 {
	width: 250px;
	background: #f7323f;
	text-align: center;
	display: inline-block;
	position: relative;
	top: 5%;
	left: 18%;
	text-align: center;
}

p { /*그래프 글씨  */
	color: white;
	display: inline-block;
}

#a { /*그래프 사진  */
	width: 100%;
	height: 100%;
	position: relative;
	top: 5px;
}

div#reviewCount {
	position: relative;
	top: 10%;
	left: 69%;
	width: 8%;
	background: red;
	text-align: center;
}
</style>
<style type="text/css"> /*그래프  */
tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #bbb;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 10px;
	border-style: solid;
	border-width: 0px;
	overflow: hidden;
	word-break: normal;
	border-color: #bbb;
	color: #594F4F;
	background-color: #E0FFEB;
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
	border-color: #bbb;
	color: #493F3F;
	background-color: #9DE0AD;
}

.tg .tg-axis {
	font-size: 18px;
	background-color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-7ru9 {
	font-size: 18px;
	background-color: #efefef;
	border-color: inherit;
	text-align: center
}

.tg .tg-6iur {
	font-size: 18px;
	background-color: #ffffff;
	color: #656565;
	border-color: inherit;
	text-align: center
}

.tg .tg-azch {
	font-weight: bold;
	font-size: 18px;
	font-family: Impact, Charcoal, sans-serif !important;;
	background-color: #f7323f;
	color: #ffffff;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-j9lp {
	font-weight: bold;
	font-size: 18px;
	font-family: "Arial Black", Gadget, sans-serif !important;;
	background-color: #f7323f;
	color: #ffffff;
	border-color: #000000;
	text-align: center
}

.tg .tg-u01n {
	font-weight: bold;
	font-size: 18px;
	background-color: #f7323f;
	color: #ffffff;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-2qjj {
	font-weight: bold;
	font-size: 18px;
	background-color: #f7323f;
	border-color: inherit;
	text-align: center;
	vertical-align: top
}

.tg .tg-6kia {
	font-size: 15px;
	background-color: #efefef;
	border-color: inherit;
	text-align: center
}

.tg .tg-3etr {
	font-size: 15px;
	background-color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-8rzn {
	font-size: 18px;
	background-color: #efefef;
	color: #ffffff;
	border-color: inherit;
	text-align: center
}

.tg .tg-rkeo {
	font-size: 15px;
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-l0dw {
	font-size: 18px;
	background-color: #efefef;
	color: #343434;
	text-align: center;
	vertical-align: top
}

.tg .tg-op2s {
	font-size: 18px;
	background-color: #efefef;
	color: #efefef;
	text-align: center;
	vertical-align: top
}

.tg .tg-7t59 {
	font-size: 18px;
	background-color: #efefef;
	text-align: center;
	vertical-align: top
}
div#test {
    width: 100%;
}
</style>
</head>
<body>
	<div class="body1">
	<div class="box">
		<div id="boxHeader">
			<p>제휴 리뷰 종합 좋아요</p>
			<img
				src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
				id="a">
		</div>
		<div id="boxHeader1">
			<p>제휴 리뷰 종합 조회수</p>
			<img
				src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
				id="a">
		</div>
		<div id="boxHeader2">
			<p>제휴 리뷰 종합 수익</p>
			<img
				src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/87118/sample-data-1.png"
				id="a">
		</div>
	</div>
	<div id="test">
		<table class="tg"
			style="table-layout: fixed;width: 1000px;margin: 0 auto;margin-top: 3%;">
			<colgroup>
				<col style="width: 111px">
				<col style="width: 111px">
				<col style="width: 201px">
				<col style="width: 111px">
				<col style="width: 111px">
			</colgroup>
			<tr>
				<th class="tg-j9lp">번호</th>
				<th class="tg-azch">아이디</th>
				<th class="tg-u01n">리뷰제목</th>
				<th class="tg-2qjj"><span style="color: rgb(255, 255, 255)">상품이름</span></th>
				<th class="tg-u01n">좋아요</th>
			</tr>
			<tr>
				<td class="tg-6kia">01</td>
				<td class="tg-7ru9">A</td>
				<td class="tg-7ru9">S9좋아요</td>
				<td class="tg-7ru9">S9</td>
				<td class="tg-7ru9">1000</td>
			</tr>
			<tr>
				<td class="tg-3etr">02</td>
				<td class="tg-axis">B</td>
				<td class="tg-axis">배부르다</td>
				<td class="tg-axis">버거킹</td>
				<td class="tg-6iur">830</td>
			</tr>
			<tr>
				<td class="tg-6kia">03</td>
				<td class="tg-7ru9">C</td>
				<td class="tg-8rzn"><span style="color: rgb(52, 52, 52)">창렬</span></td>
				<td class="tg-7ru9">창렬도시락</td>
				<td class="tg-7ru9">400</td>
			</tr>
			<tr>
				<td class="tg-3etr">04</td>
				<td class="tg-axis">D</td>
				<td class="tg-axis"><span style="color: rgb(52, 52, 52)">혜자</span></td>
				<td class="tg-axis">혜자도시락</td>
				<td class="tg-axis">900</td>
			</tr>
			<tr>
				<td class="tg-rkeo">05</td>
				<td class="tg-l0dw">E</td>
				<td class="tg-op2s"><span style="color: rgb(52, 52, 52)">어머!
						이건꼭 사야해</span><br></td>
				<td class="tg-7t59">스킨,로션</td>
				<td class="tg-7t59">1200</td>
			</tr>
		</table>
	</div>
</div>	
</body>
</html>