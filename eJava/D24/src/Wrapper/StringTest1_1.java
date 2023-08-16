package Wrapper;

import java.util.Scanner;
import java.util.Vector;

public class StringTest1_1 {

	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		Vector<String> vec = new Vector<String>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine().trim(); // trim()_공백 제거
			
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}

			for(int i=0;i<phoneNumArr.length;i++) {
				String phoneNum = phoneNumArr[i];
				String tmp = phoneNum.replace("-","");
				if(tmp.contains(input)) {
					vec.add(phoneNum);
				}				
			}

			if(vec.size()>0) {
				System.out.println(vec); 
				vec.clear(); 
			} else {
				System.out.println("일치하는 번호가 없습니다.");
			}
		}
		
	}
}