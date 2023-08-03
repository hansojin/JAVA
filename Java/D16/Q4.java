import java.util.Scanner;

class Q4{
	public static void printMatrix(int[][] matrix){
		for (int[] ar : matrix){
			for(int i : ar)
				System.out.print(i+"\t");
			System.out.println();
		}
	}

	public static int swap(int n1, int n2){
		return n1;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[25];
		for(int i=0;i<arr.length;i++){
			arr[i]=i+1;
		}

		for(int i=arr.length-1;i>=0;i--){
			int j= (int)(Math.random()*24)+1;	
			arr[j]=swap(arr[i],arr[i]=arr[j]);
		}

		int[][] matrix = new int[5][5];

		int idx=0;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				matrix[i][j]=arr[idx++];
			}
		}
		while(true){
			printMatrix(matrix);
			System.out.print("Enter between 1-25 (0 for EXIT) : ");
			int num = sc.nextInt();
			if (num==0){
				System.out.print("EXIT");
				break;
			}
			else if( num<0 || num>26)
				System.out.println("Enter between 1-25");
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if (matrix[i][j]==num)
						matrix[i][j]=0;
				}
			}
		}
		
		
	}
	
}