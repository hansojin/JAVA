class NullTest{
	public static void main(String[] args){

		String[][] str = new String[2][];

		// str[0][0] = "kim";    		// ERROR

		/*
		Exception in thread "main" java.lang.NullPointerException: 
		Cannot store to object array because "<local1>[0]" is null

		str에는 null; null; 이 담겨있는데, 
		그걸 접근하려고 하니까 nullPtrException 발생
		*/

		str[0] = new String[3];		// 담을 공간을 만들어줘야해
		str[0][0] = "kim";
		
	}
}