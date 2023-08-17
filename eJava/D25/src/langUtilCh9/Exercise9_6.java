package langUtilCh9;

import java.util.Arrays;

class Exercise9_6 {
	public static String fillZero(String src, int length) {
		if (src==null || src.length()==length)
			return src;
		else if (length<=0)
			return "";
		else if (src.length()>length)
			return src.substring(0,length);
		
		char[] zero = new char[length];
		Arrays.fill(zero, '0');
		
		char[] srcArr = src.toCharArray();
		int srcLen = src.length();
		System.arraycopy(srcArr, 0, zero, length-srcLen,srcLen);	
//		System.arraycopy(src.toCharArray(), 0, zero, length-srcLen,srcLen);	
		return String.valueOf(zero);
//		return new String(zero);
		
	}
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}