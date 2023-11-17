<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
	display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 80dvh;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="../writeOK" >
		<table>
			<caption style='font-weight:bold'>INFORMATION</caption>
			<tr>
				<td><label for="title">TITLE</label></td>
				<td><input type="text" name="title" id="title" size="40" required></td>
			</tr>
			<tr>
				<td><label for="name">NAME</label></td>
				<td><input type="text" name="name" id="name" size="40" required></td>
			</tr>
			<tr>
				<td><label for="pw">PW</label></td>
				<td><input type="password" name="pw" id="pw" size="40" required></td>
			</tr>
			<tr>
				<td><label for="email">E-MAIL</label></td>
				<td><input type="email" name="email" id="email" size="40" required></td>
			</tr>
			<tr>
				<td colspan = '2'>
				<textarea cols="40" rows="3" name="contents" id="contents"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="SUBMIT" style='background-color:white;width:80px;margin-left:100px'> 
					<input type="reset" value="RESET" style='background-color:white;width:80px'> 
			</tr>
		</table>
	</form>
</body>
</html>