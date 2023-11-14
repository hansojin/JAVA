<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file='mysqlInfo.jsp' %>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String contents = request.getParameter("contents");
	
	String sql = "INSERT INTO board2(title, name, password, email, contents) values(?, ?, ?, ?, ?)";
	int result = 0;
	
	try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
		pstmt.setString(1, title);
		pstmt.setString(2, name);
		pstmt.setString(3, pw);
		pstmt.setString(4, email);
		pstmt.setString(5, contents);
		result = pstmt.executeUpdate();
		if(result > 0) response.sendRedirect("list.jsp");
		else response.sendRedirect("error.jsp");
	}  catch(SQLException e){
		e.printStackTrace();
	}
%>