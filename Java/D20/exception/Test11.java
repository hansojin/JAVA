class Test11{
	public static void main(String[] args){	
		try{
			int result = div(10, 0);	
			System.out.println(result);
		}catch(ArithmeticException e){
			System.out.println("0으로 나누면 안돼요.");
		}
	}
	public static int div(int num1, int num2) throws ArithmeticException{
		int result = 0;
		result = num1 / num2;

		return result;
	}
}

// 0으로 나누면 안돼요.