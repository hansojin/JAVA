class RuntimeExceptionCase{	
	public static void main(String[] args){
		try{
			int[] arr=new int[3];
			arr[-1]=20;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
			// Index -1 out of bounds for length 3
		}
		
		try{
			Object obj=new int[10];
			String str=(String)obj;
		}catch(ClassCastException e){
			System.out.println(e.getMessage());
			// class [I cannot be cast to class java.lang.String ([I and java.lang.String are in module java.base of loader 'bootstrap')
		}
		
		try{
			int[] arr=new int[-10];
		}catch(NegativeArraySizeException e){
			System.out.println(e.getMessage());
			// -10
		}
		
		try{
			String str=null;
			int len=str.length();
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
			// Cannot invoke "String.length()" because "<local1>" is null
		}
	}
}