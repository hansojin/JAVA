<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>ContextParam 모든 서블릿이 공유한다</h4>
	NAME : <%= application.getInitParameter("Name") %>
</body>
</html>