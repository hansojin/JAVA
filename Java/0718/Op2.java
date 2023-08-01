import java.util.Scanner;

class Op2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number : ");
		int num = sc.nextInt();

		int abs = (num>=0) ? num : num*(-1);
		//int abs = (num>=0) ? num : -num;
		System.out.print("abs(num) : " + abs);
	}
}
