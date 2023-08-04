class AAA{
	public void rideMethod(){
		System.out.println("AAA's Method");
	}
	public void loadMethod(){
		System.out.println("void Method");
	}
}

class BBB extends AAA{
	public void rideMethod(){
		System.out.println("BBB's Method");
	}
	public void loadMethod(int num){
		System.out.println("int Method");
	}
}

class CCC extends BBB{
	public void rideMethod(){
		System.out.println("CCC's Method");
	}
	public void loadMethod(double num){
		System.out.println("double Method");
	}
}

class OverRideAndLoad{
	public static void main(String[] args){
		AAA ref1=new CCC();	// 참조타입 참조변수 = new 생성자	
		BBB ref2=new CCC();
		CCC ref3=new CCC();
		
		ref1.rideMethod();		
		ref2.rideMethod();		
		ref3.rideMethod();		// 모두 " CCC's Method " 출력
		
		ref3.loadMethod();		// '다형성'
		ref3.loadMethod(1);	// 매개변수에 전달되는 값에 따라
		ref3.loadMethod(1.2);	// 메소드 호출이 달라짐
	}
}