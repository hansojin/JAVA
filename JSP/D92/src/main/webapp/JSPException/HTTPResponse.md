# HTTP 응답 메세지 구조 / 응답 코드

## HTTP 응답 메세지 구조

### 구성 요소

- Response Line
	- version : http protocol version
	- status : request 처리 여부 / 응답 코드
- HTTP
- Header Data

### 응답 코드

* 1XX : **정보전달** _ 요청에 대해여 작업을 하고 있을 때 응답 코드
* 2XX : **성공** _ 요청에 대하여 성공적으로 응답할 때 응답 코드
* 3XX : **리다이렉션** _ URI에 대하여 데이터가 없을 때 응답 코드로 위치 이동이 대표적
* 4XX : **클라이언트 오류** _ 클라이언트의 요청이 형식에 맞지 않거나 인증되지 않을 때 응답 코드
	* 400 Bad Request
	* 401 Unauthorized
	* 403 Forbidden
	* 404 Not Found
* 5XX : **서버오류** _ 서버 에러로 인해 응답에 실패할 때 응답 코드
