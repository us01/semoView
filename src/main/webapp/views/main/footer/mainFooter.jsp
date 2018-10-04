<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	.footer{
		background: #F5F5F5;
		width:100%;
		text-align:center;
		margin:0 auto;
		margin-top:90px;
		clear:both;
	}
	.footer div{
		background: #F5F5F5;
		width:1000px;
		text-align:center;
		margin:0 auto;
		padding-top:30px;
		padding-bottom:30px;
		font-size:13px;
		font-family:"맑은고딕";
	}
	.footer ul {
		margin:0 auto;
		list-style-type:none;
		padding-left:0px;
		text-align:left;
		
	}
	.footer ul li {
		display:inline-block;
		
	}
	.footer ul li a {
		text-decoration:none;
		color:#999999;
	}
	.footer ul li span {
		color:#999999;
	}
	.footer p{
		height:70px;
		text-align:left;
		color:#999999;
	}
	.footer address{
		text-align:left;
		font-style:normal;
		line-height:2;
		color:#ABABAB;
	}
	@media all and (max-width:768px) {
		.footer div{
			width:100%;
			font-size:11px;
		}
		.footer div ul, p, address{
			margin-left:20px;
		}
	}
</style>
</head>
<body>
	<div class="footer">
		<div>
			<ul>
				<li><a href="#" target="_blank">이용약관</a> <span>|</span></li>
				<li><a href="#" target="_blank">개인정보처리방침</a></li>
			</ul>
			<p>
				<br>
				<br> <b>고객센터</b> 오전9시 - 오후6시, 점심시간 : 오후 12시 - 오후 1시 <br>
				<br>
			</p>
			<address>
				<span>(주)CHAIN5</span> 주소 : 서울특별시 도봉구 시루봉로 15라길 1층<br> 대표이사 :
				원빈 | 사업자등록번호 : 742-11-111<br> 통신판매번호 : 2018-서울역삼-123456<br>
				전화번호 : 070-123-1234<br> 전자우편 주소 : help@chain5.kr<br>
				Copyright CHAIN5 Corp. All rights reserved.
			</address>
		</div>
	</div>
</body>
</html>