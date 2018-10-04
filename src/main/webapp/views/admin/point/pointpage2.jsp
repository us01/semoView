<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
<script src="/triangleView/js/sample.js"></script>
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="/triangleView/css/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
<style>
html, body {
	font-family: 'Open Sans', sans-serif; /*글씨체 묶어서 저장함*/
	height: 100%; /*최상위 태그에 높이 값을지정*/
}

body {
	background: #FFFFFF;
	height: 100%;
	margin: 0 0 0 0px;
}

img {
	max-width: 80%; /*이미지 크기를 영역내의 80%로 정의함*/
}

ul {
	list-style: none; /*항목모양을 정의함*/
	margin: 0;
	padding: 0;
}

a {
	text-decoration: none; /*글자에 줄을 넣음 none이기때문에 줄그어짐 없앰*/
}

#header {
	float: left;
	width: 850px;
	background: #d2452d;
	position: relative; /*기준이 되는 위치가 자기 자신으로 바뀜*/
}

.mainlogo {
	/* 위쪽 메뉴바위에 배경*/
	float: left;
	background: #f7323f;
	max-width: 150px;
	padding: 10px;
	min-height: 44px;
	width: 150px;
	max-height: 44px;
}

.mainlogo img {
	max-height: 80px;
	position: relative;
	left: 10px;
}

.login-back {
	/* 위쪽 로그인창 옆의 배경*/
	min-height: 64px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box; /*박스사이징 설정하면 더이상 박스의 크기를 늘리지 않는다.*/
	background: #f7323f;
}

#category-nav{

    margin-top: 0px;
    padding-top: 20px;
    padding-left: 650px;
    font-weight:bold;
    color:white;

}

/*사이드바 옆에 들어갈 항목*/
#sidebar {
	overflow: hidden; /*섹션부분이 값이 html의 범위를 넘어 가면 숨김기능*/
	font: 12px/20px 돋움;
	color: #424242;
	width: 150px;
	height: 100%;
	float: left;
	background: #2A2D33;
}

#list {
	width: 106%;
	height: calc(100% - 95px); /*사칙연산으로 높이 설정기능*/
	padding: 0;
	background: #2A2D33;
	border-right: 1px solid #E0E0E0;
	/*사용자가 해당부분을 확인 할수있도록 스크롤로 표시*/
}

#list h2 {
	color: #c2c2c2;
	font-size: 2.0em;
	float: left;
	width: 100%;
	font-family: 'Open Sans', sans-serif; /*원하는 글꼴을 쉽표로 구분하여 표시할수있다.*/
	font-weight: 600;
	text-transform: uppercase; /*모든문자를 대문자로 변환시킴*/
	padding: 3px 2px 20px;
	border-top: 0 solid #4D4C4C;
	background: #2A2D33;
	margin: 10px 0;
	text-align: center;
}

#list ul #member h2 {
	margin-top: 0px;
}

#list ul li a {
	color: #C2C2C2;
	font-size: .95em;
	padding: 15px 20px;
	float: left;
	width: 100%;
	font-weight: 600;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	text-align: center;
}

#list ul p a {
	padding: 0 0 0 0px;
}

#list ul li h2:hover a {
	background: #fff;
	color: #333;
}

#list ul li :hover a {
	color: #333;
}

#list p {
	padding: 0 10px;
	margin: 0;
	height: 0;
	font-size: 1.5em;
	color: #f5f5f5;
	text-align: center;
	overflow: hidden;
	-moz-transition: height 0.5s ease-in;
	-webkit-transition: height 0.5s ease-in;
	-o-transition: hegith 0.5s ease-in;
	transition: height 0.5s ease-in;
	overflow: hidden; /* 부모요소를 넘어가는 자식부분을 숨김 */
}

#list :target p {
	overflow: auto;
	height: 20px;
}

