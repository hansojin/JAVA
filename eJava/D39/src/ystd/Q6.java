package ystd;

import java.util.Arrays;
import java.util.List;

public class Q6 {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Toy", "Robot", "Simple");
		ls.stream().map(n->n.length()).forEach(System.out::println);
	}
}
