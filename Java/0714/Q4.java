class Q4{
	public static void main(String[] args){
		int i=0,sum=0,cnt=0;
		do{
			i+=7;
			cnt+=1;
			sum+=i;

		}while(sum<=1000);
		System.out.println(cnt+"번째 항 : "+sum);
	}
}