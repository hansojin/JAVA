class EnhancedFor{
	public static void main(String[] args){		
		int[] arr={1, 2, 3, 4, 5};
		
		int sum=0;
		for(int e: arr)
			sum+=e;
		
		System.out.println("배열 요소의 합: "+sum);
		
		for(int e: arr){
			e++;
			System.out.print(e+" ");	//2 3 4 5 6
		}
		System.out.println();
	
		for(int e: arr)
			System.out.print(e+" ");	//1 2 3 4 5
	}
}