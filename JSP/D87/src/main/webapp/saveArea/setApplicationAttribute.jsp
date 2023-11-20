<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application 속성 지정</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String value = request.getParameter("value");
	if (name!=null && value!=null){
		application.setAttribute(name, value);
%>
		application 기본 객체의 속성 설정<br>
		<%=name %> : <%=value %>
<% 
	}else{
%>
		application 기본 객체의 속성 설정 안함
<%
	}
%>

</body>
</html>