package optionalTest;

import java.util.Optional;

public class Q14 {
	public static void main(String[] args) {
		Optional<String> str = Optional.of(new String("Optional String"));
		
		Optional<String> str2 = str.map(s->s.toUpperCase());
		System.out.println(str2.get());
		
		Optional<String> str3 = str.map(s->s.replace(" ", "_")).map(s->s.toLowerCase());
		System.out.println(str3.get());
	}
}
