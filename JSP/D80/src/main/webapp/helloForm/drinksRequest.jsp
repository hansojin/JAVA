<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.net.URLEncoder"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drinks Request PAGE</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String strAge = request.getParameter("age");
	
	String encodedName = URLEncoder.encode(name, "UTF-8");
	int age = Integer.parseInt(strAge);
	
	if (age>=20){
		response.sendRedirect("drinksPass.jsp?name=" + encodedName + "&age=" + strAge);
	}else{
		response.sendRedirect("drinksNPass.jsp?name=" + encodedName + "&age=" + strAge);
	}
%>
</body>
</html>