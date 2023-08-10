interface Readable {
	public void read();
}

class OuterClass{
	private String myName;
	
	OuterClass(String name){
		myName=name;
	}
	
	public Readable createLocalClassInst(final int num){
		return new Readable(){
			public void read(){
				System.out.println(myName);
				System.out.println(num);
			}
		};
	}
}

class LocalAnoTest{	
	public static void main(String[] args){
		OuterClass out=new OuterClass("My Outer Class");
		Readable localInst1=out.createLocalClassInst(111);
		localInst1.read();
		
		Readable localInst2=out.createLocalClassInst(222);
		localInst2.read();
	}
}