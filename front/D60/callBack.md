## 자바스크립트 콜백 함수 란?

콜백(Callback) 함수는 간단히 말하면 **매개변수로 함수 객체를 전달** 해서 호출 **함수 내에서 매개변수 함수를 실행하는 것** 을 말한다. 예를 들어 아래 코드와 같이 `sayHello() 함수`를 호출할때 입력 매개변수로 문자열과 `printing` 함수 자체를 전달하는 것을 볼 수 있다. 그리고 `sayHello()` 함수가 실행되면 실행문 안에서 함수가 들은 두번째 매개변수인 `callback` 을 괄호 () 를 붙여 호출한다.

```
function sayHello(name, callback) {
    const words = '안녕하세요 내 이름은 ' + name + ' 입니다.';
    callback(words);    // 매개변수의 함수(콜백 함수) 호출
}

sayHello("인파", function printing(name) {
	console.log(name);      
});
```

즉, 콜백 함수란 파라미터로 일반적인 변수나 값을 전달하는 것이 아닌 **함수 자체를 전달하는 것** 을 말한다고 보면 된다. 또한 어차피 매개변수에 함수를 전달해 **일회용으로 사용** 하기 때문에 굳이 함수의 이름을 명시할 필요가 없어 보통 콜백 함수 형태로 함수를 넘겨줄때 함수의 이름이 없는 **'익명 함수' 형태** 로 넣어주게 된다.

```
function sayHello(name, callback) {
    const words = '안녕하세요 내 이름은 ' + name + ' 입니다.';
    callback(words);
}

sayHello("인파", function (name) { 
	console.log(name); 
});
```

---

### 콜백 함수 사용 원칙

1. 익명의 함수 사용

위에서 소개했듯이 보통 콜백 함수는 호출 함수에 일회용으로 사용하는 경우가 많아, **코드의 간결성** 을 위해 이름이 없는 '익명의 함수'를 사용한다. 함수의 내부에서 매개변수를 통해 실행되기 때문에 이름을 붙이지 않아도 되기 때문이다.

이밖에도 뜻하지 않은 개발자의 실수로 인한 **함수 이름의 충돌 방지** 를 위한 이유도 있다. 콜백함수에 이름을 붙이면, 그 이름은 함수 스코프 내에서 유효한 식별자가 되는데, 만약 같은 스코프 내에 이미 같은 이름의 식별자가 있다면, 콜백함수의 이름이 기존의 식별자를 덮어쓰게 되어 버린다. 이는 의도치 않은 결과를 초래할 수 있다. 예를 들어, 아래 코드에서는 변수 `add`와 콜백함수의 이름이 `add`로 설정할 경우, 콜백 함수가 변수의 값을 변경해 버리게 된다.

```
let add = 10; // 변수 add

function sum(x, y, callback) {
  callback(x + y);  // 콜백함수 호출
}

// 이름 있는 콜백함수 작성
sum(1, 2, function add(result) {
  console.log(result);  // 3
});

// 변수 add가 함수 add가 되어버린다.
console.log(add);   // function add(result) {...}
```

2. 화살표 함수 모양의 콜백

콜백 함수를 익명 함수로 정의함으로써 코드의 간결성을 얻을 수 있었지만, 한단계 더 간결성을 얻기 위해 자바스크립트의 화살표 함수를 통해 '익명 화살표 함수' 형태로 정의해 사용할 수 있다. 이러한 익명 화살표 콜백 함수 형태는 앞으로 자바스크립트 프로그래밍을 하면서 정말 자주 접하게 되는 형태이다.

```
function sayHello(callback) {
  var name = "Alice";
  callback(name); // 콜백 함수 호출
}

// 익명 화살표 콜백 함수
sayHello((name) => {
  console.log("Hello, " + name);       // Hello, Alice
}); 
```

3. 함수의 이름을 넣기

