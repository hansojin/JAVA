<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %><%-- exception 내장객체를 쓰기위해서 설정 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>errorPage 디렉티브 태그</h4>
	<h5>exception 내장 객체 변수</h5>
	<%
		exception.printStackTrace(new java.io.PrintWriter(out));
	%>
</body>
</html>