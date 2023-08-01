class StringCopy{
	public static void main(String[] args){
		String str1="Lemon";
		String str2="Lemon";
		String str3=new String(str2);
		
		if(str1==str2)
			System.out.println("str1과 str2는 동일 인스턴스 참조");
		else
			System.out.println("str1과 str2는 다른  인스턴스 참조");			
		
		if(str2==str3)
			System.out.println("str2와 str3는 동일 인스턴스 참조");
		else
			System.out.println("str2와 str3는 다른  인스턴스 참조");	
		

		// 객체 주소값 확인
		System.out.println(System.identityHashCode(str1));	//1000
		System.out.println(System.identityHashCode(str2));	//1000
		System.out.println(System.identityHashCode(str3));	//2000
	}
}