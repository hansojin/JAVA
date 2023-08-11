package OOP2;

class Outer {
	class Inner {
		int iv=100;
	}
}
class Outer2{
	static class Inner2{
		int iv2 = 200;
	}
}
class Exercise7_25 {
	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		System.out.println(in.iv);
		
		Outer2.Inner2 in2= new Outer2.Inner2();
		System.out.println(in2.iv2);
	}
}
