public class DivTest {
	public static void main(String[] args) {
		//System.out.println(3/0);		// ArithmeticException_ div by zero
		System.out.println(3/0.0);		// Infinity (as 0.000000...00001)은 3.e+무한
		System.out.println(3%0.0);		// NaN _ A를 B로 몇번 뺄수 있는지를 인식
						// 몫은 무한대, 나머지는 없음
		System.out.println(3/(3/0.0)); 	// 0.0
		System.out.println(3%(3/0.0)); 	// 3.0
		System.out.println(0.0/0.0);		// NaN 
		System.out.println(0.0%0.0);		// NaN 
		System.out.println( (3/0.0)/3 );	// Infinity
		System.out.println( (3/0.0)%3 );	// NaN
		System.out.println( (3/0.0)/(3/0.0) );	// NaN
		System.out.println( (3/0.0)%(3/0.0) );	// NaN
	}
}

// NaN : Not a Number
// Infinity : 무한대