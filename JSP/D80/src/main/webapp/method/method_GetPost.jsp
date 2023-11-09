<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET POST</title>
</head>
<body>
<form method="get" action='getOne.jsp'>
	<table border="1">
		<caption style="font-weight:bold">GET_1</caption>
		<tr>
			<td>NAME</td>
			<td><input type='text' name='name'></td>
		</tr>
		<tr>
			<td>AGE</td>
			<td><input type='text' name='age'></td>
		</tr>
		<tr>
			<td colspan="2" style='text-align: center'>
				<input type='submit' value='submit' style='background-color:white'>
			</td>
		</tr>
	</table>
</form><br><hr><br>


<p style="font-weight:bold; margin-left: 85px">GET_2</p>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href='getTwo.jsp?name=kim&age=28'>clickME</a><br><br><hr><br>


<form method="post" action='postOne.jsp'>
	<table border="1">
		<caption style="font-weight:bold">POST_1</caption>
		<tr>
			<td>NAME</td>
			<td><input type='text' name='name'></td>
		</tr>
		<tr>
			<td>AGE</td>
			<td><input type='text' name='age'></td>
		</tr>
		<tr>
			<td colspan="2" style='text-align: center'>
				<input type='submit' value='submit' style='background-color:white'>
			</td>
		</tr>
	</table>
</form><br><hr>

<p style="font-weight:bold; margin-left: 85px">POST_2</p>
<form method="post" action='postTwo.jsp'>
	NAME : <input type='text' name='name'>
	<input type='hidden' name='secret' value='007'> 
	<input type='submit' value='submit' style='background-color:white'>
</form>

</body>
</html>