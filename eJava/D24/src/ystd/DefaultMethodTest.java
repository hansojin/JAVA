package ystd;

class DefaultMethodTest {
	public static void main(String[] args) {
		Childd c = new Childd();
		c.method1();
		c.method2();
		MyInterface.staticMethod(); 
		MyInterface2.staticMethod();
	}
}

/*
 * method1() in Childd
 * method2() in Parentt
 * staticMethod() in MyInterface
 * staticMethod() in MyInterface2
 */

class Parentt {
	public void method2() {	
		System.out.println("method2() in Parentt");
	}
}

class Childd extends Parentt implements MyInterface, MyInterface2 {
	public void method1() {	
		System.out.println("method1() in Childd"); 
	}			
}

interface MyInterface {
	default void method1() { 
		System.out.println("method1() in MyInterface");
	}

	default void method2() { 
		System.out.println("method2() in MyInterface");
	}

	static  void staticMethod() { 
		System.out.println("staticMethod() in MyInterface");
	}
}

interface MyInterface2 {
	default void method1() { 
		System.out.println("method1() in MyInterface2");
	}

	static  void staticMethod() { 
		System.out.println("staticMethod() in MyInterface2");
	}
}
