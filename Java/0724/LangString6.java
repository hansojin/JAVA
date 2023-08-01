public class LangString6{
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(10));	// 1010 (반환형_String)
		System.out.println(Integer.toBinaryString(5));	// 101
		
		String str = "0123456789";
		System.out.println(str.substring(3));		// 3456789
		System.out.println(str.substring(5));		// 56789
		System.out.println(str.substring(3,5));		// 34
	}
}

