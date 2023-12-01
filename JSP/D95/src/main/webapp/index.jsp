<%@page import="mvc2.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${userInfo eq null}">
			<form action="login.do" method="post">
				아이디 : <input type="text" name="id"><br />
				비밀번호 : <input type="password" name="pw"><br />
				<input type="submit" value="로그인">
			</form>
			<a href="Member/memberRegister.do">회원가입</a><br/>		
		</c:when>
		<c:when test="${userInfo ne null }">
			${userInfo.id } 님<br/>
			<a href="logout.do">로그아웃</a><br/>
			<a href="Member/memberModify.do">회원정보 수정</a><br/>
			<a href="Board/list.do">게시판</a><br/>
		</c:when>
	</c:choose>

<%-- 	
	<c:if test="${userInfo eq null}">
		<form action="login.do" method="post">
			아이디 : <input type="text" name="id"><br />
			비밀번호 : <input type="password" name="pw"><br />
			<input type="submit" value="로그인">
		</form>
		<a href="Member/memberRegister.do">회원가입</a><br/>
	</c:if>
	<c:if test="${userInfo ne null }">
		${userInfo.id } 님<br/>
		<a href="logout.do">로그아웃</a><br/>
		<a href="Member/memberModify.do">회원정보 수정</a><br/>
		<a href="Board/list.do">게시판</a><br/>
	</c:if> 
--%>
</body>
</html>