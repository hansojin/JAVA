<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name", "JH");
		response.sendRedirect("result.jsp");
	%>
<!--  	(출력) 	NAME : null  
		왜냐면, 새요청을 만들기 때문에, 원래 요청 속성이 전달되지 않음 -->
</body>
</html>