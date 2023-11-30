<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="mvc2.dto.BulletinDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<form method='post' action='search.do'>
	<select name="searchBox" id='searchBox' style='background-color: white;width:90px'>
  		<option value="title" selected>제목</option>
  		<option value="titleCon">제목+내용</option>
  		<option value="writer">작성자</option>
	</select>
	<input type='text' name='searchBar' id='searchBar' style='width:120px'>
	<input type='submit' value='검색' style='background-color: white;'>
</form><br>

<table border="1">
	<tr>
		<td>번호</td><td>아이디</td><td>제목</td><td>조회수</td>
	</tr>
	<c:choose>
		<c:when test="${not empty searchFlag and searchFlag eq 'true'}">
			<c:forEach var="dto" items="${slist }">
				<tr>
					<td>${dto.no}</td>
					<td>${dto.id}</td>
					<td><a href="view.do?no=${dto.no}">${dto.title}</a></td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:forEach var="dto" items="${list }">
				<tr>
					<td>${dto.no}</td>
					<td>${dto.id}</td>
					<td><a href="view.do?no=${dto.no}">${dto.title}</a></td>
					<td>${dto.hit}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
	<tr>
		<td colspan="5"><a href="write.do">글작성</a></td>
	</tr>
</table>

</body>
</html>