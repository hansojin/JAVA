package ystd;

import java.util.Arrays;
import java.util.List;

public class Q5 {
	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5};
		List<String> ls = Arrays.asList("Toy", "Robot", "Box");
		
		Arrays.stream(ar).filter(n->n%2==1).forEach(n->System.out.print(n+ "\t"));
		System.out.println();
		ls.stream().filter(n->n.length()==3).forEach(System.out::println);
	}
}
