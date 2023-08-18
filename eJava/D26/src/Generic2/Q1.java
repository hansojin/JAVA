package Generic2;

// A 클래스에 매개변수가 한개인 제네릭 메소드를 정의하고 
// main 메소드가 있는 Test 클래스에서 호출해 보자.

class A{
	public <T> void show(T inst) {
		System.out.println(inst);
	}
}

class B{
	public String toString() {
		return "B class";
	}
}

class Q1 {
	public static void main(String[] args) {
		A a= new A();
		a.<B>show(new B());
		a.show(new B());	//컴파일러가 메소드 호출 시 전달되는 참조변수의
							// 자료형을 근거로 자료형 정보를 판단하기 때문에 가능함
	}
	
	
}
