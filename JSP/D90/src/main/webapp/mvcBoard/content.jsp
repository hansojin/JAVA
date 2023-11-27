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
<form method='post' action='modify.do'>
	<table border='1' style='border-collapse: collapse'>
		<caption>POST CONTENT</caption>
		<tr>
			<td id='tag'>No</td>
			<td>
				${dto.no}
			</td>
			<input type='hidden' name='no' id='no' value= '${dto.no}' >
		</tr>
		<tr>
			<td id='tag'>View</td>
			<td>
				${dto.hit}
			</td>
			<input type='hidden' name='hit' id='hit' value= '${dto.hit}' >
		</tr>
		<tr>
			<td id='tag'>Name</td>
			<td>
				<input type='text' name='name' id='name' value = '${dto.name}' required>
			</td>
		</tr>
		<tr>
			<td id='tag'>Title</td>
			<td>
				<input type='text' name='title' id='title' value = '${dto.title}'  required>
			</td>
		</tr>
		<tr>
			<td id='tag'>Content</td>
			<td>
				<textarea name='contents' id='contents' cols="50" rows='5'>${dto.contents}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan='2'>
				<input type='submit' value='SUBMIT' style='background-color:white; width:100px; margin-left:110px; font-weight: bold'>
				<a href='view.do'>HOME</a>
				<a href='delete.do?no=${dto.no}'>DELETE</a>
				<a href='reply.do?no=${dto.no}'>REPLY</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>