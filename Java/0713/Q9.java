class Q9{
	public static void main(String[] args){
		int i=0,sum=0,cnt=0;
		while(sum<=1000){
			i+=7;
			cnt+=1;
			sum+=i;
		}
		System.out.println(cnt+"번째 항 : " + sum);
	}
}
