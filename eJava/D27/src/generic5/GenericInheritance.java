package generic5;

class Box<T> {
	protected T ob;

	public void set(T o) { 
		ob = o; 
	}
	public T get() {
		return ob; 
	}
}

class SteelBox<T> extends Box<T> {
	public SteelBox(T o) {	// 제네릭 클래스의 생성자
		ob = o;
	}
}



class GenericInheritance {
	public static void main(String[] args) {
		Box<Integer> iBox = new SteelBox<>(7959);
		Box<String> sBox = new SteelBox<>("Simple");

		System.out.println(iBox.get());
		System.out.println(sBox.get());
	}
}

/*
제네릭 클래스도 상속이 가능하다.

제네릭 클래스의 상속을 설명하기 위해서, 예제에서는 Box<T>를 상속하는 하위 클래스를 다음과 같이 간단히 정의하였다.

class SteelBox<T> extends Box<T> {
	public SteelBox(T o) {	// 생성자
		ob= o;
	}
}

그리고 이로 인하여 다음과 같이 Box<T>의 참조변수로 SteelBox<T> 인스턴스를 참조하는 문장을 구성할 수 있게 되었다.

Box<Integer> iBox = new SteelBox<>(7759);
	<-> Box<Integer> iBox = new SteelBox<Integer>(7759);

Box<String> sBox = new SteelBox<>("Simple");
	<-> Box<String> sBox = new SteelBox<String>("Simple");

즉, 두 제네릭 클래스가 다음의 상속 관계를 구성하면,

Box<T>
    ^
    |
SteelBox<T>
[제네릭 클래스의 상속]

다음 관계도 성립한다. 때문에 예제에서 SteelBox<Integer> 인스턴스를 Box<Integer>형 참조변수로 참조할 수 있었다.

Box<Integer>			Box<String>
       ^				       ^
       |				       |
SteelBox<Integer> 			SteelBox<String>


[제네릭 클래스의 상속으로 인해 형성되는 관계]

앞에서 Box<Integer>와 같은 것을 '매개변수화 타입' 또는 '제네릭 타입'이라 함을 설명하였는데, 이렇듯 '타입(Type)'이라는 단어가 포함된 것은 Box<Integer>를 일종의 자료형으로, 정확히는 클래스의 이름으로 간주함을 뜻한다. 따라서 위와 같은 상속의 관계가 형성될 수 있고, 이를 다음과 같이 표현할 수 있다.

'SteelBox<Integer> 클래스는 Box<Integer> 클래스를 상속한다."

물론 다음과 같이 표현하는 것이 보편적이긴 하다.

"SteelBox<Integer> 제네릭 타입은 Box<Integer> 지네릭 타입을 상속한다."

그렇다면 다음 문장도 컴파일이 가능할까? Number를 Integer가 상속하니 컴파일이 되지 않을까?

Box<Number> box = new Box<Integer>();	// 컴파일 가능할까?

Number를 Integer가 상속하지만 Box<Number>와 Box<Integer>는 상속 관계를 형성하지 않는다. 따라서 컴파일 되지 않는다. 
Box<Number>와 Box<Integer>이 상속 관계를 형성하지 않는 것은 언어를 디자인 한 설계자의 결정이므로 이해보다는 인식이 우선인 부분이다. 그러나 조금만 생각해 보면 이러한 결정이 합리적임을 알 수 있다. 예를 들어서 SteelBox<Integer>와 Box<Integer>가 상속 관계를 형성하는데, 여기에 더해 Box<Integer>와 Box<Number>가 상속 관계를 형성한다면? 매우 혼란스러운 상속의 구조가 만들어진다. 그에 따른 이점은 별로 보이지 않는데 말이다.
 */