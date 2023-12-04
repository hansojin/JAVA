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
	
	
	<fmt:setBundle basename="FMTtag.messages"/>
	<fmt:message key="kjh.msg.name"/> : <input type="text" name="name"/><br/>
	<fmt:message key="kjh.msg.age"/> : <input type="text" name="age"/><br/><br>
	
	<fmt:setBundle basename="FMTtag.en_messages"/>
	<fmt:message key="kjh.msg.name"/> : <input type="text" name="name"/><br/>
	<fmt:message key="kjh.msg.age"/> : <input type="text" name="age"/><br/><br>
	
	<fmt:bundle basename="FMTtag.messages" prefix="kjh.msg.">
		<fmt:message key="hello">
			<fmt:param value="KJH"/>
		</fmt:message>
		<br/>
		<fmt:message key="name"/>
	</fmt:bundle>
	
	
</body>
</html>