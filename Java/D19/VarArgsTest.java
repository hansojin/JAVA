class VarArgsTest{

	/*
	// 메소드 오버로딩 사용
	public static int add(int num1){
		return num1;
	}
	public static int add(int num1, int num2){
		return num1 + num2;
	}
	public static int add(int num1, int num2, int num3){
		return num1 + num2 + num3;
	}
	*/

	// 가변인수를 사용
	static int add(int... args){
		int sum=0;
		for(int i : args)
			sum+=i;
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println(add(5));			// 5
		System.out.println(add(5, 10));		// 15
		System.out.println(add(5, 10, 15));		// 30
	}
}