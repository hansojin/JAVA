import java.util.Scanner;

class String2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("문자나 숫자를 입력해주세요 : ");
		String str = sc.nextLine();

		// 숫자 to ASCII
		if( Character.isDigit(str.charAt(0))){
			System.out.println((char)(Integer.parseInt(str)));
		}

		// 문자 to 숫자
		else{
			System.out.println((int)(str.charAt(0)));
		}
	}
}