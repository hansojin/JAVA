package OOP2;

class Outer3 {
	
	int value=10;
	
	class Inner3 {
		
		int value=20;
		
		void method1() {
			
			int value=30;
			
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer3.this.value);
		}
	} // Inner클래스의 끝
} // Outer클래스의 끝

class Exercise7_27 {
	public static void main(String args[]) {
		Outer3 out = new Outer3();
		Outer3.Inner3 inner = out.new Inner3();
		
		inner.method1();
	}
}
