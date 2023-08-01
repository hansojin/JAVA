import java.util.Scanner;

class LangString{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	
		System.out.print("문자열을 입력하시오 : ");
		String str1 = sc.nextLine();
		System.out.println("length of str1 : " + str1.length());

		System.out.print("문자열을 입력하시오 : ");
		String str2 = sc.nextLine();
		System.out.print("문자열을 입력하시오 : ");
		String str3 = sc.nextLine();
		System.out.println(str2.concat(str3));

		System.out.print("소문자로 바꿀 문자열을 입력하시오 : ");
		String str4 = sc.nextLine();
		System.out.println(str4.toLowerCase());

		System.out.print("대문자로 바꿀 문자열을 입력하시오 : ");
		String str5 = sc.nextLine();
		System.out.println(str5.toUpperCase());

	}	
}

