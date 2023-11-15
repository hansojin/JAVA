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
	String id = (String)session.getAttribute("id");
	if (id!=null){
%>
		current user ID : <%=id %>
<%
	}else{
%>
		<script>
			alert("INVALID ACCESS");
			location.href='login.jsp';
		</script>
<%
	}
%>
</body>
</html>