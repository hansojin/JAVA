<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="boardInputValue" class="boardInputValue.BoardInputValue" scope="page" />
<!-- boardInputValue.BoardInputValue boardInputValue = new boardInputValue.BoardInputValue(); -->
<jsp:setProperty property="*" name="boardInputValue" />

NAME : ${boardInputValue.name }<br>
ID : ${boardInputValue.id }<br>
PW : ${boardInputValue.password }<br>
AGE :${boardInputValue.age }<br>
eMAIL : ${boardInputValue.email }<br>
</body>
</html>