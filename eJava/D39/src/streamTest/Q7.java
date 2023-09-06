package streamTest;

import java.util.stream.Stream;

public class Q7 {
	public static void main(String[] args) {
		Stream.of("Box", "Apple", "Robot")
			.sorted()
			.forEach(System.out::println);
		
		Stream.of("Box", "Apple", "Robots")
			.sorted((a,b)->a.length()-b.length())
			.forEach(System.out::println);
		
	}
}
