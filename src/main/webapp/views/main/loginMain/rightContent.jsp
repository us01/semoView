<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.chain.triangleView.notice.notice.vo.notice.Notice, java.util.*, java.text.SimpleDateFormat"%>
 <%
 	Member loginUser = (Member)session.getAttribute("loginUser");
  ArrayList<HashMap<String, Object>> noticeList = (ArrayList<HashMap<String, Object>>)request.getAttribute("selectAllNotice");
 %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<script type="text/javascript" src="jqcloud-1.0.4.js"></script>
<title>Insert title here</title>
<style>
	.rightContent {
		display:inline-block;	
		border:1px solid #E5E5E5;
		float:right;
		width:15%;
		text-align:center;
		border-radius:10px;
		margin-top:9px;
		background:white;
		margin-bottom:80px;
	}
	.rightMenu{
		list-style: none;
		padding-left: 0px;
	}
	
	.hotTagArea p, .favorRiviewArea .favorTitle, .companyArea .companyTitle{
		display:inline-block;
		width:90%;
		font-weight:bold;
		font-size:17px;
		font-family:"나눔고딕";
		text-align:left;
		color:#474747;
		margin-bottom:10px;
		margin-top:40px;
	}
	.companyArea .companyTitle{
		margin-top:0px;
	}
	.hotTagArea ul{
		margin:0 auto;
		width:85%;
		list-style: none;
		padding-left: 0px;
		
	}
	.hotTagArea li{
		width:100%;
		text-align:left;
		font-size:13px;
		margin-bottom:5px;
	}
	.hotTagArea em {
		background:ghostwhite;
		display:inline-block;
		min-width:15px;
		height:15px;
		border:1px solid #e0e0e0;
		font-size:11px;
		font-family:"나눔고딕";
		margin-right:8px;
		font-style:normal;
		text-align:center;
		vertical-align: bottom;
	}
	.rolling_panel{
		display:inline-block;
		position: relative;
		width: 137px;
		height: 180px;
		margin: 0;
		padding: 0;
		overflow: hidden;
	}
	
	.rolling_panel ul {
		position: absolute;
		margin: 0px;
		padding: 0;
		list-style: none;
	}
	
	.rolling_panel ul li {
		float: left;
		width: 137px;
		height: 180px;
	}
	.rolling_panel ul li img {
		width: 137px;
		height: 130px;
	}
	.reviewTitle {
		display:inline-block;;
		font-size:14px;
		font-weight:bold;
		color:#555555;
		padding:2px 0 2px 0;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		width:137px;
		margin-top:0px;
		margin-bottom:0px;
		text-align:left;
	}
	
	.member_id{
		display:inline-block;
		font-size:8px;
		font-weight:bold;
		color:#393939;
		padding:2px 0 2px 0;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		width:137px;
		margin-top:5px;
		margin-bottom:3px;
		text-align:right;
	}
	@media all and (max-width:768px) {
		.rightContent { display:none; }
	}
	
	.icon{
		
		width : 17px !important;
		height : 17px !important;
		float : left !important;
	}
	
	.content{

		margin-left : 2px;
		margin-right : 20px;
		
	}
	.noticeBottom {
		margin-left: auto;
	    margin-right: auto;
	    text-align: center;
	    height : 20px;
		font-size:12px;
	}
	.noticeBottom td{
		line-height: 0;
	}
	.noticeDate{
		display:inline-block;
		background: #f7323f;
	    border-radius: 8px;
	    width: 45px;
	    height: 17px;
	    line-height: initial;
	    color:white;
	    font-weight : bold;
	}
	.formArea {
		display:inline-block;
		z-index: 300;
   		position: fixed;
   		left: 50%;
   		margin-left:-500px;
    	top: 80px;
	}
	.notice:hover{
		cursor:pointer;
	}

	#hottag:hover, #hotreview:hover{
		
		cursor:pointer;
	}
