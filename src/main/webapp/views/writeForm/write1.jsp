<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- w3 혁동 밤길조심해... -->
<link rel="stylesheet" href="../../css/w3.css" media="screen"
	title="no title" charset="utf-8">
<!-- font awesome -->
<link rel="stylesheet" href="../../css/font-awesome.min.css" media="screen"
	title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="../../css/style.css" media="screen"
	title="no title" charset="utf-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
body {
	margin: 0px;
	/* background: #fafafa; */
	font-family: '맑은고딕';
}
.everyThing1 {
	width: 1000px;
	margin: 0 auto;
}

.container2 {
	justify-content: space-between;
	flex-direction: column;
	height: 100vh;
	display: flex;
}

.container2 .btn-holder {
	justify-content: flex-end;
	display: flex;
}

#field {
	width: 100px;
	height: 100px;
	border: 1px solid;
}
/* 여기부터 새로운거 */
/* input[type=file] {
	display: none;
} */
.my_button {
	background-color: #f8585b;
	border: none;
	color: #FDEBEC;
	padding: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-top: 4px;
	margin-bottom: 4px;
	cursor: pointer;
	border-radius: 5px;
	width: 120px;
	height: 30px;
}

.subButton {
	width: 120px;
	background-color: #f8585b;
	border: none;
	color: #FDEBEC;
	padding: 6px;
	text-align: center;
	text-decoration: none;
	font-size: 14px;
	margin-top: 4px;
	margin-bottom: 4px;
	cursor: pointer;
	border-radius: 5px;
	margin-left: 5px;
}

.imgs_wrap {
	border: 2px solid #A8A8A8;
	margin-top: 30px;
	margin-bottom: 30px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.imgs_wrap img {
	max-width: 150px;
	margin-left: 10px;
	margin-right: 10px;
}

input:hover+p.arrow_box {
	display: block;
}

.arrow_box {
	display: none;
	position: absolute;
	padding: 16px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	background: #333;
	color: #fff;
}

.arrow_box:after {
	position: absolute;
	bottom: 100%;
	left: 50%;
	width: 0;
	height: 0;
	margin-left: -10px;
	border: solid transparent;
	border-color: rgba(51, 51, 51, 0);
	border-bottom-color: #333;
	border-width: 10px;
	pointer-events: none;
	content: " ";
}

.w3-change {
	width: 650px;
	height: 30px;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.star-input>.input, .star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	display: inline-block;
	vertical-align: top;
	background-image: url("/triangleView/img/reviewForm/star.png");
    background-repeat: no-repeat;
}

.star-input {
	white-space: nowrap;
}

.star-input>.input {
	display: inline-block;
	width: 100px;
	background-size: 100px;
	height: 19px;
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.star-input>.input>input {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

.star-input>.input.focus {
	outline: 1px dotted #ddd;
}

.star-input>.input>label {
	width: 10px;
	height: 0;
	padding: 19px 0 0 0;
	overflow: hidden;
	float: left;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: 0;
}

.star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	background-size: 100px;
	background-position: 0 bottom;
}

.star-input>.input>label:hover ~label{
	background-image: none;
}

.star-input>.input>label[for="p1"] {
	width: 10px;
	z-index: 10;
}

.star-input>.input>label[for="p2"] {
	width: 20px;
	z-index: 9;
}

.star-input>.input>label[for="p3"] {
	width: 30px;
	z-index: 8;
}

.star-input>.input>label[for="p4"] {
	width: 40px;
	z-index: 7;
}

.star-input>.input>label[for="p5"] {
	width: 50px;
	z-index: 6;
}

.star-input>.input>label[for="p6"] {
	width: 60px;
	z-index: 5;
}

.star-input>.input>label[for="p7"] {
	width: 70px;
	z-index: 4;
}

.star-input>.input>label[for="p8"] {
	width: 80px;
	z-index: 3;
}

.star-input>.input>label[for="p9"] {
	width: 90px;
	z-index: 2;
}

.star-input>.input>label[for="p10"] {
	width: 100px;
	z-index: 1;
}

.star-input>output {
	display: inline-block;
	width: 36px;
	text-align: right;
}

.star-input>output>b {
	font: bold 18px Helvetica, Arial, sans-serif;
	vertical-align: middle;
}

div.gallery {
	margin: 5px;
	border: 1px solid #ccc;
	float: left;
	width: 180px;
}

div.gallery:hover {
	border: 1px solid #777;
}

div.gallery img {
	width: 100%;
	height: auto;
}

div.desc {
	padding: 15px;
	text-align: center;
}

.wrap_test1 {
	position: relative;
}

.ico_test1 {
	background: url(/triangleView/img/writeForm/imgplus.png) 0 0 no-repeat;
	background-size: 250px;
	width: 250px;
	height: 250px;
	display: inline-block;
	position: absolute;
	top: 0;
	left: 0;
	border: 1px solid white;
}

#imgInput1 {
	width: 250px;
	height: 250px;
	display: visible;
}

#imgInput999 {
	width: 200px;
	height: 200px;
	display: visible;
}

