package ystd;

public class Q2 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		int tokenizer = fullPath.lastIndexOf("\\");
		
		System.out.println(fullPath);
		System.out.println(fullPath.substring(0,tokenizer));
		System.out.println(fullPath.substring(tokenizer+1,fullPath.length()));
	}
}
