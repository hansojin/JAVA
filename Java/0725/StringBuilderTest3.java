public class StringBuilderTest3 {
	public static void main(String[] args) {
		
		// 역순 출력 _ reverse(String)

		String str1 = "ABCDEFGHIJKLMN";
		StringBuilder buffer1 = new StringBuilder(str1); 
		System.out.println(buffer1.reverse());
		
		// 삭제  _ deleteCharAt(int idx)
		// 해당 문자 idx 찾기 + indexOf(char)

		String str2 = "990208-1012752";
		StringBuilder buffer2 = new StringBuilder(str2); 
		int idx = str2.indexOf("-");
		if(idx!=-1)
			System.out.println(buffer2.deleteCharAt(idx));
		else
			System.out.println(buffer2);
		
		
	}
}