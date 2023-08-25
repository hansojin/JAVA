package collectionsQ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q3 {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5};
		Set<Integer> one = new HashSet<Integer>(Arrays.asList(arr));
		Integer[] arr2 = {4,5,6,7,8};
		Set<Integer> two = new HashSet<Integer>(Arrays.asList(arr2));
		
		
		System.out.print("합집합 >> ");
		one.addAll(two);
		for(int n : one)
			System.out.print(n+" ");
		System.out.println();
		
		System.out.print("교집합 >> ");
		one.retainAll(two);
		for(int n : one)
			System.out.print(n+" ");
		System.out.println();

		System.out.print("차집합 >> ");
		one.removeAll(two);
		for(int n : one)
			System.out.print(n+" ");
	}
}
