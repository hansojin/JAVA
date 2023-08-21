package generic5;

class Box_x<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class Toy_y {
    @Override 
    public String toString() { 
        return "I am a Toy_y";
    }
}

class Robot {
    @Override 
    public String toString() { 
        return "I am a Robot";
    }
}

class Box_xHandler {
    public static <T> void outBox_x(Box_x<? extends T> Box_x) {
        T t = Box_x.get();
        System.out.println(t);
    }

    public static <T> void inBox_x(Box_x<? super T> Box_x, T n) {
        Box_x.set(n); 
    } 
}

class BoundedWildcardGenericMethod {
    public static void main(String[] args) {
        Box_x<Toy_y> tBox_x = new Box_x<>();
        Box_xHandler.inBox_x(tBox_x, new Toy_y());
        Box_xHandler.outBox_x(tBox_x); 

        Box_x<Robot> rBox_x = new Box_x<>();
        Box_xHandler.inBox_x(rBox_x, new Robot());
        Box_xHandler.outBox_x(rBox_x);
    }
}

/*
제한된 와일드카드 선언을 갖는 제네릭 메소드
앞서 Toy_y 클래스를 담은 상자를 기준으로 다음과 같이 inBox_x와 outBox_x 메소드를 정의하였다.

class Box_xHandler{
	public static void outBox_x(Box_x<? extends Toy_y> Box_x){
		Toy_y t = Box_x.get();	// 상자에서 꺼내기
		System.out.println(t);
	}
	public static void inBox_x(Box_x<? super Toy_y> Box_x, Toy_y n){
		Box_x.set(n);	// 상자에 넣기
	}
}

위의 두 메소드는 Box_x<Toy_y> 인스턴스를 대상으로 정의된 메소드이다. 
이 상황에서 다음 클래스를 정의했다고 가정해보자.

class Robot{
	@Override
	public String toString() { return "I am a Robot"; }
}

그리고 Box_x<Robot>의 인스턴스를 대상으로 outBox_x와 inBox_x 메소드를 호출하고 싶다고 가정하자.
그렇다면 다음과 같이 오버로딩을 하여 메소드를 정의하는 방법을 고려할 수 있다.

class Box_xHandler {
	// 다음 두 메소드는 오버로딩 인정 안됨.
	public static void outBox_x(Box_x<? extends Toy_y> Box_x) {...}
	public static void outBox_x(Box_x<? extends Robot> Box_x) {...}

	//  다음 두 메소드는 두 번째 매개변수로 인해 오버로딩 인정 됨.
	public static void inBox_x(Box_x<? super Toy_y> Box_x, Toy_y n) {...}
	public static void inBox_x(Box_x<? super Robot> Box_x, Robot n) {...}
}

그런데 위 클래스의 다음 두 메소드 정의는 오버로딩이 성립하지 않는다.

public static void outBox_x(Box_x<? extends Toy_y> Box_x) {...}
public static void outBox_x(Box_x<? extends Robot> Box_x) {...}
	-> 컴파일러는 두 메소드의 오버로딩을 인정하지 않는다.

그 이유는 기술적인 문제에 기인하는데 조금만 설명하면, 
자바는 제네릭 등장 이전에 정의된 클래스들과의 상호 호환성 유지를 위해 컴파일 시 제네릭과 와일드카드 관련 정보를 지우는 과정을 거친다. 
즉 위의 두 매개변수 선언은 컴파일 과정에서 다음과 같이 수정이 되고, 
이로 인해 메소드의 오버로딩이 성립 불가능한 상태가 된다.

Box_x<? extends Toy_y> Box_x -> Box_x Box_x
Box_x<? extends Robot> Box_x -> Box_x Box_x

위와 같이 컴파일러가 제네릭 정보를 지우는 행위를 가리켜 'Type Erasure'라 한다. 
따라서 위와 같이 오버로딩을 하고 컴파일 하면 다음 메시지가 포함된 에러 메시지가 출력된다.

name clash:
outBox_x(Box_x<? extends Robot>) and outBox_x(Box_x<? extends Toy_y>)have the same erasure

위의 내용을 조금 과장해서(생략 및 축소된 내용을 포함해서) 의역하면 이렇다.

이름 충돌:
outBox_x(Box_x<? extends Robot>)와 outBox_x(Box_x<? extends Toy_y>)은 'Type Erasure'에 의해 매개변수 정보가 같아집니다.

반면 Box_xHandler 클래스에 정의된 다음 두 메소드는 오버로딩이 인정된다. 이유는 제네릭과 관련없는 두 번째 매개변수의 자료형이 다르기 때문이다.

public static void inBox_x(Box_x<? super Toy_y> Box_x, Toy_y n) {...}
public static void inBox_x(Box_x<? super Robot> Box_x, Robot n) {...}
	-> 두 번째 매개변수의 자료형이 다르므로 오버로딩이 인정된다.

다시 본론으로 돌아와서 Box_x<Toy_y> 인스턴스와 Box_x<Robot> 인스턴스를 동시에 허용할 수 있도록 inBox_x와 outBox_x 메소드를 정의하려면 어떻게 해야 할까? 
답은 위의 예제에서 보이듯이 '제네릭 메소드'에 있다.

위 예제의 결론은 이렇다. 
다음과 같이 메소드를 오버로딩 해야 하는 상황에서는 'Type Erasure'라는 것 때문에 오버로딩으로 인정이 되지 않으니,

public static void outBox_x(Box_x<? extends Toy_y> Box_x) {...}
public static void outBox_x(Box_x<? extends Robot> Box_x) {...}

다음과 같은 제네릭 메소드의 정의로 이를 대신하자는 것이다.

public static <T> void outBox_x(Box_x<? extends T> Box_x) {...}

그리고 이후에 <? extends T> 선언을 볼일이 있을 텐데, 
그때는 지금 설명한 위 예제의 상황을 떠올려 이 선언이 의미하는 바를 이해하길 바란다.

*/
