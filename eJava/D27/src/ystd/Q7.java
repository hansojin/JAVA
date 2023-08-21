package ystd;

public class Q7 {
	public static String delChar(String src, String key) {
		char[] keyList = key.toCharArray();
		for(int i=0;i<keyList.length;i++) {
			src=src.replace(Character.toString(keyList[i]),"");
		}
		return src;
	}
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)"+" -> "
				+ delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)"+" -> "
				+ delChar("(1 2 3 4\t5)"," \t"));
	}
}
