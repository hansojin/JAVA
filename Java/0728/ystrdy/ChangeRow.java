class ChangeRow{
	public static void change(int[][] arr){
		int[] last= arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--){
			arr[i]=arr[i-1];
		}
		arr[0] = last;
	}
	public static void main(String[] args){
		int[][] arr = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		for(int[] ar : arr){
			for(int i : ar){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
		change(arr);
		
		for(int[] ar : arr){
			for(int i : ar){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		
	}
}