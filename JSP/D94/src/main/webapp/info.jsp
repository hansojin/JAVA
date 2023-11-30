<%@page import="mvc2.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MY INFO</title>
</head>
<style>
button{
	background-color: white;
}
</style>
<body>

<h3>INFO PAGE</h3>
<form name ="form" method="post" action="infoMLogic.do" onsubmit="return validateForm()">
<label for='name'>이름</label><br>
<input type='text' name='name' id='name' value="${dto.name}" readonly><br>
<label for="id">아이디</label><br>
<input type='text' name='id' id ='id' value="${dto.id}" readonly><br>
<!-- <button>중복확인</button><br> -->
<label for="nickname">닉네임</label><br>
<input type='text' name='nickname' id ='nickname' value="${dto.nickname }" required><br>
<label for="pw">비밀번호</label><br>
<input type="password" name='pw' id='pw' required><br>
<label for="pw2">비밀번호 확인</label><br>
<input type="password" name='pw2' id='pw2' required><br>
<label for="email">이메일</label><br>
<input type="email" name='email' id='email' value="${dto.email }" required><br>
<label for="email">주소</label><br>
<input type="text" id="postcode" name="postcode" placeholder="우편번호" value="${dto.postcode }">
<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" style='background-color:white;'><br>
<input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소" value="${dto.roadAddress }">
<input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소" value="${dto.jibunAddress }">
<input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소" value="${dto.detailAddress }">
<input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목" value="${dto.extraAddress }"><br>
<label for="bYear">생년월일</label><br>
<input type="text" name='bYear' id='bYear' value="${dto.bYear }" required>
<select name="bMonth" id="bMonth" style='background-color:white;'>
    <c:forEach var="i" begin="1" end="12">
        <c:choose>
            <c:when test="${i lt 10}">
                <option value="0${i}" ${dto.bMonth == '0'+i ? 'selected' : ''}>0${i}</option>
            </c:when>
            <c:otherwise>
                <option value="${i}" ${dto.bMonth == i ? 'selected' : ''}>${i}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</select>
<input type="text" name='bDay' id='bDay' value="${dto.bDay }" required><br>
<label for="tel">번호</label><br>
<input type="text" name="tel" id="tel" value="${dto.tel }" required><br>
<label for="sex">성별</label><br>
<label><input type='radio' name='sex' value='male' ${dto.sex == 'male' ? 'checked' : ''} />남</label>
<label><input type='radio' name='sex' value='female' ${dto.sex == 'female' ? 'checked' : ''} />여</label><br><br>
<input type='submit' value='MODIFY' style='background-color:white;'>
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
</script>
</body>
</html>