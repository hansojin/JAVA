<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 속성보기</title>
</head>
<body>
<%
	Enumeration<String> attributes = application.getAttributeNames();
	while (attributes.hasMoreElements()){
		String name = (String)attributes.nextElement();
		Object values = application.getAttribute(name);
%>
		[ application 속성 ] <b><%=name %></b> : <%= values %><br>
<% 
	}
%>
</body>
</html>