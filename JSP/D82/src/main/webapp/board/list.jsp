<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시판 목록</title>
</head>
<body>
<h3>목록</h3>
<table border="1">
	<tr>
		<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
	</tr>
<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
	String mysqlId = "root";
	String mysqlPw = "1234";
	String sql = "Select no, title, name, wTime, rCnt, email from BOARD2 ORDER BY no DESC";
	try{
		Class.forName(driver);		
	} catch(ClassNotFoundException e){
		System.out.println("드라이버 로드 실패");
	}
	
	try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
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
	}  catch(SQLException e){
		e.printStackTrace();
	}
%>
</table>
<div><a href="write.jsp">글쓰기</a></div>
</body>
</html>