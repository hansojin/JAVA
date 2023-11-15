<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<h3>SessionTest 페이지 입니다.</h3>
<script>
function expireSession()
{
  location.href = "SessionForm.jsp";
}
setTimeout(expireSession, <%= session.getMaxInactiveInterval() * 1000 %>);
</script>
</body>
</html>