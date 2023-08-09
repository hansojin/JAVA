class VarArgs{
	public static int add(int... args){
		int sum=0;
		for (int i : args)
			sum+=i;
		return sum;
	}
	public static void main(String[] args){
		System.out.println(add(5));			// 5
		System.out.println(add(5, 10));		// 15
		System.out.println(add(5, 10, 15));		// 30
	}
}