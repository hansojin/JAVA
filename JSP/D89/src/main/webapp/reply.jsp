<%@page import="mvc2.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REPLY</title>
</head>
<body>
	<form method="post" action="replyOK.do">
		<table border="1">
			<tr>
				<td>번호</td><td>${dto.num}</td>
			</tr>
			<tr>
				<td>조회수</td><td>${dto.hit}</td>
			</tr>
			<tr>
				<td>이름</td><td><input type="text" name="name" autofocus/></td>
			</tr>
			<tr>
				<td>제목</td><td><input type="text" name="title" value="re: ${dto.title}"/></td>
			</tr>
			<tr>
				<td>내용</td><td><textarea name="contents" cols="100" rows="15">&#10&#13re: ${dto.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변"> 
					<a href="list.do">목록</a>
				</td>
			</tr>
		</table>
		<input type="hidden" name="num" value="${dto.num}" />
		<input type="hidden" name="groupNum" value="${dto.groupNum}" />
		<input type="hidden" name="stepNum" value="${dto.stepNum}" />
		<input type="hidden" name="indentNum" value="${dto.indentNum}" />
	</form>
	
	<!-- 
	&#10;     Line feed 		// 커서를 현재 행의 다음 행으로, 즉 아래로 내리기
	&#13;     Carriage Return	// 커서를 현재 행의 맨 좌측으로 옮기기
	-->
</body>
</html>