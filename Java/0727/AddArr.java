class AddArr{
	public static void addOneDArr(int[] arr, int add){
		for(int i=0;i<arr.length; i++)
			arr[i] += add;
	}

	public static void addTwoDArr(int[][] arr, int add){
		for(int i=0;i<arr.length; i++){
			addOneDArr(arr[i],add);
		}
			
	}

	public static void main(String[] args){
		int[][] arr = new int[][]{
			{1,2,3},
			{2,4,6}
		};

		for(int[] n : arr){
			for(int  m : n)
				System.out.print(m+ " ");
			System.out.println();		//1 2 3 \n 2 4 6
		}	
		
		for(int i=0;i<arr.length;i++){
			addOneDArr(arr[i],3);
		}
		
		for(int[] n : arr){
			for(int  m : n)
				System.out.print(m+ " ");
			System.out.println();		//4 5 6 \n 5 7 9
		}
		
		addTwoDArr(arr,2);
		for(int[] n : arr){
			for(int  m : n)
				System.out.print(m+ " ");
			System.out.println();		//6 7 8 \n 7 9 11
		}
		
	}
}




