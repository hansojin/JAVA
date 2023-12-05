<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
     request.setCharacterEncoding("utf-8");
     
     String id = request.getParameter("id");
     String password = request.getParameter("password");
     
     if(id.equals(password)) {		//로그인 성공시 세션 생성
           HttpSession session = request.getSession();
           session.setAttribute("id", id);
     }else {
           response.sendRedirect("login.jsp");
     }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>메인페이지</title>
</head>
<body>
     <h1><%= id %> 님 로그인 되었습니다.</h1>
     <a href='logout.jsp'>로그아웃</a>
</body>
</html>