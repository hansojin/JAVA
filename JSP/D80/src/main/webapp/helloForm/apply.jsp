<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 메타 태그(meta tag)는 웹페이지가 담고 있는 컨텐츠가 아닌 
	웹페이지 자체의 정보를 명시하기 위한 목적으로 사용되는 HTML 태그-->
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Apply Form</title>

<link rel="stylesheet" type="text/css" href="../css/apply.css">
</head>

<body>
	<form method='post' action='applyResult.jsp'>
		<table>
			<caption>Apply Form</caption>
			<tr>
				<td><label for='name'>NAME </label></td>
				<td><input type='text' name='name' id='name' required></td>
			</tr>
			<tr>
				<td><label for='id'>ID </label></td>
				<td><input type='text' name='id' id='id' required></td>
			</tr>
			<tr>
				<td><label for='pw'>PASSWORD </label></td>
				<td><input type='password' name='pw' id='pw' required></td>
			</tr>
			<tr>
				<td><label for='pw2'>PASSWORD check </label></td>
				<td>
					<input type='password' name='pw2' id='pw2' required>
					<span id="pwChkTxt"></span>
				</td>
			</tr>
			<tr>
				<td><label for='email'>EMAIL </label></td>
				<td><input type='email' name='email' id='email' required></td>
			</tr>
			<tr>
				<td>HOBBY</td>
				<td>
					<input type="checkbox" name='hobby' value='reading' id='reading'><label for='reading'>reading</label> 
					<input type="checkbox" name='hobby' value='eating' id='eating'><label for='eating'>eating</label> 
					<input type="checkbox" name='hobby' value='running' id='running'><label for='running'>running</label>
					<input type="checkbox" name='hobby' value='swimming' id='swimming'><label for='swimming'>swimming</label> 
					<input type="checkbox" name='hobby' value='sleeping' id='sleeping'><label for='sleeping'>sleeping</label>
					<input type="checkbox" name='hobby' value='shopping' id='shopping'><label for='shopping'>shopping</label>
				</td>
			</tr>
			<tr>
				<td>MAJOR</td>
				<td>
					<input type='radio' name='major' value='Math' id='Math' checked='checked'><label for='Math'>Math</label> 
					<input type='radio' name='major' value='Design' id='Design'><label for='Design'>Design</label> 
					<input type='radio' name='major' value='English' id='English'><label for='English'>English</label>
					<input type='radio' name='major' value='Science' id='Science'><label for='Science'>Science</label> 
					<input type='radio' name='major' value='History' id='History'><label for='History'>History</label>
					<input type='radio' name='major' value='Music' id='Music'><label for='Music'>Music</label>
				</td>
			</tr>
			<tr>
				<td><label for='mobileCarrier'>MOBILE CARRIER </label></td>
				<td>
					<select name='mobileCarrier' required>
						<option value='SKT'>SKT</option>
						<option value='KT'>KT</option>
						<option value='LG'>LG</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan='2' id='submit'>
					<input type='submit' value='SUBMIT'>
					<input type='reset' value='RESET'>
				</td>
			</tr>
		</table>
	</form>
	<script>
		var pw = document.getElementById("pw");
		var pw2 = document.getElementById("pw2");
		var pwChkTxt = document.getElementById("pwChkTxt");
		pw.addEventListener('keyup', passwordCheck);
		pw2.addEventListener('keyup', passwordCheck);
		function passwordCheck() {
			if (pw.value != pw2.value) {
				pwChkTxt.innerHTML = "&nbsp;Check your eMAIL";
			} else if (pw.value == pw2.value) {
				pwChkTxt.innerHTML = "";
			}
		}
	</script>
</body>
</html>