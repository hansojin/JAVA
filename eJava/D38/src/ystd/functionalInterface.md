표준으로 정의된 대표적인 함수형 인터페이스 네 개와 그 안에 위치한 추상 메소드는 다음과 같다. 그리고 이들은 모두 java.util.function 패키지로 묶여 있다.

| 인터페이스 | 추상메소드 |
| ------ | ----------- |
|Predicate<T>|		boolean test(T t)|
|Supplier<T>|		T get()|
|Consumer<T>| 		void accept(T t)|
|Function<T, R>| 		R apply(T t)|

*[참고] java.lang.Runnable		void run()*

* 매개변수가 두 개인 함수형 인터페이스

매개변수의 개수가 2개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다.

*[참고] 매개변수의 타입으로 보통 'T'를 사용하므로, 알파벳에서 'T'의 다음 문자인 'U', 'V', 'W'를 매개변수의 타입으로 사용하는 것일 뿐 별다른 의미는 없다.* 

|함수형 인터페이스|		메서드|
| ------ | ----------- |
|BiConsumer<T, U>|		void accept(T t, U u)|
|BiPredicate<T, U>|		boolean test(T t, U u)|
|BiFunction<T, U, R>|	R apply(T t, U u)|
*[참고] Supplier는 매개변수는 없고 반환값만 존재하는데, 메서드는 두 개의 값을 반환할 수 없으므로 BiSupplier가 없는 것이다.*

두 개 이상의 매개변수를 갖는 함수형 인터페이스가 필요하다면 직접 만들어서 써야한다.

만일 3개의 매개변수를 갖는 함수형 인터페이스를 선언한다면 다음과 같을 것이다.

```
@FunctionalINterface
interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}
```

* UnaryOperator와 BinaryOperator

Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 매개변수의 타입과 반환타입의 타입이 모두 일치한다는 점만 제외하고는 Function과 같다.

*[참고] UnaryOperator와 BinaryOperator의 조상은 각각 Function과 BiFunction이다.*

* 함수형 인터페이스

	* UnaryOperator<T>	 	R appy(T t)	Function의 자손, Function과 달리 매개변수와 결과의 타입이 같다.

	* BinaryOperator<T>		R apply(T t, T t)	BiFunction의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같다.