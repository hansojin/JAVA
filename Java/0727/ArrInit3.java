import java.util.Arrays;
import java.util.stream.IntStream;

class ArrInit3{
	public static void main(String[] args){
		
		int[] arr = new int[10];
		Arrays.fill(arr, 10);		// arr 전체 10으로 초기화

		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
		
		int[] arr2 = new int[10];
		System.out.println(Arrays.toString(arr2));
  		Arrays.setAll(arr2, num -> num+1);		// for문을 순회하면서 배열의 요소 값을 순차적(1 ~ 10)으로 채움
  		System.out.println(Arrays.toString(arr2));	// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		
		int[] arr3 = new int[10];
		System.out.println(Arrays.toString(arr2));
  		Arrays.setAll(arr2, num -> num*2);
  		System.out.println(Arrays.toString(arr2));	// [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]

		int arr4[] = IntStream.range(10,16).toArray();
  		System.out.println(Arrays.toString(arr4));	// [10, 11, 12, 13, 14, 15]

		IntStream.range(0, 10).forEach(System.out::print);		//0123456789
		IntStream.range(0, 10).forEach(e -> System.out.print(e+" "));	//0 1 2 3 4 5 6 7 8 9	
	}
}