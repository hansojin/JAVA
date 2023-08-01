// 영문자하나를 입력받아, 소문자는 대문자로, 대문자는 소문자로 출력

import java.util.Scanner;

class LangString5{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("문자를 입력하시오 : ");
		char ch = sc.next().charAt(0);

		if (ch>=65 && ch<=90){
			System.out.println((char)(ch+32));
		}
		else if (ch>=97 && ch<=122){
			System.out.println((char)(ch-32));
		}

		// 아니면, int diff = 'a' - 'A'; 를 이용해서
		// (char)(ch+- diff) 으로도 가능
	
	}
}