package langUtilCh9;

class Exercise9_7 {
	public static boolean contains(String str,String target) {
		return str.contains(target);
//		return str.indexOf(target)!=-1;
	}
	
	public static void main(String[] args) {
		System.out.println(contains("12345","23"));
		System.out.println(contains("12345","67"));
	}
}