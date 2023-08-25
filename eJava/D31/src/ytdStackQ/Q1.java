package ytdStackQ;

import java.util.Scanner;
import java.util.Stack;

class Q1 {
	public static void printStack(Stack<String> one, Stack<String> two) {
		System.out.print("  back  >> ");
		for(String i : one)
			System.out.print(i+" ");
		System.out.println();
		System.out.print("forward >> ");
		for(String i : two)
			System.out.print(i+" ");
		if (!one.empty())
			System.out.println("\nYou are in page >> "+one.peek());
		else
			System.out.println("\nNo more page to move..");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stackOne = new Stack<>();
		Stack<String> stackTwo = new Stack<>();
		stackOne.push("1.Naver");
		stackOne.push("2.Kakao");
		stackOne.push("3.Line");
		stackOne.push("4.Cupang");
		printStack(stackOne,stackTwo);
		
		while (true) {
			System.out.print("Enter 1 for backward, 2 for forward and 0 for quit : ");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				if (stackOne.empty()) {
					System.out.println("Stack is empty");
					break;
				}
				stackTwo.push(stackOne.pop());
				printStack(stackOne,stackTwo);
				break;
			case 2:
				if (stackTwo.empty()) {
					System.out.println("Stack is empty");
					break;
				}
				stackOne.push(stackTwo.pop());
				printStack(stackOne,stackTwo);
				break;
			case 0:
				sc.close();
				return;
			}
		}
		
		
	}
}
