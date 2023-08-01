class Test{
	
	public static void hi(){
		System.out.println("hi");
	}

	public static void hello(int num){
		for (int i=0;i<num;i++)
			System.out.println("hello");
	}
	
	public static int world(int num){
		for(int i=0;i<num;i++)	
			System.out.print("*");
		return 100;
	}	

	public static int add (int n, int m){
		return n+m;
	}

	public static void main(String[] args){
		System.out.println("main method");
		hi();
		hello(3);
		System.out.println(world(2));
		System.out.println(add(4,8));
	}


}
