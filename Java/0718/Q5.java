class Q5{

	public static int sigma(int n1, int n2){
		int sum=0;
		for(int i=n1;i<=n2;i++){
			sum+=i;
		}
		return sum;

	}
	public static void main(String[] args){
		System.out.println(sigma(1,10));
	}
}
