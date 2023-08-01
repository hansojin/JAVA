import java.util.Scanner;

class AscNum3{

	public static int swap(int n1, int n2){
		return n1;
	}

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		final int SIZE = 5;
		int[] arr = new int[SIZE];
		int len = arr.length;

		for(int i=0;i<len;i++){
			System.out.print("Enter number : ");
			arr[i]=sc.nextInt();
		}

		// advanced selectionSort
		for(int i=0;i<len-1;i++){
			for(int j=i+1;j<len;j++){
				if (arr[i]>arr[j]){
					arr[j]=swap(arr[i], arr[i]=arr[j]);
				}
			}
		}

		for (int numbers : arr)
			System.out.print(numbers+ " ");	
	}
}