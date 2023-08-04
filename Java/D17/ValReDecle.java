class AAA {
	public int num=2;
}

class BBB extends AAA{
	public int num=5;
}

class CCC extends BBB{
	public int num=7;
}

class ValReDecle{
	public static void main(String[] args){
		CCC ref1=new CCC();		
		BBB ref2=ref1;
		AAA ref3=ref2;
		System.out.println(System.identityHashCode(ref1));	// 모두
		System.out.println(System.identityHashCode(ref2));	// 1000번지로
		System.out.println(System.identityHashCode(ref3));	// 동일한 주소값	
		System.out.println("CCC's ref: "+ref1.num);		// 7
		System.out.println("BBB's ref: "+ref2.num);		// 5
		System.out.println("AAA's ref: "+ref3.num);		// 2		
		// 멤버 변수의 이름이 같으면, 참조변수 타입의 멤버 변수를 출력
		
		CCC ref4=new CCC();		
		BBB ref5=new CCC();
		AAA ref6=new CCC();
		System.out.println("CCC's ref: "+ref4.num);		// 7
		System.out.println("BBB's ref: "+ref5.num);		// 5
		System.out.println("AAA's ref: "+ref6.num);		// 2
		

		
		
	}
}