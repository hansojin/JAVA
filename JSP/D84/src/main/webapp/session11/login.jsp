<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span{
	font-weight: bold;
}
</style>
</head>
<body>
<form method='post' action='loginChk.jsp'>
<%
	String id= (String)session.getAttribute("id");
	if (id==null){
%>
	ID : <input type='text' name='id'>
	PW : <input type='password' name='password'>
	<input type='submit' value="LOGIN" style='background-color:white'>
<%
	}else{
%>
		hello <span><%=id %></span><br>
		<a href= 'logout.jsp'>LOGOUT</a>
<%
	}
%>
<br><a href='loginTest.jsp'>LOGIN TEST</a>
</form>
</body>
</html>