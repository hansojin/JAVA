class StringMethod{
	public static void main(String[] args){
		String str1="Smart";
		String str2=" and ";
		String str3="Simple";
		String str4=str1.concat(str2).concat(str3);
		
		System.out.println(str4);			// Smart and Simple
		System.out.println("문자열 길이: "+str4.length());	//16

		if(str1.compareTo(str3)<0)			
			System.out.println("str1이 앞선다");
		else
			System.out.println("str3이 앞선다");


		System.out.println(System.identityHashCode(str1));	//1000
		System.out.println(System.identityHashCode(str4));	//2000

		// AS string is immutable, 
		// str1.concat 이 되었더라도, str1문자열이 변경되는게 아니라
		// 새로운 문자열이 생성되는 거
	}
}