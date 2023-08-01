class TwoDimenArray{
	public static void main(String[] args){
		int[][] arr=new int[3][4];
		int i,j;	
		for(i=0; i<arr.length; i++)
			for(j=0; j<arr[i].length; j++)
				arr[i][j]=i+j;
		
		// 이중 for문 접근
		for(i=0; i<arr.length; i++){
			for(j=0; j<arr[i].length; j++)
				System.out.print(arr[i][j]+" ");	
			System.out.println("");
		}
		
		// 배열로 접근
		for (int[] m : arr){				//반환값 확인 int[]
			for (int n : m)			//arr[i] 가 아니라, m 
				System.out.print(n+ " ");
			System.out.println("");
		}
	}
}

