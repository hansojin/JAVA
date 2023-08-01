import java.util.Scanner;

class LangString2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
	
		System.out.print("문자열을 입력하시오 : ");
		String str1 = sc.nextLine();
		System.out.print("문자열을 입력하시오 : ");
		String str2 = sc.nextLine();
		
		int num=str1.compareTo(str2);
		if (num>0){
			System.out.println(str1 + " " + str2);
		}
		else{
			System.out.println(str2 + " " + str1);
		}

	}	
}

// compareTo 연산은, 처음으로 틀린 구간부터 문자열 연산을 함
// A 65 B 66 C 67 D 68 E 69
// a 97 b 98 c 99 d 100 e 101
// 0 48 1 49 2 50