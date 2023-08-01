class Q4{
	public static void main(String[] args){
		int sum=0,cnt=0;
		for(int i=1;i<=1e10;i++){
			if (i%2!=0)
				sum+=i;
			else	
				sum-=i;
			cnt+=1;
			if(sum>=100)
				break;
		}
		System.out.println(cnt);
	}
}