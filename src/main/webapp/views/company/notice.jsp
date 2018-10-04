<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.insertMemberTypeArea {
		z-index: 300;
   		position: absolute;
   		left: 50%;
   		margin-left:-150px;
    	top: 150px;
	}
</style>




<script>
function insertMemberTypeDisplayNone() {
	document.getElementById('insertMemberTypeArea').style.display = 'none';
	document.getElementById('insertMemberTypeAearArea').style.display = 'none';
}
</script>
</head>
<body>
<div id="insertMemberTypeArea" class="insertMemberTypeArea"></div>
	<div id="insertMemberTypeAearArea" class="w3-modal" onclick="insertMemberTypeDisplayNone();"></div>
</body>
</html>