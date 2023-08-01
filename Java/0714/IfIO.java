import java.util.Scanner;

class IfIO{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a : ");
		int a = sc.nextInt();
		System.out.println("enter b : ");
		int b = sc.nextInt();
		if (a>b)
			System.out.println(a + " is bigger");
		else if (a<b)
			System.out.println(b + " is bigger");
		else
			System.out.println("equal");

			


	}
}
