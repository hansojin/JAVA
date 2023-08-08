interface Readable {
	public void read();
}

class OuterClass{
	private String myName;
	
	OuterClass(String name){
		myName=name;
	}
	
	public Readable createLocalClassInst(final int instID){		
		return new Readable(){
			public void read(){
				System.out.println("Outer inst name: "+myName);
				System.out.println("Local inst ID: "+instID);
			}			
		};
	}
}

/*
as, LocalClass는 외부에서 인식 할 수 없으므로, 그냥 익명의 class로 만들 수 있다.
BY, 'return new LocalClass()' 자리에 interface 이름으로 채워넣으면서. 
*/

class LocalParamAnonymous{	
	public static void main(String[] args){
		OuterClass out=new OuterClass("My Outer Class");
		Readable localInst1=out.createLocalClassInst(111);
		localInst1.read();
		
		Readable localInst2=out.createLocalClassInst(222);
		localInst2.read();
	}
}

