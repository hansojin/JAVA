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
	<%= person.getId() %>
	<%= person.getMajor() %>
</body>
</html>