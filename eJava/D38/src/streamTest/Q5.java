package streamTest;

import java.util.Arrays;
import java.util.List;

public class Q5 {
	public static void main(String[] args) {
		int[] arrN = {1, 2, 3, 4, 5};
		List<String> arrS = Arrays.asList("Toy","Robot","Box");

		Arrays.stream(arrN)
			.filter(n->n%2==1)
			.forEach(n->System.out.print(n + " "));
		System.out.println();

		arrS.stream().filter(n->n.length()==3)	
		.forEach(n->System.out.print(n + " "));
	}

}
