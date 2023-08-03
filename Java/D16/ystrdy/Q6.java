class Q6{
	public static void main(String[] args){
		int[][] score = {
			{100, 100, 100}
			, {20, 20, 20}
			, {30, 30, 30}
			, {40, 40, 40}
			, {50, 50, 50}
			};
		int col = score[0].length;	//3
		int row = score.length;	//5
		int[][] ans = new int[row+1][col+1];

		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				ans[i][j]=score[i][j];
				ans[i][col]+=ans[i][j];

				ans[row][j]+=score[i][j];
				ans[row][col]+=score[i][j];
			}
		}

		for (int[] i : ans){
			for(int j : i)
				System.out.print(j+"\t");
			System.out.println();
		}

		
	}
}