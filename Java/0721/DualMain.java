class AAA{
	int aaa;
	public AAA(int num){ 
		aaa=num; 
	}
	
	public static void main(String[] args){
		AAA ins1=new AAA(10);
		BBB ins2=new BBB(20);
		
		System.out.println("ins1.aaa="+ins1.aaa);	//10
		System.out.println("ins2.bbb="+ins2.bbb);	//20
	}
}

class BBB {
	int bbb;
	public BBB(int num){ 
		bbb=num; 
	}
	
	public static void main(String[] args){
		AAA ins1=new AAA(11);
		BBB ins2=new BBB(22);
		
		System.out.println("ins1.aaa="+ins1.aaa);	//11
		System.out.println("ins2.bbb="+ins2.bbb);	//22
	}
}

// java 에서는 main method가 여러개 있을수가 있음
// java AAA 하면 AAA의 main 이 실행되고, java BBB하면 BBB class의 main method가 실행됨
// 물론 javac 해서 해당 java 파일명으로 컴파일 한 후에.