자바스크립트는 일급 객체의 특성을 가지고 있기 때문에, 자바스크립트는 null과 undefined 타입을 제외하고 모든 것을 객체로 다룬다. 그래서 매개변수에 일반적인 변수나 상수값 뿐만 아니라 함수 자체를 객체로서 전달이 가능한 것이다. 만일 콜백 함수가 일회용이 아닌 여러 호출 함수에 재활용으로 자주 이용될 경우, 별도로 함수를 정의하고 **함수의 이름만 호출 함수의 인자에 전달** 하는 식으로 사용이 가능하다.

```
// 콜백 함수를 별도의 함수로 정의
function greet(name) {
  console.log("Hello, " + name);
}

function sayHello(callback) {
  var name = "Alice";
  callback(name); // 콜백 함수 호출
}

function sayHello2(callback) {
  var name = "Inpa";
  callback(name); // 콜백 함수 호출
}

// 콜백 함수의 이름만 인자로 전달
sayHello(greet); // Hello, Alice
sayHello2(greet); // Hello, Inpa
```

이러한 특징을 응용하면, 매개변수에 전달할 콜백 함수 종류만을 바꿔줌으로서 **여러가지 함수 형태를 다양하게 전달이 가능** 하다. 아래와 같이 다른 동작을 수행하는 함수 `say_hello` 와 `say_bye` 를 정의해두고 `introduce` 함수의 입력값으로 각기 다른 콜백 함수를 전달해주면, introduce라는 함수에서 다른 동작을 수행하는 것이 가능해진다.

```
function introduce (lastName, firstName, callback) {
    var fullName = lastName + firstName;
    callback(fullName);
}

function say_hello (name) {
    console.log("안녕하세요 제 이름은 " + name + "입니다");
}

function say_bye (name) {
    console.log("지금까지 " + name + "이었습니다. 안녕히계세요");
}

introduce("홍", "길동", say_hello);// 안녕하세요 제 이름은 홍길동입니다
introduce("홍", "길동", say_bye);  // 지금까지 홍길동이었습니다. 안녕히계세요
```

---

### 콜백 함수 활용 사례

위 처럼 직접 콜백 함수를 만들어 사용하기도 하지만, 이미 우리는 자바스크립트에서 콜백 함수를 사용하는 여러가지 메서드를 이용해왔었다.

1. 이벤트 리스너로 사용

`addEventListener`는 특정 이벤트가 발생했을 때 콜백 함수를 실행하는 메서드이다. 클릭과 같은 이벤트를 처리하기 위해 등록하는 이벤트 리스너로 콜백함수가 쓰인다. 버튼을 클릭하면 그에 연관되는 스크립트 실행을 콜백 함수로 등록하는 형태인 것이다.

```
let button = document.getElementById("button"); // 버튼 요소를 선택

// 버튼에 클릭 이벤트 리스너를 추가
button.addEventListener("click", function () { // 콜백 함수
  console.log("Button clicked!"); 
});
```
2. 고차함수에 사용

자바스크립트에서 for문 보다 더 자주 사용되는 반복문이 `forEach` 메서드일 것이다. 이 역시 `forEach` 메서드의 입력값으로 콜백 함수를 전달하는 형태임을 볼 수 있다.

```
// 예시 : 배열의 각 요소를 두 배로 곱해서 새로운 배열을 생성하는 콜백 함수 
let numbers = [1, 2, 3, 4, 5]; // 배열 선언 
let doubled = []; // 빈 배열 선언 

// numbers 배열의 각 요소에 대해 콜백 함수 실행 
numbers.forEach(function (num) { 
    doubled.push(num * 2); // 콜백 함수로 각 요소를 두 배로 곱해서 doubled 배열에 추가 
}); 

console.log(doubled); // [2, 4, 6, 8, 10]
```

3. Ajax 결과값을 받을 때 사용

서버와 데이터를 주고받을 때 사용하는 fetch 메서드의 서버 요청의 결과값을 처리하기 위해 콜백 함수가 사용된다.

