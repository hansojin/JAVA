class VarArgs1{
	public static int add(int a){
		return a;
	}
	public static int add(int a,int b){
		return a+b;
	}
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	public static void main(String[] args){
		System.out.println(add(5));			// 5
		System.out.println(add(5, 10));		// 15
		System.out.println(add(5, 10, 15));		// 30
	}
}