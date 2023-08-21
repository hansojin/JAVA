package generic3;

class Box2<T> {
	private T ob;
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}

class UnBoxer {
	public static <T> T openBox2(Box2<T> Box2) {
		return Box2.get();
	}
}

class GenericMethodBoxMaker2 {
	public static void main(String[] args) {
		Box2<String> Box2 = new Box2<>();
		Box2.set("My Generic Method");

		String str = UnBoxer.<String>openBox2(Box2);
		System.out.println(str);
	}
}

/*
위 예제에 정의된 제네릭 메소드는 다음과 같다. 인자로 전달된 상자에서 내용물을 꺼내 반환하는 메소드이다.

class Unboxer {
	public static <T> T openBox(Box<T> box){
		return box.get();
	}
}

위의 메소드는 반환형이 T이고 전달인자의 자료형이 Box<T>인 경우이다. 
그리고 이 메소드의 호출방법은 다음과 같다.

public static void main(String[] args){
	Box<String> box = new Box<>();
	box.set("My Generic Method");

	String str = Unboxer.<String>openBox(box);
	...
}

위의 메소드 호출에서는 T가 String이어야 하므로 타입 인자가 <String>으로 결정되었다. 
물론 다음과 같이 이 정보를 생략할 수 있고 또 이것이 일반적이다.

String str = Unboxer.openBox(box);
*/