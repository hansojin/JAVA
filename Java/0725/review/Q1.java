import java.util.Scanner;

class Q1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : " );
		char ch = sc.next().charAt(0);
		if (ch>='A' && ch<='Z'){
			System.out.println("char는 대문자");
		}
		else if (ch>='a' && ch<='z'){
			System.out.println("char는 소문자");
		}
		else if (ch>='0' && ch<='9'){
			System.out.println("char는 숫자");
		}
		else
			System.out.println("char는 영숫자가 아님");
		
	}
}