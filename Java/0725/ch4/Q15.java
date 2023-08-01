class Q15{
	public static void main(String[] args){
		int number=12321;
		int tmp=number;
		
		int result=0;
		int cnt=4;	
		while(tmp!=0){
			result+=(tmp%10)*Math.pow(10,cnt);
			tmp/=10;
			cnt-=1;
		}
		
		if (number==result)
			System.out.println(number+ "는 회문수");
		else
			System.out.println(number+ "는 회문수 아님");	
	}
}