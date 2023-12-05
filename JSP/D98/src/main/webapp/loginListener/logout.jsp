<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <%
           HttpSession session = request.getSession(false);
           String id = (String)session.getAttribute("id");
           session.invalidate();
     %>     
     <h1><%= id %> 로그아웃됨 </h1>    
</body>
</html>

<!-- 
    
getSession(), getSession(true), getSession(false) 차이점

1. getSession(), getSession(true)
 - HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 세션을 생성합니다.

2. getSession(false)
 - HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로 생성하지 않고 그냥 null을 반환합니다.

* session.isNew() : 새로 생성된 세션이면 true를 리턴.
* getSession(), getSession(true)는 null 체크없이 바로 

getAttribute()를 사용해도 무방하지만, 
getSession(false)는 null을 리턴할수 있기 때문에 null체크를 해야 합니다. 

-->