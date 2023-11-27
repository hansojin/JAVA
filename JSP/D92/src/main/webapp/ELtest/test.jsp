<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=10 %><br />
	<%=99.99 %><br />
	<%="ABC" %><br />
	<%=true %><br />
	
	${10} ${99.99} ${"ABC"} ${true}
	
	<hr>
	
	<%=  1+2 %> <br />
	<%= 1-2 %> <br />
	<%= 1*2 %> <br />
	<%= 1/2 %> <br />
	<%= 1>2 %> <br />
	<%= 1<2 %> <br />
	<%= (1>2) ? 1 : 2 %> <br />
	<%= (1>2) || (1<2) %> <br />
	
	${1+2} ${1-2} ${1*2} ${1/2} 
	${1>2} ${1 gt 2 }
	${1<2} ${1 lt 2 } 
	${(1>2) ? 1 : 2} ${(1 gt 2) ? 1 : 2} 
	${(1>2) || (1<2)} ${(1 gt 2) or (1 lt 2)}
	
	<hr>
	 
	<jsp:useBean id="member" class="boardInputValue.MemInfo" />
	<jsp:setProperty property="name" name="member" value="JH"/>
	<jsp:setProperty property="id" name="member" value="bling"/>
	<jsp:setProperty property="pw" name="member" value="948"/>
	
	NAME : <%= member.getName() %><br />
	ID : <%= member.getId() %><br />
	PW : <%= member.getPw() %><br /><br />
	
	NAME : ${member.name}<br>
	ID : ${member.id}<br>
	PW : ${member.pw}<br>
	
	<hr>
	
	<form action="testOK.jsp" method="get">
		I D : <input type="text" name="id"><br />
		PW : <input type="password" name="pw">
		<input type="submit" value="login">
	</form>
	<% 
		application.setAttribute("application_name", "application_value");
		session.setAttribute("session_name", "session_value");
		pageContext.setAttribute("page_name", "page_value");
		request.setAttribute("request_name", "request_value");
	%>
	
	<hr>
	
	<form method="post" action="testOK2.jsp">
		이름 : <input type="text" name="name"><br>
		성별 : <input type="radio" name="gender" value="male" checked>남 <input type="radio" name="gender" value="female">여<br>
		취미 : 	<input type="checkbox" name="hobby" value="swimming">수영
		<input type="checkbox" name="hobby" value="baseball">야구
		<input type="checkbox" name="hobby" value="soccer">축구
		<input type="checkbox" name="hobby" value="basketball">농구
		<input type="submit" value="SUBMIT">
	</form>
</body>
</html>