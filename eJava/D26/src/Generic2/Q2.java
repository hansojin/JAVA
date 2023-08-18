package Generic2;

// 둘 이상의 매개변수를 받는 제네릭 메소드를 정의하고 호출해 보자.

class AA{
	public String toString() {
		return "AA";
	}
}

class BB{
	public String toString() {
		return "BB";
	}
}

class InstType2{
	public <T,U> void showInstType(T inst1, U inst2) {
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

public class Q2 {
	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		
		InstType2 shower = new InstType2();
		shower.<AA,BB>showInstType(a,b);
		shower.showInstType(a, b);	//<AA, BB> 생략 가능
	}
}
