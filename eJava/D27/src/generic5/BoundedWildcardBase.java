package generic5;

class Box4<T> {
	private T ob;     
	public void set(T o) { ob = o; }
	public T get() { return ob; }
}

class Toy {
	@Override 
	public String toString() { 
		return "I am a Toy.";
	}
}

class Box4Handler {
	public static void outBox4(Box4<Toy> Box4) {
		Toy t = Box4.get();    // 박스에서 꺼내기
		System.out.println(t);
	}

	public static void inBox4(Box4<Toy> Box4, Toy n) {
		Box4.set(n);    // 박스에 넣기
	} 
}


class BoundedWildcardBase {
	public static void main(String[] args) {
		Box4<Toy> Box4 = new Box4<>();
		Box4Handler.inBox4(Box4, new Toy());
		Box4Handler.outBox4(Box4); 
	}
}

/*
 언제 와일드 카드에 제한을 걸어야 하는가?

다음 메소드의 매개변수 선언에 대해서 설명하라고 하면,

public static void peekBox4(Box4<? extends Number> Box4) {...}

인자로 전달할 수 있는 인스턴스의 형과 관련하여 다음 내용으로 설명하고 마무리하는 경우가 대부분이다.

"Box4<T>의 T를 Number 또는 Number를 직간접적으로 상속하는 클래스로 제한하기 위한 것"

물론 정확한 설명이다. 그리고 인자로 전달되는 대상을 제한하는 것은 그 자체로 프로그램에 안정성을 높여 의미가 있다. 

그러나 다른 관점에서 '상한 제한된 와일드카드'의 의미를 설명할 수 있어야 한다. 

마찬가지로 다음 메소드의 매개변수 선언에 대해서 설명하라고 하면,

public static void peekBox4(Box4<? super Integer> Box4) {...}

인자로 전달할 수 있는 인스턴스의 형과 관련하여 다음 내용으로 설명하고 마무리하는 경우가 대부분이다.

"Box4<T>의 T를 Integer 또는 Integer가 직간접적으로 상속하는 클래스로 제한하기 위한 것"

그러나 이 경우에도 다른 관점에서 하한 제한된 와일드카드의 의미를 설명할 수 있어야 한다. 

그렇지 않으면 자바에서 제공하는 다음과 같은 메소드의 사용은 부담스러울 수 밖에 없다.

public static <T> void copy(List<? super T> dest, List<? extends T> src)
	-> Collections 클래스의 복사 메소드

위 예제에서 관심을 두어야 할 부분은 Box4Handler 클래스에 정의된 다음 두 메소드이다.

    public static void outBox4(Box4<Toy> Box4) {
        Toy t = Box4.get();    // 박스에서 꺼내기
        System.out.println(t);
    }

    public static void inBox4(Box4<Toy> Box4, Toy n) {
        Box4.set(n);    // 박스에 넣기
    } 

첫 번째 메소드 outBox4는 상자에서 물건을 꺼낼 때 사용하는 메소드이다. 

반면 inBox4는 상자에 물건을 넣을 때 사용하는 메소드이다. 둘 다 잘 정의되었고 잘 동작한다. 

그러나 잘 만들어진 코드는 다음의 조건을 추가로 만족해야 하는데, 위 의 두 메소드는 이 조건까지 만족하는 형태로 정의되지 않았다.

"필요한 만큼만 기능을 허용하여, 코드의 오류가 컴파일 과정에서 최대한 발견되도록 한다."

먼저 다음 메소드를 보자.

public static void outBox4(Box4<Toy> Box4) {...}
	-> 매개변수 Box4가 참조하는 상자에서 인스턴스를 꺼내는 기능

이 메소드를 정의할 당시 프로그래머의 생각은 다음과 같다.

"상자에서 내용물을 꺼내는 기능의 메소드를 정의하자."

그런데 매개변수 Box4를 대상으로는 다음과 같이 get은 물론 set의 호출도 가능하다.

    public static void outBox4(Box4<Toy> Box4) {
        Toy t = Box4.get();    	// 꺼내는 것! OK!
        Box4.set(new Toy());	// 넣는 것! 이것도 OK!
    }

따라서 다음과 같은 유형의 오류를 범할 수 있는 상황이다.

"outBox4 메소드 내에서 실수로 set 메소드를 호출하여 임의의 인스턴스를 넣었다."

이러한 다음과 같은 유형의 오류를 범할 수 있는 상황이다.

"outBox4 메소드 내에서 실수로 set 메소드를 호출하여 임의의 인스턴스를 넣었다."

이러한 실수는 누구나 할 수 있다. 그러나 이러한 오류는 컴파일 과정에서 발견되지 않는다. 때문에 outBox4 메소드를 정의할 때에는 매개변수 Box4를 대상으로 get은 가능하지만 set은 불가능하도록 제한을 거는 것이 좋다. 그리고 이러한 일이 '필요한 만큼만 기능을 허용하여, 코드의 오류가 컴파일 과정에서 최대한 발견되도록 하는 일'이다.
그렇다면 어떻게 outBox4 메소드를 정의해야 할까? 다음과 같이 정의하면 된다. 다음과 같이 매개변수 선언을 하면 상자에서 꺼내는 것은 가능하지만 넣는 것은 불가능하게 된다. 넣으려고 하면 컴파일 오류가 발생한다.

    public static void outBox4(Box4<? extends Toy> Box4) {
        Toy t = Box4.get();    	// 꺼내는 것! OK!
        Box4.set(new Toy());	// 넣는 것! ERROR!
    }

위의 상황에서 SET 메소드의 호출이 불가능한 이유는 무엇일까? 바로 결론을 말하면, 위 메소드의 매개변수로 Toy 인스턴스를 저장할 수 있는 상자만(Box4<T> 인스턴스만) 전달된다는 사실을 보장할 수 없기 때문이다.
이에 대해 보충 설명을 하면, Toy 클래스는 다음과 같이 다른 클래스들에 의해 얼마든지 상속이 될 수 있다.

class Car extends Toy {...}	// 자동차 장난감
class Robot extends Toy {...}	// 로봇 장난감

그리고 이렇게 상속 관계를 맺으면 위의 outBox4 메소드에 Box4<Car> 또는 Box4<Robot>인스턴스가 인자로 전달될 수 있다. 이러한 상황에서 다음과 같이 Toy 인스턴스를 상자에 담을 수 있겠는가?

    public static void outBox4(Box4<? extends Toy> Box4) {
       // Box4로 Box4<Car> 또는 Box4<Robot> 인스턴스가 전달된다면?
        Box4.set(new Toy());	// 넣는 것! ERROR!
    }

바로 이러한 문제점 때문에 다음과 같이 선언된 매개변수를 대상으로 저장하는(전달하는) 메소드의 호출이 불가능하다.

Box4<? extends Toy> Box4

지금까지 설명한 내용을 정리하면, 다음과 같은 매개변수 선언을 보았을 때,

public static void outBox4(Box4<? extends Toy> Box4){
	// 이 안에서는 Box4가 참조하는 인스턴스에
	//	Toy 인스턴스를 저장하는(전달하는) 메소드 호출은 불가능하다.
}

다음과 같은 판단을 할 수 있어야 한다.

"Box4가 참조하는 인스턴스를 대상으로 저장하는 기능의 메소드 호출은 불가능하다."

 */
