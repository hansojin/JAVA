package ystd;

import java.util.Arrays;

public class Q4 {
	public static String fillZero(String src, int length) {
		int slen = src.length();
		if (src==null || slen==length)
			return src;
		else if (length<=0)
			return "";
		else if (slen>length)
			return src.substring(0,length);
		
		char[] arr = new char[length];
		Arrays.fill(arr, '0');
		System.arraycopy(src.toCharArray(),0, arr, length-slen,slen);
		return String.valueOf(arr);
	}
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fillZero(src,10));
		System.out.println(fillZero(src,-1));
		System.out.println(fillZero(src,3));
	}
}
