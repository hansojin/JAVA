package generic5;

interface Getable<T> {
    public T get();
}

class Boox<T> implements Getable<T> {
    private T ob;     
    public void set(T o) { ob = o; }

    @Override
    public T get() { 
        return ob; 
    }
}

class Tooy {
    @Override 
    public String toString() { 
        return "I am a Tooy";
    }
}

class GetableGenericInterface {
    public static void main(String[] args) {
        Boox<Tooy> Boox = new Boox<>();
        Boox.set(new Tooy());
    
        Getable<Tooy> gt = Boox;
        System.out.println(gt.get());        
    }
}

/*
위 예제의 Boox<T> 클래스는 다음과 같이 Getable<T> 인터페이스를 구현하는 형태로 정의되었다.

class Boox<T> implements Getable<T> {...}

따라서 Getable<T>형 참조변수로 Boox<T>의 인스턴스를 참조할 수 있다. 
단 T를 대신할 자료형이 다음 문장과 같이 동일해야 참조가 가능하다.

public static void main(String[] args) {
	Boox<Tooy> Boox = new Boox<>();
	...
	Getable<Tooy> gt = Boox;
	...
}

그리고 제네릭 인터페이스를 구현할 때에는 다음과 같이 T를 결정한 상태로 구현할 수도 있다.

class Boox<T> implements Getable<String> {...}

단 이렇듯 제네릭 인터페이스의 T를 String으로 결정하면 Getable<T>의 메소드를 구현할 때에도 
다음과 같이 T가 아닌 String으로 명시하고 구현해야 한다.

@Override
public String get() {...}

*/
