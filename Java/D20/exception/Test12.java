class Test12{
	public static void main(String[] args) throws ArithmeticException{	
		int result = div(10, 0);
		System.out.println(result);
	}
	public static int div(int num1, int num2) throws ArithmeticException{
		int result = 0;
		result = num1 / num2;

		return result;
	}
}

/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Test12.div(Test12.java:8)
        at Test12.main(Test12.java:3)
*/