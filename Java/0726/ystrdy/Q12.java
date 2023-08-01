class Q12{
	public static void main(String[] args){
		int num = 12321;
		int tmp=num, rev=0;
		int len=String.valueOf(num).length();

		while(tmp>0){
			rev+=(tmp%10)*Math.pow(10,len-1);
			len-=1;
			tmp/=10;
		}
		if (rev==num)
			System.out.println("회문수");
		else
			System.out.println("회문수 아님");
		
	}
}