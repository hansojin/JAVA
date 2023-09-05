package streamTest;

import java.util.Arrays;
import java.util.List;

class Nine<T>{
	private T ob;
	public Nine(T o) { ob = o; }
	public T get() { return ob; }
}
public class Q9 {
	public static void main(String[] args) {
		List<Nine<String>> ls = Arrays.asList(new Nine<>("Robot"), new Nine<>("Simple"));
		ls.stream().mapToInt(n->n.get().length()).forEach(System.out::println);
	}

}
