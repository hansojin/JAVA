class Test1{
	public static void main(String[] args){
		try{
			System.out.println(10/0);	//throw new ArithmeticException()

		}catch(ArithmeticException e){
			System.out.println("You can NOT divide in 0");
		}
	}
}