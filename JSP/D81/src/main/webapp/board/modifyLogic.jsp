<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
    private final String user = "root";
    private final String pwDB = "1234";
%>

<%
    request.setCharacterEncoding("UTF-8");
    String num = request.getParameter("num");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    String sql = "UPDATE board SET content=?, title=? WHERE num=?";

    try {
        Class.forName(driver);
    } catch (ClassNotFoundException e) {
        out.write("mysql driver failed");
        e.printStackTrace();
    }

    try (Connection conn = DriverManager.getConnection(url, user, pwDB);
         PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, content);
        pst.setString(2, title);
        pst.setString(3, num);

        int result = pst.executeUpdate();
        if (result > 0) {
            System.out.println("modify success");
        } else {
            System.out.println("modify failed");
        }
    } catch (SQLException e) {
        out.write("SQL exception");
        e.printStackTrace();
    } finally {
        response.sendRedirect("mainBoard.jsp");
    }
%>
