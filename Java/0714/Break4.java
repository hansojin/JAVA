class Break4{
	public static void main(String[] args){
		int cnt=0;
		for(int i=1;i<101;i++){
			if (i%5!=0)
				continue;
			else{
				if (i%7==0){
					System.out.print(i + " ");
					cnt+=1;
				}
			}
		}
		System.out.print("total : " + cnt);

	}
}
