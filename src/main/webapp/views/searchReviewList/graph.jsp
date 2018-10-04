<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
<style>
	.canvasArea {
		display:inline-block;
	  	text-align: center;
	  	color: #bdc3c7;
	}
</style>
<script>
	$(function(){
		var myColor = ["#39ca74","#e54d42","#f0c330"];
		var myData = [7,82,10];
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
		  var x = (canvas.width)/2.00;
		  var y = (canvas.height)/2.1;
		  var r = 100;
		  
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
		    end = getPoint(x,y,r+20,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
		    start = getPoint(x,y,r-20,(lastend+(Math.PI*2*(myData[i]/myTotal))/2));
		    if(start[0] <= x)
		    {
		      flip = -1;
		      textOffset = -80;
		    }
		    else
		    {
		      flip = 1;
		      textOffset = 10;
		    }
		    ctx.moveTo(start[0],start[1]);
		    ctx.lineTo(end[0],end[1]);
		    ctx.lineTo(end[0]+80*flip,end[1]); //글자 아래 라인 길이
		    ctx.strokeStyle = "#bdc3c7";
		    ctx.lineWidth = 2; //글자 아래 라인 두께
		    ctx.stroke();
		    // The labels
		    ctx.font="13px 맑은고딕";
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
	});
	
</script>
</head>
<body>
	<div class="canvasArea">
	  <canvas id="canvas" width="400" height="300"></canvas>
	</div>
</body>
</html>