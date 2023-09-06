package streamTest;

import java.util.stream.IntStream;

public class Q10 {
	public static void main(String[] args) {
		int sum = IntStream.of(1, 3, 5, 7, 9).sum();
		System.out.println(sum);
		
		long cnt = IntStream.of(1, 3, 5, 7, 9).count();
		System.out.println(cnt);
		
		IntStream.of(1, 3, 5, 7, 9).average().ifPresent(System.out::println);
		
		IntStream.of(1, 3, 5, 7, 9).max().ifPresent(System.out::println);
		
		IntStream.of(1, 3, 5, 7, 9).min().ifPresent(System.out::println);


	}
}
