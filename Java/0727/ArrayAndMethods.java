class ArrayAndMethods{
	public static int[] addAllArray(int[] ar, int addVal){

		for(int i=0; i<ar.length; i++)
			ar[i]+=addVal;

		return ar;		
	}
	
	public static void main(String[] args){

		int[] arr={1, 2, 3, 4, 5};
		int[] ref;
		
		ref=addAllArray(arr, 7);	// ref에 (arr를 가리키는) 주소값이 들어감 
		
		if(arr==ref)
			System.out.println("동일 배열 참조");	// <- as 주소값 같으니까
		else
			System.out.println("다른 배열 참조");
				

		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i]+" ");		// 8 9 10 11 12
		
		for(int i=0; i<ref.length; i++)
			System.out.print(ref[i]+" ");		// 8 9 10 11 12


		System.out.println(System.identityHashCode(arr));	//1000
		System.out.println(System.identityHashCode(ref)); 	//1000
		/*
		
		*/	
	}
}

