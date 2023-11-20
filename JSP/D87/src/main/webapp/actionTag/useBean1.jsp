<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="date" class = "java.util.Date" />
	<% out.println("CURRENT : "); %> 
	<%= date %>
	
</body>
</html>

<%-- 
	useBean 액션 태그의 속성
	속성		설명
	id		자바빈즈를 식별하기 위한 이름
	class	패키지 이름을 포함한 자바빈즈 이름. 자바빈즈는 인수가 없는 기존 생성자가 있어야 하며 추상 클래스를 사용할 수 없다.
	scope	자바빈즈가 저장되는 영역을 설정. page(기본 값), request, session, application 중 하나의 값을 사용
	
	
	useBean 태그는 new 명령문, 즉 새로운 객체를 생성하는 표준 액션 태그

	새로 생성할 클래스의 이름은 class 속성에 지정하며, 생성된 객체를 참조하는 변수의 이름은 id 속성에 지정함

	<jsp:useBean class="HelloBean" id="hello" >
	=== HelloBean hello = new HelloBean(); 
--%>