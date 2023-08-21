package generic;

//둘 이상의 매개변수를 받는 제네릭 메소드를 정의하고 호출해 보자.

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
	public <T,U> void showType(T inst1, U inst2) {
		System.out.println(inst1);
		System.out.println(inst2);
	}
}

public class Q3 {
	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		InstType2 inst = new InstType2();
		inst.<AA,BB>showType(a,b);
	}
}
