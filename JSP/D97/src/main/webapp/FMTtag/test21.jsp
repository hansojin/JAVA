<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${pageContext.request.locale.language}"/><br>
	
	<c:choose>
		<c:when test="${'ko' eq pageContext.request.locale.language}">
			<fmt:setBundle basename="FMTtag.messages"/>
			<fmt:message key="kjh.msg.name"/> : <input type="text" name="name"/><br/>
			<fmt:message key="kjh.msg.age"/> : <input type="text" name="age"/><br/>
		</c:when>
		<c:otherwise>
			<fmt:setBundle basename="FMTtag.en_messages"/>
			<fmt:message key="kjh.msg.name"/> : <input type="text" name="name"/><br/>
			<fmt:message key="kjh.msg.age"/> : <input type="text" name="age"/><br/>
		</c:otherwise>
	</c:choose>
</body>
</html>