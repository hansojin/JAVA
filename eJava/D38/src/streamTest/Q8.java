package streamTest;

import java.util.Arrays;
import java.util.List;

class Eight<T>{
	private T ob;
	public Eight(T o) { ob = o; }
	public T get() { return ob; }
}
public class Q8 {
	public static void main(String[] args) {
		List<Eight<String>> ls = Arrays.asList(new Eight<>("Robot"), new Eight<>("Simple"));
		ls.stream().map(n->n.get().length()).forEach(System.out::println);
	}

}



