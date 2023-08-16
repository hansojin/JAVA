package Wrapper;

public class SubStringTest {

	public static void main(String[] args) {
		String str = "0123456789";

		System.out.println(str.substring(0));	// 0123456789
		System.out.println(str.substring(3));	// 3456789
		System.out.println(str.substring(5));	// 56789

		System.out.println();

		System.out.println(str.substring(0, 5));	// 01234
		System.out.println(str.substring(3, 7));	// 3456
		System.out.println(str.substring(5, 9));	// 5678

		System.out.println();

		str = "Good morning";

		System.out.println(str.substring(0));	// Good morning
		System.out.println(str.substring(3));	// d morning
		System.out.println(str.substring(5));	// morning

		System.out.println();

		System.out.println(str.substring(0, 5));	// Good 
		System.out.println(str.substring(3, 7));	// d mo
		System.out.println(str.substring(5, 9));	// morn

		System.out.println();

		str = "012\\345\\678";
		System.out.println(str.substring(0,4));		// 012\
		System.out.println(str.substring(0,5));		// 012\3
		// \는 두개가 하나니까 (0,5)에서 012\3 출력

		System.out.println();

		str = "c:\\jdk1.8\\work\\PathSeparateTest.java";	// c:\jdk1.8\work\PathSeparateTest.java
		System.out.println(str);

	}
}
