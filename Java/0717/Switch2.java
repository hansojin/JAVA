import java.util.Scanner;

class Switch2{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("== menu ==");
		System.out.println("1. pizza");
		System.out.println("2. chicken");
		System.out.println("3. hamburger");
		System.out.print("Enter the number : ");
		int menu = sc.nextInt();

		if (menu==1)
			System.out.println("You choose 1. pizza");
		else if(menu==2)	
			System.out.println("You choose 2. chicken");
		else if(menu==3)
			System.out.println("You choose 3. hamburger");
		else
			System.out.println("You enter the wrong number");
		

	}
}

