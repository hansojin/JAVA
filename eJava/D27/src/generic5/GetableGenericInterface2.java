package generic5;

interface Getablle<T> {
    public T get();
}

class Booxx<T> implements Getablle<String> {
    private T ob;     
    public void set(T o) { ob = o; }

    @Override
    public String get() { 
        return ob.toString(); 
    }
}

class Tooyy {
    @Override 
    public String toString() { 
        return "I am a Tooyy";
    }
}

class GetableGenericInterface2 {
    public static void main(String[] args) {
        Booxx<Tooyy> Booxx = new Booxx<>();
        Booxx.set(new Tooyy());
    
        Getablle<String> gt = Booxx;
        System.out.println(gt.get());        
    }
}

/* 
위 예제에서는 다음과 같이 클래스를 정의하였다.

class Booxx<T> implements Getablle<String> {...}

따라서 Getablle<String>형 참조변수는 다음과 같이 Booxx<T> 인스턴스를 T의 자료형에 상관없이 참조할 수 있다.

public static void main(String[] args) {
	Booxx<Tooyy> Booxx = new Booxx<>();
	...
	Getablle<String> gt = Booxx;
	...
}
*/
