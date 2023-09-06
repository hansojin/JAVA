package ystd;

import java.util.Optional;

public class Q15 {
	public static void main(String[] args) {
		Optional<String> one = Optional.ofNullable(null);
		Optional<String> two = Optional.of("BASIC");
		
		String ret = one.orElse("empty");
		String ret2 = two.orElse("empty");
		System.out.println(ret +"\t" + ret2);
		
	}
}
