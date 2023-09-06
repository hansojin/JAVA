package streamTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q13 {
	public static void main(String[] args) {
		List<String> lis = Stream.of("Hello", "Box", "Robot", "Toy")
				.filter(n->n.length()<5)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(lis);	//[Box, Toy]

		lis = Stream.of("Hello", "Box", "Robot", "Toy")
				.filter(n->n.length()<5)
				.collect(Collectors.toList());
		System.out.println(lis);	//[Box, Toy]

		Stream.of("Hello", "Box", "Robot", "Toy")
			.filter(n->n.length()<5)
			.collect(Collectors.toList())
			.forEach(System.out::println);	//Box Toy
	}
}
