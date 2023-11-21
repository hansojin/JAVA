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
<title>글쓰기</title>
</head>
<style>
td{
	padding:5px;
}
</style>
<body>
<form method='post' action="<%=request.getContextPath()%>/insert.do">
	<table border='1' style='border-collapse: collapse'>
		<tr>
			<td>이름</td>
			<td><input type='text' name='name' id='name' required>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type='text' name='title' id='title' required>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name='contents' id='contents' rows="5" cols="50" required></textarea>
		</tr>
		<tr>
			<td colspan="2">
				<input type='submit' value="입력" style='background-color: white; margin-left:200px'>
				<a href="<%=request.getContextPath()%>/list.do">목록</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>