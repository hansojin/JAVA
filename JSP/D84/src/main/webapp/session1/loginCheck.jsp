<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#submitBtn{
	background-color:white;
}
</style>
<body>

<%
	String ID = "123";
	String PW = "123";
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if (ID.matches(id)){
		out.print("hello " + id);
	%>
		<form method='post' action='login.jsp'>
			<input type='submit' value='logout' id = 'submitBtn'>
		</form>
	<% 
	}
	else
		response.sendRedirect("login.jsp");
	
%>

</body>
</html>