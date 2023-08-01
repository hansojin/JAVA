import java.util.Scanner;

class String1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// 알파벳을 아스키 코드로
		System.out.print("알파벳을 입력해주세요 : ");
		char alpha = sc.nextLine().charAt(0);			
		System.out.println((int)alpha);	
		
		// 아스키 코드를 알파벳으로
		System.out.print("숫자를 입력해주세요 : ");
		int num = sc.nextInt();
		System.out.println((char)num);	
	}
}