package ystd;

class Exercise7_20 {
	public static void main(String[] args) {
		Parrent p = new Chhild();
		Chhild c = new Chhild();
		System.out.println("p.x = " + p.x);	// 100
		p.method();							// Chhild
		System.out.println("c.x = " + c.x);	// 200
		c.method();							// Chhild
	}
}
class Parrent {
	int x = 100;
	void method() {
		System.out.println("Parrent Method");
	}
}
class Chhild extends Parrent {
	int x = 200;
	void method() {
		System.out.println("Chhild Method");
	}
}