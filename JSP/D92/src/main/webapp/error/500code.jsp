<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	h1{
	color:red;
	}
</style>
<body>
<%
    response.setStatus(HttpServletResponse.SC_OK);
%>
    <h1>500 ERROR</h1>
    <h2>요청 문서에 문법적인 에러가 있습니다</h2>
    <h3>프로그램의 코드를 확인해 주세요</h3>
</body>
</html>