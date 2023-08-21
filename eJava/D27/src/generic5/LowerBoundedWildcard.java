package generic5;

class Box3<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class UnBox3er {
    public static void peekBox3(Box3<? super Integer> Box3) {
        System.out.println(Box3);
    }
}

class LowerBoundedWildcard {
    public static void main(String[] args) {
        Box3<Integer> iBox3 = new Box3<Integer>();
        iBox3.set(5577);
        
        Box3<Number> nBox3 = new Box3<Number>();
        nBox3.set(9955);

        Box3<Object> oBox3 = new Box3<Object>();
        oBox3.set("My Simple Instance");

        UnBox3er.peekBox3(iBox3);
        UnBox3er.peekBox3(nBox3);
        UnBox3er.peekBox3(oBox3);
    }
}

/*
그리고 다음과 같이 참조변수에 '하한 제한된 와일드카드(Lower-Bounded Wildcards)'선언을 할수도 있다.

Box3<? super Integer> Box3
	-> Box3는 Box3<T> 인스턴스를 참조하는 참조변수이다.
	-> 단 이때 Box3<T> 인스턴스의 T는 Integer 또는 Integer가 상속하는 클래스이어야 함

예를 들어서 메소드의 매개변수를 다음과 같이 선언하면,

public static void peekBox3(Box3<? super Integer> Box3){
	System.out.println(Box3);
}

위 메소드의 인자로 전달될 수 있는 인스턴스의 타입 종류는 다음과 같이 제한된다.

Box3<Integer>, Box3<Number>, Box3<Object>

*/ 
