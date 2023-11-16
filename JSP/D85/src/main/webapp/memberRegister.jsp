<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form name="member" method="post" action="MemberRegisterOK" onsubmit="return validateForm()">
<table>
<tr>
	<td>이름 </td>
	<td><input type="text" name="name" required></td>
</tr>
<tr>
	<td>아이디 </td>
	<td><input type="text" name="id" required></td>
</tr>
<tr>
	<td>비밀번호 </td>
	<td><input type="password" name="password" required></td>
</tr>
<tr>
	<td>비밀번호확인 </td>
	<td><input type="password" name="passwordChk" required></td>
</tr>
<tr>
	<td>성별 </td>
	<td>	
		<input type="radio" name="sex" value="male" checked>남 
		<input type="radio" name="sex" value="female">여
	</td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="email" name="email" required></td>
</tr>
<tr>
	<td>취미</td>
	<td>
		<input type="checkbox" name="hobby" value="수영">수영 
		<input type="checkbox" name="hobby" value="야구">야구 
		<input type="checkbox" name="hobby" value="영화감상">영화감상 
		<input type="checkbox" name="hobby" value="음악감상">음악감상 
	</td>
</tr>
<tr>
	<td>핸드폰</td>
	<td>
		<select name="mobilePhone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
		</select>
		<input type="text" name="mobilePhone2" required>	
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="회원가입" style='background-color:white;'> 
		<input type="reset" value="초기화" style='background-color:white;'>
	</td>
</tr>
</table>
</form>
<script>
function validateForm() {
    var password = document.forms["member"]["password"].value;
    var passwordChk = document.forms["member"]["passwordChk"].value;
    if(password != passwordChk){
        alert("비밀번호와 비밀번호확인이 서로 다릅니다.");
        return false;
    }
}
</script>
</body>
</html>