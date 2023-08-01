class Number{

	int num;					//Number의 멤버변수
	
	public void initNumber(int n){
		num=n;
	}

	public void currentState(){
		System.out.println(num);
	}
}

class NumberMain{
	public static void main(String[] args){
		Number n1 = new Number();	// class명 변수명 = new(=객체생성키워드) instance명(=class명)();
		n1.initNumber(10);			// " 변수명 + . " 이 해당 객체의 주소값 알려준다!
		n1.currentState();			//10
	
		Number n2 = new Number();
		n2.initNumber(100);
		n2.currentState();			//100

		Number n3;
		n3=n1; 				// can access memory 
		n3.currentState();			//10
		n3=n2;
		n3.currentState();			//100


	}
}