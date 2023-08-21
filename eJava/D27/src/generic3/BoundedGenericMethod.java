package generic3;

class Boxxx<T> {
    private T ob;
    
    public void set(T o) {
        ob = o;
    }
    public T get() {
        return ob;
    }
}

class BoxxxFactory {
    public static <T extends Number> Boxxx<T> makeBoxxx(T o) {
        Boxxx<T> Boxxx = new Boxxx<T>();
        Boxxx.set(o);

        System.out.println("Boxxxed data: " + o.intValue());
        return Boxxx;
    }
}

class UnBoxxxer {
    public static <T extends Number> T openBoxxx(Boxxx<T> Boxxx) {
        System.out.println("UnBoxxxed data: " + Boxxx.get().intValue());        
        return Boxxx.get();
    }
}

class BoundedGenericMethod {
    public static void main(String[] args) {
        Boxxx<Integer> sBoxxx = BoxxxFactory.makeBoxxx(5959);
        
        int n = UnBoxxxer.openBoxxx(sBoxxx);
        System.out.println("Returned data: " + n);
    }
}



/*
제네릭 메소드의 제한된 타입 매개변수 선언
앞서 제네릭 클래스를 정의할 때 다음과 같이 타입 인자를 제한할 수 있음을 설명하였다.

class Box<T extends Eatable> {...}

마찬가지로 제네릭 메소드도 호출 시 전달되는 타입 인자를 제한할 수 있다. 
그리고 제네릭 클래스의 타입 인자를 제한할 때 생기는 특성이 제네릭 메소드의 타입 인자를 제한할 때에도 생긴다. 

위 예제에서는 다음과 같이 제네릭 메소드에 전달되는 타입 인자를 제한하였다. 
Number를 상속하는 클래스로 타입 인자를 제한하였다.

public static <T extends Number> Box<T> makeBox(T o){
	...
	// 타입 인자 제한으로 intValue 호출 가능
	System.out.println("Boxed data: " + o.intValue());
	return box;
}

public static <T extends Number> T openBox(Box<T> box) {
	// 타입 인자 제한으로 intValue 호출 가능
	System.out.println("Unboxed data: " + box.get().intValue());
	return box.get();
}
*/