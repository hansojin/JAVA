<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%!
	public class Inner{
		private String name;
		public void setName(String name){ this.name = name; }
		public String getName(){ return this.name; }
}
%>
<%
	Inner inner = new Inner();
	inner.setName("JH");
	request.setAttribute("inner", inner);
	
	request.setAttribute("num1", "100");
	request.setAttribute("num2", "30");
	
	request.setAttribute("bool", "false");
	request.setAttribute("data", "");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 연산 사용!</h3>
	num1 : ${requestScope.num1}<br/>
	num2 : ${requestScope.num2}<br/>
	bool : ${requestScope.bool}<br/>
	data : ${requestScope.data}<br/>
	inner.name = ${requestScope.inner.name}<br>
	inner["name"] = ${requestScope.inner["name"] }<br>
	num1 * (num2 + 3) : ${ requestScope.num1 * (requestScope.num2 + 3) }<br/>
	num1 / num2 : ${ requestScope.num1 / requestScope.num2 }<br/>
	num1 div num2 : ${ requestScope.num1 div requestScope.num2 }<br/>
	num1 != num2 : ${ requestScope.num1 != requestScope.num2 }<br/>
	num1 ne num2 : ${ requestScope.num1 ne requestScope.num2 }<br/>	
	(num1 % 2 == 0) and (num2 mod 4 == 0) : 
		${ (requestScope.num1 % 2 == 0) and (requestScope.num2 mod 4 == 0) }<br/>
	!bool : ${ !requestScope.bool }<br/>
	not bool : ${ not requestScope.bool }<br/>
	empty(data) : ${ empty(requestScope.data) }<br/>
	
	<hr>
	num1 : ${num1}<br/>
	num2 : ${num2}<br/>
	bool : ${bool}<br/>
	data : ${data}<br/>
	inner.name : ${ inner.name }<br/>
	inner["name"] : ${ inner["name"] }<br/>
	num1 * (num2 + 3) : ${ num1 * (num2 + 3) }<br/>
	num1 / num2 : ${ num1 / num2 }<br/>
	num1 div num2 : ${ num1 div num2 }<br/>
	num1 != num2 : ${ num1 != num2 }<br/>
	num1 ne num2 : ${ num1 ne num2 }<br/>	
	(num1 % 2 == 0) and (num2 mod 4 == 0) : 
		${ (num1 % 2 == 0) and (num2 mod 4 == 0) }<br/>
	!bool : ${ !bool }<br/>
	not bool : ${ not bool }<br/>
	empty(data) : ${ empty(data) }<br/>
	
</body>
</html>