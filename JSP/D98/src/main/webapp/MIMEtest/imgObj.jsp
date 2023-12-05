<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h4>이미지 객체를 출력하는 태그를 사용하여 이미지 출력</h4>
<img src="<%=request.getContextPath()%>/IMGServlet"/>
<!-- 우리가 익히 알고 있는 웹 프로그램은 그 자체가 주로 HTML과 같은 형태를 띤다. 
	그래서 보통 서블릿과 같은 웹 프로그램을 웹 페이지로 착각하는 경우가 많다. 
	그러나 서블릿은 그 자체가 웹 페이지일 수도 있지만 이미지일 수도 있고, MS 워드일 수도 있다. 
	다시 말해, MIME의 설정에 따라 웹 서버가 서블릿을 전혀 다른 형태로 인식할 수 있다는 것이다. -->
</body>
</html>