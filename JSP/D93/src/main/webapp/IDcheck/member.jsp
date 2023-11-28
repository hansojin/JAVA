<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<style>
input{
	background-color: white;
}
</style>
<body>

<form name="memberRegister" method="post" action="memberRegisterOK.jsp">
	I D : <input type="text" name="id" readonly> 
	<input type="button" onClick="idCheck()" value="중복확인"><br>
	PW : <input type="password" name="password">
	<input type ="submit" value="SUBMIT">
</form>

<script>
	function idCheck(){
		window.open("idCheckForm.jsp", "idCheckForm", "width=400, height=300");
	}
</script>

</body>
</html>