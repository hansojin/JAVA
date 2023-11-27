<%@page import="mvcBoard.dao.BoardDAO"%>
<%@page import="mvcBoard.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border='1' style='border-collapse: collapse; width:60%'>
	<tr>
		<th>No</th><th>Name</th><th>Title</th><th>Date</th><th>View</th>
	</tr>
<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.selectAll();
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
		<td colspan="5" >
			<a href='write.do'><span style='margin-left:42%; font-weight: bold'>WRITE POST</span></a>
		</td>
	</tr>
</table>
</body>
</html>