package streamTest;

import java.util.Arrays;

public class Q2 {
	public static void main(String[] args) {
		String[] names = {"YOON", "LEE", "PARK"};
		Arrays.stream(names).forEach(n->System.out.println(n));
	}
}
