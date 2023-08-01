class Q7{
	public static void main(String[] args){
		int cnt=0;
		for (int i=28;i>=20;i--){
			System.out.print(i+"\t");
			cnt+=1;
			if (cnt%3==0)
				System.out.println();
		}
	}
}
