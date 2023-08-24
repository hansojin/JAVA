package lab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q3 {
	static Queue<String> q = new LinkedList<>();
	static final int MAX_SIZE = 5;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String option;
		while(true) {
			System.out.print("Enter command : ");
			option = sc.nextLine();
			if (option.equals("help"))
				System.out.println("What can I do for you?");
			else if (option.equalsIgnoreCase("q")) {
				System.out.println("EXIT");
				sc.close();
				return;
			}
			else if (option.equals("history")) {
				for(String i : q)
					System.out.println(i);
			}
			else {
				if(q.size()<MAX_SIZE) {
					q.offer(option);
				}
				else
					System.out.println("Queue Overflow!");
			}
		}
	}
}
