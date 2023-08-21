package generic3;

class Apple {
    public String toString() {
        return "I am an apple.";
    }    
}

class Orange {
    public String toString() {
        return "I am an orange.";
    }
}
/*
class AppleBox {
    private Apple ap;
    public void set(Apple a) {
        ap = a;
    }
    public Apple get() {
        return ap;
    }
}


class OrangeBox {
    private Orange or;
    public void set(Orange o) {
        or = o;
    }
    public Orange get() {
        return or;
    }
}
*/

class Box<T> {
    private T obj;
    public void set(T obj) {
        this.obj=obj;
    }
    public T get() {
        return obj;
    }
}

class FruitAndBox {
    public static void main(String[] args) {
        Box<Apple> aBox = new Box<Apple>();
        Box<Orange> oBox = new Box<Orange>();
 
        aBox.set(new Apple());
        oBox.set(new Orange());

        Apple ap = aBox.get();
        Orange og = oBox.get();

        System.out.println(ap);
        System.out.println(og);
    }
}

/*

용어 정리
* 타입 매개변수(Type Parameter)				Box<T>에서 T
* 타입 인자(Type Argument)					Box<Apple>에서 Apple
* 매개변수화 타입(Parameterized Type)		Box<Apple>

그리고 '매개변수화 타입'은 '제네릭 타입(Generic Type)'이라고도 한다.

제네릭 이후의 코드는 제네릭 이전의 코드와 비교하여 다음 불편함과 문제점이 사라졌다.
* 필요시 형 변환을 해야 한다.
* 자료형과 관련된 프로그래머의 실수가 컴파일 과정에서 드러나지 않는다.

*/