package ystd;

import java.util.Optional;

public class Q14 {
	public static void main(String[] args) {
		Optional<String> str = Optional.of("Optional String");
		str.ifPresent(s->System.out.println(s.toUpperCase()));
		
		Optional<String> str2 = str.map(s->s.replace(" ","_")).map(s->s.toLowerCase());
		System.out.println(str2.get());
	}
}
