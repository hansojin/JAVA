class AddArrMain{
	public static void addOneDArr(int[] arr, int add){
		for(int i=0;i<arr.length; i++)
			arr[i] += add;
	}

	public static void addTwoDArr(int[][] arr, int add){
		for(int i=0;i<arr.length; i++)
			addOneDArr(arr[i],2);
	}

	public static void main(String[] args){
		int[][] arr = {
			{1,2,3},
			{2,4,6}
		};
		
		for(int[] ar : arr){
			for(int i : ar){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
		for(int [] ar : arr){
			addOneDArr(ar,1);
		}
		for(int[] ar : arr){
			for(int i : ar){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
		addTwoDArr(arr,2);
		
		for(int[] ar : arr){
			for(int i : ar){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
	}
}