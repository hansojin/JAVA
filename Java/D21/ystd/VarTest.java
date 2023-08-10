class VarTest{
	public static int add(int... num){
		int sum=0;
		for (int i : num)
			sum+=i;
		return sum;
	}
	public static void main(String[] args){
		System.out.println(add(5));	
		System.out.println(add(5, 10));		
		System.out.println(add(5, 10, 15));	
	}
}