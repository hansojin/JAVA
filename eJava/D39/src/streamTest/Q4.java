package streamTest;

import java.util.stream.Stream;

public class Q4 {
	public static void main(String[] args) {
		Stream<String> one = Stream.of("Cake", "Milk");
		Stream<String> two = Stream.of("Lemon", "Jelly");
		
		Stream.concat(one, two).forEach(System.out::println);
	}
}
