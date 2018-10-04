<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@page import="com.chain.triangleView.review.review.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	ArrayList<Review> searchReviewList = (ArrayList<Review>)request.getAttribute("searchReviewList");
	String searchReviewData = "default";

	if(request.getAttribute("searchReviewData") != null){
		searchReviewData = (String)request.getAttribute("searchReviewData");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<script src="/triangleView/js/jqcloud-1.0.4.js"></script>
<link rel="stylesheet" href="/triangleView/css/w3.css">
<link rel="stylesheet" href="/triangleView/css/jqcloud.css" />
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<title></title>
<style>
	.viewForm{
		width:210px;
		height:287px;
		margin:7px;
		margin-top:8px;
		position:relative;
		display:inline-block;
		float:left;
		border:1px solid #E5E5E5;
		background:white;
	}
	.viewMainImage img{
		width:210px;
		height:210px;
		cursor:pointer;
	}
	.formType{
		top:0px;
		left:10px;
		position:absolute;
		z-index:2;
	}
	.viewTitle {
		width:95%;
		display:inline-block;
		text-align: left;
		margin-left : 3px;
	}
	.viewTitle p {
		font-size:13px;
		font-weight:bold;
		overflow:hidden;
		white-space:nowrap;
		text-overflow:ellipsis;
		padding-left:5px;
		margin-top:5px;
		margin-bottom:5px;
	}
	.viewSearchImage, .viewLikeImage{
		width:45%;
		float:left;
		display:table;
		text-align:left;
		padding-left: 10px;
		margin-top : 5px;
	}
	.viewSearchImage p, .viewLikeImage p{
		display:table-cell;
		font-size:14px;
		font-weight: bold;
		text-align:left;
		vertical-align:middle;
		margin:0px;
		color:darkgray;
		padding-bottom:6px;
	}
	
	.viewSearchImage img, .viewLikeImage img{
		margin-right:7px;
	}
	
	.viewSearchImage div, .viewLikeImage div{
		display:inline;
	}
	
	.viewSearchImage p, .viewLikeImage p{
		display:table-cell;
		font-size:14px;
		font-weight: bold;
		text-align:left;
		margin:0px;
		color:darkgray;
	}
	
	.reviewWriter {
		float:right;
		font-size:12px;
		font-weight:bold;
		cursor:pointer;
	}
	
	.reviewWriter p{
		display:inline;
		padding-right:3px;
		font-size:12px;
		font-weight:bold;
		margin:0px;
		margin-top: -5px;
	}
	.formArea {
		display:inline-block;
		z-index: 300;
   		position: fixed;
   		left: 50%;
   		margin-left:-500px;
    	top: 80px;
	}
	.reviewInfoArea {
		width: 99%;
	    margin-left: auto;
	    margin-right: auto;
		margin-top:9px;
		display: flex;
		border: 1px solid #E5E5E5;
		background:white;
		border-radius: 10px;
	}
	
	.graphArea {
		width:50%;
	}
	
	.cloudTageArea {
		width:50%;
	}
	
	.canvasArea {
		display:inline-block;
	  	text-align: center;
	  	color: #bdc3c7;
	}
	@media all and (max-width:768px){
		.centerContent { 
			width:100%; 
			display:inline-table;
		}
	}

	#cloudCanvas{
		width : 339px;
		height : 240px;
	}
