<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:choose>
    <c:when test="${empty sessionScope.id}">
        <form method='post' action='loginLogic.do'>
            I D : <input type='text' name='id' required><br>
            PW : <input type='password' name='pw' required><br>
            <input type='submit' value='SUBMIT' style='background-color:white;width:200px'><br>
            <a href="register.do">REGISTER</a>
        </form>
    </c:when>
    <c:otherwise>
        WELCOME <strong>${sessionScope.id}</strong><br>
        <a href='logoutLogic.do'>LOGOUT</a><br>
        <a href='info.do?id=${id }'>MODIFY</a><br>
        <a href='list.do'>BULLETIN</a>
    </c:otherwise>
</c:choose>
<c:if test="${not empty sessionScope.loginError and sessionScope.loginError eq 'true'}">
    <script>
        alert("Please check your login information.");
        ${sessionScope.remove("loginError")};
    </script>
</c:if>
</body>
</html>