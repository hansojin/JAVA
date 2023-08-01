class Q8{
	public static void main(String[] args){
		int num=12345;
		int sum=0, tmp=num;
		while(tmp>0){
			sum+=tmp%10;
			tmp/=10;
		}
		System.out.println(sum);
		
	}
}