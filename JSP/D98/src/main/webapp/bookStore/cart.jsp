<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bookStore.MyCart" %>
<%
	ArrayList<MyCart> myCart = null;
	Object obj = session.getAttribute("cart");
	
	if(obj==null)
		myCart=new ArrayList<MyCart>();
	else
		myCart = (ArrayList<MyCart>)obj;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 장바구니</title>
</head>
<body>
	<h2>내 장바구니</h2>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>제품명</th>			
			<th>수량</th>
			<th>가격</th>
			<th>총가격</th>
		</tr>
		<%
		if(myCart.size() == 0) {
			out.println("<tr><td colspan='5'>");
			out.println("구입하신 물품이 없습니다.");
			out.println("</td></tr>");
		}
		else {
			int total = 0;
			for(int i = 0; i < myCart.size(); ++i) {
				MyCart cart = (MyCart)myCart.get(i);
				out.println("<tr><td>");
				out.println(i + 1 + "</td>");
				out.println("<td>" + cart.getName() + "</td>");
				out.println("<td>" + cart.getCnt() + "개</td>");
				out.println("<td>" + cart.getPrice() + "원</td>");
				out.println("<td>" + cart.getCnt() * cart.getPrice());
				out.println("원</td></tr>");
				total += cart.getCnt() * cart.getPrice();
			}
			out.println("<tr><td colspan='4'>전체 합계</td>");
			out.println("<td>" + total + " 원</td></tr>");
		}
		%>
	</table>
</body>
</html>