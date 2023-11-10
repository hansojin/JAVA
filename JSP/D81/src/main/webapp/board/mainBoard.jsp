<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='java.sql.*' %>
<%!
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UCT";
    private final String user = "root";
    private final String pwDB = "1234";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
    <h1>LIST</h1>
    <table border='1'>
        <tr>
            <th>No</th>
            <th>Title</th>
            <th>Writer</th>
            <th>Date</th>
            <th>View</th>
        </tr>
        <%
        	request.setCharacterEncoding("UTF-8");
            String sql = "select * from board order by num desc";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                out.write("mysql driver failed");
                e.printStackTrace();
            }

            try (Connection conn = DriverManager.getConnection(url, user, pwDB);
                    Statement st = conn.createStatement();
                    ResultSet rset = st.executeQuery(sql)) {
                while (rset.next()) {
                    int num = rset.getInt("num");
                    String title = URLEncoder.encode(rset.getString("title"), "UTF-8");
                    String name = URLEncoder.encode(rset.getString("name"), "UTF-8");
                    String date = URLEncoder.encode(rset.getString("date"), "UTF-8");
                    int view = rset.getInt("view");
                    String pw = URLEncoder.encode(rset.getString("pw"), "UTF-8");
                    String email = URLEncoder.encode(rset.getString("email"), "UTF-8");
                    String content = URLEncoder.encode(rset.getString("content"), "UTF-8");
                    out.print("<tr>");
                    out.print("<td style='text-align:center'>" + num + "</td>");
                    out.print("<td style='text-align:center'><a href='desc.jsp?num=" + num + "&title=" + title + "&name=" + name + "&date=" + date + "&view=" + view + "&pw=" + pw + "&email=" + email + "&content=" + content + "' >" + rset.getString("title") + "</a></td>");
                    out.print("<td style='text-align:center'><a href=mailto:" + email + ">" + rset.getString("name") + "</a></td>");
                    out.print("<td style='text-align:center'>" + rset.getString("date") + "</td>");
                    out.print("<td style='text-align:center'>" + view + "</td>");
                    out.print("</tr>");

                }
            } catch (SQLException e) {
                out.write("SQL exception!");
                e.printStackTrace();
            }

        %>
    </table><br>
    <a href='addPost.jsp'>글쓰기</a>
</body>
</html>
