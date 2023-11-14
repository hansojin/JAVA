<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String pw = request.getParameter("pw");
	String password = request.getParameter("password");
	String no = request.getParameter("no");
	String mode = request.getParameter("mode");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 확인</title>
<script>
	function goToLocation(no)
	{
		if(no==1){
			alert("데이터가 삭제 되었습니다");
			location.href = "list.jsp";			
		}
		else if(no==2){
			location.href = "modify.jsp?no=<%=no%>";
		}
		else if(no==3){
			alert("비밀번호가 일치하지 않습니다.");
			history.go(-2);
		}
	}
</script>
</head>
<body>
<%@ include file='mysqlInfo.jsp' %>
<%		
	String sql = null;
	
	try(Connection conn = DriverManager.getConnection(url, mysqlId, mysqlPw);
			Statement stmt = conn.createStatement()){
		if(pw.matches(password)) {
			if(mode.matches("1")) {
				sql = "DELETE FROM board2 where no = " + no;
				stmt.executeUpdate(sql);
			}
		}
		else mode = "3";
	}  catch(SQLException e){
		e.printStackTrace();
	}
%>
<script>goToLocation(<%=mode%>)</script>	
</body>
</html>