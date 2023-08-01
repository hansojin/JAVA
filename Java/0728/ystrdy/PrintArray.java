class PrintArray{


	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		
		for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+ " ");
		}

		System.out.println();

		for (int i : arr)
			System.out.print(i+ " ");
		
		System.out.println();

		int[][] arr2 = {
			{10, 20, 30},
			{40, 50, 60},
			{70, 80, 90}
		};

		for (int i=0;i<arr2.length;i++){
			for(int j=0;j<arr2[i].length;j++)
				System.out.print(arr2[i][j] + " " );
			System.out.println();
		}
		
		for (int[] ar : arr2){
			for(int i : ar)
				System.out.print(i + " " );
			System.out.println();
		}
	}
}