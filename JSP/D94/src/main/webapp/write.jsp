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
<form method="post" action="writeLogic.do">
		<table border="1">
			<input type='hidden' name='id' value=${id }>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="contents" cols="100" rows="15"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력"> 
				<a href="list.do">목록</a></td>
			</tr>
		</table>
	</form>
</body>
</html>