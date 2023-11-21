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
<title>글보기</title>
</head>
<style>
td{
	padding:5px;
}
</style>
<body>
<form method='post' action="<%=request.getContextPath()%>/replyInsert.do">
	<table border='1' style='border-collapse: collapse'>
		<tr>
			<td>번호</td>
			<td> ${boardDTO.no}</td>
			<input type='hidden' name='no' value='${boardDTO.no}'>
		</tr>
		<tr>
			<td>조회수</td>
			<td> ${boardDTO.hit}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type='text' name='name' id='name' required></td>
		</tr>
		<tr>
			<td>제목</td>
			<td> - re : ${boardDTO.title}</td>
			<input type='hidden' name='title' value='-&nbsp;re&nbsp;${boardDTO.title}'>
		</tr>
		<tr> 
			<td>내용</td>
			<td>
  				<textarea name='contents' id='contents' rows="5" cols="50">

-&nbsp;re&nbsp;:&nbsp;${boardDTO.contents}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type='submit' value="답변" style='background-color: white; margin-left:160px'>
				<a href="<%=request.getContextPath()%>/list.do">목록</a>
				<a href="<%=request.getContextPath()%>/delete.do?no=${boardDTO.no}" >삭제</a>
				<a href="<%=request.getContextPath()%>/reply.do?no=${boardDTO.no}">답변</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>