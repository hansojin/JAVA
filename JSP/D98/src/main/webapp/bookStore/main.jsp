<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %> 	<%-- 현재 페이지를 session에 참여 시킨다. --%>
<!-- JSP 페이지가 HttpSession을 사용할지 여부를 지정하는 속성 : true(default), false -->
<%
	String[] img = new String[] {
		"cpoint", "java", "jsp", "mfc", 
		"net", "oracle", "python", "tcpip", "xml"
	};	//이미지 파일명 

	String[] name = new String[] {
		"C포인터", "자바", "JSP & Servlet", "MFC",
		"닷넷", "오라클", "파이썬", "TCP/IP", "XML 웹 서비스"
	};	
	
	String[] price = new String[] {
		"20,000", "32,000", "29,000", "35,000", 
		"29,000", "25,000", "32,000", "28,000", "30,000"
	};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOOK STORE</title>
</head>
<script>
	function toCart(){
		location.href='cart.jsp';
	}
	function addCart(name,price){
		location.href=`process.jsp?name=\${name}&price=\${price}`;
	}
</script>
<body>
	<h2>Book Store</h2>
	<table>
		<tr>
			<td colspan='3'>
				<input type='button' value='내 장바구니' onclick="toCart()" style='border:none' />
			</td>
		</tr>
		<%
		for(int i=0;i<img.length;++i){
			if (i%3==0)
				out.println("<tr>");
			out.println("<td><table>");
			out.println("<tr><td>");
			out.println("<img src='./images/" + img[i] + ".gif'/> ");
			out.println("</td></tr>");
			out.println("<tr><td>");
			out.println("<b>"+name[i]+"</b></td></tr>");
			out.println("<tr><td>");
			out.println("가격 : "+price[i]+"원</td></tr>");
			out.println("<tr><td>");
			out.println("<input type='button' value='담기'");
			out.println("onclick='addCart(\"" + name[i] + "\",\"" + price[i] + "\")' style='border:none'/>");
			out.println("</td></tr>");
			out.println("</table></td>");
			if (i%3==2)
				out.println("</tr>");
		}
		%>		
	</table>
</body>
</html>