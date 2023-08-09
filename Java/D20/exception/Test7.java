class Test7{
	public static void main(String[] args) throws ArithmeticException{
		hi();
	}
	public static void hi() throws ArithmeticException{
		bye();
	}
	public static void bye() throws ArithmeticException{
		System.out.println(10/0);
	}
}

// main에서도 안 받고 던진다면,
// > Exception in thread "main" java.lang.ArithmeticException: / by zero