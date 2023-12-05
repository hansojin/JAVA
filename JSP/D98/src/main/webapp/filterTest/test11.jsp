<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <% request.setCharacterEncoding("UTF-8"); %> --%>
<!-- 필터를 거치게 되면서, 한글 인코딩 하므로 위 코드는 필요없음  -->
이름 : ${param.name } <br>
번호 : ${param.tel } <br>
주소 : ${param.addr } <br>
</body>
</html>