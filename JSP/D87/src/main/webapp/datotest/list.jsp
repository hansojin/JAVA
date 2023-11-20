<%@page import="java.util.ArrayList"%>
<%@page import="datotest.*"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 목록</title>
</head>
<style>
hr{
	width:30%;
	margin-left:0
}
</style>
<body>
<h3>목록</h3><hr>
<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.selectDAO();
	for(int i=0;i<list.size();i++){
		BoardDTO dto = list.get(i);
		out.print("번&nbsp;&nbsp;&nbsp;호 " + dto.getNo()+"<br>");
		out.print("제&nbsp;&nbsp;&nbsp;목 " + dto.getTitle()+"<br>");
		out.print("작성자 " + dto.getName()+"<br>");
		out.print("작성일 " + dto.getWtime()+"<br>");
		out.print("조회수 " + dto.getRcnt()+"<br><hr>");
	}
%>
<br><a href="write.jsp"><span style='font-size: 1.5em;font-weight:bold;margin-left:100px'>글쓰기</span></a>
</body>
</html>