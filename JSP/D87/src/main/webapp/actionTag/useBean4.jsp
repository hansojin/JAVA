<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class = "bean.actionTag.Person" scope="request"/>
	
	<jsp:include page="useBean3.jsp" />
	<%
		person.setId(123456789);
		person.setMajor("software");
	%>
	<br>
	<%= person.getId() %>
	<%= person.getMajor() %>
</body>
</html>