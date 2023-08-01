import java.util.Random;
import java.util.Scanner;

class RandomPlay{
	public static void main(String[] args){
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		int num = rand.nextInt(100)+1;		// 1-100

		while(true){
			System.out.println("enter number : ");
			int tmp= sc.nextInt();
			cnt++;
			if (tmp>num)
				System.out.println("The number is smaller than " + tmp);
			else if(tmp<num)
				System.out.println("The number is bigger than " + tmp);			
			else{
				System.out.println("You got the number in "+cnt+" tries");
				break;
			}
		
		}	
		
	}
}
