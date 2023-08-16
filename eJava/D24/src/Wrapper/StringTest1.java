package Wrapper;

import java.util.Scanner;

public class StringTest1 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num: ");
		String num = sc.nextLine();
		String phoneList="";
		
		for(String comp : phoneNumArr) {
			String tmp = comp.replace("-","");
			if (tmp.indexOf(num)!=-1) 
				phoneList+= comp+ "\t";
		}
		System.out.println(phoneList);
		sc.close();
	}




}
