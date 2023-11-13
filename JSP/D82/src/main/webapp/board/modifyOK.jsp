<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
	String mysqlId = "root";
	String mysqlPw = "1234";
	String sql = "UPDATE board2 SET title=?, contents=?, wTime=now() WHERE no = ?";	
	
	int result = 0;
	
	try{
		Class.forName(driver);
	} catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
		pstmt.setString(1, title);
		pstmt.setString(2, contents);
		pstmt.setInt(3, Integer.parseInt(no));
		result = pstmt.executeUpdate();
		if(result > 0) response.sendRedirect("list.jsp");
		else response.sendRedirect("error.jsp");
	}  catch(SQLException e){
		e.printStackTrace();
	}
%>