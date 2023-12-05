<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileFormOk.jsp" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"><br />
		파일1 : <input type="file" name="file1"><br />
		파일2 : <input type="file" name="file2"><br />
		<input type="submit" value="Upload">
	</form>
</body>
</html>