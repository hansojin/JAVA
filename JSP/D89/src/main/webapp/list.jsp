<%@page import="java.util.ArrayList"%>
<%@page import="mvc2.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
</head>
<body>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>조회수</td>
	</tr>
<%
	for(int i=0;list != null && i<list.size();i++){
		BoardDTO dto = list.get(i);
%>
	<tr>
		<td><%=dto.getNum() %></td>
		<td><%=dto.getName() %></td>
		<td>
			<%
				int indentNum = dto.getIndentNum();
				for(int j=0;j<indentNum;j++)
					out.println("-");
			%>
			<a href="view.do?num=<%=dto.getNum()%>"><%=dto.getTitle() %></a>
		</td>
		<td><%=dto.getWtime() %></td>
		<td><%=dto.getHit() %></td>
	</tr>	
<%
	}
%>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>
</body>
</html>