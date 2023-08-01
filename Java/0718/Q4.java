class Q4{

	public static int sigma(int num){
		int sum=0;
		for (int i=1;i<=num;i++){
			sum+=i;
		}
		return sum;
	
	}
	public static void main(String[] args){
		System.out.println(sigma(5));
	}

}
