package ystd;

import java.util.Arrays;
import java.util.List;

public class Q4 {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Toy", "Robot", "Box");
		ls.stream().forEach(System.out::println);
	}

}
