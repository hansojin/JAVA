<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN PAGE</title>
<style>
span{
	font-weight: bold;
}
</style>

</head>
<body>
<form method='post' action='../loginOK'>
<%
	String id= (String)session.getAttribute("id");
	Boolean loginFailed = (Boolean)session.getAttribute("loginFailed");
	if (loginFailed != null && loginFailed) {
		%>
	    <script>
	        alert("로그인에 실패했습니다. 다시 시도해주세요.");
	    </script>
	<%
	        // 실패 여부를 한 번 읽었으면 세션에서 제거
	        session.removeAttribute("loginFailed");
	}
	if (id==null){
%>
	
	I D : <input type='text' name='id' required><br>
	PW : <input type='password' name='password' required><br><br>
	<input type='submit' value="LOGIN" style='background-color:white; width:200px'><br><br>
	<a href= 'register.jsp'>REGISTER</a>
<%
	}else{
%>
		hello <span><%=id %></span><br>
		<a href= '../logout'>LOGOUT</a>
		<a href= '../modify'>MODIFY</a>
<%
	}
%>
</form>

</body>
</html>