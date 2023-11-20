<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>THIS IS forwardParam.jsp</p>
	<jsp:forward page="forwardParamTo.jsp">
		<jsp:param value="idid" name="id"/>
		<jsp:param value="pwpw" name="pw"/>
	</jsp:forward>
</body>
</html>