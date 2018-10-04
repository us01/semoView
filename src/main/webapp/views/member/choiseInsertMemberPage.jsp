<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://code.jquery.com/color/jquery.color-2.1.2.js"
	integrity="sha256-1Cn7TdfHiMcEbTuku97ZRSGt2b3SvZftEIn68UMgHC8="
	crossorigin="anonymous">
</script>
<style>
.choiseInsertMemberArea {
	width: 530px;
	height: 280px;
	border-radius: 5px;
	position: fixed;
	background: white;
	margin: 0 auto;
	padding: 10px;
}

.choiseInsertMemberArea p {
	text-align: center;
	font-size: 13px;
}

.divisionLineLeftTop {
	background-color: #efefef;
	height: 1px;
	width: 180px;
	display: inline-block;
	margin-top: 10px;
	float: left;
}

.divisionLineRightTop {
	background-color: #efefef;
	height: 1px;
	width: 180px;
	display: inline-block;
	margin-top: 10px;
	margin-bottom: 20px;
	float: right;
}

.divisionTitle {
	display: inline-block;
	font-size: 13px;
	width: 170px;
	text-align: center;
}

.submitBtn {
	/* width: 199px;
		
		border: none;
		color: #FDEBEC;
		padding: 6px;
		text-align: center;
		text-decoration: none;
		font-size: 14px;
		margin-top: 4px;
		margin-bottom: 4px;
		cursor: pointer;
		border-radius:5px; */
	
}

.insertMember {
	background: url(/triangleView/img/member/personMember.png) 0 0 no-repeat;
	background-size: 250px;
	width: 260px;
	height: 260px;
	display: inline-block;
	position: absolute;
	top: 0;
	left: 10px;
	border: 1px solid white;
	top: 30px;
}

.insertCompany {
	background: url(/triangleView/img/member/companyMember.png) 0 0 no-repeat;
	background-size: 250px;
	width: 260px;
	height: 260px;
	display: inline-block;
	position: absolute;
	top: 0;
	left: 30px;
	border: 1px solid white;
	left: 280px;
    top: 30px;
}
</style>
<script>
	function insertGeneralMemberPageMove() {
/* 		document.getElementById('insertMemberTypeArea').style.display = 'none';
		$(".insertMemberTypeArea").css("margin-left", "-275px");
		$
				.ajax({
					url : "/triangleView/views/member/insertGeneralMemberPage.jsp",
					data : "html",
					success : function(data) {
						$(".insertMemberTypeArea").html(data);
						document.getElementById('insertMemberTypeAearArea').style.display = 'block';
						document.getElementById('insertMemberTypeArea').style.display = 'block';
					}
				}); */
		location.href="/triangleView/views/member/insertGeneralMemberPage.jsp";
	}

	function insertCompanyMemberPageMove() {
		location.href="/triangleView/views/member/insertCompanyMemberPage.jsp";
	}
</script>
</head>
<body>
	<div class="choiseInsertMemberArea">
		<div class="divisionLineLeftTop"></div>
		<div class="divisionTitle">가입 종류</div>
		<div class="divisionLineRightTop"></div>
		<input class="submitBtn insertMember" name = insertMember type="button" 
		 value="" onclick="insertGeneralMemberPageMove()">
		<input class="submitBtn insertCompany" name = insertCompany type="button" value="" onclick="insertCompanyMemberPageMove()">
	</div>
</body>
</html>