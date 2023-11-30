<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>아이디 중복 확인 결과</h3>
	입력 ID : <strong> ${param.id } </strong>
	<c:choose>
    <c:when test="${not empty hasID and hasID eq 'true'}">
        <p style='color: red'>이미 사용중인 ID입니다.</p>
        <c:remove var="hasID" scope="session" />
    </c:when>
    <c:otherwise>
        <p>사용 가능한 아이디입니다.</p>
        <a href='javascript:apply("${param.id}")'>[적용]</a>
    </c:otherwise>
	</c:choose>

	<script>
	function apply(id){
		opener.document.getElementById('id').value=id;
		window.close(); 
	}
	</script>

	<hr>
	<a href="javascript:history.back()">[다시시도]</a>&nbsp; &nbsp;
	<a href="javascript:window.close()">[창닫기]</a>
</body>
</html>