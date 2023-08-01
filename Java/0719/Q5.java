import java.util.Scanner;

class Q5{

	public static int fib(int n){
		if (n==1 || n==2)
			return 1;
		else{
			return fib(n-1) + fib(n-2);
		}
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int num = sc.nextInt();
		System.out.println(fib(num));
	}
}
