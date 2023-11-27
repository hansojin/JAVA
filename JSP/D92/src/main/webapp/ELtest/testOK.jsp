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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
%>
	
	I D : <%= id %> <br />
	PW : <%= pw %>
	
	<hr>
	
	${param.id} 
	${param["id"]} <br />
	${param.pw }
	${param["pw"]}
	
	<hr />
	
	applicationScope : <%= application.getAttribute("application_name") %><br />
	sessionScope : <%= session.getAttribute("session_name") %><br />
	pageScope : <%= pageContext.getAttribute("page_name") %><br />
	requestScope : <%= request.getAttribute("request_name") %><br />
	
	<hr>
	
	applicationScope : ${ applicationScope.application_name }<br />
	sessionScope : ${ sessionScope.session_name }<br />
	pageScope : ${ pageScope.page_name }<br />
	requestScope : ${ requestScope.request_name }<br />
	
	<hr />
	
	applicationScope : ${ application_name }<br />
	sessionScope : ${ session_name }<br />
	pageScope : ${ page_name }<br />
	requestScope : ${ request_name }<br />
	
	<hr />
	
	* context 초기화 파라미터 <br />
	<%= application.getInitParameter("Name") %> <br />
	<%= application.getInitParameter("Num") %> <br />
	<%= application.getInitParameter("Email") %> <br />
	
	<hr>
	
	${initParam.Name}
	${initParam.Num }
	${initParam.Email }
	
</body>
</html>