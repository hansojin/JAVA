package langUtilCh9;

import java.util.Arrays;

class Exercise9_10{
	public static String format(String str, int length,int alignment) {
		if (length<str.length())
			return str.substring(0,length);

//		1.
		char[] strArr = str.toCharArray();
		char[] alpha = new char[length];
		Arrays.fill(alpha, ' ');
		switch(alignment) {
		case 0: 
			System.arraycopy(strArr, 0, alpha, 0, str.length());
			break;
		case 1:
			System.arraycopy(strArr, 0, alpha, (length-str.length())/2, str.length());
			break;
		case 2:
			System.arraycopy(strArr, 0, alpha, length-str.length(), str.length());
			break;
		}
		return String.valueOf(alpha);

		
//		2.
//		int start = 0;
//		if(alignment == 0) start = 0;
//		else if(alignment == 1) start = (length - str.length())/2;
//		else start = length - str.length();
//		System.arraycopy(str.toCharArray(), 0, alpha, start, str.length());
//		return new String(alpha);
		
		
	}
	public static void main(String[] args) {
		String str = "가나다"; 
		System.out.println(format(str,7,0)); // 왼쪽 정렬
		System.out.println(format(str,7,1)); // 가운데 정렬
		System.out.println(format(str,7,2)); // 오른쪽 정렬
	}
}