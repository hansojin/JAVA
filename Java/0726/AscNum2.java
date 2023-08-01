import java.util.Scanner;
import java.util.Arrays;

class AscNum2{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		final int SIZE = 5;
		int[] arr = new int[SIZE];
		int len = arr.length;

		for(int i=0;i<len;i++){
			System.out.print("Enter number : ");
			arr[i]=sc.nextInt();
		}

		// bubbleSort
		for(int i=len-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if (arr[j]>arr[j+1]){
					int tmp = arr[j];
					arr[j]=arr[j+1];	
					arr[j+1]=tmp;
				}
			}
			
		}


		for (int numbers : arr)
			System.out.print(numbers+ " ");
	
		System.out.println(); 
		System.out.print(Arrays.toString(arr));		//배열 형태로 반환
	}
}