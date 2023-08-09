public class CompTest{

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = "abc";
		
		System.out.println(str1.equals(str2));			// F
		System.out.println(str1.equalsIgnoreCase(str2));		// T
		
		System.out.println(str1.compareTo(str2));		// -
		System.out.println(str1.compareToIgnoreCase(str2));	// 0
	}
}