<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
	트랜잭션 처리를 했을 경우, 
	오류가 발생하여도 통장에 있는 돈이 빠져나가기 이전상태로 돌아갔다.
 -->

<%
	DataSource dataSource = null;		 
	String occuredException = null;
	String payment = "1000";		
	
	try {
		Context context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
	} catch (NamingException e) {
		e.printStackTrace();
	}	
	 
	try(Connection conn = dataSource.getConnection()){
		try(PreparedStatement pstmtBankBook = conn.prepareStatement("update bankbook set balance= balance-"+payment+" where name = 'starTraveller'");
				PreparedStatement pstmtPoint= conn.prepareStatement("update pointbook set point = point+("+payment+"/10) where name = 'starTraveller'")){
			
			conn.setAutoCommit(false);		//트랜잭션 설정 , false를 인자값으로 넘겨서 트랜잭션을 시작
		    
		    pstmtBankBook.executeUpdate(); 
		    
		    if(true){
		        	throw new Exception("오류 발생 !!");
		    }
		    
		    pstmtPoint.executeUpdate(); 
		     
		    conn.commit();				//트랜젝션 커밋
		}
		catch(Exception e){
			occuredException = "error";
			conn.rollback();			// 문제가 있다면, rollback()
		}
	 
	}catch(Exception e){
	    e.printStackTrace();
	}
%>



