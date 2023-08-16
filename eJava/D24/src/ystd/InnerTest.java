package ystd;

class OuterOne{
	public static class Nested{
		public void simpleM(){
			System.out.println(" one - public nested - simpleM " );
		}
	}
}

class OuterTwo{
	public class JustInner{
		public void simpleM(){
			System.out.println(" two - public Inner - simpleM " );
		}
	}
}

class InnerTest{
	public static void main(String[] args) {
		OuterOne.Nested one = new OuterOne.Nested();
		one.simpleM();
		
		OuterTwo two = new OuterTwo();
		OuterTwo.JustInner twoIn = two.new JustInner();
		twoIn.simpleM();
		
	}
}
