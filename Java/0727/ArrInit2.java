class ArrInit2{
	public static void main(String[] args){

		//int[] num1 = new int[3]{10,20,30};	// Error
	
		int[] num2 = new int[]{10,20,30};
		int[] num3 = {10,20,30};		// new 키워드는 생략할 수 있음

		/*
		int[][] num4= new int[2][3]{		// Error
			{10, 20, 30},
			{40, 50, 60}
		};
		*/

		int[][] num5= new int[][]{
			{10, 20, 30},
			{40, 50, 60}
		};
		int[][] num6= {
			{10, 20, 30},
			{40, 50, 60}
		};

		int [][] num7 = new int[2][2];
		num7[0][0] = 1;
		num7[0][1] = 2;
		num7[1][0] = 3;
		num7[1][1] = 4;

		int [][] num8 = {{1, 2}, {3, 4}}
	}
}