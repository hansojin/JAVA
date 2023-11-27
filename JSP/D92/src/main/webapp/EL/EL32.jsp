<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	
	<!-- 초기화 매개변수 ipAddress의 값을 추출한다. -->
<%--<%= application.getInitParameter("ipAddress") %> --%>
	initParam ipAddress : ${ initParam.ipAddress }<br/><br/>
	
	<!-- application 영역의 데이터 uri를 추출한다. -->
	Application URI : ${ applicationScope.uri }<br/><br/>
	<!-- application 영역의 데이터 uri를 추출한다. -->
	Application URI : ${ uri }<br/><br/>
	
	<!-- session 영역의 데이터 id와 pw를 추출한다. -->
	Session 아뒤 : ${ sessionScope.id }<br/>
	Session 비번 : ${ sessionScope.pw }<br/><br/>
	<!-- session 영역의 데이터 id와 pw를 추출한다. -->
	Session 아뒤 : ${ id }<br/>
	Session 비번 : ${ pw }<br/><br/>
	
	<!-- request Parameter인 name과 addr을 추출한다. -->
	Request 이름 : ${ param.name }<br/>
	Request 주소 : ${ param.addr }<br/><br/>
	
	<!-- session 영역의 배열을 하나씩 추출한다. -->
	0번 과목 : ${ sessionScope.subject[0] }<br/>
	1번 과목 : ${ sessionScope.subject[1] }<br/>
	2번 과목 : ${ sessionScope.subject[2] }<br/><br/>
	<!-- session 영역의 배열을 하나씩 추출한다. -->
	0번 과목 : ${ subject[0] }<br/>
	1번 과목 : ${ subject[1] }<br/>
	2번 과목 : ${ subject[2] }<br/><br/>
	
	<!-- 
	request Parameter인 language를 배열로 추출한다.
	일단은 두개만 선택하여 결과를 확인하면 마지막 부분은 공백이 출력될 것이다. 
	-->
	0번 선택 내용 : ${ paramValues.language[0] }<br/>
	1번 선택 내용 : ${ paramValues.language[1] }<br/>
	2번 선택 내용 : ${ paramValues.language[2] }<br/>
</body>
</html>