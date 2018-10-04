<script src="/triangleView/js/jquery-3.3.1.min.js"></script>
<%
	String msg = request.getParameter("msg");
%>
<script>
	$(function(){
		<% if(msg != null){ %>
			alert(<%= msg %>);	
		<% } %>
		
		location.href="<%= request.getContextPath()%>/logoutMain.rl";
	});
</script>