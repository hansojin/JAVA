class PrintfTest{
	public static void main(String[] args){
		int num = 5;
		System.out.printf("%d\n", num);
		System.out.printf("%5d\n", num);
		System.out.printf("%10d\n", num);
		System.out.printf("%05d\n", num);
		System.out.printf("%010d\n", num);

		String name = "Jane";
		System.out.printf("%10d%10s\n", num, name);
		System.out.printf("%10d%-10s\n", num, name);

		// width +  argument_index 옵션
		System.out.println(String.format("%2$10s%1$10s", "KOREA", "JAPAN"));
     		/*
		     JAPAN     KOREA
		N$는 N번째 문자열을 의미
		*/

		// flags 옵션
		System.out.println(String.format("%-10s%-10s", "KOREA", "JAPAN"));
		System.out.println(String.format("%10s%10s", "KOREA", "JAPAN"));
		/*
		KOREA     JAPAN 
		     KOREA     JAPAN
		[flags]는 [argument_index]와 [width]사이에 위치
		'-' flag를 사용하면 출력되는 문자열이 왼쪽으로 정렬 
		'-' flag를 빼면 오른쪽으로 정렬
		*/
		
	}
}