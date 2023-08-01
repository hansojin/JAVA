class Adder{
	private int cntAdd;
	
	Adder(){
		cntAdd=0; 	//사실 0 안해줘도 이미 멤버변수니까 0으로 초기화됨
	}
	int getCntAdd(){
		return cntAdd;
	}
	int addNum(int n1, int n2){
		cntAdd++;
		return n1+n2;
	}
}

class Subtractor{
	private int cntSub;
	
	Subtractor(){
		cntSub=0; 	
	}
	int getCntSub(){
		return cntSub;
	}
	int subNum(int n1, int n2){
		cntSub++;
		return n1-n2;
	}
}

class Calculator{
	private Adder adder;
	private Subtractor subb;

	public Calculator(){
		adder = new Adder();
		subb = new Subtractor();
	}

	public int addNum(int n1, int n2){
		return adder.addNum(n1,n2);
	}

	public int subNum(int n1, int n2){
		return subb.subNum(n1,n2);
	}
	
	public void showOperatingTimes(){
		System.out.println(" add : " + adder.getCntAdd());
		System.out.println(" sub : " + subb.getCntSub());
	}
}

class CalculatorMain{
	public static void main(String[] args){

		Calculator cal = new Calculator();

		System.out.println("1 + 2 = " + cal.addNum(1, 2));
		System.out.println("2 + 4 = " + cal.addNum(2, 4));
		System.out.println("5 - 1 = " + cal.subNum(5, 1));

		cal.showOperatingTimes();
	}
}



/*

클래스를 작은 크기로 디자인하여 하나의 완성된 클래스로 묶으면,
 1. 변경이 필요할 때, 변경되는 클래스의 범위를 최소화 할 수 있음
 2. 작은 크기의 클래스를 다른 클래스의 정의에도 활용할 수 있음

*/