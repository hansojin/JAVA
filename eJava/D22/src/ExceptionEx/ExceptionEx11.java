package ExceptionEx;

class ExceptionEx11 {
	public static void main(String[] args) {
		throw new RuntimeException();	// RuntimeException을 고의로 발생시킨다.
	}
}

//> Exception in thread "main" java.lang.RuntimeException