.imgPlus {
	width: 250px;
	height: 250px;
	display: visible;
}

.w3-input2 {
	padding: 8px;
	display: block;
	/* border: none; */
	border-bottom: 1px solid #ccc;
	width: 100%;
}
</style>

<script type="text/javascript">
$(function(){
    
    $('#hash').focusout(function(){
       
       var input = $("#hash");
       var str = input.val();
        var res = str.substring(input.val().length-2, input.val().length);
        var newStr = str.slice(0, -2);
        
        if(res == " #"){
                     
           input.val(newStr);
        }
        input.css('color','#f7323f').css("font-weight","Bold");
    });
    
    $('#hash').focusin(function(){
       
       var input = $("#hash");
       input.css('color','black').css("font-weight","");
    });
    
    $('#hash').keydown(function(e) {
       
        var k = e.keyCode;
        var input = $("#hash");
        
        if(input.val() == ""){
              
           input.val('#');
        }
        if ((90 >= k && k >= 65) // a ~ z
                || (111 >= k && k >= 106) // keypad operator
                || (192 >= k && k >= 186) // -,=./;
                || (222 >= k && k >= 219) // ']\[
                || k == 59 // FF ;
                || k == 61 // FF =
                || k == 173 // FF -
                ) {
            e.preventDefault();
        }else if(k == 16){
           
           e.preventDefault();
        }else if(k == 32){

           var str = input.val();
           var res = str.substring(input.val().length-1, input.val().length);
           if(res == "#"){
              e.preventDefault();                
           }else{ 
              e.preventDefault();
              input.val(input.val()+' #');
           }
        }
    });
 });


	function submitAction() {
		
		theForm = document.write1Test;
		if(theForm.title.value==""){
	        alert("제목을 입력하지 않았습니다.")
	        theForm.title.focus();
	        return false;
		} else if(theForm.imgInput999.value==""){
	        alert("썸네일을 입력하지 않았습니다.")
	        theForm.imgInput999.focus();
	        return false;
		} else if(theForm.imgInput1.value==""){
	        alert("이미지를 입력하지 않았습니다.")
	        theForm.imgInput1.focus();
	        return false;
		} else if(theForm.hash.value==""){
	        alert("해시태그를 입력하지 않았습니다.")
	        theForm.hash.focus();
	        return false;
		} else if(theForm.introduce.value==""){
	        alert("한마디를 입력하지 않았습니다.")
	        theForm.introduce.focus();
	        return false;
		} else{
			
			$('#end').attr("disabled", false); 
			var write1Test= document.getElementById("write1Test");
	        write1Test.action = "<%=request.getContextPath()%>/insertWrite1.bo";
	        write1Test.submit();
		}
		
	}

	function moveEditor() {

/* 		var title = document.getElementById('title').value;
		var companySpon = document.getElementById('companySpon').value;
		var category = $("#categoryCheck option:selected").val();
		var hash = $("#hash").val();
		var intro = $("#introduce").val();
		var star = ($('input:radio[name=star-input]:checked').val());
		alert(title);
		alert(companySpon);
		alert(category);
		alert(hash);
		alert(intro);
		alert(star); */
		window.open("/triangleView/views/writeForm/forWrite1/editor.jsp","editor","width=800, height=600,left=250");

	}

</script>
</head>

