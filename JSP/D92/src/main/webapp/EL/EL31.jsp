<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//application 영역에 데이터를 추가한다.
	application.setAttribute("uri", request.getRequestURI());

	//session 영역에 id와 pw를 추가한다.
	session.setAttribute("id", "hong");
	session.setAttribute("pw", "1234");
	
	String[] subject = new String[]{"KOR", "ENG", "MATH"};
	session.setAttribute("subject", subject);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request Param으로 name과 addr을 전송한다. -->
	<form method="post" action="EL32.jsp">
		NAME : <input type="text" name="name"/><br/>
		ADDR : <input type="text" name="addr"/><br/>
		LANG : <input type="checkbox" name="language" value="c"/>C
			&nbsp;<input type="checkbox" name="language" value="java"/>JAVA
			&nbsp;<input type="checkbox" name="language" value="basic"/>BASIC<br/>
		<input type="submit" value="SUBMIT" style='background-color: white; width:260px'/>
	</form>
</body>
</html>