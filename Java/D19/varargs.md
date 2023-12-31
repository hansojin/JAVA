## 가변인자(varargs)와 오버로딩
---
* 기존에는 메서드의 매개변수 개수가 고정적이었으나 JDK1.5부터 동적으로 지정해 줄 수 있게 되었으며, 이 기능을 **가변인자(variable arguments)** 라고 한다.
* 가변인자는 ' **타입... 변수명** ' 과 같은 형식으로 선언하며, PrintStream 클래스의 printf()가 대표적인 예이다.

```
public PrintStream printf(String format, Object... args ) {
	 // 코드 
}
```
위와 같이 가변인자 외에도 매개변수가 더 있다면, 가변인자를 매개변수 중에서 **제일 마지막에 선언** 해야 한다. 그렇지 않으면, 컴파일 에러가 발생한다. 가변인자인지 아닌지를 구별할 방법이 없기 때문에 허용하지 않는 것이다.
```
> // 컴파일 에러 발생 - 가변인자는 항상 마지막 매개변수이어야 한다.
public PrintStream printf(Object... args, String format){
	// 코드
}
```

만일 여러 문자열을 하나로 결합하여 반환하는 concatenate 메서드를 작성한다면, 아래와 같이 매개변수의 개수를 다르게 해서 여러 개의 메서드를 작성해야할 것이다.
```
String concatenate(String s1, String s2) { //코드 }
String concatenate(String s1, String s2, String s3) { //코드 }
String concatenate(String s1, String s2, String s3, String s4) { //코드 }
```
이럴 때, 가변인자를 사용하면 메서드 하나로 간단히 대체할 수 있다.

```
String concatenate(String... str) { // 코드 }
```

이 메서드를 호출할 때는 아래와 같이 인자의 개수를 가변적으로 할 수 있다. 심지어는 인자가 아예 없어도 되고 배열도 인자가 될 수 있다.

```
System.out.println(concatenate());			// 인자가 없음
System.out.println(concatenate("a"));			// 인자가 하나
System.out.println(concatenate("a", "b"));		// 인자가 둘
System.out.println(concatenate(new String[] {"A", "B"));	// 배열도 가능
```

이쯤에서 아마도 눈치를 챘을 것이다. 그렇다 가변인자는 내부적으로 배열을 이용하는 것이다. 그래서 가변인자가 선언된 메서드를 호출할 때마다 배열이 새로 생성된다. 가변인자가 편리하지만, 이런 비효율이 숨어있으므로 꼭 필요한 경우에만 가변인자를 사용하자.

그러면 가변인자는 아래와 같이 매개변수의 타입을 배열로 하는 것과 어떤 차이가 있는가?
```
String cocatenate(String[] str) { // 코드}

String result = concatenate(new String[0]);		// 인자로 배열을 지정
String result = concatenate(null);			// 인자로 null을 지정
String result = concatenate();			// 에러. 인자가 필요함.
```
매개변수의 타입을 배열로 하면, 반드시 인자를 지정해 줘야하기 때문에, 위의 코드에서처럼 인자를 생략할 수 없다. 그래서 null이나 길이가 0인 배열을 인자로 지정해줘야 하는 불편함이 있다.

*[참고] C언어와 달리 자바에서는 길이가 0인 배열을 생성하는 것이 허용된다.*

가변인자를 오버로딩할 때 한 가지 주의해야할 점이 있는데, 먼저 예제부터 살펴보자.

```
class VarArgsEx {
	public static void main(String[] args) {
		String[] strArr = { "100", "200", "300" };
		
		System.out.println(concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");
	}

	static String concatenate(String delim, String... args) {
		String result = "";

		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}

/*
	static String concatenate(String... args) {
		return concatenate("",args);
	}
*/
} 
```

실행결과
```
> 100200300
> 100-200-300-
> 1,2,3,
> []
> []
```

concatenate 메서드는 매개변수로 입력된 문자열에 구분자를 사이에 포함시켜 결합해서 반환한다. 

가변인자로 매개변수를 선언했기 때문에 문자열을 개수의 제약없이 매개변수로 지정할 수 있다.
```
String[] strArr = new String[] {"100", "200", "300"};
System.out.println(concatenate("-", strArr));
```
위의 두 문장을 하나로 합치면 아래와 같이 쓸 수 있다.
```
System.out.println(concatenate("-", new String[]{"100", "200", "300"}));
```
그러나 아래와 같은 문장은 허용되지 않는다는 것에 주의하자.
```
// System.out.println(concatenate("-", {"100", "200", "300"}));
```
위의 예제에서는 주석처리하였지만, concatenate 메서드의 또 다른 오버로딩된 메서드가 있다.
```
	static String concatenate(String delim, String... args) {
		String result = "";

		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}


	static String concatenate(String... args) {
		return concatenate("",args);
	}
```
이 두 메서드는 별 문제가 없어 보이지만 위의 예제에서 주석을 풀고 컴파일을 하면 아래와 같이 컴파일에러가 발생한다.
```
> Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
> 	The method concatenate(String, String[]) is ambiguous for the type VarArgsEx
> 	The method concatenate(String, String[]) is ambiguous for the type VarArgsEx
> 
> 	at VarArgsEx.main(VarArgsEx.java:5)
```
에러의 내용을 살펴보면 두 오버로딩된 메서드가 구분되지 않아서 발생하는 것임을 알 수 있다. 가변인자를 선언한 메서드를 오버로딩하면, 메서드를 호출했을 때 이와 같이 구별되지 못하는 경우가 발생하기 쉽기 때문에 주의해야 한다. 가능하면 가변인자를 사용한 메서드는 오버로딩하지 않는 것이 좋다.