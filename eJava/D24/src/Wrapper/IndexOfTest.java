package Wrapper;

public class IndexOfTest {

	public static void main(String[] args) {
		String str = "ABCDEABCDEABCDE";
		int pos;
		
		pos = str.indexOf("AB");	// 0
		// "ABCDEABCDEABCDE"로 부터 "AB"문자열을 검색하여 처음으로 나오는 "AB"문자열의 시작위치를, 못찾으면 -1 반환
		System.out.println(pos);

		pos = str.indexOf("AB", 2);		// int fromIndex
		System.out.println(pos);		// 5

		pos = str.indexOf("AB", 7);		// 10
		System.out.println(pos);

		System.out.println("===============================");

		pos = str.lastIndexOf("AB");	// 10
		System.out.println(pos);

		pos = str.lastIndexOf("AB", 15);	// 10
		System.out.println(pos);

		pos = str.lastIndexOf("AB", 9);	// 5
		System.out.println(pos);

		pos = str.lastIndexOf("AB", 4);	// 0
		System.out.println(pos);
	}
}