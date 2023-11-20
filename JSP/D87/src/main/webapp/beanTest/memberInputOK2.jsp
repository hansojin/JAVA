<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:useBean id="memberDTO" class="bean.beanTest.MemberDTO" />
	
	<jsp:setProperty property="name" name="memberDTO" />
	<jsp:setProperty property="id" name="memberDTO" />
<!-- input form 에서의 이름과 useBean내의 property의 이름이 같다면, value 생략 가능 -->

	name : <jsp:getProperty property="name" name="memberDTO"/><br>
	ID : <jsp:getProperty property="id" name="memberDTO"/>
</body>
</html>