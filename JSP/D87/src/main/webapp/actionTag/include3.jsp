<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> three </p>
	<jsp:include page="include4.jsp">
		<jsp:param value="idid" name="id"/>
		<jsp:param value="pwpw" name="pw"/>
	</jsp:include>
</body>
</html>

<!-- 출력 : three \n id \n pw -->