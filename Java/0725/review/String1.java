import java.util.Scanner;

class String1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : " );
		String str1 = sc.nextLine();
		System.out.println(str1.length());

		System.out.print("문자열을 입력하세요 : " );
		String str2 = sc.nextLine();
		System.out.println(str1.concat(str2));
		System.out.println(str1 + str2);

		System.out.print("문자열을 입력하세요 : " );
		String str3 = sc.nextLine();
		System.out.println(str3.toLowerCase());

		System.out.print("문자열을 입력하세요 : " );
		String str4 = sc.nextLine();
		System.out.println(str4.toUpperCase());
	}
}