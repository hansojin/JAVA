package generic5;

class Box5<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class Toy5 {
    @Override 
    public String toString() { 
        return "ToyToy";
    }
}

class Box5Handler {
    public static void outBox5(Box5<? extends Toy5> Box5) {
        Toy5 t = Box5.get();    // 박스에서 꺼내기
        System.out.println(t);
    }

    public static void inBox5(Box5<Toy5> Box5, Toy5 n) {
        Box5.set(n);    // 박스에 넣기
    } 
}

class BoundedWildcardUsage {
    public static void main(String[] args) {
        Box5<Toy5> Box5 = new Box5<>();
        Box5Handler.inBox5(Box5, new Toy5());
        Box5Handler.outBox5(Box5); 
    }
}

/*
언제 와일드카드에 제한을 걸어야 하는가? : 하한 제한의 목적

이번에는 다음 클래스의 두 번째 메소드에 주목하자.

class Box5Handler{
	...
	public static void inBox5(Box5<Toy5> Box5, Toy5 n){
		Box5.set(n);	// 상자에 넣기
	}
}

위의 두 번째 메소드 inBox5도 좋은 코드가 되기 위한 다음 조건을 만족하지 못한다.

"필요한 만큼만 기능을 허용하여, 코드의 오류가 컴파일 과정에서 최대한 발견되도록 한다."

이 메소드는 상자에 인스턴스를 저장하는 것이 목적이니, 다음과 같이 get 메소드를 호출하는 코드가 삽입된다면 이는 분명 프로그래머의 실수이다.

	public static void inBox5(Box5<Toy5> Box5, Toy5 n){
		Box5.set(n);	// 상자에 넣기
		Toy5 myToy5 = Box5.get();	// 꺼내는 것! 이것도 OK!
	}

그러나 이러한 실수는 컴파일 과정에서 발견되지 않는다. 따라서 이러한 실수가 컴파일 과정에서 발견될 수 있도록 매개변수를 다음과 같이 선언해야 한다.

	public static void inBox5(Box5<? super Toy5> Box5, Toy5 n){
		Box5.set(n);	// 넣는 것! OK!
		Toy5 myToy5 = Box5.get();	// 꺼내는 것! Error!
	}

위와 같이 매개변수를 선언하면 get 메소드의 호출문에서 컴파일 오류가 발생한다. 
이유는 반환형을 Toy5로 결정할 수 없기 때문이다. 
즉 get 메소드 호출 자체는 문제 되지 않으나, 반환되는 값을 저장하기 위해 선언한 참조변수의 형을 Toy5로 결정했다는 사실에서 문제가 발생한다.
이와 관련하여 보충 설명을 하기 위해 Toy5 클래스의 상속 관계가 다음과 같다고 가정하자.

class Plastic {...}
class Toy5 extends Plastic {...}

그러면 inBox5 메소드의 첫 번째 인자로 전달 가능한 두 가지 유형의 Box5<T> 인스턴스는 다음과 같다.

Box5<Toy5> tBox5 = new Box5<Toy5>();
Box5<Plastic> pBox5 = new Box5<Plastic>();

그리고 위의 inBox5 메소드에 tBox5가 전달되면 메소드 내에서 다음 문장을 실행하는데 문제가 없지만,

Toy5 myToy5 = Box5.get();	// get이 반환하는 것이 Toy5 인스턴스이므로 문제가 없지만,

pBox5가 전달되면, 메소드 내에서 다음 문장을 실행하는데 있어서 문제가 된다. 그래서 컴파일러는 이 문장 자체를 허용하지 않는다.

Toy5 myToy5 = Box5.get();	// get이 반환하는 것이 Plastic 인스턴스이므로 문제가 된다.

자!그럼 지금 설명한 내용을 이렇게 정리하자. 다음과 같은 매개변수 선언을 보았을 때,
public static void inBox5(Box5<? super Toy5> Box5, Toy5 n){
	// 이 안에서는 Box5가 참조하는 인스턴스에서
		// Toy5 인스턴스를 꺼내는(반환하는) 메소드 호출은 불가능하다. 
}

다음과 같은 판단을 할 수 있어야 한다.

"Box5가 참조하는 인스턴스를 대상으로 꺼내는 기능의 메소드 호출은 불가능하다."

실제 문제를 일으키는 부분은 메소드 호출 자체가 아닌, 매개변수의 반환형 선언이지만 이렇게 정리해 두는 것이 여러모로 도움이 된다.

참고 - 참조변수를 Object형으로 선언한다면?
앞서 설명한 내용과 관련하여 다음과 같이 참조변수 myToy5를 Object형으로 선언하면 컴파일이 되지 않으냐고 질문할 수 있다.

public static void inBox5(Box5<? super Toy5> Box5, Toy5 n){
	Object myToy5 = Box5.get();
}
위의 상황에서 get 메소드의 반환형을 결정할 수 없기 때문에 컴파일러는 get의 반환형을 Object로 결정해버린다. 
그래서 위의 메소드 정의는 컴파일 된다. 
그러나 자바는 Object형 참조변수의 선언이나 Object형으로의 형 변환이 불필요하도록 문법을 개선시켜왔다. 
Object라는 이름의 코드에 직접 등장하는 것은 컴파일러를 통한 오류의 발견 가능성을 낮추는 행위이기 때문이다. 
그러니 지금 설명하는 부분에서 참조변수를 Object 형으로 선언하는 것은 논외로 해야 한다. 동시에 당연히 피해야 할 일이기도 하다.

*/