<body>
<jsp:include page="../main/header/headerNav.jsp" flush="true" />
<br>
<br>
<br>
<div class="everyThing1">
<form class="writeForm" id="write1Test" name="write1Test" action="" method="post" encType="multipart/form-data" style="margin: 15px;background:#fff;text-align:center; border:1px solid black;">
	<div class="container">
		<h3 style="text-align:center; color:#f8585b;">카드형 리뷰</h3>
		</div>
		<hr>
		
		<div class="input-group" style="display:-webkit-inline-box; text-align: left; width:650px; margin-left:-130px;">
		<h5>제목</h5>
			<input type="text" class="w3-input2 w3-change" id="title" name="title" style="text-align: center;
    margin-left: 100px;" placeholder="글제목을 입력해주세요">
		</div>
		<br>


		<div class="input-group" style="display:-webkit-inline-box; text-align: left;">
			<div id="companySup" style="width:635px;">
			<h5 style="display:inline-block;">기업후원 리뷰</h5>
				<input type="checkbox" class="w3-check" name="companySpon" id="companySpon" value="1" style="margin-left: 18px;">
			</div>
			
			<div id="categorySup" >
			<h5 style="display:inline-block;">카테고리</h5>

			<select name="categoryCheck" id="categoryCheck" class="form-control">
				<option value="1" name="category" selected="selected">자유</option>
				<option value="2" name="category">IT/가전</option>
				<option value="3" name="category">음악</option>
				<option value="4" name="category">뷰티</option>
				<option value="5" name="category">스포츠</option>
				<option value="6" name="category">금융 </option>
				<option value="7" name="category">게임</option>
				<option value="8" name="category">취미</option>
				<option value="9" name="category">인생</option>
			</select>
			</div>
		</div>
		<br>

		<div id="thumbNail" style="display: block; text-align: left; margin-left: 90px;">
			<h5 style="display: inline-block;">썸네일</h5><br>
			<label name = "testGoGo" id="testGoGo" style="background-image: url(/triangleView/img/writeForm/imgplus.png);
			background-size: 200px; width: 200px; height: 200px; display: inline-block;">
			<input type="file" id="imgInput999" name="file99" accept="image/gif, image/jpeg, image/png" id="imgInput"
			onchange="LoadImg(this);" style="visibility: hidden;">
			</label>
		</div>
		<br>
		
		<script>
		function LoadImg(value) {
			if (value.files && value.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$("#testGoGo").css('background', 'transparent url('+e.target.result +') left top no-repeat').css('background-size','300px').css('background-size','contain');
					
				}

				reader.readAsDataURL(value.files[0]);
			}
		}

		</script>

		<div id="imageEdit" style="display: -webkit-box;text-align: left; margin-left: 90px;">
			<h5 style="display: inline-block;">이미지</h5>
			<div class="changePhoto">
				<a> <input type="button" class="my_button" id="newPhoto"
					value="이미지편집" onclick="moveEditor();" style="margin-left: 28px; margin-top: 8px;">
					<p class="arrow_box">원하시는 이미지 파일을 편집해서 저장후에 업로드 해주세요!</p>
				</a>
			</div>
		</div>
		

		<div id="write1Content" style="text-align: left; margin-left: 90px;">
			<label for="imgInput1" id="test0" style="background-image: url(/triangleView/img/writeForm/imgplus.png); 
			background-size: 250px; width: 250px; height: 250px; display: inline-block;">
				<input type="file" id="imgInput1" name="file0" id="imgInput" accept="image/gif, image/jpeg, image/png"
					onChange="b()" style="visibility: hidden;">
			</label>
		</div>
		<script>
		var i = 0;
	function readURL(input) {
  		var elem = $(input);
  		if (input.files && input.files[0]) {
   			var reader = new FileReader();
    		reader.onload = function(e) {
    			$("#test"+(i-1)).css('background', 
    					'transparent url('+e.target.result +') left top no-repeat')
    					.css('background-size','300px').css('background-size','contain');
    			
    		}
    		reader.readAsDataURL(elem.get(0).files[0]);
  		}
	}

	$("input[type='file']").change(function() {
  		readURL(this);
  		
	});
	
	
	 function b() {
        i=i+1;
  		var $div =$("<label for = 'imgInput1"+i+"' id ='test"+i+"' style='width:250px; height:250px;background-image:url(/triangleView/img/writeForm/imgplus.png); background-size:250px; display:inline-block;'></label>");
        var $input = $("<input type = 'file' class = 'imgPlus' id = 'imgInput1"+i+"' name = 'file"+i+"' onChange='b()' style='visibility: hidden;'>").change(function() {
      		readURL(this);
      		
    	});

        $($div).append($input);
        $("#write1Content").append($div);
		
	 }
