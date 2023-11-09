<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drink Form</title>
</head>
<body>
	<form method='post' action='drinksRequest.jsp'>
		<table>
			<tr>
				<td><label for='name' id='name'>NAME</label></td>
				<td><input type='text' id='name' name='name' required></td>
			</tr>
			<tr>
				<td><label for='age' id='age'>AGE</label></td>
				<td><input type='text' id='age' name='age' required></td>
			</tr>
			<tr>
				<td colspan="2" style='text-align:center'><input type='submit' value='submit' style='background-color: white'></td>
			</tr>
			
		</table>
	</form>
</body>
</html>