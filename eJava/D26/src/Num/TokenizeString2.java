package Num;

import java.util.StringTokenizer;

class TokenizeString2{	
	public static void main(String[] args){
		String phoneNum="TEL 82-02-997-2059"; 	
		String javaCode="num+=1";
		
		System.out.println("First Result...........");
		StringTokenizer st1=new StringTokenizer(phoneNum);
		while(st1.hasMoreTokens())
			System.out.println(st1.nextToken());
		
		System.out.println("\nSecond Result...........");
		StringTokenizer st2=new StringTokenizer(phoneNum, " -");
		while(st2.hasMoreTokens())
			System.out.println(st2.nextToken());
		
		System.out.println("\nThird Result...........");
		StringTokenizer st3=new StringTokenizer(javaCode, "+=");
		while(st3.hasMoreTokens())
			System.out.println(st3.nextToken());
		
		System.out.println("\nFourth Result...........");
		StringTokenizer st4=new StringTokenizer(javaCode, "+=", true);
		// 그럼 토큰이 + 이랑 =
		while(st4.hasMoreTokens())
			System.out.println(st4.nextToken());
		
		System.out.println("\nFifth Result...........");
		StringTokenizer st5=new StringTokenizer(javaCode, "+=", false);
		// 구분자를 토큰에 포함하지 않음
		// 사실 default가 false라 이건, st2랑 같은 결과
		while(st5.hasMoreTokens())
			System.out.println(st5.nextToken());
	}
}
