package Num;

class BoxingUnboxingAuto2 {
	public static void main(String[] args){
		Integer num1=10;
		Integer num2=20;

		num1++;			// auto boxing과 auto unboxing이 같이 일어남
		System.out.println(num1);

		num2+=3;		// auto boxing과 auto unboxing이 같이 일어남
		System.out.println(num2);	

		int addResult=num1+num2;
		System.out.println(addResult);

		int minResult=num1-num2;	
		System.out.println(minResult);	
	}
}
