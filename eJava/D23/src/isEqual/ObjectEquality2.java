package isEqual;

// 연산자는 참조변수의 참조 값을 비교한다. 따라서 인스턴스에 저장되어 있는 값 자체를 비교하려면 별도의 방법을 사용해야 한다. 
// 값 자체를 비교할 수 있도록 public boolean isEquals(IntNumber numObj) 메소드를 정의하시오.
// 해당 문제를 Object 클래스의 equals 라는 메소드를 이용하여 구현하시오.(메소드 오버라이딩)
class IntNumber2{
	int num;

	public IntNumber2(int num){
		this.num=num;
	}
	
}

class ObjectEquality2{
	public static void main(String[] args){
		IntNumber2 num1=new IntNumber2(10);
		IntNumber2 num2=new IntNumber2(12);
		IntNumber2 num3=new IntNumber2(10);

		if(num1.equals(num2))
			System.out.println("num1과 num2는 동일한 정수");
		else
			System.out.println("num1과 num2는 다른 정수");

		if(num1.equals(num3))
			System.out.println("num1과 num3는 동일한 정수");
		else
			System.out.println("num1과 num3는 다른 정수");		
	}
}
