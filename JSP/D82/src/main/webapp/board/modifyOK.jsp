<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file='mysqlInfo.jsp' %>
<%
	request.setCharacterEncoding("UTF-8");
	String no = request.getParameter("no");
	String title = request.getParameter("title"); 
	String contents = request.getParameter("contents");
	String sql = "UPDATE board2 SET title=?, contents=?, wTime=now() WHERE no = ?";	
	
	int result = 0;

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