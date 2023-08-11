package OOP2;

class Exercise7_20 {
	public static void main(String[] args) {
		Parentt p = new Childd();
		Childd c = new Childd();
		System.out.println("p.x = " + p.x);
		p.method();
		System.out.println("c.x = " + c.x);
		c.method();
	}
}
class Parentt {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
}
class Childd extends Parentt {
	int x = 200;
	void method() {
		System.out.println("Child Method");
	}
}

// 100 child 200 child