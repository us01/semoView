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
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
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
	max-width: 180px;
	padding: 10px;
	min-height: 44px;
	width: 180px;
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
    padding-left: 620px;
    font-weight:bold;
    color:white;

}

/*사이드바 옆에 들어갈 항목*/
#sidebar {
	overflow: hidden; /*섹션부분이 값이 html의 범위를 넘어 가면 숨김기능*/
	font: 12px/20px 돋움;
	color: #424242;
	width: 180px;
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

.select-script {
	position: relative;
	width: 200px;
	height: 40px;
	line-height: 40px;
	border: 1px solid #606976;
	border-radius: 4px;
	text-transform: uppercase;
	background: #fff;
}

.select-script label {
	position: absolute;
	width: 90%;
	font-size: .86em;
	color: #606976;
	top: 0;
	left: 0;
	padding: 0 5%;
}

.select-script label:after {
	content: '▼';
	width: 40px;
	height: 40px;
	position: absolute;
	top: 100;
	right: 0;
	font-size: .76em;
	color: #fff;
	text-align: center;
	background: #606976;
}

.select-script select {
	width: 100%;
	height: 40px;
	opacity: 0;
	filter: alpha(opacity = 0);
	-ms-filter: alpha(opacity = 0) /* IE 8 */;
}

/*테이블생성*/
.mTable {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: center;
	line-height: 1.5;
	margin: 10px 10px;
}

.mTable th {
	width: 155px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
	background: #f7323f;
}

.mTable td {
	width: 155px;
	/* padding: 10px; */
	vertical-align: center;
	border-bottom: 1px solid #ccc;
	background: white;
}

.settingArea {
	z-index: 300;
	position: absolute;
	left: 30%;
	top: 200px;
}
.enroll{
	/* background:red; */


}

#buttonArea{

	margin-left:450px;

}
#pageBtn{

	margin-left:340px;

}


.date{
	
	margin-left:180px;
	margin-top:10px;
}
.date>fromDt{

	width:100px;

}
 .date>toDt{
 
 	width:100px;
 
 }
 




</style>
<script type="text/javascript">
			$(document).ready(function(){

				var select = $('.select-script select');
				select.change(function(){
					var select_name = $(this).children('option:selected').text();
					$(this).siblings("label").text(select_name);
				});

			});
		</script>

