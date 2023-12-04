<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!-- 전송된 데이터에 대한 한글 처리 -->
<fmt:requestEncoding value="utf-8"/>

<!-- 한국 지역으로 한국어를 지정한다. -->
<fmt:setLocale value="ko_KR"/>

<!--  특정 영역에 표준 시간대를 지정하는 태그 -->
<fmt:setTimeZone value="Asia/Seoul"/>

<c:set var="str" value="Hello" scope="request"/>
<c:set var="str2" value="World" scope="session"/>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Requested Data1 : ${ param.data }<br/>
	Requested Data2 : ${ param.data2 }<br/><br/>
	
	str : <c:out value="${ requestScope.str }" /><br/>
	str2 : <c:out value="${ sessionScope.str2 }" /><br/><br/>	

	<c:set var="date" value="<%= new java.util.Date() %>"/>
	
	<fmt:formatDate value="${ date }" pattern="yyyy-MM-dd hh:mm a z"/><br/>
	
	<fmt:timeZone value="US/Eastern">
		<fmt:formatDate value="${ date }" pattern="yyyy-MM-dd hh:mm a z"/><br/> 
	</fmt:timeZone>

</body>
</html>