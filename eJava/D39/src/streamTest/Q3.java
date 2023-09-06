package streamTest;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Q3 {
	public static void main(String[] args) {
		Stream<String> st = Stream.of("Box", "Simple", "Complex", "Robot");
		
		BinaryOperator<String> op = (a,b)-> a.length()>b.length()?a:b;
		
		String str = st.parallel().reduce("",op);
		System.out.println(str);
	}
}
