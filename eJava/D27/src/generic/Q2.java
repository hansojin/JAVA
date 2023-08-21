package generic;

// A 클래스에 매개변수가 한개인 제네릭 메소드를 정의하고 
// main 메소드가 있는 클래스에서 호출해 보자.

class A{
	public <T> void show(T inst) {
		System.out.println(inst);
	}
}

class B{
	public String toString() {
		return "B";
	}
}

public class Q2 {
	public static void main(String[] args) {
		A a = new A();
		a.<B>show(new B());
	}
	
}
