<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> one </p>
	<jsp:include page="include2.jsp" flush='false' />
	<p> one </p>
</body>
</html>

<%-- <jsp:include> 액션태그의 경우, 
jsp 흐름을 내부적으로 두개의 페이지가 순서대로 각각 처리되는 방식인 반면, 
include 디렉티브인 경우에는 두개의 코드 자체를 하나의 jsp 페이지에 합쳐 처리--%>