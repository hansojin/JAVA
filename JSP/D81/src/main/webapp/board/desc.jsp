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
	<caption style='font-weight:bold; margin:10px; font-size:1.2em'>내용보기</caption>
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
<div style='margin-top:15px'>
	<button style='margin-left:75px;float:left '><a href='mainBoard.jsp' style='text-decoration: none;text-align: center'>HOME</a></button>
	<form action="pwModify.jsp" method="post">
	<input type="hidden" name="num" value="<%= request.getParameter("num") %>">
    <input type="hidden" name="title" value="<%= URLEncoder.encode(request.getParameter("title"), "UTF-8") %>">
    <input type="hidden" name="name" value="<%= URLEncoder.encode(request.getParameter("name"), "UTF-8") %>">
    <input type="hidden" name="pw" value="<%= request.getParameter("pw") %>">
    <input type="hidden" name="email" value="<%= request.getParameter("email") %>">
    <input type="hidden" name="date" value="<%= request.getParameter("date") %>">
    <input type="hidden" name="view" value="<%= request.getParameter("view") %>">
    <input type="hidden" name="content" value="<%= URLEncoder.encode(request.getParameter("content"), "UTF-8") %>">
    <button type="submit" style='float:left'>MODIFY</button>
</form>
<form action="pwDelete.jsp" method="post">
	<input type="hidden" name="num" value="<%= request.getParameter("num") %>">
    <input type="hidden" name="pw" value="<%= request.getParameter("pw") %>">
    <button type="submit" style='float:left'>DELETE</button>
</form>
	
</div>
<%

        String num = request.getParameter("num");
        String view = request.getParameter("view");
        String viewPlus = Integer.toString(Integer.parseInt(view));
        request.getRequestDispatcher("viewLogic.jsp?num=" + num + "&view=" + viewPlus).include(request, response);
    %>
</body>
</html>