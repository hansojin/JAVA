<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modifyOK.do">
		<table border="1">
			<tr>
				<td>아이디</td><td>${dto.id}</td>
			</tr>
			<tr>
				<td>번호</td><td>${dto.tel}</td>
			</tr>
			<tr>
				<td>이름</td><td>${dto.name}</td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="${dto.title}"/></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15">${dto.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
    				<input type="hidden" name="no" value="${dto.no}">
    				<c:if test="${dto.id == id}">
        				<input type="submit" value="수정">
        				<a href="delete.do?no=${dto.no}">삭제</a>
    				</c:if>
    				<a href="list.do">목록</a>
    				<a href="reply.do?no=${dto.no}&id=${id}">답변</a>
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>