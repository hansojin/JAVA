import java.util.Scanner;

class DivideByZero{	
	public static void main(String[] args){
		System.out.print("두 개의  정수 입력: ");
		Scanner sc=new Scanner(System.in);
		int num1=sc.nextInt();
		int num2=sc.nextInt();	
		try{
			System.out.println("나눗셈 결과의 몫: "+(num1/num2));
			System.out.println("나눗셈 결과의 나머지: "+(num1%num2));
		}
		catch(ArithmeticException e){
			System.out.println("나눗셈 불가능");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램을 종료합니다.");
	}
}