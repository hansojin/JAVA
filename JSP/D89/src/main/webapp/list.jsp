<%@page import="java.util.ArrayList"%>
<%@page import="mvc2.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
</head>
<body>
<table border="1">
	<tr>
		<td>번호</td><td>이름</td><td>제목</td><td>날짜</td><td>조회수</td>
	</tr>
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.num}</td>
			<td>${dto.name}</td>
			<td>
				<c:forEach var="i" begin="1" end="${dto.indentNum }">
					-
				</c:forEach>
				<a href="view.do?num=${dto.num}">${dto.title}</a>
			</td>
			<td>${dto.wtime}</td>
			<td>${dto.hit}</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>
</body>
</html>