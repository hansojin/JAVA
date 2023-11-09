<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import='java.sql.*' %>
<%!
	private final String driver="com.mysql.cj.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UCT";
	private final String user="root";
	private final String password="1234";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER LIST</title>
</head>
<body>
<%
	String sql = "select * from member";
	try{
		Class.forName(driver);
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection(url,user,password);
			Statement st = conn.createStatement();
			ResultSet rset= st.executeQuery(sql)){
		while(rset.next()){
			int num=rset.getInt("num");
			String id = rset.getString("id");
			String pw = rset.getString("pw");
			String name = rset.getString("name");
 			out.print(String.format("#%d. <span style='font-weight:bold'>%s</span> [%s %s]<br>",num,id,pw,name));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
%>
</body>
</html>