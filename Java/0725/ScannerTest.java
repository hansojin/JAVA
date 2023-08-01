public class ScannerTest{
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);

		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		System.out.println(num);
		System.out.print("문자열 입력 : ");

		sc.nextLine();	
		// if 이게 주석처리되면, 아래 str에 버퍼에 남아 있는 enter가 들어감	

		String str = sc.nextLine();
		System.out.println(num + " " + str);
	}
}