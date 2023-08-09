class Test4{
	public static void main(String[] args){
		hi();
	}
	public static void hi(){
		bye();
	}
	public static void bye(){
		try{
			System.out.println(10/0);
		} catch (ArithmeticException e){
			System.out.println("ArithmeticException");
		}
	}
}