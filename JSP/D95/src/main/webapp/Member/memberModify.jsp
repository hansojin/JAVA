<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원정보수정</title>
</head>
<body>
	<form action="memberModifyOK.do" method="post">
		이름<br />
		<input type="text" name="name" size="30" value="${userInfo.name}" readonly><br />
		아이디<br />
		<input type="text" name="id" size="30" value="${userInfo.id }" readonly><br />
		NickName<br />
		<input type="text" name="nickname" size="20" value="${userInfo.nickname }"><br />		
		비밀번호<br />
		<input type="password" name="pw" size="20"><br />
		비밀번호 재확인<br />		
		<input type="password" name="pw2" size="20"><br />
		이메일<br />
		<input type="email" name="email" size="20" value="${userInfo.email }"><br />				
		주소<br />
		<input type="text" id="postcode" placeholder="우편번호" name="postcode" value="${userInfo.postcode }" readonly>
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br />
		<input type="text" id="roadAddress" placeholder="도로명주소" name="roadAddress" value="${userInfo.roadAddress }">
		<input type="text" id="jibunAddress" placeholder="지번주소" name="jibunAddress" value="${userInfo.jibunAddress }">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="detailAddress" placeholder="상세주소" name="detailAddress" value="${userInfo.detailAddress }">
		<input type="text" id="extraAddress" placeholder="참고항목" name="extraAddress" value="${userInfo.extraAddress }"><br/>
		생년월일<br />
		<input type="text" name="birthYear" max="4" value="${userInfo.birthYear }">
 		<select name="birthMonth">
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i}" <c:if test="${userInfo.birthMonth eq i}">selected</c:if> >${i}</option>
			</c:forEach> 
 		</select>
		<input type="text" name="birthDate" value="${userInfo.birthDate }"><br />
		전화번호<br />
		<input type="text" name="cellphone" value="${userInfo.cellphone }"><br />
		성별구분<br />
		<!--  <input type="radio" name="gender" value="male" <c:if test="${userInfo.gender eq 'male'}"> checked </c:if> >남 &nbsp; -->
		<input type="radio" name="gender" value="male" ${userInfo.gender eq 'male' ? 'checked':''}>남 &nbsp;
		<input type="radio" name="gender" value="female" <c:if test="${userInfo.gender eq 'female'}"> checked </c:if> >여 <br />
		<input type="submit" value="회원정보수정"> <input type="reset" value="취소">
	</form>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src= "../js/memberRegister.js"></script>
</body>
</html>