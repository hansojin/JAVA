class Q8{
	public static void main(String[] args){
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		
		for(int i : answer)
			counter[i-1]+=1;
		for(int i: counter){
			System.out.print(i);
			for(int j=0;j<i;j++)
				System.out.print("*");
			System.out.println();
		}						
	}
}