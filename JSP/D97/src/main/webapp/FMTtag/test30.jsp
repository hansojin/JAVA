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
	number type  : <fmt:formatNumber value="1234.56" type="number"/><br/>	<!--  숫자로 1,234.56을 출력 -->
	currency type : <fmt:formatNumber value="1234.56" type="currency" currencySymbol="$"/><br/> <!-- 달러로 $1,234.56을 출력 -->
	percent type : <fmt:formatNumber value="1234.56" type="percent"/><br/> <!-- 퍼센트로 1,234.56을 출력 -->
	pattern type : <fmt:formatNumber value="1234.567" pattern="#,###.0"/><br/>	<!-- 사용자 정의 패턴으로 1,234.5을 출력 -->
	max digits : <fmt:formatNumber value="1234.56" maxIntegerDigits="3"/><br/>	<!-- 정수부의 최대 수가 3이므로 234.56을 출력 -->
	max fractions : <fmt:formatNumber value="1234.56" maxFractionDigits="1"/><br/>	<!-- 소수부의 최대 수가 1이므로 1,234.6(자동 반올림)이 출력 -->
	parse number : <fmt:parseNumber value="1234.56" integerOnly="true"/><br/><br/><hr/><br/> <!-- 정수부만 출력 1234 -->
	
	<c:set var="datetime" value="<%= new java.util.Date() %>" scope="request"/>
	normal type : <c:out value="${datetime}"/><br/>
	time type : <fmt:formatDate value="${datetime}" type="time" timeStyle="full"/><br/>	<!-- 시간 -->
	date type : <fmt:formatDate value="${datetime}" type="date" dateStyle="full"/><br/> <!-- 날짜 -->
	both type : <fmt:formatDate value="${datetime}" type="both" dateStyle="full" timeStyle="full"/><br/> <!-- 시간,날짜 -->
	pattern type : 
		<fmt:parseDate value="20100216201524" pattern="yyyyMMddHHmmss" var="mydate"/> <!-- 포맷 지정하여 출력 -->
		<fmt:formatDate value="${ mydate }" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>