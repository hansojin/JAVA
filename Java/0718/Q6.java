class Q6{

	public static int mul(int n){
		int sum=1;
		for(int i=n;i>0;i--){
			sum*=i;
		}
		return sum;

	}
	public static void main(String[] args){
		System.out.println(mul(5));
	}
}
