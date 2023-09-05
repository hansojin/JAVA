package optionalTest;

import java.util.Optional;

public class Q15 {
	public static void main(String[] args) {
		Optional<String> s1 = Optional.of(new String("So Basic"));
		Optional<String> s2 = Optional.empty();

		String ret = s1.orElse("Empty");
		System.out.println(ret);
		String ret2 = s2.map(s->s.toString()).orElse("Empty");
		System.out.println(ret2);

		
		
	}
}
