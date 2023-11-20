<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" class="bean.beanTest.Student" scope="page" />
	<jsp:setProperty property="name" name="student" value="JH"/>
	<jsp:setProperty property="age" name="student" value="28"/>
	<jsp:setProperty property="grade" name="student" value="3"/>
	<jsp:setProperty property="stuNum" name="student" value="948"/>
	<%= student.getName() %>
	<%= student.getAge() %>
	<%= student.getGrade() %>
	<%= student.getStuNum() %>
</body>
</html>