<script language="javascript" type="text/javascript">
$(document).ready(function() {
	var st="";

//******************************************************************************
// 상세검색 달력 스크립트
//******************************************************************************
var clareCalendar = {
monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
dayNamesMin: ['일','월','화','수','목','금','토'],
weekHeader: 'Wk',
dateFormat: 'yymmdd', //형식(20120303)
autoSize: false, //오토리사이즈(body등 상위태그의 설정에 따른다)
changeMonth: true, //월변경가능
changeYear: true, //년변경가능
showMonthAfterYear: true, //년 뒤에 월 표시
//buttonImageOnly: true, //이미지표시
buttonText: '달력선택', //버튼 텍스트 표시
//buttonImage: 'res/img/comn/calendar.gif', //이미지주소
showOn: "both", //엘리먼트와 이미지 동시 사용(both,button)
yearRange: '1990:2020' //1990년부터 2020년까지
};
 $("#fromDt").datepicker(clareCalendar);
 st = $("#fromDt").val();
$("#toDt").datepicker(clareCalendar); 
$("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지버튼 style적용
$("#ui-datepicker-div").hide(); //자동으로 생성되는 div객체 숨김 
});   

</script>




</head>
<body>
	<section id="sidebar">
		<div class="mainlogo">
	<a href="<%= request.getContextPath() %>/loginMain">
								<img id="main_Logo" src="/triangleView/img/admin/mainlogo.png">
							</a>
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
					<p><a href="/triangleView/views/admin/payment/paymentpage2.jsp#payment">수익내역</a></p>
				<li>
				<li id="point"><h2>
						<a href="#point"> 포인트관리</a>
					</h2>
					<p><a href="/triangleView/views/admin/point/pointpage1.jsp#point">환급내역</a></p>
					<p><a href="/triangleView/views/admin/point/pointpage2.jsp#point">지급내역</a></p></li>
				

			</ul>
		</div>
		
		
		
		
		
		
		
		
		
	</section>

	<section id="content">

		<div class="login-back">
		<div id="category-nav">
			결제관리 > 구매내역
		</div></div>
		
		<div class="content">
			
			<h3 align="center">*구매내역*</h3>
			
			<div class="date">
			<input name="fromDt" type="text" id="fromDt" size="8" maxlength="8" title="시작일자" style="width:150px" placeholder="시작일"> ~ 
			<input name="toDt" type="text" id="toDt" size="8" maxlength="8" title="종료일자" style="width:150px" placeholder="종료일" >
			</div>
			
			<div style="margin-left:130px; margin-top:20px;">
			<div style="float:left;">
			
			
			
			<div class="select-box select-script">
				<label for="selectbox">검색목록</label> <select id="select-box"
					title="선택 구분">
					<option value="selectAll" selected="selected">검색목록</option>
					<option value="payDetailCode">결제상세코드</option>
					<option value="copName">기업명</option>
					<option value="userNo">유저번호</option>
					<option value="payType">결제종류</option>
					<option value="payStatus">결제상태</option>
					<option value="serviceType">구분</option>

					</select>
					</div>
					</div>
			
				
				
					<div class="search">
				<input type="text" placeholder="검색어 입력" id="searchWord" class="search-bar">
				<button id="searchMemberBtn" class="search-btn">검색</button></div>
				</div>


			<table class="mTable" id="searchTable">
				<thead>
					<tr>
						<th>행번호</th>
						<th>결제상세코드</th>
						<th>기업명</th>
						<th>유저번호</th>
						<th>구분</th>
						<th>결제액</th>
						<th>결제종류</th>
						<th>결제일자</th>
						<th>결제상태</th>
						
					</tr>
				</thead>
				<tbody id="tb">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>


					</tr>

				</tbody>

			</table>
			<div id="pageBtn">
				<button><<</button>
				<button><</button>
				<button>1</button>
				<button>></button>
				<button>>></button>				
				</div>

		</div>
	</section>
	<script>
	
	
	
	
	
	
	
	
	
	</script>
	
	
	
	<script>
	
	
	$(function(){
		$("#searchMemberBtn").click(function(){
			var option= $("#select-box option:selected").val();
			var searchWord = $('#searchWord').val();
			var FromDt = $("#fromDt").val();
			var ToDt = $("#toDt").val();
			var serviceType=serviceType+"";
			var payType=payType+"";
			var payStatus=payStatus+""; 
			
			
			
			console.log(option);
			console.log(searchWord);
			
			$.ajax({
				url:"/triangleView/searchPayment",
				type:'post',
				data:{
					option:option,
					searchWord:searchWord,
					FromDt:FromDt,
					ToDt:ToDt,
					serviceType:serviceType,
					payType:payType,
					payStatus:payStatus
					
					
				},
				success:function(data){
					$table = $("#searchTable");
					console.log(data);
					$tbody=$("#tb");
					$div=$("#pageBtn");
					$div.empty();
					$tbody.empty();    
					var count=1;
					var st="";
					var pt="";
					var ps="";
					
					
				   if(data != null){
					
					   
				
					   for (var i = 0; i<data.payment.length; i++) {
						
					
						
						
						
						var $tr = $("<tr>");
						var $td0=$("<td>");
						$td0.text(count++);
						var $td1 = $("<td>");
						$td1.text(data.payment[i].payDetailCode);
						var $td2 = $("<td>");
						$td2.text(data.payment[i].copName);
						var $td3 = $("<td>");
						$td3.text(data.payment[i].userNo);
						if(data.payment[i].serviceType==0){
							st="공고";
						}else if(data.payment[i].serviceType==1){
							st="제휴";
						}
						var $td4 = $("<td>");
						$td4.text(st);
						var $td5 = $("<td>");
						$td5.text(data.payment[i].money);
						if(data.payment[i].payType==0){
							pt="카드";
						}else if(data.payment[i].payType==1){
							pt="무통장";
						}
						var $td6 = $("<td>");
						$td6.text(pt);
						var $td7 = $("<td>");
						$td7.text(data.payment[i].payDate);
						if(data.payment[i].payStatus==0){
							ps="결제";
						}else if(data.payment[i].payStatus==1){
							ps="환불";
						}
						
						
						var $td8 =$("<td>");
						$td8.text(ps);

						
						$tr.append($td0);
						$tr.append($td1);
						$tr.append($td2); 
						$tr.append($td3); 
						$tr.append($td4); 
						$tr.append($td5); 
						$tr.append($td6); 
						$tr.append($td7);
						$tr.append($td8);
						$table.append($tr);
						
						
		
					 } 
					   console.log(data.pi.maxPage);
						console.log(data.option);
						console.log(data.searchWord);
						$("#pageBtn").empty(); 
			               if(data.pi.maxPage!=0){
			               $Btn1 = $("<button class='btn' onclick = a(1,'"+data.option+"')>");
			               $Btn1.append("<<");
			               $("#pageBtn").append($Btn1);
			               if(data.pi.currentPage <= 1){ 
			                  $Btn2  = $("<button class='btn' disabled>");    
			               }else{
			                  $Btn2  = $("<button class='btn' onclick = a("+(data.pi.currentPage - 1)+",'"+data.option+"')>");
			               }
			               }
			               $Btn2.append("<");
			               $("#pageBtn").append($Btn2);
			               for(var p = data.pi.startPage; p <= data.pi.endPage; p++){ 
			                  if(p == data.pi.currentPage){
			                     $page = $("<button class='btn' disabled>");
			                   }else{
			                      $page = $("<button class='btn' onclick=a("+p+",'"+data.option+"')>");
			                  } 
			                  $page.append(p);
			                  $("#pageBtn").append($page);
			               }          
			               
			               if(data.pi.currentPage >= data.pi.maxPage){ 
			                  $Btn3 = $("<button class='btn' disabled>");
			               }else{ 
			                  $Btn3 = $("<button class='btn' onclick=a("+(data.pi.currentPage + 1)+",'"+data.option +"')>");
			               } 
			               $Btn3.append(">");
			               $("#pageBtn").append($Btn3);
			               $Btn4 = $("<button class='btn' onclick=a("+data.pi.maxPage+",'"+data.option+"')>");
			               $Btn4.append(">>");
			               $("#pageBtn").append($Btn4);
			               
					   
					   
					   
					   
					   
					}
					}
				});
			});
		});
	
	</script>
	<script>
	function a(cp,option,serviceType,payType,payStatus){
	
	var option =option+"";
	var serviceType=serviceType+"";
	var payType=payType+"";
	/* var payStatus=payStaus+""; */
	
	$.ajax({
		url:"/triangleView/searchPayment",
		type:'post',
		data:{
			currentPage:cp,
			option:option,
			serviceType:serviceType,
			/*FromDt:FromDt,
			ToDt:ToDt, */
			payType:payType,
			payStatus:payStatus
			
			
		},
		success:function(data){
			$table = $("#searchTable");
			console.log(data);
			$tbody=$("#tb");
			$div=$("#pageBtn");
			$div.empty();
			$tbody.empty();    
			var count=1;
			var st="";
			var pt="";
			var ps="";
			
			
		   if(data != null){
			
			   
		
			   for (var i = 0; i < data.payment.length; i++) {
		
				var $tr = $("<tr>");
				var $td0=$("<td>");
				$td0.text(count++);
				var $td1 = $("<td>");
				$td1.text(data.payment[i].payDetailCode);
				var $td2 = $("<td>");
				$td2.text(data.payment[i].copName);
				var $td3 = $("<td>");
				$td3.text(data.payment[i].userNo);
				if(data.payment[i].serviceType==0){
					st="공고";
				}else if(data.payment[i].serviceType==1){
					st="제휴";
				}
				var $td4 = $("<td>");
				$td4.text(st);
				var $td5 = $("<td>");
				$td5.text(data.payment[i].money);
				if(data.payment[i].payType==0){
					pt="카드";
				}else if(data.payment[i].payType==1){
					pt="무통장";
				}
				var $td6 = $("<td>");
				$td6.text(pt);
				var $td7 = $("<td>");
				$td7.text(data.payment[i].payDate);
				if(data.payment[i].payStatus==0){
					ps="결제";
				}else if(data.payment[i].payStatus==1){
					ps="환불";
				}
				
				
				var $td8 =$("<td>");
				$td8.text(ps);

				
				$tr.append($td0);
				$tr.append($td1);
				$tr.append($td2); 
				$tr.append($td3); 
				$tr.append($td4); 
				$tr.append($td5); 
				$tr.append($td6); 
				$tr.append($td7);
				$tr.append($td8);
				$table.append($tr);
				
				

			 } 
	
			   console.log(data.pi.maxPage);
				console.log(data.option);
				console.log(data.searchWord);
				$("#pageBtn").empty();
				
				
	               
	               if(data.pi.maxPage!=0){
	               $Btn1 = $("<button class='btn' onclick = a(1,'"+data.option+"')>");
	               $Btn1.append("<<");
	               $("#pageBtn").append($Btn1);
	               if(data.pi.currentPage <= 1){ 
	                  $Btn2  = $("<button class='btn' disabled>");    
	               }else{
	                  $Btn2  = $("<button class='btn' onclick = a("+(data.pi.currentPage - 1)+",'"+data.option+"')>");
	               }
	               }
	               $Btn2.append("<");
	               $("#pageBtn").append($Btn2);
	               for(var p = data.pi.startPage; p <= data.pi.endPage; p++){ 
	                  if(p == data.pi.currentPage){
	                     $page = $("<button class='btn' disabled>");
	                   }else{
	                      $page = $("<button class='btn' onclick=a("+p+",'"+data.option+"')>");
	                  } 
	                  $page.append(p);
	                  $("#pageBtn").append($page);
	               }          
	               
	               if(data.pi.currentPage >= data.pi.maxPage){ 
	                  $Btn3 = $("<button class='btn' disabled>");
	               }else{ 
	                  $Btn3 = $("<button class='btn' onclick=a("+(data.pi.currentPage + 1)+",'"+data.option +"')>");
	               } 
	               $Btn3.append(">");
	               $("#pageBtn").append($Btn3);
	               $Btn4 = $("<button class='btn' onclick=a("+data.pi.maxPage+",'"+data.option+"')>");
	               $Btn4.append(">>");
	               $("#pageBtn").append($Btn4);
	               
			}
		  }
		   

   	});
		}
	
	
	
	
	</script>
	
	
	
	
	
</body>
</html>