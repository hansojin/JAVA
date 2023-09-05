package streamTest;

import java.util.Arrays;

public class Q3 {
	public static void main(String[] args) {
		double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};
		
		Arrays.stream(ds,1,4).forEach(n->System.out.println(n));
	}
}
