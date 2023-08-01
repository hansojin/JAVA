class Q9_1{
	public static void main(String[] args){
		int i=0,j=0;
		for (i=0;i<4;i++){
			for(j=0;j<i;j++)
				System.out.print(" ");
			for (;j<7-i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
