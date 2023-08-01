class AAA{
	public AAA(){
		System.out.println("AAA");
	}
}

class BBB{
	public BBB(){	
		System.out.println("BBB");
	}
}

class ABMain{
	public static void main(String[] args){
		AAA aaa = new AAA();
		BBB bbb = new BBB();
	}
}