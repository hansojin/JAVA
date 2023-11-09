<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
	out.print("<caption>구구단</caption>");
	for(int i=1;i<=9;i++){
		out.print("<tr>");
		for(int j=2;j<=9;j++){
			out.print("<td>"+j+"*"+i+"="+j*i+"</td>");
		}
		out.print("</tr>");
	}
%>
</table>

</body>
</html>