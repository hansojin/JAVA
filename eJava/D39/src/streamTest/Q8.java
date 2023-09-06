package streamTest;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Q8 {
	public static void main(String[] args) {
		IntStream.of(3,9,7,2).sorted().forEach(System.out::println);
		DoubleStream.of(3.3, 6.2, 1.5, 8.3).sorted().forEach(System.out::println);
		
	}
}
