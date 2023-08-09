class Test10{
	public static void main(String[] args){
		int result = div(10, 0);
		System.out.println(result);
	}
	public static int div(int num1, int num2){
		int result = 0;
		try{
			result = num1 / num2;
		}catch(ArithmeticException e){
			System.out.println("0으로 나누면 안돼요");
		}
		return result;
	}
}

