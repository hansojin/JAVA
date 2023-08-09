class Test2{
	public static void main(String[] args){
		hi();
	}
	public static void hi(){
		try{
			System.out.print(10/0);

		} catch (ArithmeticException e){
			System.out.println("CAN'T divide in 0 " );
		}
	}
}