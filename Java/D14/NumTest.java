public class NumTest {

	public static void main(String[] args) {
		int num = 10;
		String numStr = "20";

		int tmpInt = Integer.parseInt(numStr);		// 문자열을 int로
		String tmpStr = String.valueOf(num);		// int를 문자열로

		System.out.println(Math.floor(3.7));		// 내림 3.0
		System.out.println(Math.ceil(3.1));		// 올림 4.0
		System.out.println(Math.round(3.1));		// 반올림 3
		System.out.println(Math.round(3.7));		// 반올림 4


		String strNum="123";
		// System.out.println(strNum[0]);		// String은 배열 접근 불가
		char[] chs = strNum.toCharArray();
		System.out.println(chs[0]);			// 문자열을 char Array로
		
		for(String str: args)
			System.out.println(str);		
		
	}
}