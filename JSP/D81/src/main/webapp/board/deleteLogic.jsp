<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UCT";
    private final String user = "root";
    private final String pwDB = "1234";
%>

<%
    request.setCharacterEncoding("UTF-8");
    String no = request.getParameter("num");
    
    String sql = "DELETE FROM board WHERE num=" + Integer.parseInt(no);
    
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        out.write("mysql driver failed");
        e.printStackTrace();
    }

    try (Connection conn = DriverManager.getConnection(url, user, pwDB);
         Statement st = conn.createStatement()) {

        int result = st.executeUpdate(sql);
        if (result > 0) {
            System.out.println("delete success");
        } else {
            System.out.println("delete failed");
        }
    } catch (SQLException e) {
        out.write("SQL exception");
        e.printStackTrace();
    } finally {
        response.sendRedirect("mainBoard.jsp");
    }
%>
