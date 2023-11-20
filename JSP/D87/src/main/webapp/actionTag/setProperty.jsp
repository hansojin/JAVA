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
	<jsp:setProperty property="id" name="person" value="525" />
	<jsp:setProperty property="major" name="person" value="SHINee"/>
	<% out.println(person.getId()); %>
	<%= person.getMajor() %>
</body>
</html>

<%--
	setProperty 액션 태그의 속성
	속성				설명
	name			useBean 태그에 id 속성 값으로 설정된 자바빈즈를 식별하기 위한 이름
	property		자바빈즈의 프로포티 이름이다. 만약 프로퍼티 이름에 "*"를 사용하면 모든 요청 파라미터가 
					자바빈즈 프로퍼티의 setter() 메소드에 전달됨을 의미한다.
	value			변경할 자바빈즈의 프로퍼티 값이다. 만약 프로퍼티 값이 null 이거나 존재하지 않는 요청
					파라미터인 경우에는 setProperty 액션태그가 무시 됩니다.
	param			자바빈즈의 프로퍼티 값을 전달하는 요청 파라미터의 이름이다. param과 value를 동시에 
					모두 사용할 수 없으며 하나를 선택하여 사용하는 것은 가능하다.
--%>