```
// fetch 메서드를 사용하여 서버로부터 JSON 데이터를 받아오고 콜백 함수로 화면에 출력
fetch("https://jsonplaceholder.typicode.com/users")
  .then(function (response) {
    // fetch 메서드가 성공하면 콜백 함수로 response 인자를 받음
    return response.json(); // response 객체의 json 메서드를 호출하여 JSON 데이터를 반환
  })
  .then(function (data) {
    // json 메서드가 성공하면 콜백 함수로 data 인자를 받음
	console.log(data);
  })
```

4. 타이머 실행 함수로 사용
`setTimeout`이나 `setInterval`과 같은 타이머 함수에서 일정 시간마다 스크립트를 실행하는 용도로서 콜백 함수를 이용한다.

```
// 3000 밀리초(3초) 후에 콜백 함수 실행
setTimeout(function () {
  console.log("Time is up!"); // 콜백 함수로 콘솔에 메시지 출력
}, 3000);
```

5. 애니메이션 완료

jQuery에서 제공하는 애니메이션 메서드들은 애니메이션이 끝난 후에 실행할 콜백 함수를 인자로 받는다.

```
// jQuery의 slideUp 메서드를 사용하여 #box 요소를 숨기고 콜백 함수로 콘솔에 메시지 출력
$("#box").slideUp(1000, function () {
  console.log("Animation completed!"); // 콜백 함수로 콘솔에 메시지 출력
});
```

---

### 자바스크립트 콜백 함수 주의점

#### this를 사용한 call back 함수

콜백 함수 내에서 this 키워드를 사용하면, 기대한 대로 작동하지 않을 수가 있다. 아래 코드를 보자.

```
let userData = {
    signUp: '2021-4-06 12:00:00',
    name: 'Not Set',
    setName: function(firstName, lastName) {
        this.name = firstName + ' ' + lastName;
    }
}

// 해당 콜백함수는 userData.setName과 아무런 관계가 없는 함수 형태만 비슷한 독립적인 함수이다.
function getUserName(firstName, lastName, callback) {
    callback(firstName, lastName);
}

getUserName('홍', '길동', userData.setName);

console.log('1: ', userData.name);  // Not Set
console.log('2: ', window.name);    // 홍 길동
```

getUserName 함수를 실행한 후 실행 첫 번째 콘솔의 값이 '홍 길동' 이기를 기대했지만, Not Set이 출력되는 걸 볼 수 있다. 왜냐하면 userData 객체의 setName 프로퍼티 함수 내부에서 사용된 this.name 이 userData 객체의 name을 가리키는게 아니라 전역 객체 window 의 name을 가리키기 때문이다.

#### 콜백 this가 전역 객체인 이유

콜백 함수는 다른 함수의 인자로 전달되는 함수다. 그래서 콜백 함수는 자신을 전달받은 함수에 의해 호출되는데, 이때 콜백 함수 내부에서의 `this`는 해당 콜백 함수의 제어권을 넘겨받은 함수가 정의한 바에 따르며, 정의하지 않은 경우에는 전역 객체를 참조하게 된다.

아래의 코드에서 `userData.setName('홍', '길동')`와 같이 직접 객체의 **메서드 호출 방식**으로 실행되었다. 메서드 호출 방식에서는 `this`는 함수가 들어있는 자기 자신 객체인 `userData` 를 가리킨다. 따라서 정상적으로 `userdata.name` 프로퍼티 값이 업데이트 되게 된다.

#### 콜백 this 해결 방안

따라서 콜백 함수 내의 this를 보호할 수 있도록 콜백 함수를 만들어야 한다.

1. call , bind, apply 메서드 사용
 
* call() : 첫 번째 인자로 this 객체 사용, 나머지 인자들은 , 로 구분
* apply() : 첫 번째 인자로 this 객체 사용, 나머지 인자들은 배열 형태로 전달

원리는 간단하다. 참조할 객체를 추가로 함수의 매개변수로 전달하고, 콜백 함수 내에서 call(), apply() 메서드를 통해 콜백 함수가 참조할 객체를 지정해주면 된다.

