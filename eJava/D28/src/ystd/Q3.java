package ystd;

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
class AABB{
	public <T,U> void show(T inst1, U inst2) {
		System.out.println(inst1);
		System.out.println(inst2);
	}
}
public class Q3 {
	public static void main(String[] args) {
		AA a = new AA();
		BB b = new BB();
		AABB ab = new AABB();
		
		ab.<AA,BB>show(a,b);
	}

}
