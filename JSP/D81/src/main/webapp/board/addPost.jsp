<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board.css">
</head>
<body>
	<form method='post' action='addLogic.jsp'>
		<table border='1' style='margin-top: 20px'>
			<caption style='font-weight: bold; font-size: 1.2em; margin: 10px'>글쓰기</caption>
			<tr>
				<td>제목</td>
				<td><input type='text' id='title' name='title' required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type='text' id='name' name='name' required></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type='password' id='pw' name='pw' required></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type='email' id='email' name='email' required></td>
			</tr>
			<tr>
				<td colspan='2'><textarea id='content' name='content'></textarea></td>
			</tr>
			<tr>
				<td colspan=2>
					<input type='submit' value='SUBMIT' style='background-color:white; width:100px; margin-left:140px'>
					<button><a href='mainBoard.jsp' style='text-decoration: none;text-align: center'>HOME</a></button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>