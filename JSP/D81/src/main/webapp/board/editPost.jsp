<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>

<table border='1'>
	<caption style='font-weight:bold; margin:10px; font-size:1.2em'>수정하기</caption>
	<tr>
		<td>Title</td>
		<td>&nbsp;<%= request.getParameter("title") %></td>
	</tr>
	<tr>
		<td>Writer</td>
		<td>&nbsp;<%= request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>Date</td>
		<td>&nbsp;<%= request.getParameter("date") %></td>
	</tr>
	<tr>
		<td colspan='2' style='height:150px; font-weight:400; text-align:start'><%= request.getParameter("content") %></td>
	</tr>
</table>

</body>
</html>