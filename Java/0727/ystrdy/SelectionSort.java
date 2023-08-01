import java.util.Scanner;

class SelectionSort{
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

		for (int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if (arr[i]>arr[j])
					arr[j]=swap(arr[i],arr[i]=arr[j]);
			}
		}
		for(int members : arr){
			System.out.print(members + " " );
		}
	}
}