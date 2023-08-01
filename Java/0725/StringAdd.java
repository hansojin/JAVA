class StringAdd{
	public static void main(String[] args){
		String str1="Lemon"+"ade";
		String str2="Lemon"+'A';
		String str3="Lemon"+3;
		String str4=1+"Lemon"+2;
		str4+='!';
		
		System.out.println(str1);	//Lemonade	
		System.out.println(str2);	//LemonA
		System.out.println(str3);	//Lemon3
		System.out.println(str4);	//1Lemon2!
		

		// String.valuleOf(char) => "char를 String으로 변환"
		// 변수명.getClass().getName() => 클래스 정보 가져오기( 자료형 타입 )

 		char ch = 'A';
		System.out.println(String.valueOf(ch));
		System.out.println(String.valueOf(ch).getClass().getName()); //java.lang.String

	}
}


/*

str4는 내부적으로 
new StringBuilder().append(1).append("Lemon").append(2).toString();
해당 코드 처럼 작동함
얘는 아무리 많이 append해도, 2개의 객체만 생성됨
StringBuilder 하나랑, 맨 마지막에 문자열로 반환시키는 String 객체

*/