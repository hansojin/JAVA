class Q2{
	public static void main(String[] args){
		
		 int[][] score = {
			{100,100,100},
			{20,20,20},
			{30,30,30},	
			{40,40,40},	
			{50,50,50}
		};
		int row = score.length;	//5
		int col = score[0].length;	//3

		int [][] result = new int[row+1][col+2];
		for(int i=0;i<row;i++){
			result[i][0]=i+1;
			for(int j=0;j<col;j++){
				result[i][j+1]=score[i][j];
				result[i][4]+=result[i][j+1];
				result[5][j+1]+=score[i][j];
			}
		}
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("=============================================");
		for(int i=0;i<result.length-1;i++){
			for(int j=0;j<result[0].length;j++){
				System.out.print(result[i][j]+"\t");
			}
			System.out.print(result[i][4]/3f);
			System.out.println();
		}
		System.out.println("=============================================");	
		System.out.print("총점\t");
		for(int i=1;i<=3;i++){
			System.out.print(result[5][i]+ "\t");
		}

		
	}	
}