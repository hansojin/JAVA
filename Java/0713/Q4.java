class Q4{
	public static void main(String[] args){
		int cnt=0,sum=0;
		for(int i=0;sum<=1000;i+=7){
			cnt+=1;
			sum+=i;
		}
		System.out.println(cnt + "번째 항 : " + sum);
	}
}