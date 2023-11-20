<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form method='post' action='memberInputOK.jsp'> -->
<!-- <form method='post' action='memberInputOK2.jsp'> -->
<form method='post' action='memberInputOK3.jsp'>
	<table>
		<caption style='font-weight:bold'>REGISTER</caption>
		<tr>
			<td> NAME </td>
			<td> <input type = 'text' name='name' id='name' required></td>
		</tr>
		<tr>
			<td> ID  </td>
			<td> <input type= 'text' name='id' id='id' required></td>
		</tr>
		<tr>
			<td colspan="2"> <input type='submit' value="SUBMIT" style='background-color:white; width:210px'>
		</tr>
	</table>
</form>
</body>
</html>