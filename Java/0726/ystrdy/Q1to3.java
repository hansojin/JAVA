import java.util.Scanner;

class Q1to3{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);

		// 아스키 코드를 입력받으면 알파벳을 출력
		System.out.print("숫자를 입력하세요 : ");	
		int num = sc.nextInt();
		System.out.println((char)num);

		// 알파벳을 입력하면 아스키 코드를 출력
		System.out.print("문자를 입력하세요 : ");	
		char ch = sc.next().charAt(0);
		System.out.println((int)ch);	

		// 역순 출력
		String str1 = "ABCDEFGHIJKLMN";
		StringBuilder buf1 = new StringBuilder(str1);
		System.out.println(buf1.reverse());

		// 중간 삽입 "-" 삭제
		String str2 = "990208-1012752";
		StringBuilder buf2 = new StringBuilder(str2);
		int idx = buf2.indexOf("-");
		if (idx!=-1)
			System.out.println(buf2.deleteCharAt(idx));
		else
			System.out.println(buf2);
		
		
	}
}