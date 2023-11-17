<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>requestDispatcherInclude PAGE</h1>
<%
	out.flush();
	RequestDispatcher dispatcher = request.getRequestDispatcher("requestDispatcherIncludeResult.jsp");
	dispatcher.include(request, response);
%>
</body>
</html>

