class ImmutableString{
	public static void main(String[] args){
		String str1="My String";
		String str2="My String";	// 같은 문자열 객체가 있다면, 
					// 객체를 새로 생성하지 않고, 
					// 이미 있는 객체를 가리킴 
					// (= 동일한 주소값을 갖게 됌)	
		String str3="Your String";
		

		if(str1==str2)
			System.out.println("동일 인스턴스 참조");
		else
			System.out.println("다른 인스턴스 참조");		
		

		if(str2==str3)
			System.out.println("동일 인스턴스 참조");
		else
			System.out.println("다른 인스턴스 참조");	



		// 객체 주소값 확인
		System.out.println(System.identityHashCode(str1));	//1000
		System.out.println(System.identityHashCode(str2));	//1000
		System.out.println(System.identityHashCode(str3));	//2000	
		
	}
}