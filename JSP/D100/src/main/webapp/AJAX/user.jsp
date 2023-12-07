<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP AJAX</title>
<script>
		var searchRequest = new XMLHttpRequest();
		var registerRequest = new XMLHttpRequest();

		function searchFunction() {
			searchRequest.open("get", "./userSearch.do?userName=" + encodeURIComponent(document.getElementById("userName").value), true);
			searchRequest.onreadystatechange = searchProcess;
			searchRequest.send();

			/*
			@ open(method, url, async) 
			method : the type of request : GET or POST
			url : the server (file) location
			async : true (asynchronous) or false (synchronous) 
			
			async : false (synchronous)
			동기적으로 동작하므로 이 함수가 호출되면 UI가 멈춤 (즉, 사용불가 상태가 됨).
			따라서 브라우저가 우리 요청을 처리하는 동안에도 평상시처럼 계속 동작하게 하려면, async : true (asynchronous)를 사용해야 함

			@ 동기식 처리 모델(Synchronous processing model) : 직렬적으로 태스크(task)를 수행 = 어떤 작업이 수행 중이면 다음 작업은 대기/블로킹하게 됨
			@ 비동기식 처리 모델 (Asynchronous processing model 또는 Non-Blocking processing model) : 병렬적으로 태스크 수행 = 이후 서버로부터 데이터가 응답되면 이벤트가 발생하고 이벤트 핸들러가 데이터를 가지고 수행할 태스크를 계속해 수행
			
			cf. 자바스크립트의 대부분의 DOM 이벤트와 Timer 함수(setTimeout, setInterval), Ajax 요청은 비동기식 처리 모델로 동작함
			
			--- 

			@ XMLHttpRequest도 파라미터를 웹서버에 전송하기 때문에 JS가 지원해주는 인코딩 처리 함수인 escape()와 encodeURIComponent()를 사용해야함 

			두 함수의 실행 결과는 문서 캐릭터셋이 euc-kr 이거나 utf-8 인 경우 모두 동일하다.
			escape('한글')				%uD55C%uAE00		유니코드 값을 표현
			encodeURIComponent('한글')	%ED%95%9C%EA%B8%80	utf-8로 인코딩. encodeURI() 함수도 동일한 결과 출력

			두 함수의 실행 결과를 보면 encodeURIComponent() 함수가 utf-8로 인코딩한 결과를 보여줌을 알 수 있다. 
			따라서, XMLHttpRequest로 한글 파라미터를 전송할 때에는 다음과 같은 방법을 사용하면 된다.
			웹브라우저에서: 자바스크립트 encodeURIComponent() 함수를 사용하여 파라미터 값을 utf-8로 인코딩하여 전송한다.
			서버에서: 파라미터 값을 utf-8로 디코딩하여 읽어온다.
			
			---

			서버에서 응답이 도착하면 특정한 자바스크립트 함수를 호출할 수 있는것이 onreadystatechange
			작업의 주체인 XMLHTTP에게 서버로 부터 응답을 받을 때 까지 대기하고 있다가 다 되고 알려주면 콜백함수(여기서는 searchProcess)를 호출하겠다는 의미
			*/
		}
		
		function searchProcess(){
			var table = document.getElementById("ajaxTable");
			table.innerHTML = "";
			if(searchRequest.readyState == 4 && searchRequest.status == 200){
				var object = eval('(' + searchRequest.responseText + ')');
				var result = object.result;
				for(var i = 0; i < result.length ; i++){
					var row = table.insertRow(0);
					for(var j = 0; j < result[i].length; j++){
						var cell = row.insertCell(j);
						cell.innerHTML = result[i][j].value;
						console.log("result[" + i + "]" + "["+ j+"]" + result[i][j].value);
					}
				}
			}
			/*
				responseText 프로퍼티는 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환
				-> eval(string) : eval('2+2')는 문자열 2+2가 아니라 계산한 결과 4
				
				JSON Text를 Object로 변환해야 할 때가 있다. 여기서 JSON Text라는 것은 형태는 JSON의 형태이지만 JS에서 이걸 Object가 아닌 그냥 텍스트로만 인식하고 있다는 것이다. 이걸 Object로 바꾸어야만 그안의 값을 불러다가 사용할 수 있다.
				가장 흔한 예가 Ajax를 사용할 경우이다. Ajax로 호출을 하고 결과값으로 받은 req.responseText로 JSON을 받았을 경우에는 그냥 Text이기 때문에 Object로 변환해 주어야 한다.

				Ajax에서 리턴받을 JSON의 형태가 { id:'JH', sex:'male' } 처럼 되어 있을 경우에
				var obj = eval("("+returnValue.responseText+")"); 처럼 eval을 해주면 JSON 오브젝트로 변환할 수 있다.					
			*/
		}

		function registerFunction(){
			let radioButtons = document.querySelectorAll('input[type="radio"]');
			let checkedValue;
			radioButtons.forEach(radioButton => {
				if(radioButton.checked){
					checkedValue = radioButton.value;
				}
			});			
			
			registerRequest.open("get", "./userRegister.do?userName=" + encodeURIComponent(document.getElementById("registerName").value)
														+ "&userAge=" + encodeURIComponent(document.getElementById("registerAge").value)
														+ "&userGender=" + encodeURIComponent(checkedValue)
														+ "&userEmail=" + encodeURIComponent(document.getElementById("registerEmail").value),
														true);
			registerRequest.onreadystatechange = registerProcess;
			registerRequest.send();			 
		}

		function registerProcess(){
			if(registerRequest.readyState == 4 && registerRequest.status == 200) {
				var result = registerRequest.responseText;		// responseText : 서버에 요청하여 응답으로 받은 데이터를 문자열로 반환
				if(result != 1){
					alert("등록에 실패했습니다.");
				}else {
					var userName = document.getElementById("userName");
					var registerName = document.getElementById("registerName");
					var registerAge = document.getElementById("registerAge");
					var registerEmail = document.getElementById("registerEmail");
					userName.value = "";
					registerName.value = "";
					registerAge.value = "";
					registerEmail.value = "";
					searchFunction();
				}
			}
		}

		window.onload = function(){
			searchFunction();
		}

	</script>
</head>
<body>
	<input id="userName" onkeyup="searchFunction();" type="text" size="20">
	<button onclick="searchFunction();" type="button" style='background-color: white'>검색</button><br><br>
	
	<table class="table" style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th style="background-color: #fafafa; text-align: center;">이름</th>
				<th style="background-color: #fafafa; text-align: center;">나이</th>
				<th style="background-color: #fafafa; text-align: center;">성별</th>
				<th style="background-color: #fafafa; text-align: center;">이메일</th>
			</tr>
		</thead>
		<tbody id="ajaxTable"></tbody>
	</table><br><br>

	<table style="text-align: center; border: 1px solid #dddddd">
		<thead>
			<tr>
				<th colspan="2" style="background-color: #fafafa;">회원 등록 양식</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이름</h5></td>
				<td><input type="text" id="registerName" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>나이</h5></td>
				<td><input type="text" id="registerAge" size="20"></td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>성별</h5></td>
				<td>
					<div style="text-align: center; margin: 0 auto;">
						<input type="radio" name="registerGender" value="남자" checked>남자 
						<input type="radio" name="registerGender"  value="여자">여자
					</div>
				</td>
			</tr>
			<tr>
				<td style="background-color: #fafafa; text-align: center;"><h5>이메일</h5></td>
				<td><input class="form-control" type="text" id="registerEmail" size="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="registerFunction();" type="button" style='background-color: white; width:95%'>등록</button>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
