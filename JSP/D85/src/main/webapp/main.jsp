<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if (id==null){
%>
		<form method='post' action='LoginOK'>
			I D : <input type='text' name='id'><br>
			PW : <input type='password' name='password'><br><br>
			<input type='submit' value='SUBMIT' style='background-color:white;'>
			<a href="memberRegister.jsp">REGISTER</a>
		</form>
<% 
	}else{
%>
		WELCOME <%=id %><br>
		<a href='Logout'>LOGOUT</a>
		<a href='memberModify.jsp'>MODIFY</a>
<% 		
	}
%>
</body>
</html>