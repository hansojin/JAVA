import java.util.Scanner;
import java.util.Random;

class RandomNum{
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter start number: ");
		int srt = sc.nextInt();
		System.out.print("Enter end number : ");
		int end = sc.nextInt();
		int diff = end-srt;
		
		//Math.random() 
		for(int i=0;i<10;i++){
			System.out.print((int)(Math.random()*(diff+1))+srt + " ");
		}
		
		// import Random()
		Random rand = new Random();
		for(int i=0;i<10;i++){
			System.out.print(rand.nextInt(diff+1)+srt+ " ");
		}
		
	}
}