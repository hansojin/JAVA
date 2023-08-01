class Q4{
	public static void main(String[] args){
		int[][] arr = {
			{ 5, 5, 5, 5, 5},
			{10,10,10,10,10},
			{20,20,20,20,20},
			{30,30,30,30,30}
		};
		int total=0;
		float average=0;
		
		int cnt=0;
		for (int[] intArr : arr){
			for(int i : intArr){
				total+=i;
				cnt+=1;
			}
		}
		average= (float)total/cnt;
		System.out.print(total+" " + average);
	}
}