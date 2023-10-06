## 기본 타입

자바스크립트의 기본 타입은 크게 원시 타입과 객체 타입으로 구분

* **원시 타입(primitive type)**
    1. 숫자(number)
        * 다른 언어와는 달리 정수와 실수를 따로 구분하지 않고, 모든 수를 실수 하나로만 표현
        * 매우 큰 수나 매우 작은 수를 표현할 경우에는 e 표기법을 사용
    2. 문자열(string)
        * 큰따옴표("")나 작은따옴표('')로 둘러싸인 문자의 집합
        * 숫자와 문자열을 더할 수도 있음
            * 숫자를 문자열로 자동 변환하여, 두 문자열을 연결하는 연산을 수행
    3. 불리언(boolean)
        * 참(true)과 거짓(false)을 표현
    4. 심볼(symbol) 
        * ECMAScript 6부터 제공
        * 유일하고 변경할 수 없는 타입
        * 객체의 프로퍼티를 위한 식별자로 사용
    5. undefined
        * null은 object 타입이며, 아직 '값'이 정해지지 않은 것을 의미
        * undefined란 null과는 달리 '타입'이 정해지지 않은 것을 의미
        * 따라서 undefined는 초기화되지 않은 변수나 존재하지 않는 값에 접근할 때 반환됨


* **객체 타입(object type)**
    6. 객체(object)
        * 객체는 여러 프로퍼티(property)나 메소드(method)를 같은 이름으로 묶어놓은 일종의 집합체

```
var num = 10;          // 숫자
var myName = "홍길동"; // 문자열
var str;               // undefined

var num;          // 초기화하지 않았으므로 undefined 값을 반환
var str = null;   // object 타입의 null 값
typeof secondNum; // 정의되지 않은 변수에 접근하면 undefined 값을 반환

null ==  undefined; // true
null === undefined; // false
// null과 undefined는 동등 연산자(==)와 일치 연산자(===)로 비교할 때 그 결괏값이 다름
// null과 undefined는 타입을 제외하면 같은 의미지만, 타입이 다르므로 일치하지는 않음

var dog = { name: "해피", age: 3 }; // 객체의 생성
// 객체의 프로퍼티 참조
document.getElementById("result").innerHTML =
    "강아지의 이름은 " + dog.name + "이고, 나이는 " + dog.age + "살 입니다.";
```

---

## 타입 변환

자바스크립트는 타입 검사가 매우 유연한 언어

자바스크립트의 변수는 타입이 정해져 있지 않으며, 같은 변수에 다른 타입의 값을 다시 대입할 수도 있음

```
var num = 20; // Number 타입의 20
num = "이십"; // String 타입의 "이십"
var num;      // 한 변수에 여러 번 대입할 수는 있지만, 변수의 재선언은 할 수 없으며 재선언문은 무시됨
```

