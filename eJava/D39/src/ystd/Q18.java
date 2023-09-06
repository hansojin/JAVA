package ystd;

import java.util.Optional;

public class Q18 {
	public static void main(String[] args) {
		Optional<String> str = Optional.of("Optional String");
		
		Optional<String> lc = str.map(s->s.toLowerCase());
		System.out.println(lc.get());
		
		Optional<String> flc = str.flatMap(s->Optional.of(s.toLowerCase()));
		System.out.println(flc.get());
	}
}
