class ValueMain{

	public static int minValue(int[] arr){
		int min = Integer.MAX_VALUE;
		for(int i : arr){
			if(i<min)
				min=i;
		}
		return min;
	}

	public static int maxValue(int[] arr){
		int max = Integer.MIN_VALUE;
		for(int i : arr){
			if(i>max)
				max=i;
		}
		return max;
	}

	public static void main(String[] args){
		int[] arr = {10,2,7,5,50};
		
		System.out.println("min : " + minValue(arr));
		System.out.println("max : " + maxValue(arr));
	}
}