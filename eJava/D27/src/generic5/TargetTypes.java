package generic5;

class ABox<T> {
	private T ob;

	public void set(T o) { 
		ob = o; 
	}
	public T get() {
		return ob; 
	}
}


class EmptyABoxFactory {
	public static <T> ABox<T> makeABox() {	// 제네릭 메소드
		ABox<T> ABox = new ABox<T>();			
		return ABox;						
	}
}

class TargetTypes {
	public static void main(String[] args) {
		ABox<Integer> iABox = EmptyABoxFactory.<Integer>makeABox();
		iABox.set(25);
		System.out.println(iABox.get());
	}
}

/*
위의 예제에서는 다음과 같이 상자를 생성해서 반환하는 '제네릭 메소드'를 정의하였다.

    public static <T> ABox<T> makeABox() {	
        ABox<T> ABox = new ABox<T>();		
        return ABox;		
    }

그런데 이전에 구현했던 ABoxFactory 클래스의 makeABox 메소드와 달리 인자를 전달받지 않는다. 
당시에는 인자를 전달받았기 때문에 컴파일러가 이 인자를 통해서 T를 유추할 수 있었다. 
그러나 위의 메소드는 인자를 전달받지 않으므로 다음과 같이 T에 대한 타입 인자를 전달해야 한다.

ABox<Integer> iABox = EmptyABoxFactory.<Integer>makeABox();

그런데 자바 7부터 다음과 같이 호출하는 것이 가능하게 되었다. 
자바 7부터 컴파일러의 자료형 유추범위가가 넓어졌기 때문이다.

ABox<Integer> iABox = EmptyABoxFactory.makeABox();	// 자바 7부터 컴파일 되는 문장

어떻게 가능한 것일까? 

우리는 위의 문장을 보면서 makeABox 메소드는 ABox<Integer> 인스턴스의 참조 값을 반환해야 한다고 판단할 수 있다. 
왼편에 선언된 매개변수의 형을 보고 이러한 판단을 할 수 있다. 
따라서 makeABox 메소드 호출 시 T는 Integer가 되어야 함을 알 수 있다. 
그런데 이러한 판단을 자바 7부터 컴파일러도 할 수 있게 되었다.
지금 설명한 상황에서 T의 유추에 사용된 정보 ABox<Integer>를 가리켜 '타겟 타입'이라 한다. 
그리고 이러한 유추는 당연한 듯 보이지만, 대입 연산자의 왼편에 있는 정보를 가지고 컴파일러가 이러한 유추를 진행한다는 것은 주목할 만한 일이다.
 */