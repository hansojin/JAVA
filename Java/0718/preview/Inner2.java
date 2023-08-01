class OuterClass{
	int x=10;
	
	static class InnerClass{
		int y=5;	
	}
}

public class Inner2{
	public static void main(String[] args){
		
		OuterClass.InnerClass myInner = new OuterClass.InnerClass();
		System.out.println(myInner.y);

		// static -> can access without creating an object of the outer class
	}
}