<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!-- 상단의 page 디렉티브의 session 속성이 false인것을 볼 수 있는데, 
이는 JSP 페이지에서 이 값을 false로 명시하지 않는 경우 기본적으로 세션을 생성하기 때문임 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="main.jsp" method="post">
    	I D : <input type="text" name="id"><br>
        PW : <input type="password" name="password"><br>
        <input type="submit" value="로그인" style='background-color:white'>
     </form>
</body>
</html>