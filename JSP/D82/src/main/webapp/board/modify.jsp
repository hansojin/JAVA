<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정하기</title>
<link rel="stylesheet" href="css/view.css">
</head>
<body>
<form method="post" action="modifyOK.jsp">
<table border="1">
	<caption>수정하기</caption>
<%
	String no = request.getParameter("no");
	
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
	String mysqlId = "root";
	String mysqlPw = "1234";
	String pw = null;
	String sql = "SELECT title, name, wTime, contents, rCnt, password FROM board2 where no =" + no;
	
	int rCnt = 0;
	
	try{
		Class.forName(driver);
	} catch(ClassNotFoundException e){
		System.out.println("드라이버 로드 실패");
	}
	
	try( Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql) ){
		if(rs.next()){
			pw = rs.getString("password");
%>
	<tr>
		<td>제목</td><td><input type="text" name="title" value='<%=rs.getString("title") %>'></td>
	</tr>
	<tr>
		<td>이름</td><td><%=rs.getString("name") %></td>
	</tr>
	<tr>
		<td>작성일</td><td><%=rs.getString("wTime") %></td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="contents" cols="50" rows="10" style="resize: none;"><%=rs.getString("contents") %></textarea></td>
	</tr>
	
<%	
		}
	}  catch(SQLException e){
		e.printStackTrace();
	}		
%>		
</table>
<input type="hidden" name="no" value="<%=no %>">
<a href="list.jsp"><input type="button" value="목록"></a> 
<input type="submit" value="등록">
</form>
</body>
</html>