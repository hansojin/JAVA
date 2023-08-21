package generic3;

//'매개변수화 타입'을 '타입 인자'로 전달하기

class Boxx<T> {
	private T ob;

	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class BoxInBox {
	public static void main(String[] args) {
		Boxx<String> sBox = new Boxx<>();
		sBox.set("I am so happy.");

		Boxx<Boxx<String>> wBox = new Boxx<>();
		wBox.set(sBox);

		Boxx<Boxx<Boxx<String>>> zBox = new Boxx<>();
		zBox.set(wBox);

		System.out.println(zBox.get().get().get());
	}
}

/*
타입 인자의 생략 : 다이아몬드(Diamond) 기호
컴파일러는 프로그래머가 작성하는 제네릭 관련 문장에서 자료형의 이름을 추론하는 능력을 갖고 있다. 

따라서 아랫 문장을 대신하여, 다음과 같이 쓸 수 있다.

Box<Apple> aBox = new Box<Apple>();
Box<Apple> aBox = new Box<>();

이 경우 참조변수의 선언을 통해서 <> 안에 Apple이 생략되었다고 컴파일러는 판단한다. 
쉽게 말해서 왼쪽을 보고 오른쪽의 빈 공간을 채운다. 
그리고 <>을 가리켜 '다이아몬드(Diamond) 기호' 또는 '다이아몬드 표시'라 부른다. 
이는 비공식적인 표현이긴 하지만 공식적인 표현으로 인식될 만큼 널리 사용되는 표현이다.

위 예제를 통해서 Box<String>과 같은 '매개변수화 타입'이 다음과 같이 '타입 인자'로 사용이 될 수 있음을 말하고자 하였다.

Box<Box<String>> wBox = new Box<>();
 */
