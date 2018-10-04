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
			게시물관리 > 게시물삭제
		</div></div>
		<div class="content">
		
			
		<h3 align="center">*게시물관리목록*</h3>
			<div style="margin-left:130px; margin-top:20px;">
			<div style="float:left;">
			
			<div class="select-box select-script">
				<label for="selectbox">검색목록</label> <select id="select-box"
					title="선택 구분">
					<option value="selectAll" selected="selected">검색목록</option>
					<option value="userNo">유저번호</option>
					<option value="rwNo">리뷰번호</option>
					<option value="categoryType">카테고리</option>
					<option value="rwCount">조회수</option>
					<option value="rwcontentType">글종류</option>
					<option value="rwType">구분</option>
					<option value="writedate">작성일</option>
					

					</select>
					</div>
			</div>
			
			<div class="search"><input type="text" placeholder="검색어 입력" id="searchWord"class="search-bar">
			<button id="searchMemberBtn"class="search-btn">검색</button></div>
			</div>
			
			<table class="mTable" id="searchTable">
				<thead>
					<tr>
						<th>행번호</th>
						<th>유저번호</th>
						<th>리뷰번호</th>
						<th>카테고리</th>
						<th>조회수</th>
						<th>글종류</th>
						<th>구분</th>
						<th>작성일</th>
						<th>좋아요수</th>
						<th>첨부파일</th>
						<th>게시물삭제</th>
						
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
	$(function(){
		$("#searchMemberBtn").click(function(){
			var option= $("#select-box option:selected").val();
			var searchWord = $('#searchWord').val();
			var categoryType=categoryType+"";
			var rwcontentType=rwcontentType+"";
			var rwType=rwType+"";
			$.ajax({
				url:"/triangleView/searchReviews",
				type:'post',
				data:{
					option:option,
					searchWord:searchWord,
					categoryType:categoryType,
					rwcontentType:rwcontentType,
					rwType:rwType
					
				},
				success:function(data){
					$table = $("#searchTable");
					console.log(data);
					$tbody=$("#tb");
					$div=$("#pageBtn");
					$div.empty();
					$tbody.empty();  
					var count=1;
					var cg="";
					var rct="";
					var rt="";
					
				   if(data != null){
					
					   
				
					   for (var i = 0; i < data.review.length; i++) {
						
					
						
						var cg="";
						var rct="";
						var rt="";
						
						var $tr = $("<tr>");
						var $td0=$("<td>");
						$td0.text(count++);
						var $td1 = $("<td>");
						$td1.text(data.review[i].userNo);
						var $td2 = $("<td>");
						$td2.text(data.review[i].rwNo);
						
						if(data.review[i].categoryType==1){
							cg="자유";
						}else if(data.review[i].categoryType==2){
							cg="it/가전";
						}else if(data.review[i].categoryType==3){
							cg="뷰티";
						}else if(data.review[i].categoryType==4){
							cg="금융";
						}
						else if(data.review[i].categoryType==5){
							cg="스포츠";
						}
						else if(data.review[i].categoryType==6){
							cg="취미";
						}
						else if(data.review[i].categoryType==7){
							cg="게임";
						}
						else if(data.review[i].categoryType==8){
							cg="음악";
						}
						else if(data.review[i].categoryType==9){
							cg="인생";
						}
						
					
						var $td3 = $("<td>");
						$td3.text(cg);
						var $td4 = $("<td>");
						$td4.text(data.review[i].rwCount);
						
						
						if(data.review[i].rwcontentType==0){
							rct="글";
						}
						else if(data.review[i].rwcontentType==1){
							rct="카드";
						}
						else if(data.review[i].rwcontentType==2){
							rct="동영상";
						}
						
						var $td5 = $("<td>");
						$td5.text(rct);
						
						
						if(data.review[i].rwType==0){
							rt="일반";
						}else if(data.review[i].rwType==1){
							rt="제휴";
						}
						var $td6 = $("<td>");
						$td6.text(rt);
						var $td7 = $("<td>");
						$td7.text(data.review[i].writedate);
						var $td8 =$("<td>");
						$td8.text(data.review[i].rwLike);
						var $td9=$("<td>");
						var $button1=$("<button>");
						$button1.text("확인");
						$button1.attr("id",data.review[i].userNo);
						var $td10=$("<td>");
						var $button2=$("<button>");
						$button2.text("삭제");
						$button2.attr("id",data.review[i].rwNo);
						$button2.attr("onclick","DeleteRwBtn(this);");
						
						
						
						
						$tr.append($td0);
						$tr.append($td1);
						$tr.append($td2); 
						$tr.append($td3); 
						$tr.append($td4); 
						$tr.append($td5); 
						$tr.append($td6); 
						$tr.append($td7);
						$tr.append($td8);
						$td9.append($button1).trigger("create");
						$tr.append($td9);
						$td10.append($button2).trigger("create");
						$tr.append($td10);
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
	function a(cp,option,categoryType,rwcontentType,rwType){
		
		 var option = option+"";
		 var categoryType=categoryType+"";
		 var rwcontentType=rwcontentType+"";
		 var rwType=rwType+"";
		 
		 
		
		
		$.ajax({
			url:"/triangleView/searchReviews",
			type:'post',
			data:{
				
				currentPage:cp,
				option:option,
				categoryType:categoryType,
				rwcontentType:rwcontentType,
				rwType:rwType
				
			},
			success:function(data){
				$table = $("#searchTable");
				console.log(data);
				$div=$("#pageBtn");
				$div.empty();
				$tbody=$("#tb");
				$tbody.empty();  
				var count=1;
				var cg="";
				var rct="";
				var rt="";
				
			   if(data != null){
				
				   
			
				   for (var i = 0; i < data.review.length; i++) {
						
					
				
					
					var cg="";
					var rct="";
					var rt="";
					
					var $tr = $("<tr>");
					var $td0=$("<td>");
					$td0.text(count++);
					var $td1 = $("<td>");
					$td1.text(data.review[i].userNo);
					var $td2 = $("<td>");
					$td2.text(data.review[i].rwNo);
					
					if(data.review[i].categoryType==1){
						cg="자유";
					}else if(data.review[i].categoryType==2){
						cg="it/가전";
					}else if(data.review[i].categoryType==3){
						cg="뷰티";
					}else if(data.review[i].categoryType==4){
						cg="금융";
					}
					else if(data.review[i].categoryType==5){
						cg="스포츠";
					}
					else if(data.review[i].categoryType==6){
						cg="취미";
					}
					else if(data.review[i].categoryType==7){
						cg="게임";
					}
					else if(data.review[i].categoryType==8){
						cg="음악";
					}
					else if(data.review[i].categoryType==9){
						cg="인생";
					}
					
				
					var $td3 = $("<td>");
					$td3.text(cg);
					var $td4 = $("<td>");
					$td4.text(data.review[i].rwCount);
					
					
					if(data.review[i].rwcontentType==0){
						rct="글";
					}
					else if(data.review[i].rwcontentType==1){
						rct="카드";
					}
					else if(data.review[i].rwcontentType==2){
						rct="동영상";
					}
					
					var $td5 = $("<td>");
					$td5.text(rct);
					
					
					if(data.review[i].rwType==0){
						rt="일반";
					}else if(data.review[i].rwType==1){
						rt="제휴";
					}
					var $td6 = $("<td>");
					$td6.text(rt);
					var $td7 = $("<td>");
					$td7.text(data.review[i].writedate);
					var $td8 =$("<td>");
					$td8.text(data.review[i].rwLike);
					var $td9=$("<td>");
					var $button1=$("<button>");
					$button1.text("확인");
					$button1.attr("id",data.review[i].userNo);
					var $td10=$("<td>");
					var $button2=$("<button>");
					$button2.text("삭제");
					$button2.attr("id",data.review[i].rwNo);
					$button2.attr("onclick","DeleteRwBtn(this);");
					
					
					
					
					$tr.append($td0);
					$tr.append($td1);
					$tr.append($td2); 
					$tr.append($td3); 
					$tr.append($td4); 
					$tr.append($td5); 
					$tr.append($td6); 
					$tr.append($td7);
					$tr.append($td8);
					$td9.append($button1).trigger("create");
					$tr.append($td9);
					$td10.append($button2).trigger("create");
					$tr.append($td10);
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
	
	
	
	
	
	
	
	
	
	<div id="settingArea" class="settingArea"></div>
	<div id="settingBoardArea" class="w3-modal" onclick="displayNoneCancle();"></div>
	
	<script>
	function DeleteRwBtn(userInfo){
		
		var rwNo = $(userInfo).attr("id");
		
		$.ajax({
			url:"/triangleView/views/admin/review/deletePage.jsp",
			data:{
				
				rwNo:rwNo
				
				},
			type:"post",
			success:function(data){
				
				$(".settingArea").html(data);
				
				document.getElementById('settingBoardArea').style.display='block';
				document.getElementById('settingArea').style.display='block';
				
			}
			});
		
		
	}

	</script>
	<script>
	
	function displayNoneCancle(){
		
		
		document.getElementById('settingArea').style.display='none';
		document.getElementById('settingBoardArea').style.display='none';
	}
	
	function displayNoneEnroll(){
		
		
		document.getElementById('settingArea').style.display='none';
		document.getElementById('settingBoardArea').style.display='none';
		
		
	}
	
	function okBtn(rwInfo){
		
		
		$("#"+rwInfo).css("background","red");

		document.getElementById('settingArea').style.display='none';
		document.getElementById('settingBoardArea').style.display='none';
	}
	
</script>
	
	
	
	
	
	
	
	
</body>
</html>