</script> 

		<div class="hash" style="display:-webkit-inline-box">
		<h5>해시태그</h5>
			<input type="text" class="w3-input2 w3-change" id="hash" name="hash"
				style="width:650px; height:30px; margin-left: 60px;" placeholder="hashtag를 입력해주세요">
		</div>
		<br>
		

		<div style="display:-webkit-inline-box">	
			<h5>한마디</h5>
			<textarea id="introduce" class="w3-input2 w3-change" name="introduce" rows="5" style="width:650px; height:120px; margin-left:78px;"></textarea>
			<!-- <span id="text_counter"></span> -->
		</div>
	<br>
		<script>
				$(document).ready(function() {
					var left = 100
					$('#text_counter').text('작성할 수 있는 글자수: ' + left);

					$('#introduce').keyup(function() {

						left = 100 - $(this).val().length;

						if (left < 0) {
							$('#text_counter').addClass("overlimit");
							$('#end').attr("disabled", true);
						} else {
							$('#text_counter').removeClass("overlimit");
							$('#end').attr("disabled", false);
						}

						$('#text_counter').text('작성할 수 있는 글자수: ' + left);
					});
				});
			</script>
			
		<div style="display: -webkit-box; margin-left: 90px;">
			<h5>별점</h5>
				<span class="star-input">
  					<span class="input" style="margin-top:12px; margin-left: 92px;">
    					<input type="radio" name="star-input" id="p1" value="1"><label for="p1">0.5</label>
    					<input type="radio" name="star-input" id="p2" value="2"><label for="p2">1</label>
    					<input type="radio" name="star-input" id="p3" value="3"><label for="p3">1.5</label>
    					<input type="radio" name="star-input" id="p4" value="4"><label for="p4">2</label>
    					<input type="radio" name="star-input" id="p5" value="5"><label for="p5">2.5</label>
    					<input type="radio" name="star-input" id="p6" value="6"><label for="p6">3</label>
    					<input type="radio" name="star-input" id="p7" value="7"><label for="p7">3.5</label>
    					<input type="radio" name="star-input" id="p8" value="8"><label for="p8">4</label>
    					<input type="radio" name="star-input" id="p9" value="9"><label for="p9">4.5</label>
    					<input type="radio" name="star-input" id="p10" value="10"><label for="p10">5</label>
  					</span>
  					 <output for="star-input" style="display:none"><b id="reresult" style="display:none">0</b>점</output>
  				<input type="text" id="starPoint" name="rwGrade" style="width: 100px; height:20px; display:none;" value="0" >
			</span>
		</div>
		
		<br>
	<hr>
	<script>
	// star rating
	var starRating = function(){
	  var $star = $(".star-input"),
	      $result = $star.find("output>b");
	  var num2 = "";
	  
	  $(document)
	    .on("focusin", ".star-input>.input", function(){
	    $(this).addClass("focus");
	  })
	    .on("focusout", ".star-input>.input", function(){
	    var $this = $(this);
	    setTimeout(function(){
	      if($this.find(":focus").length === 0){
	        $this.removeClass("focus");
	      }
	    }, 100);
	  })
	    .on("change", ".star-input :radio", function(){
	    $result.text($(this).next().text());
	  })
	    .on("mouseover", ".star-input label", function(){
	    $result.text($(this).text());
	  })
	    .on("mouseleave", ".star-input>.input", function(){
	    var $checked = $star.find(":checked");
	    if($checked.length === 0){
	      $result.text("0");
	      num2 = 0;
	      $("#starPoint").val(num2);
	    } else {
	      $result.text($checked.next().text());
	      num2 = ($checked.val());
	      $("#starPoint").val(num2);
	    }
	  });
	};
	starRating();
	</script>

			<div class="container2" style="height: 50px; display: -webkit-inline-box;">
				<div class="btn-holder" style="    margin-left: 50px;">
					<button type="submit" class="subButton" id="end" onclick="submitAction();" disabled="disabled" style="width:350px; height: 35px;"> 
						게시물 작성
					</button>
					<button type="reset" class="subButton" onclick="goBack()"  style="width:350px; height: 35px; margin-left: 100px;">
						작성취소
					</button>
				</div>
			</div>

		<script>
		function goBack(){
			 location.href="/triangleView/loginMain"; 

		}
		</script>

</form>
</div>
</body>
</html>