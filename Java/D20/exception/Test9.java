class Test9{
	public static void main(String[] args){
		int result = 0;
		result = 10 / 0;
		System.out.println("결과 값은 " + result);
	}
}

/*
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Test9.main(Test9.java:4)
*/