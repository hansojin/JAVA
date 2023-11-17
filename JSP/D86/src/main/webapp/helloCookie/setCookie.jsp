<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Cookie cookie = new Cookie("id","JH");
	cookie.setMaxAge(60*60); // 단위 : sec
	response.addCookie(cookie);
%>