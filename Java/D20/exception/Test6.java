class Test6{
	public static void main(String[] args){
		try{
			hi();
		} catch ( ArithmeticException e){
			System.out.println("ArithmeticException");
		}
	}
	public static void hi() throws ArithmeticException{
		bye();
	}
	public static void bye() throws ArithmeticException{
		System.out.println(10/0);
	}
}