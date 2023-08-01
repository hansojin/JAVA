import java.util.Scanner;

public class CharAtTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();	// Hello
		char ch = str.charAt(0);
		System.out.println(ch);	// H
		System.out.println((int)ch); 	// 72
		sc.close();
	}
}


// charAt() : String으로 저장된 문자열 중에 한 글자(idx)를 선택해서 char 타입으로 반환