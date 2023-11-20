<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>hello</p>
	<jsp:forward page="forwardTo.jsp" />
<%-- 	<jsp:forward page="forwardTo.jsp"></jsp:forward> --%>

</body>
</html>

<!-- link 	 : forwardTest.jsp -->
<!-- content : world -->

<!-- 액션 태그는 서버나 클라이언트에게 어떤 행동을 하도록 명령하는 태그로 
스크립트 태그, 주석, 디렉티브 태그와 함께 JSP 페이지를 구성하는 태그로 <jsp: ## /> 형태로 작성

표준 액션 태그 종류 : forward, include, attribute, body, element, fallback, output,
				getProperty, setProperty, param, params, plugin, useBean
-->