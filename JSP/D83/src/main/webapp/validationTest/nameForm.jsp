<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = 'nameForm' method='post' action='nameCheck.jsp'>
	<label for = 'name'>NAME&nbsp;</label>
	<input type='text' id='name' name='name'>
	<input type='button' value='SUBMIT' onclick='checkName()'>
</form>
<script>
	function checkName(){
		var nameForm = document.nameForm;
		
		if (nameForm.name.value=="")
			alert("ENTER NAME");
		else
			nameForm.submit();
		
	}
</script>
</body>
</html>