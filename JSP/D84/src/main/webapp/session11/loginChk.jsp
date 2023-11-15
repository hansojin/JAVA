<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.setAttribute("id", request.getParameter("id"));
	response.sendRedirect("login.jsp");
%>