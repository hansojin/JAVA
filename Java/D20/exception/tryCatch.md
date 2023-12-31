﻿ 일반적으로 '오류'라 함은 문법적 실수를 뜻하는 경우가 많다. 따라서 대부분의 오류는 컴파일 과정에서 그 잘못이 드러난다. 그러나 '예외'는 프로그램이 실행 중에 발생하는 정상적이지 않은 상황을 뜻한다.

* if문은 예외처리 이외의 용도로도 사용되기 때문에, 프로그램 코드상에서 예외처리 부분을 구분하기가 쉽지 않다.
* try는 예외상황이 발생할만한 영역을 감싸는 용도로 사용이 되고, catch는 발생한 예외의 처리를 위한 코드를 묶어두기 위한 용도로 사용이 된다.

```
try{
	// try 영역
}
catch(AAA e){
	// catch 영역
}
```

 try와 catch는 각각이 별도의 문장처럼 느껴지는데, 이 둘은 하나의 문장이다. 때문에 try와 catch 사이에 다른 문장이 삽입될 수 없다. "try 영역에서 발생한 예외상황은 이어서 등장하는 catch 영역에서 처리한다." 

 그런데 catch 영역에서 모든 예외상황을 처리하는 것은 아니다. 위 그림의 catch 영역을 보면 매개변수 선언이 있는데(AAA e), 이 부분에 명시되어 있는 유형의 예외상황만 처리가 가능하다. 따라서 위의 문장은 다음과 같이 정리되어야 한다. "try 영역에서 발생한 AAA에 해당하는 예외상황은 이어서 등장하는 catch 영역에서 처리된다."

1. try 영역으로 일단 들어가면 무조건 실행되는 영역. 예외상황의 발생여부와 상관없이 항상 실행되는 영역 : (finally)
2. 예외상황을 알리는데 필요한 예외 클래스의 정의. "(Exception) 클래스를 상속한다."
   (Exception) 클래스는 모든 예외 클래스가 상속하는 (Throwable) 클래스의 하위 클래스이다. 따라서 이를 상속함으로써 예외 클래스가 되어서 try~catch 예외처리 메커니즘에 활용이 가능한 클래스가 된다.
3. (throw)는 예외상황이 발생되었음을 자바 가상머신에게 알리는 키워드이다. 따라서 이 문장이 실행되면서 자바의 예외처리 메커니즘이 동작하게 된다.
4. "Exception 클래스의 생성자 호출을 통해서 전달된 문자열이 (getMessage)의 호출을 통해서 반환된다."
"예외상황이 메소드 내에서 처리되지 않으면, 메소드를 호출한 영역으로 예외의 처리가 넘어감을(던져 짐을) 반드시 명시해야 한다."
5. Throwable을 상속하는 예외 클래스는 (Exception), (Error)이다. 그런데 Error는 그 이름이 의미하듯이 단순히 예외라고 하기에는 심각한 오류의 상황을 표현하기 위해 정의된 클래스이다. 따라서 이 클래스를 상속하여 정의된 클래스는(이는 프로그래머가 정의하는 클래스가 아니다) 프로그램의 실행을 멈춰야 할 정도의 매우 심각한 오류상황을 표현하는데 사용이 된다. Error를 상속하는 대표적인 클래스의 이름은 VirtualMachineError 이다. API문서에서는 이 클래스에 대해서 다음과 같이 설명한다. "자바 가상머신에 문제가 생겨서 더 이상 제대로 동작할 수 없는 상황을 알리기 위해서 정의된 클래스입니다." Error를 상속하는 클래스의 오류상황이 발생하면, 그냥 프로그램이 종료되도록 놔두는 것이 상책이다.(프로그램이 종료된 뒤 소스코드를 수정하는 등의 방식으로 원인을 해결해야 한다.)


	VirtualMachineError의 하위 클래스

	Error를 상속하는 대표적인 클래스가 VirtualMachineError이다. 그리고 이를 상속하는 클래스 중에서 OutOfMemoryError라는 클래스가 있는데, 이는 메모리 공간이 부족한 상황을 표현하는 예외 클래스이다. 따라서 이러한 오류가 발생하면, 메모리가 효율적으로(또는 적절히) 사용되도록 소스코드 자체를 변경해야 한다. 이렇듯 Error와 관련 있는 오류상황은 소스코드의 변경을 통해서 해결해야 하는 경우가 대부분이다.

	메소드를 볼 때에도 throws 절을 참조

	Exception을 상속하는 클래스의 예외 상황이 임의의 메소드 내에서 발생 가능하다면, 해당 메소드는 반드시 다음 두 가지 중 한가지 방법을 선택해서 정의되어야 한다.
	* try~catch문을 이용해서 메소드 내에서 예외를 처리하도록 정의한다.
	* throws를 이용해서 메소드를 호출한 영역으로 예외가 전달되도록 정의한다.

6. Object 클래스의 clone 이라는 메소드를 호출해서 쓸려고 한다. 그리고 clone는 상황에 따라서 CloneNotSupportedException 이라는 예외를 전달하는 메소드이다.(API 참조)
다음과 같이 메소드를 정의하면 컴파일 에러가 발생한다.
```
public void simpleMethod(int n){
	MyClass my = new MyClass();
	my.clone();
	...
}
```
컴파일 에러가 안나게 수정하면 다음과 같이 try~catch를 삽입하거나
```
public void simpleMethod(int n){
	MyClass my = new MyClass();
	try{
		my.clone();
	}
	catch(CloneNotSupportedException e) { ... }
	...
}
```
다음과 같이 throws에 의해서 던져짐을 명시해야 컴파일이 된다.
```
public void simpleMethod(int n) throws CloneNotSupportedException{
	MyClass my = new MyClass();
	my.clone();
	........
}
```

처리하지 않아도 되는 RuntimeException의 하위 클래스

Exception의 하위 클래스 중에는 RuntimeException이라는 클래스가 존재한다. 그런데 이 클래스는 그 성격이 Error 클래스와 비슷하다.(이는 Exception을 상속하는 다른 예외 클래스들과의 차이점이다.) 

RuntimeException을 상속하는 예외 클래스도 Error를 상속하는 예외 클래스와 마찬가지로 try~catch문, 또는 throws절을 이용한 예외처리를 필요로 하지 않는다. 하지만 다음과 같이 Error의 하위 클래스들과 구분되는 특징이 있다.

* RuntimeException을 상속하는 예외 클래스는 Error를 상속하는 예외 클래스처럼 치명적인 상황을 표현하지 않는다.
* 따라서 예외발생 이후에도 프로그램의 실행을 이어가기 위해서 try~catch문으로 해당 예외를 처리하기도 한다.

7. RuntimeException의 하위 클래스
* ArrayIndexOutOfBoundsException
* ClassCastException
* NegativeArraySizeException
* NullPointerException
예외의 성격이 보여주듯이 특별한 경우가 아니면, 이들에 대해서는 try~catch문을 이용해서 예외처리를 하지 않는다.

8.
* 가상머신의 예외처리1	getMessage 메소드를 호출한다.
* 가상머신의 예외처리2	예외상황이 발생해서 전달되는 과정을 출력해준다.
* 가상머신의 예외처리3	프로그램을 종료한다.