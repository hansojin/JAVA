class OuterClass{
	private String myName;
	private int num;
	
	OuterClass(String name){
		myName=name;
		num=0;
	}
	
	public void whoAreYou(){
		num++;
		System.out.println(myName+ " outer "+num);
	}
	
	class InnerClass{		// 접근은 무조건, outer 객체 먼저 만든 후에 가능
		InnerClass(){
			whoAreYou();
		}
	}
}

class InnerClassTest{	
	public static void main(String[] args){
		OuterClass out1=new OuterClass("First");
		OuterClass out2=new OuterClass("Second");
		out1.whoAreYou();				// First outer 1
		out2.whoAreYou();				// Second outer 1
		
		OuterClass.InnerClass inn1=out1.new InnerClass();// First outer 2
		OuterClass.InnerClass inn2=out2.new InnerClass();// Second outer 2
		OuterClass.InnerClass inn3=out1.new InnerClass();// First outer 3
		OuterClass.InnerClass inn4=out1.new InnerClass();// First outer 4
		OuterClass.InnerClass inn5=out2.new InnerClass();// Second outer 3
	}
}