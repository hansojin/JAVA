package generic5;

class Boxx<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }

    @Override
    public String toString() {
        return ob.toString();
    }
}

class Unboxer {
//    public static <T> T openBox(Boxx<T> box) {
//        return box.get();
//    }
    
    // 상자 안의 내용 물을 확인하는(출력하는) 기능의 제네릭 메소드
    public static <T> void peekBox(Boxx<T> box) {
        System.out.println(box);
    }
}

class WildcardUnboxer {
    public static void main(String[] args) {
        Boxx<String> box = new Boxx<>();
        box.set("So Simple String");
        Unboxer.peekBox(box);		// 상자 안의 내용물을 확인해본다.
    }
}

/*
위 예제에서 다음 제네릭 메소드를 추가하였다.

    public static <T> void peekBox(Box<T> box) {
        System.out.println(box);
    }

그런데 이 메소드를 제네릭으로 정의한 이유가 Box<Integer>, Box<String>의 인스턴스를 인자로 전달받도록 하기 위함이니 다음과 같이 정의해도 되지 않겠는가?

    public static <T> void peekBox(Box<Object> box) {
        System.out.println(box);
    }

안된다! 이유는?

"Box<Object>와 Box<String>은 상속 관계를 형성하지 않는다."
"Box<Object>와 Box<Integer>은 상속 관계를 형성하지 않는다."

즉 Object와 String이 상속 관계에 있더라도 Box<Object>와 Box<String>은 상속 관계를 형성하지 않는 별개의 자료형이다. 
대신 '와일드카드'라는 것을 사용하면 원하는 바를 이룰 수 있다.
*/