#content {
	float: left;
	width: 850px;
	height: 100%;
	word-wrap: break-word; /*div영역내에서 텍스트가 넘칠경우 알아서 텍스트 정렬변환*/
	background: #3c59cd;
	font-family: Raleway, sans-serif;
}

/*여기서부터 그래프 차트 영역*/
::-webkit-scrollbar {
	width: 12px;
}

::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
	border-radius: 10px;
}

::-webkit-scrollbar-thumb {
	border-radius: 10px;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.5);
}

.content {
	/*메인페이지 배경*/
	float: left;
	background: #E9EEF4;
	width: 850px;
	height: calc(100% - 64px);
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

.content-header {
	/*메인페이지 위쪽 회색 헤더*/
	background: #808080;
	float: left;
	width: 100%;
	margin-bottom: 15px;
	padding: 15px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	border-bottom: 1px solid #ccc;
}

.content-header h1 {
	margin: 0;
	font-weight: normal;
	padding-bottom: 5px;
}

.content-header p {
	margin: 0;
	padding-left: 2px;
}

.search {
	height: 40px;
	border: 1px solid #d2452d;;
	background: #ffffff;
	display: inline-block;
	border-radius: 4px;
	
	}

.search-bar {
	font-size: 16px;
	width: 325px;
	padding: 10px;
	border: 0px;
	outline: none;
	float: left;
}

.search-btn {
	width: 50px;
	height: 100%;
	border: 0px;
	background: #f7323f;
	outline: none;
	float: right;
	color: #ffffff;
}

#top {
	margin-left: 300px;
	margin-right: 200px;
	display: inline-block;
}
#chart1{

	background:white;

}
#chart2{

	background:white;
}
#chart3{

	background:white;
}
#chart4{

	background:white;
}
#chartTop p{

	text-align:center;
	width:300px;
	margin:0px;
	height:40px;
	font-size:30px;
	
	


}
#chartTop{
background:blue;
	width:300px;
	hight:100px;
}

#firstChar{
	margin-left:20px;
	margin-top:20px;
	display:none;
	float:left;


}
#secondChar{
	margin-left:340px;
	margin-top:20px;
	display:none;
	position:absolute;
	float:left;
	margin-left:30px;

}
#thirdChar{

	margin-left:20px;
	margin-top:100px;
	display:none;
	float:left;


}
#fourthChar{

	margin-left:340px;
	margin-top:100px;
	display:none;
	position:absolute;
	float:left;
	margin-left:30px;



}




#wrap{

	position:absolute;
	height:50%; 
	margin-left:100px;
	margin-top:0px;
	
	

}
#wrap2{

	position:absolute;
	height:50%;
	margin-left:100px;
	margin-top:170px;
	
	

}









 
 




</style>
</head>
<body>
	
			<section id="sidebar">
		<div class="mainlogo">
		<a href="/triangleView/views/main/admin/main/mainpage2.jsp#main"><img
				src="/triangleView/img/admin/mainlogo.png"></a>
		</div>
		<div id="list">
			<ul>

				<li id="member"><h2>
						<a href="#member"> 회원관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/member/memberPage1.jsp#member">회원관리목록</a></p>
					<p><a href="/triangleView/views/admin/member/memberpage2.jsp#member">회원탈퇴현황</a></p>
					<p><a href="/triangleView/views/admin/member/memberpage3.jsp#member">블랙리스트목록</a></p></li>
				<li id="company"><h2>
						<a href="#company">기업회원관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/company/companypage1.jsp#company">기업회원목록</a></p>
					<p><a href="/triangleView/views/admin/company/companypage2.jsp#company">기업탈퇴목록</a></p></li>

				<li id="reviews"><h2>
						<a href="#reviews"> 게시물관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/review/reviewspage1.jsp#reviews">게시물삭제</a></p>
					<p><a href="/triangleView/views/admin/review/reviewspage2.jsp#reviews">게시물삭제목록</a></p></li>
				<li id="payment"><h2>
						<a href="#payment"> 결제관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/payment/paymentpage1.jsp#payment">구매내역</a></p>
					<p id="Start"><a href="/triangleView/views/admin/payment/paymentpage2.jsp#payment">수익내역</a></p>
				<li>
				<li id="point"><h2>
						<a href="#point"> 포인트관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/point/pointpage1.jsp#point">환급내역</a></p>
					<p id="payBackChart"><a href="/triangleView/views/admin/point/pointpage2.jsp#point">지급내역</a></p></li>
				

			</ul>
		</div>
