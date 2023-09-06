package ystd;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Q12 {
	public static void main(String[] args) {
		List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");
		
		BinaryOperator<String> lc = (s,t) -> s.length()>t.length() ? s : t ;
		
//		String longestWord = ls.stream().reduce("",lc);
		String longestWord = ls.parallelStream().reduce("",lc);
		System.out.println(longestWord);
	}
}
