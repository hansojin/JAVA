package optionalTest;

import java.util.Optional;

public class Q18 {
	public static void main(String[] args) {
		Optional<String> opt = Optional.of(new String("Optional String"));
		Optional<String> lc = opt.map(s->s.toLowerCase());
		System.out.println(lc.get());
		
		Optional<String> flc = opt.flatMap(s->Optional.of(s.toLowerCase()));
		System.out.println(flc.get());

	}
}
