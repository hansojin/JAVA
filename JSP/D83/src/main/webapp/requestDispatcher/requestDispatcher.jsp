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
	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request, response);
%>
<!-- 	(출력) NAME : JH  
		이 경우에는, 현재 요청을 유지하고 새로운 페이지로 제어를 전달하기 때문에, 한번의 요청 = 즉, 속성이 전달됨 -->

</body>
</html>