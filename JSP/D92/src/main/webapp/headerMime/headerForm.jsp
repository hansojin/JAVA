<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="../HeaderForm">
		NAME : <input type="text" name="name"/><br/>
		STACK<br/>
		<input type="checkbox" name="skill" value="c"/>C<br/>
		<input type="checkbox" name="skill" value="c++"/>PYTHON<br/>
		<input type="checkbox" name="skill" value="java"/>JAVA<br/>
		<input type="checkbox" name="skill" value="jsp"/>PHP<br/>
		<input type="submit" value="SUBMIT"/>
	</form>
</body>
</html>