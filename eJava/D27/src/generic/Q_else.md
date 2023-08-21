- 다음의 메소드 정의를 보면서 매개변수로 전달될 수 있는 대상의 범위를 정리해 보자.

> public void hiMethod(Apple param) { ... }

	- 자료형이 Apple이거나, Apple 인스턴스 또는 Apple을 상속하는 인스턴스

- 다음의 메소드 정의를 보면서 매개변수로 전달될 수 있는 대상의 범위를 정리해 보자.

> public void onMethod(FruitBox<Fruit> param) { ... }

	- FruitBox<Fruit> 인스턴스의 참조 값

- 자료형을 결정짓는 제네릭 매개변수 T에 Fruit클래스를 포함하여, Fruit을 상속하는 클래스면 무엇이든 올 수 있음을 명시할려면?
	- <T extends Fruit>
	
- 위 문제에 해당하는 예제소스코드를 작성하시오.
	- FruitBox<? extends Fruit> box1 = new FruitBox<Fruit>();
	- *참고 Q5.java* 
	
- 전달되는 자료형에 상관없이 FruitBox<T>의 인스턴스를 참조하려면?
	- FruitBox<?> box;
	- FruitBox<? extends Object> box;
	
- FruitBox<T>가 인스턴스를 참조하되, T가 Apple 클래스 또는 Apple 클래스가 직간접적으로 상속하는 클래스인 경우에만 참조할 수 있게 하려면?
	- FruitBox<? super Apple> boundedBox;
		- extends for "~을 상속하는 클래스라면 무엇이든지" _ class의 자식
		- super for "~이 상속하는 클래스라면 무엇이든지" _ class의 부모
	
- 제네릭 클래스 A를 상속하려면?

```
class AAA<T>{
	T itemAAA;
}

class BBB<T> extends AAA<T>{
	T itemBBB;
}

BBB<String> myString = new BBB<String>();
BBB<Integer> myInteger = new BBB<Integer>();
```

	이렇게 상속이 되면, 하나의 자료형 정보로 인해서 AAA의 자료형과 BBB의 자료형이 모두 결정된다. 즉 위와 같이 문장을 구성하면, T가 각각 String과 Integer로 대체되어 인스턴스가 생성된다.

- AAA<T>클래스의 T를 지정해서 상속할려면?

```
class BBB extends AAA<String>{
	int itemBBB;
}
```
	물론 위의 BBB 클래스는 제네릭으로 정의될 수도 있다. 그러나 제네릭이 아니어도 된다는 것을 강조하기 위해서 일반 클래스로 정의하였다.
	
- 인터페이스를 제네릭으로 정의해보자

```
interface MyInterface<T>{
	public T myFunc(T item);
}

interface AAA<T>{
	void aaa(T item);
}
```
	
- 인터페이스를 구현하여 클래스를 정의하는 방식 두가지


```
class MyImplement<T> implements MyInterface<T>{
	public T myFunc(T item){
		return item;
	}
}
```
위와 같이 T를 그대로 유지하거나, 다른 하나는 다음과 같이 T의 자료형을 결정하는 방식

```
class MyImplement implements MyInterface<String>{
	public String myFunc(String item){
		return item;
	}
}
```

	주의해야 할 사실은 위의 클래스 정의와 같이 T의 자료형이 String으로 결정되면, MyInterface<T>의 메소드 myFunc를 구현할 때에도 T가 아닌 String으로 명시해야 한다는 점이다.

*cf_자료형의 이름은 제네릭 클래스의 인스턴스 생성에 사용될 수 없다. 즉, 다음의 형태로는 인스턴스의 생성이 _불가능_하다.*

```
FruitBox<int> fb1 = new FruitBox<int>();
FruitBox<double> fb2 = new FruitBox<double>();
```
	