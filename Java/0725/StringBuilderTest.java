public class StringBuilderTest {
	public static void main(String[] args) {
		String javaStr = new String("Java");
		// 인스턴스가 처음 생성되었을 때 메모리 주소
		System.out.println("JavaStr 문자열 주소 : " 
        				+ System.identityHashCode(javaStr));	//1000
		
		// String으로 부터 StringBuilder 생성
		StringBuilder buffer = new StringBuilder(javaStr); 
		System.out.println("연산 전 buffer 메모리 주소 : " 
        				+ System.identityHashCode(buffer));	//2000
		
		// 문자열 추가
		buffer.append(" and");
		buffer.append(" Android");
		buffer.append(" programming is fun!!");
		System.out.println("연산 후 buffer 메모리 주소 : " 
        				+ System.identityHashCode(buffer));	//2000
		
		// String 클래스로 반환
		javaStr = buffer.toString(); 
		System.out.println(javaStr);
		System.out.println("연결된 JavaStr 메모리 주소 : " 
        				+ System.identityHashCode(javaStr));	//3000

		/*

		문자열을 변경하거나 연결할때, String 클래스를 사용하면,
		내부 문자열이 변경되지 않기 때문에, 프로그램을 변경할때마다 메모리가 낭비 된다.

		-> StringBuffer와 StringBuilder 사용

		 : char[] 배열이 확장되므로 추가 메모리를 사용하지 않음 + 실행 속도 빠름


	
		*/
	}
}