</style>
<script>
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
	
	$(function(){
		
		$("#canvas").css({"display":"none"});
		
		var isStop = false;
		var searchReviewData = '<%=searchReviewData%>';
		var isNoData = true;
		var isNoData2 = false;

		// 태그 구름 AJAX
		$.ajax({
			url : "<%=request.getContextPath()%>/cloudTag.sr",
			type : "GET",
			data : {searchHash: "<%=searchReviewData%>"},
			success : function(data) {
				

				if(jQuery.isEmptyObject(data)){
					
					isNoData2 = true;
				}else{
					
			 	 	var word_array = [
	         						 {text: "", weight: 1}
	      							  ];
			  
				  	for(var key in data) {
			  		
 			  			word_array.push({text: key, weight : data[key]});
			  	   }
			  	
	    			$("#cloudCanvas").jQCloud(word_array);
				}
			
			},
			beforeSend: function () {
				
				$("#cloudCanvas").css({"display":"none"});
				$("#loading2").css({"display":"block"});
            },
            complete: function () {
            	
            	if(!isStop){
					if(isNoData2){
            			
            			console.log("노데이터");
            			$("#loading2").attr("src", "/triangleView/img/main/nodata.png");
            			$("#cloudCanvas").css({"display":"none"});
        				$("#loading2").css({"display":"block"});
            			
            		}else{
            			
            			$("#loading2").attr("src", "/triangleView/img/main/loading3.gif");
            			$("#cloudCanvas").css({"display":"block"});
        				$("#loading2").css({"display":"none"});
            		}
            	}
            }
	    });
	    
		
		// 감정분석 AJAX
		
		$.ajax({
			url : "<%=request.getContextPath()%>/crolling",
			type : "GET",
			data : {searchReviewData:searchReviewData},
			success : function(data) {
					
				isNoData = (data["good"]==0 && data["soso"]==0 && data["bad"]==0);
			
				if(data["isStop"] == 0){
					var myColor = ["#39ca74","#e54d42","#f0c330"];
					var myData = [data["good"], data["soso"], data["bad"]];
					var myLabel = ["긍정","부정","보통"];
				
					function getTotal()	{
						  var myTotal = 0;
						  for (var j = 0; j < myData.length; j++) {
				  			  myTotal += (typeof myData[j] == 'number') ? myData[j] : 0;
						  }
				 	  	  return myTotal;
					}
				
					function plotData() {
				 		var canvas;
						var ctx;
						var lastend = 0;
				 		var myTotal = getTotal();
				 		var doc;
						canvas = document.getElementById("canvas");
				  		var x = (canvas.width)/2.2;
				 		var y = (canvas.height)/2.0;
				 		var r = 75;
				  
				 	 	ctx = canvas.getContext("2d");
				  		ctx.clearRect(0, 0, canvas.width, canvas.height);
				
				  		for (var i = 0; i < myData.length; i++) {
				   			ctx.fillStyle = myColor[i];
				    		ctx.beginPath();
				    		ctx.moveTo(x,y);
				   		 	ctx.arc(x,y,r,lastend,lastend+(Math.PI*2*(myData[i]/myTotal)),false);
				    		ctx.lineTo(x,y);
				    		ctx.fill();
				    
				    		// Now the pointers
				    		ctx.beginPath();
				    		var start = [];
				    		var end = [];
				    		var last = 0;
				    		var flip = 0;
				   		 	var textOffset = 0;
				    		var precentage = (myData[i]/myTotal)*100;
				    		end = getPoint(x,y,r+10,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
				    		start = getPoint(x,y,r-30,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
				    		if(start[0] <= x){
				    			
				      			flip = -1;
				      			textOffset = -80;
				    		}else{
				    			
				      			flip = 1;
				      			textOffset = 10;
				    		}
				    		ctx.moveTo(start[0],start[1]);
				    		ctx.lineTo(end[0],end[1]);
				    		ctx.lineTo(end[0]+80*flip,end[1]); //글자 아래 라인 길이
				    		ctx.strokeStyle = "#E5E5E5";
				    		ctx.lineWidth = 2; //글자 아래 라인 두께
				    		ctx.stroke();
				    		// The labels
				    		ctx.font="12px 맑은고딕";
				    		ctx.fillText(myLabel[i]+" "+precentage.toFixed(2)+"%",end[0]+textOffset,end[1]-4); 
				    		// Increment Loop
				    		lastend += Math.PI*2*(myData[i]/myTotal);
				  		}
						}
						// Find that magical point
						function getPoint(c1,c2,radius,angle) {
				  			return [c1+Math.cos(angle)*radius,c2+Math.sin(angle)*radius];
						}
						// The drawing
						plotData();
					}else{
				
					isStop = true;
				}
			},
			beforeSend: function () {
				$("#canvas").css({"display":"none"});
				$("#loading").css({"display":"block"});
				
            },
            complete: function () {
            	
            	if(!isStop){

            		if(isNoData){
            			
            			console.log("노데이터");
            			$("#loading").attr("src", "/triangleView/img/main/nodata.png");
            			$("#canvas").css({"display":"none"});
						$("#loading").css({"display":"block"});
            			
            		}else{
            			
            			$("#loading").attr("src", "/triangleView/img/main/loading3.gif");
            			$("#canvas").css({"display":"block"});
						$("#loading").css({"display":"none"});
            		}
            	}
            	
            }
		});
	}); 
	
	function goHome(word){
		var goUser = $(word).attr("id");
		var goMe = '';
		<% if(loginUser != null){ %>
			goMe = '<%= loginUser.getUserId() %>';
		<% } %>
		
		if(goMe != goUser){
			location.href='<%= request.getContextPath()%>/userHome?goUser=' + goUser;
		}else{
			location.href='<%= request.getContextPath()%>/myHome';
		}
	}
</script>
</head>
<body>
	<div class="centerContent">
		<div class="reviewInfoArea">
			<div class="graphArea">
				<h5 style="color:#f7323f; text-align: center; padding-left:15px; font-family: '맑은고딕';"><b>SNS 감정분석</b></h5>
				<hr style="margin-top: 5px; margin-bottom: 0px;">
				<div class="canvasArea">
				  <img id="loading" src="/triangleView/img/main/loading3.gif" width="300" height="240">
				  <canvas id="canvas" width="339" height="240"></canvas>
				</div>
			</div>
			<div class="graphArea">
			    <h5 style="color:#f7323f; text-align: center; padding-left:15px; font-family: '맑은고딕';"><b>태그 구름</b></h5>
			    <hr style="margin-top: 5px; margin-bottom: 0px;">
				<div class="cloudArea">
				  <img id="loading2" src="/triangleView/img/main/loading3.gif" width="300" height="240">
				  <div id="cloudCanvas"></div>
				</div>
			</div>
		</div>
		<% for(int i = 0; i < searchReviewList.size(); i++){ %>
			<% if(i <8){ %>
				<div class="viewForm" >
			<% }else{ %>
				<div class="viewForm" id="viewForm<%= i %>" style="display:none;">
			<% } %>
				<% if(loginUser != null){ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= searchReviewList.get(i).getRwNo() %>, <%= searchReviewList.get(i).getRwContentType() %>, <%= loginUser.getUserNo() %>)">
				<% }else{ %>
					<div class="viewMainImage" onclick="loadReivewForm(<%= searchReviewList.get(i).getRwNo() %>, <%= searchReviewList.get(i).getRwContentType() %>, -1)">
				<% } %>
					<img src="<%= request.getContextPath() %>/review_upload/<%= searchReviewList.get(i).getThumbnail()%>">
				</div>
				<div class="formType">
					<% if(searchReviewList.get(i).getRwContentType() == 0){ %>
							<img src="/triangleView/img/viewList/text.png" style="position:absolute; margin-left : 165px; margin-top : 10px; opacity:0.9;">
					<% }else if(searchReviewList.get(i).getRwContentType() == 1){ %>
						<img src="/triangleView/img/viewList/card.png" style="position:absolute; margin-left : 165px; margin-top : 10px; opacity:0.9;">
					<% }else{ %>
						<img src="/triangleView/img/viewList/video.png" style="position:absolute; margin-left : 165px; margin-top : 10px; opacity:0.9;">
					<% } %>
				</div>
				<div class="viewTitle">
					<p><b><%= searchReviewList.get(i).getRwTitle() %></b></p>
				</div>
				<div style="align:center;">
					<div class="viewSearchImage">
						<img src="/triangleView/img/viewList/view.png" style="width:30px; height:25px;">
						<div><p><%= searchReviewList.get(i).getRwCount() %></p></div>
					</div>
					<div class="viewLikeImage">
						<img src="/triangleView/img/viewList/love.png" style="width:30px; height:25px;">
						<div><p><%= searchReviewList.get(i).getLikeCount() %></p></div>
					</div>
				</div>
				<div class="reviewWriter" style="padding-right:3px;">
					@<p onclick="goHome(this)" id="<%= searchReviewList.get(i).getUserId() %>"><%= searchReviewList.get(i).getNick() %></p>
				</div>
			</div>
		<% } %>
	</div>
	<div id="formArea" class="formArea"></div>
	<div id="formAreaArea" class="w3-modal" onclick="formDisplayNone();"></div>
	<script>
		var $element = $('.centerContent');
		var element = $element[0];
		var doc = element.ownerDocument;
		var win = doc.defaultView || doc.parentWindow;
		
		var startNo = 8;
		var endNo;
		
		
		$(win).scroll(function(){
			if ($(window).scrollTop() == ($(document).height() - $(window).height())) {
				
				endNo = startNo + 8;
				
				setTimeout(function(){
					jQuery.fn.exists = function(){return this.length>0;}
					
					for(var i = startNo; i < endNo && $('#viewForm' + i).exists(); i++){
						if($('#viewForm' + i) != null){
							$('#viewForm' + i).css('display', 'inline-block');
						}
					}
					
					startNo += 8;
					}, 300);
			}
		})
	</script>
</body>
</html>