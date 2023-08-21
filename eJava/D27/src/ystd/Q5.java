package ystd;

public class Q5 {
	public static boolean contains(String src, String key) {
		return src.contains(key);
	}
	public static void main(String[] args) {
		System.out.println(contains("12345","23"));
		System.out.println(contains("12345","67"));
	}
}
