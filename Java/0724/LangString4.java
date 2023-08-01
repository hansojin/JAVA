import java.util.Scanner;

class LangString4{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);	
		
		char ch = sc.next().charAt(0);

		if (ch>=65 && ch<=90){
		// if(ch >= 'A' && ch <= 'Z'){ 		// 도 가능
			System.out.println(ch+"는 대문자");
		}
		else if (ch>=97 && ch<=122){
			System.out.println(ch+"는 소문자");
		}
		else if (ch>=48 && ch<=57){
			System.out.println(ch+"는 숫자");
		}	
		else{
			System.out.println(ch+"는 영숫자가 아님");
		}
	}
}