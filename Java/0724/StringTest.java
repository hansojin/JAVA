import java.util.Scanner;

class StringTest{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// Window에서 입력받은 한글 깨질때 : 
		// Scanner sc = new Scanner(System.in, "EUC-KR");  
		
		String str = null;
		String str2 = null;

		System.out.println("문자열을 입력하세요.");
		str = sc.nextLine();				
		// enter 치기 전 모든 문자열 return
		System.out.println("nextLine 입력받은 문자열은 " + str);
		int num1 = str.length();
		System.out.println("str의 문자열의 길이는 " + num1);	

		System.out.println("문자열을 입력하세요.");
		str2 = sc.next();				
		// space나 enter 전, 즉 공백 전까지의 문자열만 return
		System.out.println("next 입력받은 문자열은 " + str2);
		int num2 = str2.length();
		System.out.println("str2의 문자열의 길이는 " + num2);		

		sc.close(); 		// resource 해제해주기 ! 
	}
}

