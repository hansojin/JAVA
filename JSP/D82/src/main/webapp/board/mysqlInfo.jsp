<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hellojsp?serverTimezone=UTC";
	String mysqlId = "root";
	String mysqlPw = "1234";
	
	try{
		Class.forName(driver);		
	} catch(ClassNotFoundException e){
		System.out.println("드라이버 로드 실패");
	}
%>