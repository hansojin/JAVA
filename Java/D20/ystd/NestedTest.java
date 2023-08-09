class OuterOne{
	OuterOne(){
		Nested nst = new Nested();
		nst.simpleM();
	}
	public static class Nested{
		public void simpleM(){
			System.out.println(" one - public nested - simpleM " );
		}
	}
}

class OuterTwo{
	OuterTwo(){
		Nested nst = new Nested();
		nst.simpleM();
	}
	private static class Nested{
		public void simpleM(){
			System.out.println(" two - private nested - simpleM " );
		}
	}
}

class NestedTest{
	public static void main(String[] args){
		OuterOne one = new OuterOne();
		OuterTwo two = new OuterTwo();

		OuterOne.Nested nst1 = new OuterOne.Nested();
		nst1.simpleM();
		//OuterTwo.Nested nst2 = new OuterTwo.Nested();
		//nst2.simpleM();
		// can NOT access as it's private
	}
}