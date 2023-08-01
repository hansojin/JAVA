import java.util.Scanner;

class Q2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : " );
		char ch = sc.next().charAt(0);
		int diff='a'-'A';
		if (ch>='A' && ch<='Z'){
			System.out.println((char)(ch+diff));
		}
		else if (ch>='a' && ch<='z'){
			System.out.println((char)(ch-diff));
		}
		
	}
}