import java.util.Scanner;

class ValueMain{
	
	public static int minValue(int[] arr){

		int min=Integer.MAX_VALUE;
		/*
		for (int i=0;i<arr.length;i++){
			if (min>arr[i])
				min=arr[i];
		}
		*/
		for (int i : arr){
			if (min>i)
				min=i;
		}
			
		return min;
	}
	public static int maxValue(int[] arr){

		int max=Integer.MIN_VALUE;
		/*
		for (int i=0;i<arr.length;i++){
			if (max<arr[i])
				max=arr[i];
		}
		*/
		for (int i : arr){
			if (max<i)
				max=i;
		}
		return max;

	}	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int size =sc.nextInt();
		int[] arr = new int[size];
		for (int i=0;i<arr.length;i++){
			System.out.print("Enter number: ");
			arr[i]=sc.nextInt();
		}
		System.out.println("MAX : " + maxValue(arr));
		System.out.println("MIN : " + minValue(arr));
	}
}