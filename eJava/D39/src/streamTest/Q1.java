package streamTest;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q1 {
	public static void main(String[] args) {
		Stream.of(11,22,33,44,55).forEach(System.out::println);
		Stream.of("So simple").forEach(System.out::println);
		Stream.of(Arrays.asList("Toy", "Robot", "Box")).forEach(System.out::println);
	} 
}
