<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4> request와 pageContext 정보 가져오기 </h4>
	request : <%=request.getAttribute("id") %><br/>
	pageContext : <%=pageContext.getAttribute("name") %> <br/>	
</body>
</html>