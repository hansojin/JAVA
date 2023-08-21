package generic;

//둘 이상의 인스턴스 변수 기반의 제네릭 클래스를 정의해 보자.

public class Q4<T,U> {
	T item1;
	U item2;
	
	public void setI1(T item) {
		item1 = item;
	}
	
	public void setI2(U item) {
		item2 = item;
	}
}
