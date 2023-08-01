import java.util.Scanner;

class Switch1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.println("== menu ==");
		System.out.println("1. pizza");
		System.out.println("2. chicken");
		System.out.println("3. hamburger");
		System.out.print("Enter the number : ");
		int menu = sc.nextInt();

		switch(menu){
			case 1:
				System.out.println("You choose 1. pizza");
				break;
			case 2:
				System.out.println("You choose 2. chicken");
				break;

			case 3: 
				System.out.println("You choose 3. hamburger");
				break;
			default:
				System.out.println("You enter the wrong number");
		}

	}
}
