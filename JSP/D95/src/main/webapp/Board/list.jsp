<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>목록</title>
</head>
<body>
	<form method = "post" action="search.do">
		검색 : 
			<select name="kindOfSearch">
				<option value="searchTitle">제목</option>
				<option value="searchTitleAndContents">제목 + 내용</option>
				<option value="searchId">작성자</option>
			</select>
			
		<input type="text" name="searchKeyword">
		<input type="submit" value="검색">
	</form>	
	<table border="1">
		<tr>
			<td>번호</td><td>아이디</td><td>제목</td><td>조회수</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.no }</td>
				<td>${dto.id}</td>
				<td>
					<a href="view.do?no=${dto.no}&id=${dto.id}">
					<c:forEach var="i" begin="1" end="${dto.indentNum}" step="1">-</c:forEach>
					${dto.title}
					</a>
				</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4"><a href="write.do">글작성</a></td>
		</tr>
	</table>
	<c:set var="curPage" value="${param.curPage }" />
	<c:if test="${curPage eq null }">
		<c:set var="curPage" value="0"/>
	</c:if>
	<c:forEach var="i" begin="0" end="${totalPage}" step="1">
		<c:choose>
			<c:when test="${i eq curPage}">
				${i+1}
			</c:when>
			<c:when test="${i ne curPage}">
				<a href="list.do?curPage=${i}">${i+1}</a>
			</c:when>
		</c:choose>
<%-- 	
		<c:if test="${i eq curPage}">
			${i+1}
		</c:if>
		<c:if test="${i ne curPage}">
			<a href="list.do?curPage=${i}">${i+1}</a>
		</c:if>	 
--%>		
	</c:forEach>
</body>
</html>