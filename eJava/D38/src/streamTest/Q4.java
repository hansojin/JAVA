package streamTest;

import java.util.Arrays;
import java.util.List;

public class Q4 {
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("Toy","Robot","Box");
		
		arr.stream().forEach(n->System.out.println(n));
		
	}
}
