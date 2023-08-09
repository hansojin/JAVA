import java.util.Scanner;

class Q1{
	public static void main(String[] args){
		try{
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter n : ");
			int n = sc.nextInt();
			System.out.print("Enter m : ");
			int m = sc.nextInt();
			System.out.println(n/m);
		} catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
	}
}