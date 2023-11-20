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
	
	<jsp:setProperty property="*" name="memberDTO" />
<!-- 모든 변수를 다 가져올거라면 * 로 표기 가능
	 단, input form 에서의 name 과 get에서의 property 이름은 동일해야함 -->
	 
	name : <jsp:getProperty property="name" name="memberDTO"/><br>
	ID : <jsp:getProperty property="id" name="memberDTO"/>
</body>
</html>