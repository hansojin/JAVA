<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name='data_form' method='post' action='../FilterTestServlet'>
		이름 : <input type='text' name='name' /><br /> 
		번호 : <input type='text' name='tel' /><br /> 
		주소 : <input type='text' name='addr' /><br /> 
		<input type='submit' value='전송' />
	</form>
<!-- 얘도 똑같음. filter로 한글 처리되는데 이건 그냥 servlet으로 보낸거 -->
</body>
</html>