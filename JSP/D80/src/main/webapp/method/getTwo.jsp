<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	NAME : <%= request.getParameter("name") %><br>
	AGE : <%= request.getParameter("age") %>
	<!-- url : method/getTwo.jsp?name=kim&age=28 -->
</body>
</html>

