<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="FileUploadResult" enctype="multipart/form-data">
		보낸이 : <input type="text" name="sender"/><br/>
		파일명 : <input type="file" name="attach"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<!-- 
		enctype은 전송되는 parameter의 형식을 알려주는 것이다. 
		일반적으로는 복합형식이 아닌 일반 text 데이터만 전송되기 때문에 아무런 지정이 필요없다.

		그러나 file과 같이 일반 text 형식이 아닌 것이 전송시에 포함되어 있으면,
		그 상황을 서버에 미리 알려 주어 전송되어온 내용을 누락시키지 않도록 만들어 주어야 한다.

		이러한 형식 지정은 smtp(simple mail transfer protocol)의 규약에서 사용하는 방식으로 웹에서도 유사한 방법으로 전송타입을 지정한다. 
		또한 multipart의 전송시에는 반드시 POST 방식의 전송이 필요하다. GET 방식은 데이터의 길이에 제약을 받기 때문이다.
	-->
</body>
</html>