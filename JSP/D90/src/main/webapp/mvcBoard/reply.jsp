<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
#tag {
	font-weight: bold;
	text-align: center;
}
td{ 
	padding:3px;
}
caption{
	font-weight: bold;
}
</style>
<%
	
%>
<form method='post' action='replyOK.do'>
	<table border='1' style='border-collapse: collapse'>
		<caption>REPLY CONTENT</caption>
		<tr>
			<td id='tag'>Name</td>
			<td>
				<input type='text' name='name' id='name' required>
				<input type='hidden' name='parentNo' id='parentNo' value='${dto.no}'>
			</td>
		</tr>
		<tr>
			<td id='tag'>Title</td>
			<td>
				<input type='text' name='title' id='title' value =-re&nbsp;${dto.title}  required>
			</td>
		</tr>
		<tr>
			<td id='tag'>Content</td>
			<td>
				<textarea name='contents' id='contents' cols="50" rows='5'>

-re&nbsp;${dto.contents}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<input type='submit' value='SUBMIT' style='background-color:white; width:100px; margin-left:110px; font-weight: bold'>
				<a href='view.do'>HOME</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>