자바스크립트는 사용자의 편의를 위해 다양한 기능의 여러 전역 함수를 미리 정의하여 제공

1. eval()
    * 문자열로 표현된 자바스크립트 코드를 실행
    ```
    var x = 10, y = 20;
    var a = eval("x + y"); // 30
    var b = eval("y * 3"); // 60
    ```
2. isFinite()
    * 전달된 값이 유한한 수인지를 검사하여 그 결과를 반환
    * 만약 인수로 전달된 값이 숫자가 아니라면, 숫자로 변환하여 검사
3. isNaN()
    * 전달된 값이 NaN인지를 검사하여 그 결과를 반환
    * 만약 인수로 전달된 값이 숫자가 아니라면, 숫자로 강제 변환하여 검사
4. parseFloat()
    * 문자열을 파싱하여 부동 소수점 수(floating point number)로 반환
5. parseInt()
    * 문자열을 파싱하여 정수로 반환
6. decodeURI()
7. decodeURIComponent()
8. encodeURI()
9. encodeURIComponent() 
10. escape()
    * 특정 문자들을 16진법 이스케이프 시퀀스 문자로 변환
11. unescape()
    * 16진법 이스케이프 시퀀스 문자를 원래의 문자로 변환
12. Number()
    * 전달받은 객체의 값을 숫자로 반환
13. String()
    * 전달받은 객체의 값을 문자열로 반환