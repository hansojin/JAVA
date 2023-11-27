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
	String name = "JH";
	int age = 27;
	request.setAttribute("name",name);
	request.setAttribute("age",age);
	RequestDispatcher dispatcher = request.getRequestDispatcher("EL22.jsp");
	dispatcher.forward(request, response);
%>
</body>
</html>