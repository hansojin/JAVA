package lab;

import java.util.Stack;

public class Q2 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		boolean flag = true;
		char[] exp = args[0].toCharArray();

		for (int i=0;i<exp.length;i++) {
			if (exp[i]=='(') {
				stack.push(args[i]);
			}
			else if (exp[i]==')') {
				if (stack.empty()) {
					flag=false;
				}	
				else
					stack.pop();
			}
		}

		System.out.print(args[0] + " >> ");
		if (flag== false || stack.size()!=0)
			System.out.println("Invalid");
		else
			System.out.println("Valid");
	}
}
