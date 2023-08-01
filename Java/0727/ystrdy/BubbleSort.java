import java.util.Scanner;

class BubbleSort{
	public static int swap(int n,int m){
		return n;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		final int SIZE = 5;
		int[] arr = new int[SIZE];
		int len = arr.length;

		for (int i=0;i<len;i++){
			System.out.print("Enter any number : ");
			arr[i]=sc.nextInt();
		}

		for (int i=len-1;i>0;i--){
			for(int j=0;j<i;j++){
				if (arr[j]>arr[j+1])
					arr[j+1]=swap(arr[j],arr[j]=arr[j+1]);
			}
		}
		for(int members : arr){
			System.out.print(members + " " );
		}
	}
}