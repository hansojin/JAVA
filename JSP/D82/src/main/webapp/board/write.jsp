<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="writeOK.jsp">
		<table>
			<caption>글 쓰 기</caption>
			<tr>
				<td><label for="title">제목</label></td><td><input type="text" name="title" id="title" size="40" required></td>
			</tr>
			<tr>
				<td><label for="name">이름</label></td><td><input type="text" name="name" id="name" size="40"  required></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호</label></td><td><input type="password" name="pw" id="pw" size="40"  required></td>
			</tr>
			<tr>
				<td><label for="email">E-mail</label></td><td><input type="email" name="email" id="email" size="40"  required></td>
			</tr>
			<tr>
				<td colspan="2"><textarea cols="50" rows="10" name="contents"  required></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"> <a href="list.jsp"><input type="button" value="목록"></a></td>
			</tr>
		</table>
	</form>
</body>
</html>