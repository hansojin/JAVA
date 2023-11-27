<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="EL12.jsp">
		<label for="name">이름</label><input type="text" name="name" id="name"><br>
		
		<label for="male">남</label><input type="radio" name="sex" value="male" id="male" checked>
		<label for="female">여</label><input type="radio" name="sex" value="female" id="female"><br>
		
		<label for="swimming">수영</label><input type="checkbox" name="hobby" value="swimming" id="swimming">
		<label for="jogging">조깅</label><input type="checkbox" name="hobby" value="jogging" id="jogging">
		<label for="reading">독서</label><input type="checkbox" name="hobby" value="reading" id="reading"><br>
		
		<input type="submit" value="전송"> <input type="reset" value="초기화"><br>
	</form>
</body>
</html>