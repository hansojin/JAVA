class arrayCopy{
	public static void main(String[] args){
		int[] arr1 = {10, 20, 30, 40, 50};
		int[] arr2 = {1, 2, 3, 4, 5};
 
		System.arraycopy(arr1, 0, arr2, 1, 3);    
		// arr1의 index 0에서부터 3개를, arr2의 index 1에서부터 copy
		// System.arraycopy(arr1, 0, arr2, 1, 5);    ->  범위를 넘어서면 Error
        
		for( int i = 0; i < arr2.length; i++ ) {
    			System.out.println(arr2[i]);		// 1 10 20 30 5
		}

	}
}