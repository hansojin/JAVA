![Exception-Hierarchy](https://github.com/hansojin/JAVA/assets/112622663/6d129450-dffe-4740-8e58-aad54f943d13)

**Throwable을 상속받는 대표적 두 유형은 Error, Exception**

**Exception내 RunTimeException을 제외한 나머지 예외처리는 반드시 try-catch문 필요**

* RuntimeException 클래스들 프로그래머의 실수로 발생하는 예외
* Exception 클래스들 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외

예외처리(exception handling)의 

정의 : 프로그램 실행 시 발생할 수 있는 **예외의 발생에 대비한 코드를 작성** 하는 것

목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것

**컴파일러가 예외 처리를 확인하지 않는** RuntimeException 클래스들은 **'unchecked 예외'**라고 부르고, **예외처리를 확인하는  Exception 클래스들은 'checked 예외'** 라고 부른다.

*[참고] Error와 그 자손도 unchecked예외이다. try~catch 블럭으로 처리할 수 없기 때문이다.*

* __unchecked__ : try-catch 구문으로 exception을 처리해도 되고 안해도 되는 부분
* __checked__ : 반드시 예외 처리 해야하는 부분

```
class ExceptionEx11 {
	public static void main(String[] args) {
		throw new RuntimeException();	// RuntimeException을 고의로 발생시킨다.
	}
}
```

 'RunTimeException클래스와 그 자손(RuntimeException클래스들)'에 해당하는 예외는 프로그래머에 의해 실수로 발생하는 것들이기 때문에 예외처리를 강제하지 않는 것이다. 만일 RuntimeException 클래스들에 속하는 예외가 발생할 가능성이 있는 코드에도 예외처리를 필수로 해야 한다면, 아래와 같이 참조 변수와 배열이 사용되는 모든 곳에 예외처리를 해주어야 할 것이다.
```
try{
	int[] arr = new int[10];
	System.out.println(arr[0]);
} catch(ArrayIndexOutOfBoundsException ae){
	...
} catch(NullPointerException ne) {
	...
}
```


#### 가상머신의 예외처리 방법
1.	getMessage 메소드를 호출한다.
2.  예외상황이 발생해서 전달되는 과정을 출력해준다.
3.	프로그램을 종료한다.

예외처리를 하지 않아도, 아래와 같이 getMessage + printStackTrace 가 출력되고 프로그램이 종료된다 (unchecked 한정)
```
> Exception in thread "main" java.lang.ArithmeticException: / by zero
>        at Test12.div(Test12.java:8)
```
