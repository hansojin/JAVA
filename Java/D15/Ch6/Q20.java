class Q20{
	public static int[] shuffle(int[] arr){
		for(int i=arr.length-1;i>=0;i--){
			int k=(int)Math.random()*arr.length+1;
			int tmp = arr[i];
			arr[i]=arr[k];
			arr[k]=tmp;
		}
		return arr;
	}
	public static void main(String args[]) {
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}