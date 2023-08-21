package generic3;

class Boox<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }
    public T get() {
        return ob;
    }
}

class PrimitivesAndGeneric {
    public static void main(String[] args) {
        Boox<Integer> iBoox = new Boox<Integer>();
    
        iBoox.set(125);				// 오토 박싱 진행
        int num = iBoox.get();		// 오토 언박싱 진행

        System.out.println(num);
    }
}
/*
기본 자료형에 대한 제한 그리고 래퍼 클래스

제네릭 클래스에 대하여 Boox<Apple>과 같이 '매개변수화 타입'을 구성할 때 기본 자료형의 이름은 '타입 인자'로 쓸 수 없다. 
즉 다음과 같은 문장 구성은 불가능하다.

Boox<int> Boox = new Boox<int>();
	-> 타입 인자로 기본 자료형이 올 수 없으므로 컴파일 오류 발생

하지만 기본 자료형에 대한 래퍼 클래스가 존재하고, 또 필요한 상황에서 박싱과 언박싱이 자동으로 이뤄지기 때문에 위와 같은 수준의 코드를 작성할 수 있다.
*/