<%@page import="java.util.Enumeration"%>
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
	request.setCharacterEncoding("UTF-8");
	Enumeration<String> names = request.getParameterNames();
	while (names.hasMoreElements()){
		String name = names.nextElement();
		String[] values = request.getParameterValues(name);
		out.write(name + " : ");
		for (int i=0;i<values.length;i++)
			out.write(values[i]+ " ");
		out.write("<br>");
	}
%>
</body>
</html>