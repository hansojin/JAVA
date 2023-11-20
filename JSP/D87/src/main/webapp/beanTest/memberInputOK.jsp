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
		String name = request.getParameter("name");
		String id = request.getParameter("id");
	%>
	<jsp:useBean id="memberDTO" class="bean.beanTest.MemberDTO" />
	<jsp:setProperty property="name" name="memberDTO" value="<%=name%>"/>
	<jsp:setProperty property="id" name="memberDTO" value="<%=id%>"/>
	name : <jsp:getProperty property="name" name="memberDTO"/><br>
	ID : <jsp:getProperty property="id" name="memberDTO"/>
</body>
</html>