</section>

	<section id="content">

		<div class="login-back">
			<div id="category-nav">
			포인트관리 > 지급내역
		</div>
		</div>
		
		<div class="content">
		<h3 align="center">*지출내역*</h3>
		
		<div id="wrap">
		<div id="firstChar">
		<div id="chartTop"><p>2018 월간 환급율</p></div>
		<div style="display:inline-block" id="chart1"><canvas id="myChart" width="300" height="200"></canvas></div>
		</div>
		
		
		<div id="secondChar">
		<div id="chartTop"><p> 9월 일간 환급율</p></div>
		<div style="display:inline-block" id="chart2"><canvas id="myChart2" width="300" height="200"></canvas></div>
		</div>
		</div>
		
		
		
		
		
		
		</div>

	
	</section>
				
	
		
	<script>
	
	 
		$(document).ready(function(){ 
			 
			$("#payBackChart").click(function(){
				document.getElementById('secondChar').style.display='inline-block';
			$.ajax({
				
				url:"/triangleView/paybackChart2",
				type:"get",
				success:function(data){
					
				console.log(data);
					
					var payBackDate=[];
					var requestPay=[];
					
					for(var i in data){
						
						payBackDate.push(data[i].payBackDate+"일");
						requestPay.push(data[i].requestPay);
						
						
					}
					var chartdata={
							
					
							
						labels:payBackDate,
						datasets:[{
							
							label:'금액',
							data:requestPay,
							 backgroundColor: [
								 'rgba(153, 102, 255, 0.2)'
				                ],
				                borderColor: [
				                	'rgba(153, 102, 255, 1)'
				                    
				                ],
				                borderWidth:1				
							
							
						}] ,options: {
					        scales: {
					            yAxes: [{
					                stacked: true
					                
					                
					            }]
					        }
					    }
					}
				
						
							
							
					
					var ctx=$("#myChart2");
					var bargraph =new Chart(ctx,{
						type:'line',
						data:chartdata
						
					});
					
				}
					
						
				
		
			});		
				
			});
		 }); 
	
	</script>

	
	 <script>
	$(document).ready(function(){ 
		 
		$("#payBackChart").click(function(){
			document.getElementById('firstChar').style.display='inline-block';
		$.ajax({
			
			url:"/triangleView/paybackChart1",
			type:"get",
			success:function(data){
				
			console.log(data);
				
				var payBackDate=[];
				var requestPay=[];
				
				for(var i in data){
					
					payBackDate.push(data[i].payBackDate+"월");
					requestPay.push(data[i].requestPay);
					
					
				}
				var chartdata={
						
				
						
					labels:payBackDate,
					datasets:[{
						
						label:'금액',
						data:requestPay,
						 backgroundColor: [
							 'rgba(75, 192, 192, 0.2)'
			                ],
			                borderColor: [
			                	 'rgba(75, 192, 192, 1)'
			                    
			                ],
			                borderWidth:1				
						
						
					}] ,options: {
				        scales: {
				            yAxes: [{
				                stacked: true
				                
				                
				            }]
				        }
				    }
				}
			
					
						
						
				
				var ctx=$("#myChart");
				var bargraph =new Chart(ctx,{
					type:'line',
					data:chartdata
					
				});
				
			}
				
					
			
	
		});		
			
		});
	 }); 

</script>
	
</body>
</html>