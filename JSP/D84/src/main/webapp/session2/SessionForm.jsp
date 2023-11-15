<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("id");
	if(id==null)
	{
%>
<form method="post" action="SessionFormOK.jsp">
	I D : <input type="text" name="id"><br>
	PW : <input type="password" name="password"><br>
	<input type="submit" value="LOGIN">
<%
	}
	else{
%>
		<%=id %>님 환영합니다.<br>
		세션 유효시간 : <%= session.getMaxInactiveInterval() %>초
<%
	}
%>
</form>
</body>
</html>