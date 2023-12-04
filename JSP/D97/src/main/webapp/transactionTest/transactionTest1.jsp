<%@page import="javax.naming.NamingException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	통장에는 10000원의 돈이 있고, 포인트는 1000점의 포인트가 있다.
	체크카드를 이용해서 1000원짜리 껌을 사면 10%의 포인트가 주어진다고 가정하자.
	체크카드로 1000원짜리 껌을 사고난후에 오류가 발생한 경우,

	트랜잭션 처리를 안했을 경우, 
	통장에서는 1000원이 결제되어서 빠져나갔지만, 포인트는 쌓이지가 않았다.
 -->

<%
	DataSource dataSource = null;		 
	String occuredException = null;
	String payment = "1000";		// 지불 금액
	
	try {
		Context context = new InitialContext();
		dataSource = (DataSource)context.lookup("java:comp/env/jdbc/testdb");
	} catch (NamingException e) {
		e.printStackTrace();
	}	
	 
	try(Connection conn = dataSource.getConnection();
			PreparedStatement pstmtBankBook = conn.prepareStatement("update bankbook set balance= balance-"+payment+" where name = 'starTraveller'");
			PreparedStatement pstmtPoint= conn.prepareStatement("update pointbook set point = point+("+payment+"/10) where name = 'starTraveller'")){
	    
	    pstmtBankBook.executeUpdate(); 		//통장 잔고 업데이트 
	    
	    
	    if(true){							//강제로 예외 날리기
	        throw new Exception("오류 발생 !!");		
	    }
	    
	    pstmtPoint.executeUpdate();			//10% 포인트 적립 
	 
	}catch(Exception e){
	    occuredException = "error";
	}
 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>트랜잭션 테스트</title>
</head>
<body>
	<c:choose>
		<c:when test="${occuredException != null}">
			<h2>거래 실패</h2>
		</c:when>
		<c:otherwise>
			<h2>거래 성공</h2>
		</c:otherwise>
	</c:choose>
</body>
</html>

