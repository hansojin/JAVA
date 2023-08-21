package ystd;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};	
		
		System.out.print("Enter number : ");
		String key =sc.nextLine();
		String ans="";
		for (String num : phoneNumArr) {
			String tmp = num.replace("-", "");
			if (tmp.contains(key))
				ans+=num+ " ";
			
		}
		System.out.println(ans);
		
		sc.close();
		
	}
}
