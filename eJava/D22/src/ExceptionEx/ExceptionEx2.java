package ExceptionEx;

class ExceptionEx2 {
	public static void main(String args[]) {
		int number = 100;
		int result = 0;

		for(int i=0; i < 10; i++) {
			result = number / (int)(Math.random() * 10); 
			// rand가 0 이 나오면, ArithmeticException 발생
			System.out.println(result);
		}
	} 
}

