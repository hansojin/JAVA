package generic3;

class Box1<T> {
    private T ob;
    
    public void set(T o) {
        ob = o;
    }
    public T get() {
        return ob;
    }
}

class Box1Factory {
    public static <T> Box1<T> makeBox1(T o) {	
        Box1<T> Box1 = new Box1<T>();	
        Box1.set(o);	
        return Box1;	
    }
}

class GenericMethodBox1Maker {
    public static void main(String[] args) {
        Box1<String> sBox1 = Box1Factory.makeBox1("Sweet");
        System.out.println(sBox1.get());

        Box1<Double> dBox1 = Box1Factory.makeBox1(7.59);
        System.out.println(dBox1.get());
    }
}

/*
제네릭 메소드의 정의

지금까지는 클래스를 제네릭으로 정의하였는데, 이렇듯 클래스 전부가 아닌 일부 메소드에 대해서만 제네릭으로 정의하는 것도 가능하며, 이렇게 정의된 메소드를 가리켜 '제네릭 메소드'라 한다. 
제네릭 메소드는 인스턴스 메소드 뿐만 아니라 다음과 같이 클래스 메소드에 대해서도 정의가 가능하다. 
쉽게 말해서 static 선언의 유무에 상관없이 제네릭 메소드의 정의가 가능하다.

public static Box<T> makeBox(T o) {...}

위의 메소드 정의에 대해서 다음 내용을 파악할 수 있어야 한다.

"메소드의 이름은 makeBox이고 반환형은 Box<T>이다."

그러나 위의 메소드 정의는 완전하지 않다. 이 상태에서 컴파일러는 T가 무엇이냐고 물어보며 컴파일 오류를 일으킨다. 따라서 T가 타입 매개변수의 선언임을 다음과 같이 표시해야 한다.

public static <T> Box<T> makeBox(T o) {...}
	-> static과 Box<T> 사이에 위치한 <T>가 T 타입 매개변수임을 알리는 표시

이후로도 위와 같은 메소드 정의를 보면 Box<T>가 반환형임을, 그리고 그 앞에 위치한 <T>는 T가 타입 매개변수임을 알리는 표시임을 알 수 있어야 한다.

class BoxFactory{
	public static <T> Box<T> makeBox(T o){
		Box<T> box = new Box<T>();	// 상자를 생성하고,
		box.set(o);	// 전달된 인스턴스를 상자에 담아서,
		return box;	// 상자를 반환한다.
	}
}

제네릭 클래스는 인스턴스 생성 시 자료형이 결정된다. 반면 제네릭 메소드는 '메소드 호출시에 자료형이 결정'된다. 
따라서 위 클래스에 정의되어 있는 makeBox 제네릭 메소드는 다음과 같이 호출해야 한다.

Box<String> sBox = BoxFactory.<String>makeBox("Sweet");
Box<Double> dBox = BoxFactory.<Double>makeBox(7.59);	// 7.59에 대해 오토 박싱 진행됨

위의 두 문장에서 메소드의 이름 앞에 표시한 <String>과 <Double>이 T에 대한 타입 인자이다. 
즉 첫 번째 문장에서는 T를 String으로 결정하여 호출하였고, 두 번째 문장에서는 Double로 결정하여 호출하였다. 
그런데 위의 두 문장을 다음 두 문장으로 대신할 수도 있다.

Box<String> sBox = BoxFactory.makeBox("Sweet");
Box<Double> dBox = BoxFactory.makeBox(7.59);		// 7.59에 대해 오토 박싱 진행됨

위의 두 문장에서는 T에 대한 타입 인자 정보가 생략되었다. 그러나 컴파일러는 makeBox에 전달되는 인자를 보고 T를 각각 String과 Double로 유추한다. 
그리고 이러한 자료형의 유추는 오토 박싱까지 감안하여 이뤄진다.
*/



