<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="bean.actionTag.Person" scope="request" />
	<jsp:getProperty property="id" name="person"/>
	<jsp:getProperty property="major" name="person"/>
</body>
</html>

<%--
	getProperty 액션 태그의 속성
	속성			설명
	name		useBean 태그에 id 속성 값으로 설정된 자바빈즈를 식별하기 위한 이름이다.
	property	자바빈즈의 프로퍼티 이름이다. 만약 프로퍼티 이름에 "*"를 사용하면 모든 요청
				파라미터가 자바빈즈 프로퍼티의 getter() 메소드에 전달됨을 의미한다.
--%>