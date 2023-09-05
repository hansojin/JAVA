package streamTest;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Q12 {
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("Box", "Simple", "Complex", "Robot");
		
		BinaryOperator<String> lc = (s1,s2)->s1.length()>s2.length()?s1:s2;
		
		String str = arr.stream().reduce("",lc);
		System.out.println(str);

	}
}
