interface Readable {
	public void read();
}

class OuterClass{
	private String myName;
	OuterClass(String name){
		myName=name;
	}
	
	public Readable createLocalClassInst(final int instID){		
		class LocalClass implements Readable{
			public void read(){
				System.out.println("Outer inst name: "+myName);
				System.out.println("Local inst ID: "+instID);
			}
		}
		return new LocalClass();
	}
	// 지역 변수의 성질이 반드시 'FINAL' 이어야 함
	// heap이 아닌 stack(임시저장)에 저장하기 때문에 collision 방지위해 final 사용
}

class LocalParamClassTest{	
	public static void main(String[] args){
		OuterClass out=new OuterClass("My Outer Class");
		Readable localInst1=out.createLocalClassInst(111);
		localInst1.read();
		
		Readable localInst2=out.createLocalClassInst(222);
		localInst2.read();

		/*
		Outer inst name: My Outer Class
		Local inst ID: 111
		Outer inst name: My Outer Class
		Local inst ID: 222
		*/
	}
}