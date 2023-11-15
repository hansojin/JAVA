<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="../register" name='myform'>
		<table>
			<caption style='font-weight:bold'>MEMBER REGISTER</caption>
			<tr>
				<td><label for="title">NAME</label></td>
				<td><input type="text" name="name" id="name" size="40" required></td>
			</tr>
			<tr>
				<td><label for="id">ID</label></td>
				<td><input type="text" name="id" id="id" size="28" required></td>
			</tr>
			<tr>
				<td><label for="pw">PW</label></td>
				<td><input type="password" name="pw" id="pw" size="40" required></td>
			</tr>
			<tr>
				<td><label for="pw2">PW check</label></td>
				<td><input type="password" name="pw2" id="pw2" size="40" required></td>
			</tr>
			<tr>
				<td> GENDER</td>
				<td>
					<input type='radio' name='gender' value='female' checked='checked'> XX
  					<input type='radio' name='gender' value='male' > XY
  				</td>
			</tr>
			<tr>
				<td><label for="email">E-MAIL</label></td>
				<td><input type="email" name="email" id="email" size="40" required></td>
			</tr>
			<tr>
				<td>HOBBY</td>
				<td>
					<input type="checkbox" name="hobby" value="swimming">수영
					<input type="checkbox" name="hobby" value="baseball">야구 
					<input type="checkbox" name="hobby" value="soccer">축구 
					<input type="checkbox" name="hobby" value="basketball">농구
				</td>
			</tr>
			<tr>
				<td><label for="number">PHONE</label></td>
				<td>
					<select name='numFront' id='numFront' style='background-color:white'> 
						<option value ='010' >010</option>
						<option value ='011' >011</option>
					</select>
					<input type="text" name="number" id="number" size="32" required>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="SUBMIT" style='background-color:white;width:80px;margin-left:120px' onclick="checkPW()"> 
					<input type="reset" value="RESET" style='background-color:white;width:80px'> 
			</tr>
		</table>
	</form>
	<script>
		function checkPW(){
			var one = document.getElementById('pw')
			var two = document.getElementById('pw2')
			var form = document.myform;
			if (one.value===two.value){
				form.submit();
			}else{
				alert("Check your password")
				two.value="";
				two.focus();
			}
		}
	</script>
</body>
</html>