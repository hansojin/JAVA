class MemberVariable{
						// 0으로 기본 초기화 
	public int num1;				// instance 변수	
	public static int num2;			// static = class 변수 (MV.num2로 호출가능)
	MemberVariable(){
		num1++;
		num2++;
	}
	public static void printNumber(){
		System.out.println(num2);
			// System.out.println(num1 + " " + num2);  
			// error as, 어떤 num1을 출력할지 모름
			// class(=static) method 내에서는 instance 변수를 참조할 수 없다.
			// printNumber2();
			// 클래스 메소드 내에서는 인스턴스 메소드를 참조할 수 없다.	
			// error as, 어떤 num1을 출력할지 모름
	}
	public void printNumber2(){
		System.out.println(num1 + " " + num2);	
		printNumber();
	}
}
class MemberVariableMain{
	public static void main(String[] args)
	{
		System.out.println(MemberVariable.num2);		// 0
								// MV.num2는 static으로 객체 생성 없이도 호출 가능 
		MemberVariable n1 = new MemberVariable();		// CS : 1 1
		MemberVariable n2 = new MemberVariable();		// CS : 1 2
		MemberVariable n3 = new MemberVariable();		// CS : 1 3
		n2.num1 = 50;
		n3.num1 =70;
		MemberVariable.printNumber();			// 3
		n2.printNumber2();					// 50 3
		System.out.println(n1.num2);				//3 (아래 다 3)
		System.out.println(n2.num2);
		System.out.println(n3.num2);
		System.out.println(MemberVariable.num2);
		n1.printNumber();
		n2.printNumber();
		n3.printNumber();
	}
}