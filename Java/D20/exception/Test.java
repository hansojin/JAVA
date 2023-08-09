class Test{
	public static void main(String[] args){
		try{
			System.out.println(10/0); // throw new ArithmeticException()
		}
		catch(ArithmeticException e){

			System.out.println(e.getMessage());	// / by zero
			
			e.printStackTrace();			
			// java.lang.ArithmeticException: / by zero
        			// at Test.main(Test.java:4)
			
			
		}
	}
}