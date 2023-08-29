## 람다식(Lambda expression)

자바가 1996년에 처음 등장한 이후로 두 번의 큰 변화가 있었는데, 한번은 JDK1.5부터 추가된 지네릭스(generics)의 등장이고, 또 한번은 JDK1.8부터 추가된 람다식(lambda expression)의 등장이다. 

특히 람다식의 도입으로 인해, 이제 자바는 객체지향언어인 동시에 함수형 언어가 되었다.

### 람다식이란?

람다식(Lambda expression)은 간단히 말해서 메서드를 하나의 '식(expression)'으로 표현한 것이다. 

메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 '익명 함수(anonymous function)'이라고도 한다.

```
int[] arr = new int[5];
Arrays.setAll(arr, ()->(int)(Math.random()*5+1));	// arr=[1,5,2,1,1]
```

위의 람다식을 메서드로 표현하면 다음과 같다.

```
int method() {
	return (int)(Math.random()*5 + 1;
}
```

람다식은 메서드의 매개변수로 전달되어지는 것이 가능하고, 메서드의 결과로 반환될 수도 있다. 람다식으로 인해 메서드를 변수처럼 다루는 것이 가능해진 것이다.

람다식 예시 1

```
// 메서드
int max(int a, int b) {
	return a > b ? a : b;
}

// 람다식
// (1) method 명 생략가능, lambda 표시 '->' 
(int a, int b) -> { return a > b ? a : b?; }
// (2) 한문장이면 중괄호 생략 가능 (근데 return 이 있으면 생략 불가능). return 과 중괄호 같이 생략 (as, 연산결과 자동으로 반환)
(int a, int b) -> a > b ? a : b
// (3) 자료형 생략
(a, b) -> a > b? a : b
```
람다식 예시2

```
//메서드
void printVar(String name, int i) {
	System.out.println(name + "=" + i);
}

// 람다식
// (1)
(String name, int i) -> { System.out.println(name + "=" + i); }
// (2)
(name, i) -> { System.out.println(name + "=" + i); }
// (3)
(name,i) -> System.out.println(name + "=" + i)
```

람다식 예시3

```
// 메서드
int square(int x) {
	return x * x;
}

// 람다식

// (1)
(int x) -> x* x
// (2)
(x) -> x * x
// (3) 매개변수가 하나면, 소괄호 생략이 가능함
x -> x * x
```

람다식 예시4

```
// 메서드
int roll() {
	return (int) (Math.random() * 6);
}

// 람다식
// (1)
() -> { return (int) (Math.random() * 6); }
// (2)
() -> (int) (Math.random() * 6)
```

람다식 예시5

```
// 메서드
int sumArr(int[] arr) {
	int sum = 0;
	for(int i : arr)
		sum += i;
	return sum;
}

// 람다식
// 매개변수가 두개이상이므로, 소괄호 생략 불가능
(arr) -> {
	int sum = 0;
	for(int i : arr)
		sum += i;
	return sum;
}
```