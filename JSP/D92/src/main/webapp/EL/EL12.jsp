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
${param.name} <br>
${param.sex} <br>
${paramValues.hobby[0]} ${paramValues.hobby[1]} ${paramValues.hobby[2]}<br>
${paramValues["hobby"][0]} ${paramValues["hobby"][1]} ${paramValues["hobby"][2]}<br>
</body>
</html>