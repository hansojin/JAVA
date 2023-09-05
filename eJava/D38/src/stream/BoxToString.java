package stream;

import java.util.Arrays;
import java.util.List;

class Box<T>{
	private T ob;
	public Box(T o) { ob = o; }
	public T get() { return ob; }
}

public class BoxToString {
	public static void main(String[] args) {
		List<Box<String>> ls = Arrays.asList(new Box<>("Robot"), new Box<>("Simple"));

		ls.stream().forEach(s->System.out.println(s.get()));
		ls.stream()
			.map(b->b.get())
			.forEach(s->System.out.println(s));

		ls.stream().forEach(s->System.out.println(s.get().length()));
		ls.stream()
			.map(b->b.get().length())
			.forEach(i->System.out.println(i));
	}
}
