<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AJAX</title>
<script>
	var req = new XMLHttpRequest();		// HTTP 요청을 만들 수 있는 객체 생성
	
	/*
	XMLHttpRequest(XHR) 객체는 서버와 상호작용할 때 사용 (AJAX 프로그래밍에 사용)
	XHR을 사용하면 페이지의 새로고침 없이도 URL에서 데이터를 가져올 수 있음 = 사용자의 작업을 방해하지 않고 페이지의 일부를 업데이트할 수 있음
	*/
	
	req.open("GET", "./data.txt");		// HTTP request method와 URL 설정
	req.send();							// 요청 전송
	console.log(req.response);			
	
	/*
	응답은 req.response에 저장됨
	비동기 방식으로 요청하기 때문에 send 메소드 호출 후, 바로 코드에서 접근하면 데이터가 비어있음  	-> <empty string> 출력
	AJAX의 진행에 따라 호출되는 'callback 함수를 활용'해야 함
	*/
</script>
</head>
<body>
	AJAX
</body>
</html>

<!-- 
	AJAX(Asynchronous JavaScript and XML) 
	브라우저에서 페이지를 이동하지 않고 자바스크립트를 통해 HTTP Request를 보내고 그 응답을 받아 처리할 수 있는 기술
	
	크롬에서 콘솔창을 열고 req.response를 입력해보면 data.txt 내용이 출력됨
-->