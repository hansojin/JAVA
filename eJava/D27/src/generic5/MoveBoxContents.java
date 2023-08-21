package generic5;

class Box7<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class Toy7 {
    @Override 
    public String toString() { 
        return "I am a Toy, toy";
    }
}

class Box7ContentsMover {
	// from에 저장된 내용물을 to로 이동
    public static void moveBox7(Box7<? super Toy7> to, Box7<? extends Toy7> from) {
        to.set(from.get());
    }
}

class MoveBoxContents {
    public static void main(String[] args) {
        Box7<Toy7> Box1 = new Box7<>();
        Box1.set(new Toy7());

	// Box1에 저장된 내용물 Box2로 이동
        Box7<Toy7> Box2 = new Box7<>();
        Box7ContentsMover.moveBox7(Box2, Box1);

        System.out.println(Box2.get());
    }
}

/*
언제 와일드카드에 제한을 걸어야 하는가? : 정리

매개변수 선언 : Box7<? extends Toy7> Box7
	-> Box7가 참조하는 인스턴스를 대상으로 꺼내는 작업만 허용하겠다는 의미
매개변수 선언 : Box7<? super Toy7> Box7
	-> Box7가 참조하는 인스턴스를 대상으로 넣는 작업만 허용하겠다는 의미

위 예제의 다음 메소드는 from으로 전달된 상자의 내용물을 to로 전달된 상자로 옮긴다.
    public static void moveBox7(Box7<? super Toy7> to, Box7<? extends Toy7> from) {
        to.set(from.get());
    }

그런데 위와 같은 유형의 메소드를 정의하는 경우 프로그래머도 실수할 수 있다. 
from에서 to로 옮겨야 하는데, 다음과 같이 to에서 from으로 옮기는 코드를 작성할 수 있는 일이다.

from.set(to.get());	// 프로그래머의 실수! 그러나 컴파일 오류로 이어진다.

그러나 매개변수의 선언에서 와일드카드에 적절히 상한과 하한 제한을 걸어 두었기 때문에 위와 같은 실수는 컴파일 과정에서 드러난다.
*/