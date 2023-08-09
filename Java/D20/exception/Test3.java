class Test3{
	public static void main(String[] args){
		try{
			hi();
		} catch (ArithmeticException e){
			System.out.println("ArithmeticException");
		}
	}
	public static void hi() throws ArithmeticException{
		System.out.println(10/0);
		System.out.println("GOOD");		// 출력 안됨
	}
}