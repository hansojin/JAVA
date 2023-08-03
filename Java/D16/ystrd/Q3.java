class Q3{
	public static void main(String[] args){
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] cnt= new int[4];

		for (int i : answer){
			cnt[i-1]+=1;
		}
		for (int i : cnt){
			System.out.print(i);
			for(int j=0;j<i;j++)
				System.out.print("*");
			System.out.println();
		}
	}
}