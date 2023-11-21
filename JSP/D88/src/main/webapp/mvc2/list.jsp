<%@page import="mvc2.dto.BoardDTO"%>
<%@page import="mvc2.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvc2.*"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 목록</title>
</head>
<style>
	table{
		width:50%;
	}
</style>
<body>
<h3>목록</h3>
<table border='1' style='border-collapse: collapse'>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>제목</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.selectDAO();
	for(int i=0;list != null && i<list.size();i++){
		BoardDTO dto = list.get(i);
%>
	<tr>
		<td style='text-align: center'><%=dto.getNo() %></td>
		<td><%=dto.getName() %></td>
		<td><a href="<%=request.getContextPath()%>/content.do?no=<%=dto.getNo()%>"><%=dto.getTitle() %></a></td>
		<td><%=dto.getWtime() %></td>
		<td style='text-align: center'><%=dto.getHit() %></td>
	</tr>
<%
	}
%>
	<tr>
		<td colspan="5">
			<a href="<%=request.getContextPath()%>/write.do">글쓰기</a>
		</td>
	</tr>
</table>
</body>
</html>