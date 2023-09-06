package ystd;

import java.util.Optional;

public class Q13 {
	public static void main(String[] args) {
		Optional<String> one = Optional.of("Toy");
		if (one.isPresent())
			System.out.println(one.get());
		
		Optional<String> two = Optional.of("Boy");
		two.ifPresent(s->System.out.println(s));
		
		Optional<String> three = Optional.of("hoy");
		three.ifPresent(System.out::println);
	}
}
