package generic5;

class Box2<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class UnBox2er {
    public static void peekBox2(Box2<? extends Number> Box2) {
        System.out.println(Box2);
    }
}

class UpperBoundWildCard {
    public static void main(String[] args) {
        Box2<Integer> iBox2 = new Box2<>();
        iBox2.set(1234);

        Box2<Double> dBox2 = new Box2<>();
        dBox2.set(10.009);

        UnBox2er.peekBox2(iBox2);
        UnBox2er.peekBox2(dBox2);
    }
}

/*
public static void peekBox2(Box2<?> Box2){
	System.out.println(Box2);
}

위 메소드의 인자로, Box2<T>에서 T가 Number 또는 Number의 하위 클래스인 제네릭 타입의 인스턴스만 전달되도록 
제한할 때 다음과 같이 '상한 제한된 와일드카드(Upper-Bounded Wildcards)'라는 것을 사용한다.

Box2<? extends Number> Box2
	-> Box2는 Box2<T> 인스턴스를 참조하는 참조변수이다.
	-> 단 이때 Box2<T> 인스턴스의 T는 Number 또는 이를 상속하는 하위 클래스이어야 함

따라서 메소드 peekBox2의 매개변수에 다음과 같이 제한을 걸어서 
Box2<Integer>, Box2<Double>과 같은 제네릭 타입의 인스턴스만 인자로 전달되도록 할 수 있다.

public static void peekBox2(Box2<? extends Number> Box2) {
	System.out.println(Box2);
}
*/
