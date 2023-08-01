class SimpleNumber{
	
	//private SimpleNumber snInst;	
	private static SimpleNumber snInst;	//  needs to be static
	int num=0;

	private SimpleNumber() {}		// 생성자가 private

	public void addNum(int n) { 
		num += n; 
	}
	public void showNum(){ 
		System.out.println(num); 
	}
	
	public static SimpleNumber getSimpleNumberInst(){
		
		//return new SimpleNumber();

		if( snInst==null ) {
			snInst = new SimpleNumber();
		}
		return snInst;
	}
}

/*

아니면, 멤버 변수 선언할때 
private static SimpleNumber snInst = new SimpleNumber(); 
라고 처음부터 객체를 만들어 놓으면, 이후 getSimpleNumberInst()에서 
if null 문 필요없이 바로 return snInst; 만 적을 수도 있음


*/


class OnlyOneInstance{
	public static void main(String[] args){
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(20);

		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num2.addNum(30);

		num1.showNum(); 	//20 -> 50
		num2.showNum();	//30 -> 50
	}
}

/*

그냥 int num=0 이면, 호출 할때 마다 객체가 생성됨
( 우선은 생성자가 private이니까 main에서 바로 객체를 만들어서 호출할수 없음.
 근데, getsimpleNumberinst()는 static이니까 객체 생성 없이 class명으로 호출 가능
 public static SimpleNumber getSimpleNumberInst()에서 SimpleNumber는 반환형 ) 

일단 sninst가 없으면, 객체를 하나 만들어 주고, 이후에는 있는 객체에 add 해줄거야
근데, 문제는 snInst가 static이 안붙어있으면 instance변수니까 static 을 붙여줘야해

This is called 'singleton (design pattern)'

*/