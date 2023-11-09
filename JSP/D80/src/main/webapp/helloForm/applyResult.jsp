<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>APPLY RESULT PAGE</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String pw2 = request.getParameter("pw2");
	String email = request.getParameter("email");
	String[] hobby = request.getParameterValues("hobby");
	String major = request.getParameter("major");
	String mobileCarrier = request.getParameter("mobileCarrier");
	
	out.print("name :&nbsp;"+name + "<br>");
	out.print("id :&nbsp;"+id + "<br>");
	out.print("pw :&nbsp;"+pw + "<br>");
	out.print("pw2 :&nbsp;"+pw2 + "<br>");
	out.print("email :&nbsp;"+email + "<br>");
	out.print("hobby :&nbsp;"+Arrays.toString(hobby) + "<br>");
	out.print("major :&nbsp;"+major + "<br>");
	out.print("mobileCarrier :&nbsp;"+mobileCarrier + "<br>");
	
%>
</body>
</html>