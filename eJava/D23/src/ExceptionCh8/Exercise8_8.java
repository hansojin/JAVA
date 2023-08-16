package ExceptionCh8;

import java.util.Scanner;

class Exercise8_8{
	public static void main(String[] args){
		
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0; 
		int count = 0; 
		do {
			count++;
			System.out.print("Enter between 1-100 :"); 
			try {
				input = new Scanner(System.in).nextInt();
			} catch (Exception e) {
				System.out.println("Enter integer.");
				continue;
			}
			
			if(answer > input) {
				System.out.println("Enter bigger number."); 
			} else if(answer < input) {
				System.out.println("Enter smaller number."); 
			} else {
				System.out.println("GOTCHA");
				System.out.println("Your try :  "+count); 
				break; 
			}
		} while(true);
	} 
} 