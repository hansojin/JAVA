<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
button{
	background-color: white;
}
</style>
<body>
<h3>REGISTER PAGE</h3>
<form name ="form" method="post" action="registerLogic.do" onsubmit="return validateForm()">
<label for='name'>이름</label><br>
<input type='text' name='name' id ='name' required><br>
<label for="id">아이디</label><br>
<input type='text' name='id' id ='id' readonly>
<input type="button" onClick="idCheck()" value="중복확인" style='background-color: white'><br>
<label for="nickname">닉네임</label><br>
<input type='text' name='nickname' id ='nickname' required><br>
<label for="pw">비밀번호</label><br>
<input type="password" name='pw' id='pw' required><br>
<label for="pw2">비밀번호 확인</label><br>
<input type="password" name='pw2' id='pw2' required><br>
<label for="email">이메일</label><br>
<input type="email" name='email' id='email' required><br>
<label for="email">주소</label><br>
<input type="text" id="postcode" name="postcode" placeholder="우편번호">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" style='background-color:white;'><br>
<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소">
<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소">
<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소">
<input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목"><br>
<label for="bYear">생년월일</label><br>
<input type="text" name='bYear' id='bYear' required>
<select name="bMonth" id="bMonth" style='background-color:white;'>
<c:forEach var="i" begin="1" end="12">
  <c:choose>
      <c:when test="${i lt 10 }">
          <option value="0${i}">0${i}</option>
      </c:when>
      <c:otherwise>
          <option value="${i}">${i}</option>
      </c:otherwise>
  </c:choose>
</c:forEach>
</select>
<input type="text" name='bDay' id='bDay' required><br>
<label for="tel">번호</label><br>
<input type="text" name="tel" id="tel" required><br>
<label for="sex">성별</label><br>
<label><input type='radio' name='sex' value='male' />남</label>
<label><input type='radio' name='sex' value='female' />여</label><br><br>
<input type='submit' value='REGISTER' style='background-color:white;'>
<input type='reset' value='RESET' style='background-color:white;'>
<a href="login.do">HOME</a>
</form>

<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var roadAddr = data.roadAddress; 
                var extraRoadAddr = ''; 
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }
            }
        }).open();
    }
    
    function validateForm() {
        var password = document.forms["form"]["pw"];
        var passwordChk = document.forms["form"]["pw2"];
        if(password.value != passwordChk.value){
            alert("Check your password");
            password.value="";
            passwordChk.value="";
            password.focus();
            return false;
        }
    }
    
    function idCheck(){
		window.open("idCheck.jsp", "idCheckForm", "width=400, height=300");
	}
</script>
</body>
</html>