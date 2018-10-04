<%@page import="com.chain.triangleView.member.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	.modifyPwdArea {
		width:300px;
		height:220px;
		background:white;
		text-align: -webkit-center;
	}
	.submitBtn {
		width: 280px;
		background-color: #f8585b;
		border: none;
		color: #FDEBEC;
		padding: 6px 0;
		text-align: center;
		text-decoration: none;
		font-size: 14px;
		margin-top: 4px;
		margin-bottom: 4px;
		cursor: pointer;
		border-radius:5px;
	}
	.modifyTableArea {
		
	}
	.modifyTableArea tr {
		font-size:12px;
		height:50px;
	}
	.modifyTableArea td:first-child {
		width:100px;
		text-align:center;
	}
	.modifyTableArea input[type='password'] {
		width:170px;
	}
</style>
<script>
	
</script>
<body>
	<div class="modifyPwdArea">
		<form action="<%= request.getContextPath() %>/modifyPwd.me" method="post">
			<table class="modifyTableArea">
				<tr>
					<td>
						아이디
					</td>
					<td>
						<%= loginUser.getUserId() %>
					</td>
				</tr>
				<tr>
					<td>
						기존 비밀번호
					</td>
					<td>
						<input type="password" name="userPwdCheck">
					</td>
				</tr>
				<tr>
					<td>
						변경할 비밀번호
					</td>
					<td>
						<input type="password" name="userPwd">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input class="submitBtn" type="submit" value="변경"> 
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>