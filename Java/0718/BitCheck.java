class BitCheck{
	public static void main(String[] args){
		int cnt=1;
		int num=15678;
		while(true){
			if(cnt==3)
				System.out.print(num%2 + " ");
			if(cnt==5){
				System.out.print(num%2);
				break;
			}
			num/=2;
			cnt++;

		}

	}
}