```
// this 대신 userData를 사용하는 방법 1. call()
let userData = {
    signUp: '2021-4-06 12:00:00',
    name: 'Not Set',
    setName: function(firstName, lastName) {
        this.name = firstName + ' ' + lastName;
    }
}

function getUserName(firstName, lastName, callback, data) { 
    // userData를 받는 매개변수 data를 추가
    callback.call(data, firstName, lastName); // data를 this로 사용
}

getUserName('홍', '길동', userData.setName, userData); // userData를 인수로 전달

console.log('1: ', userData.name); // 홍 길동
console.log('2: ', window.name); // Not Set
```

```
// this 대신 userData를 사용하는 방법 2. apply()
let userData = {
    signUp: '2021-4-06 12:00:00',
    name: 'Not Set',
    setName: function(firstName, lastName) {
        this.name = firstName + ' ' + lastName;
    }
}

function getUserName(firstName, lastName, callback, data) { 
    // userData를 받는 매개변수 data를 추가
    callback.apply(data, [firstName, lastName]); // data를 this로 사용하고 배열을 전달
}

getUserName('홍', '길동', userData.setName, userData); // userData를 인수로 전달

console.log('1: ', userData.name); // 홍 길동
console.log('2: ', window.name); // Not Set
```

2. 화살표 함수 사용

또다른 심플한 방법으로는 화살표 함수를 사용해서 this를 외부 함수의 this와 동일하게 유지하는 방법이 있다. **화살표 함수는 자신만의 this를 가지지 않고** 상위 스코프의 this를 참조하기 때문에 전역 객체를 무시하고 무조건 자신을 들고 있는 상위 객체를 가리킨다.

```
let userData = {
    signUp: '2021-4-06 12:00:00',
    name: 'Not Set',
    setName: (firstName, lastName) => { // 화살표 함수로 변경
        this.name = firstName + ' ' + lastName;
    }
}

function getUserName(firstName, lastName, callback) {
    callback(firstName, lastName); // call 메서드 없이 호출
}

getUserName('홍', '길동', userData.setName);

console.log('1: ', userData.name); // 홍 길동
console.log('2: ', window.name); // Not Set

```

---

### 콜백 지옥 (Callback Hell)

콜백 지옥이란 함수의 매개변수로 넘겨지는 콜백 함수가 반복되어 코드의 들여쓰기 수준이 감당하기 힘들어질 정도로 깊어지는 현상이다.

```
function add(x, callback) {
    let sum = x + x;
    console.log(sum);
    callback(sum);
}

add(2, function(result) {
    add(result, function(result) {
        add(result, function(result) {
            console.log('finish!!');
        })
    })
})

/*
4
8
16
finish!!
*/
```

---

### 자바스크립트 비동기와 콜백

자바스크립트는 **싱글 스레드 언어** 로서, 하나의 작업만을 동시에 처리할 수 있다. 즉, 자바스크립트는 코드를 **위에서 아래로 순차적으로 실행** 한다. 그런데 웹 개발에서는 네트워크 요청이나 타이머 등의 작업이 필요한 경우가 많은데, 이러한 작업들은 시간이 오래 걸리거나 결과가 불확실하다. 그래서 자바스크립트는 **비동기(asynchronous) 방식으로 작업을 처리** 하는 기법을 제공한다.

비동기란 현재 실행중인 작업을 멈추지 않고 **다른 작업을 병렬적으로 수행** 하는 것을 의미한다. 그래서 여러 작업(task)이 있을 때 비동기적으로 수행하면 작업들을 동시에 한번에 수행할 수 있어 위 사진 처럼 결과적으로 최종 작업 수행이 빠르게 처리되게 된다. 그리고 이러한 비동기 방식으로 작업을 처리하는 방법 중 하나가 바로 콜백(callback) 함수이다.

콜백 함수는 비동기 이벤트 작업을 위해 자바스크립트에서 광범위하게 사용된다. 



