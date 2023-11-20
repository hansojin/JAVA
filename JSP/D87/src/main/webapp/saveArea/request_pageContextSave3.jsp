<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>request와 pageContext 차이 알아보기</h4>
	<%
		request.setAttribute("id", "525");
		pageContext.setAttribute("name","JH");
	%>
	request : <%=request.getAttribute("id")%><br>
	pageContenxt : <%=pageContext.getAttribute("name") %><br><br>
	
	<jsp:forward page="request_pageContextGet.jsp" />
<!-- 	request : 525
		pageContext : null  -->
</body>
</html>