<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
	private final String driver="com.mysql.cj.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UCT";
	private final String user="root";
	private final String pwDB="1234";
%>

<%
	request.setCharacterEncoding("UTF-8");

	String title= request.getParameter("title");
	String name= request.getParameter("name");
	String pw= request.getParameter("pw");
	String email= request.getParameter("email");
	String content= request.getParameter("content");
	String sql = "insert into board (title,name,pw,email,content,view,date) values(?,?,?,?,?,0,CURRENT_TIMESTAMP)";
	
	try{
		Class.forName(driver);
	}catch(ClassNotFoundException e){
		out.write("mysql driver failed");
		e.printStackTrace();
	}
	
	try(Connection conn = DriverManager.getConnection(url,user,pwDB);
			PreparedStatement pst = conn.prepareStatement(sql)){
		pst.setString(1,title);
		pst.setString(2,name);
		pst.setString(3,pw);
		pst.setString(4,email);
		pst.setString(5,content);
		int result = pst.executeUpdate();
		if (result>0){
			System.out.println("insert success");
			response.sendRedirect("mainBoard.jsp");
		}else{
			System.out.println("insert failed");
			response.sendRedirect("addPost.jsp");
		}
	}catch(SQLException e){
		out.write("SQL exception");
		e.printStackTrace();
	}
	
%>