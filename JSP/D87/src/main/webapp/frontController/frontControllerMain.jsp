<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insert.do">insert</a><br><br>

	<a href="http://localhost:8080<%=request.getContextPath()%>/update.do">update</a><br><br>

	<a href="http://localhost:8080/D87/frontController/select.do">select</a><br><br>

	<a href="<%=request.getContextPath()%>/delete.do">delete</a>
</body>
</html>