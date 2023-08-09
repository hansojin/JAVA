class Test5{
	public static void main(String[] args){
		hi();
	}
	public static void hi(){
		try{
			bye();
		} catch ( ArithmeticException e){
			System.out.println("ArithmeticException");
		}
	}
	public static void bye() throws ArithmeticException{
		
		System.out.println(10/0);
		
	}
}