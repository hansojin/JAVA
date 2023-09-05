package optionalTest;

import java.util.Optional;

// Optional 클래스를 이용해 "Toy1"과 "Toy2"를 각각 저장하고 
// 그것을 람다식과 메소드 참조로 각각 출력해 보자.

public class Q13 {
	public static void main(String[] args) {
		Optional<String> o1 = Optional.of("toy");
		Optional<String> o2 = Optional.of("boy");
		Optional<String> o3 = Optional.of("hoy");

		
		if (o1.isPresent())
			System.out.println(o1.get());
		
		o2.ifPresent(s->System.out.println(o2.get()));
		
		o3.ifPresent(System.out::println);
	
	}
}
