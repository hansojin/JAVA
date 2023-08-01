class ArrRow{

	public static void changeRow(int[][] arr){
		int[] last = arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--){
			arr[i]=arr[i-1];
		}
		arr[0]=last;
	}
	public static void main(String[] args){
		int[][] arr = new int[][]{
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		for (int[] m : arr){
			for(int n : m){
				System.out.print(n+ " ");
			}
			System.out.println();	// 123 456 789
		}

		changeRow(arr);
		System.out.println();
		for (int[] m : arr){
			for(int n : m){
				System.out.print(n+ " ");
			}
			System.out.println();	//789 123 456
		}	
	}
}

