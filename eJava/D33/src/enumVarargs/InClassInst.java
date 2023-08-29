package enumVarargs;

class Persn { 
	public static final Persn MAN = new Persn();
	public static final Persn WOMAN = new Persn();

	@Override
	public String toString() {
		return "I am a Persn";
	}
}

enum Persm {
	MAN, WOMAN;
	
	// '열거형 값'이 두개 존재하므로, 두번의 생성자 호출이 이루어짐!
	// 즉, 열거형 값은 public static final Persm MAN|WOMAN = new Person();
	// 이라고 표현 할 수 있음!
	
	private Persm() {
		System.out.println("Persm constructor called");
	}
	
	@Override
	public String toString() {
		return "I am a Persm";
	}
}

class InClassInst {
	public static void main(String[] args) {
		// InclassInst
		System.out.println(Persn.MAN);
		System.out.println(Persn.WOMAN);
		
		//enumConst
		System.out.println(Persm.MAN);
		//System.out.println(Persm.WOMAN);
	}
}

/*
모든 열거형은 java.lang.Enum<E> 클래스를 상속한다. 그리고 Enum<E>는 Object
클래스를 상속한다. (이런 측면에서 볼 때 열거형은 클래스이다.) 그리고 두 열거형
값은 Persm 인스턴스를 참조하는 참조변수이다. 이에 대한 증거로 예제에서는 다음
문장을 통해 toString 메소드가 호출되었음을 보이고 있다.

System.out.println(Persm.MAN);

열거형의 정의에도 생성자가 없으면 디폴트 생성자가 삽입된다. 다만 생성자는 
private으로 선언이 되어 직접 인스턴스를 생성하는 것이 불가능할 뿐 이다.
*/
