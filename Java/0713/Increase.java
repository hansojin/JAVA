class Increase{
	public static void main(String[] args){

		int num1=10,num2=10;
		int result1=0, result2=0;

		result1=++num1;		// 앞이면, 증감이 진행된 결과가 result에 들어가고
		result2=num2++;		// 뒤면, 증감이 진행되기 전 결과가 result에 들어가되, num은 그대로 증감이 진행

		System.out.println(num1+" " + num2);		//11 11 (if -- : 9 9)
		System.out.println(result1+" " + result2);	//11 10 (9 10)


		int num3=10;
		System.out.println(num3++);		//10 (if -- : 10)
		System.out.println(num3);		//11 (9)

		int num4=10;
		System.out.println(++num4);		//11
		System.out.println(num4);		//11
	}
}