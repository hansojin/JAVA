<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="bean.actionTag.Person" scope="request" />
	<jsp:setProperty property="id" name="person" value="365"/>
	<jsp:setProperty property="major" name="person" value="jp"/>
	<jsp:getProperty property="id" name="person"/>
	<jsp:getProperty property="major" name="person"/>
</body>
</html>