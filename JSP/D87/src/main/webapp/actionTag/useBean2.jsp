<%@page import="bean.actionTag.PowTriple"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="cal" class="bean.actionTag.PowTriple" />
	<%
		int m=cal.process(5);
		out.print("5^3 = "+m);
	%>
</body>
</html>