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
	Cookie cookie = new Cookie("name","JH");
	response.addCookie(cookie);
%>
<a href="EL42.jsp">printCOOKIE</a>
</body>
</html>