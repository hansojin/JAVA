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
<form method="post" action="replyOK.do">
		<table border="1">
			<tr>
				<td>아이디</td><td>${id}</td>
			</tr>
			<tr>
				<td>번호</td><td>${dtoM.tel}</td>
			</tr>
			<tr>
				<td>이름</td><td>${dtoM.name}</td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="re: ${dto.title}"/></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15">&#10&#13re: ${dto.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type='submit' value='제출'>
    				<a href="list.do">목록</a>
    				<a href="reply.do?no=${dto.no}">답변</a>
				</td>
			</tr>
		</table>	
		<input type="hidden" name="id" value="${id}">	
		<input type="hidden" name="tel" value="${dtoM.tel}">
		<input type="hidden" name="name" value="${dtoM.name}">	
		<input type="hidden" name="groupNum" value="${dto.groupNum}" />
		<input type="hidden" name="indentNum" value="${dto.indentNum}" />
	</form>
</body>
</html>