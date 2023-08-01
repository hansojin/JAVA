import java.util.Scanner;

class RandomGame{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] game = {"rock", "scissor", "paper"};
		System.out.print("Enter 0 for rock, 1 for scissor, and 2 for paper : ");
		int user = sc.nextInt();
		int computer = (int)(Math.random()*3);

		System.out.println("You choose " + game[user]);
		System.out.println("Computer choose " + game[computer]);
				
		int play = user - computer;

		switch(play){
			case 2: case -1:
				System.out.println("You win");
				break;

			case 1: case -2:
				System.out.println("You lose");
				break;

			case 0:
				System.out.println("Tie");
		}
	}
}