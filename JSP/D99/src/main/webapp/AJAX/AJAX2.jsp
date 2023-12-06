<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AJAX</title>
<script>
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function a(){
		console.log(this.readyState, this.status);
		if(this.readyState == 4 && this.status == 200){
			console.log(this.response);
		}
	}
	
	/*
	Document.readyState 속성을 통해 document의 로딩 상태를 확인할 수 있다.
	Document.readyState 속성 값이 바뀔 때마다 readystatechange 이벤트 발생

	<Syntax>
	var string = document.readyState;

	<readyState 상태>
	 0. UNSENT : XMLHttpRequest 객체가 생성됨.
	 1. OPENED : open() 메소드가 성공적으로 실행됨.
	 2. HEADERS_RECEIVED : 모든 요청에 대한 응답이 도착함.
	 3. LOADING : 요청한 데이터를 처리 중임.
	 4. DONE : 요청한 데이터의 처리가 완료되어 응답할 준비가 완료됨.
	*/
	
	req.open("GET", "./data.txt");
// 	req.open("GET", "http://localhost:8080/AJAX1/wrong.jsp");	// 2부터 404
	req.send();
	console.log(req.response);
</script>
</head>
<body>
AJAX
</body>
</html>