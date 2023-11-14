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
	span{
		margin-left:250px;
	}
</style>
<body>
<h3>목록</h3>
<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
	</tr>
<%@ include file='mysqlInfo.jsp' %>	
<%
	String sql = "Select no, title, name, wTime, rCnt, email from BOARD2 ORDER BY no DESC";
	String cntSql = "select count(*) from board2";
	int postCnt=0;
	try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			Statement st = conn.createStatement();
			ResultSet rs2 = st.executeQuery(cntSql)){
		while(rs.next()){
%>
			<tr>
				<td><%=rs.getInt("no") %></td>
				<td><a href="view.jsp?no=<%=rs.getInt("no")%>"><%=rs.getString("title") %></a></td>
				<td><a href="mailto:<%=rs.getString("email")%>"><%=rs.getString("name")%></a></td>
				<td><%=rs.getString("wTime")%></td>
				<td><%=rs.getString("rCnt")%></td>
			</tr>
<%			
		}
		if (rs2.next()){
			postCnt = rs2.getInt(1);
		}
	}  catch(SQLException e){
		e.printStackTrace();
	}
%>
</table>
<div>
<a href="write.jsp">글쓰기</a>
<span>총 : <%= postCnt %></span>
</div>
</body>
</html>