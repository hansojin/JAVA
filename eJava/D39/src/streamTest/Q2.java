package streamTest;

import java.util.stream.IntStream;

public class Q2 {
	public static void main(String[] args) {
		IntStream.of(7,5,3).forEach(System.out::println);
		
		IntStream is = IntStream.range(5, 8);
		is.forEach(System.out::println);
		
		IntStream iss = IntStream.rangeClosed(5, 8);
		iss.forEach(System.out::println);
	}
}
