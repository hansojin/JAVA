package Wrapper;

public class TypeTest {
	public static void main(String[] args) {
		int num = Integer.parseInt("123");	// 문자열을 정수로
		String str = String.valueOf(123);	// 정수를 문자열로
		
		System.out.println(((Object)num).getClass().getSimpleName());	//Integer
		System.out.println(((Object)str).getClass().getSimpleName());	//String
		
	}
}