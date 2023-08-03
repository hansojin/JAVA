class Q4{
	public static void main(String[] args){
		char[][] star = {
		{'*','*',' ',' ',' '},
		{'*','*',' ',' ',' '},
		{'*','*','*','*','*'},
		{'*','*','*','*','*'}
		};	
		for (char[] i : star){
			for(char j : i){
				System.out.print(j);
			}
			System.out.println();
		}
		
		char[][] ans = new char[star[0].length][star.length];
		
		for(int i=0;i<star.length;i++){
			for(int j=0;j<star[0].length;j++){
				ans[j][star.length-i-1]=star[i][j];
			}
		}
		for (char[] i : ans){
			for(char j : i){
				System.out.print(j);
			}
			System.out.println();
		}	
	}
}