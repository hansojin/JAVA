package generic2;

class A{
	public String toString()	{
		return "Class A";
	}
}

class B{
	public String toString()	{
		return "Class B";
	}
}

class InstanceTypeShower{
	int showCnt=0;
	
	public <T> void showInstType(T inst){
		System.out.println(inst);
		showCnt++;
	}
	
	void showPrintCnt(){
		System.out.println("Show count: "+showCnt);
	}
}

class IntroGenericMethod{	
	public static void main(String[] args){
		A a=new A();
		B b=new B();
		
		InstanceTypeShower shower=new InstanceTypeShower();
		shower.<A>showInstType(a);
		shower.showInstType(a); 	// 가능 as, 컴파일러가 메소드 호출 시 전달되는 참조변수 A와 B의 자료형을 
		shower.<B>showInstType(b);
		shower.showInstType(b); 	// 근거로 자료형 정보를 판단할 수 있기 때문
		shower.showPrintCnt();
	}
}