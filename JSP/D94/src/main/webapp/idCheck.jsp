<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 아이디 중복체크 </h3>
	<form method="post" action="idCheckOK.do" onsubmit="return blankCheck(this)">
		아이디 : <input type="text" name="id" maxlength="10" autofocus>
		<input type="submit" value="중복확인">
	</form>

	<script>
	function blankCheck(form){
		var id=form.id.value;
		id=id.trim();
		if(id.length==0){
			alert("ID REQUIRED");
			return false;
		}
		return true;
	}
	</script>
</body>
</html>