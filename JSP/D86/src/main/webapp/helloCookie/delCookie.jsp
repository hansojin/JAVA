<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	for(int i=0;i<cookies.length;i++){
		String cookieProperty = cookies[i].getName();
		if(cookieProperty.equals("id")){
			cookies[i].setMaxAge(0);	// 삭제
			response.addCookie(cookies[i]);
			break;
		}
	}
%>