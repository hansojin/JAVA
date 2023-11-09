<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	NAME : <%=request.getParameter("name") %><br>
	CODE : <%=request.getParameter("secret") %>
	<!-- url : method/postTwo.jsp -->
</body>
</html>