</style>
<script>
	$(function(){
		
		// 핫태크 ajax
		tagAjax();
		
		timer = setInterval( function () {
			tagAjax();
		}, 30000); // 30초에 한번씩 받아온다.
		
		function tagAjax(){
			
			$.ajax({
				url : "/triangleView/hottag",
				type : "POST",
				success : function(data) {

					$('#hottag').empty();
					for(var i=0; i<10;i ++){
	

						var $li = $('<li><em>' + (i+1) + '</em>' + data[i] + '</li>');
						$li.click(function(){
							
							var searchData = $(this).text().substring(1, $(this).text().length);
							naySearch();
							
							function naySearch(){
								var submitCheck;
								
								if($('#sinceTime').val() != '' || $('#sinceTime').val() != ''){
									if($('#sinceTime').val() != '' && $('#sinceTime').val() != ''){
										submitCheck = 'Y';
										if($('#sinceTime').val() > $('#untilTime').val()){
											submitCheck = 'N';
										}
									}else{
										submitCheck = 'N';
									}
								}
								
								if(submitCheck != 'N'){
									$searchData = $('<input>')
									$searchData.attr('name', 'searchData');
									$searchData.attr('type', 'hidden');
									$searchData.val(searchData);
									$('#searchHash').val(searchData);
									$('#searchForm').append($searchData);
									$('#searchForm').attr('action', '<%= request.getContextPath() %>/searchReview.sr').submit();
								}else{
									alert('                         기간 검색 조건이 잘 못 됐습니다.\n                                   다시 설정해주세요.');
								} 
							}
							   
						});
						
						$('#hottag').append($li);
					}
				}
			});
		};
		
		// 인기리뷰 ajax
		$.ajax({
			url : "/triangleView/loginHotReview",
			type : "POST",
			success : function(data) {
				<% if(loginUser != null){ %>
					var userNo = '<%= loginUser.getUserNo() %>';
				<% } %>
				
				for(var key in data){
					<% if(loginUser != null){ %>
						var $li = $('<li onclick="loadReivewForm(' + data[key].rwno + ', ' + data[key].rwcontenttype + ', ' + userNo + ')">');
					<% }else{ %>
						var $li = $('<li onclick="loadReivewForm(' + data[key].rwno + ', ' + data[key].rwcontenttype + ', ' + (-1) + ')">');
					<% } %>
					var $img = $('<img src="/triangleView/review_upload/' + data[key].filename + '">');
					
					$li.append($img);
					$li.append('<p class="reviewTitle">' +	data[key].rwtitle + '</p>'); 
					$li.append('<p class="member_id">@' +  data[key].nick + '</p>');
										
					$('#hotreview').append($li);	
				}
			}
		});
		

		var $panel = $(".rolling_panel").find("ul");
		 
	    var itemWidth = $panel.children().outerWidth(); // 아이템 가로 길이
	    var itemLength = $panel.children().length;      // 아이템 수
	
	    // Auto 롤링 아이디
	    var rollingId;
	
	    auto();
	
	    // 배너 마우스 오버 이벤트
	    $panel.mouseover(function() {
	        clearInterval(rollingId);
	    });
	
	    // 배너 마우스 아웃 이벤트
	    $panel.mouseout(function() {
	        auto();
	    });
	    
	    function auto() {
	        rollingId = setInterval(function() {
	            start();
	        }, 4000);
	    }
	
	    function start() {
	        $panel.css("width", itemWidth * itemLength);
	        $panel.animate({"left": - itemWidth + "px"}, function() {
	
	            // 첫번째 아이템을 마지막에 추가하기
	            $(this).append("<li>" + $(this).find("li:first").html() + "</li>");
	
	            // 첫번째 아이템을 삭제하기
	            $(this).find("li:first").remove();
	
	            // 좌측 패널 수치 초기화
	            $(this).css("left", 0);
	        });
	    }
	})
	
	function loadReivewForm(rwNo, rwContentType, userNo){
		$.ajax({
			url : "/triangleView/loadOneReviewForm.rf",
			type : "GET",
			data : {
				rwNo : rwNo,
				rwContentType : rwContentType,
				userNo : userNo
			},
			success : function(data) {
				$(".formArea").html(data);
				document.getElementById('formAreaArea').style.display = 'inline-block';
				document.getElementById('formArea').style.display = 'inline-block';
			}
		});
	}

	function formDisplayNone() {
		document.getElementById('formArea').style.display = 'none';
		document.getElementById('formAreaArea').style.display = 'none';
	}
	
	function noticeMainList(){
    	location.href="<%=request.getContextPath() %>/noticeSelect";
 	}
</script>
</head>
<body>
	<div class="rightContent">
		<ul class="rightMenu">
			<li>
				<div class="companyArea">
					 <p class="companyTitle" onclick="noticeMainList()">기업공고</p>
					 <div class="rolling_panel">
						<ul>
							<%for(int i=0; i<noticeList.size(); i++){ 
							
								HashMap<String, Object> hmap = noticeList.get(i);
							%>
								<li class="notice">
									<img src="/triangleView/notice_upload/<%=hmap.get("filename")%>">
									<p class="reviewTitle"><%= hmap.get("noticetitle") %></p>
									<table class="noticeBottom">
										<tr>
											<td style=""><img class="icon" src="/triangleView/img/reviewForm/location2.png"></td>
											<td><span class="content"><%= hmap.get("productarea") %></span></td>
											<%
										
											Date currentTime = new Date ();
											String endString = (String)hmap.get("noticeenddate");
											Date endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endString);
											long diff = endTime.getTime() - currentTime.getTime();
											long diffDays = diff / (24 * 60 * 60 * 1000);
											    
											if(diffDays > 0){%>
											    <td><div class="noticeDate">D-<%= diffDays %></div></td>
											<%}else {%>
												 <td><div class="noticeDate">D-DAY</div></td>
											<%} %>
										</tr>
									</table>
								</li>
							<%} %>
						</ul>
					</div>
				</div>
			</li>
			<li>
				<div class="hotTagArea">
					<p>핫태그</p>
					<ul id ="hottag">
					</ul>
				</div>
			</li>
			<li>
				<div class="favorRiviewArea">
					<p class="favorTitle">인기리뷰</p>
					<div class="rolling_panel">
						<ul id="hotreview">
						</ul>
					</div>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>