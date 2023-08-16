package ystd;

class Parent {
	int x=100;
	Parent() {
		this(200); // 4. Parent(int x)를 호출
	}
	Parent(int x) {
		this.x = x;	// 5
	}
	int getX() {
		return x;
	}
}
class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000); // 2. Child(int x)를 호출
	}
	Child(int x) {
		// super(); 가 생략 되어 있음. 
		// 3. 첫줄에 다른 생성자를 호출하지 않으면, 조상의 기본 생성자를 호출하기에 parent()를 호출
		this.x = x;
	}
}
class Exercise7_7 {
	public static void main(String[] args) {
		Child c = new Child();	// 1
		System.out.println("x="+c.getX());	// 6. x=200
	}
}
