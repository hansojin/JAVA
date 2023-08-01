class Q1{
	public static int add(int n1, int n2){
		return n1+n2;
	}
	
	public static int sub(int n1, int n2){
		return n1-n2;
	}

	public static int mul(int n1, int n2){
		return n1*n2;
	}

	public static int div(int n1, int n2){
		return n1/n2;
	}

	public static void main(String[] args){
		System.out.println("1+2="+add(1,2));
		System.out.println("2-1="+sub(2,1));
		System.out.println("5*3="+mul(5,3));
		System.out.println("10/2="+div(10,2));

	}
}
