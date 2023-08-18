package ArraysClass;

import java.util.Arrays;
import java.util.Date;

public class ToStringTest {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		Date date = new Date();
		System.out.println(arr);				//[I@4517d9a3
		System.out.println(date);				//Fri Aug 18 11:48:17 KST 2023
		System.out.println(arr.toString());		//[I@4517d9a3
		System.out.println(date.toString());	//Fri Aug 18 11:48:17 KST 2023
		System.out.println(Arrays.toString(arr));	//[1, 2, 3]
	}
}
