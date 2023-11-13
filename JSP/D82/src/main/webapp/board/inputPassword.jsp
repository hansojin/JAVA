<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 입력</title>
</head>
<body>
	<form method="post" action="inputPasswordOK.jsp">
		<table>
			<tr>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="확인"></td>
			</tr>			
		</table>
		<input type = "hidden" name="no" value="<%=request.getParameter("no") %>">
		<input type = "hidden" name="pw" value="<%=request.getParameter("pw") %>">
		<input type = "hidden" name="mode" value="<%=request.getParameter("mode") %>">
	</form>
</body>
</html>