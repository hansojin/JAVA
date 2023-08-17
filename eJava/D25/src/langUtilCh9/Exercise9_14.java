package langUtilCh9;

import java.util.ArrayList;
import java.util.Scanner;

class Exercise9_14 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		ArrayList list = new ArrayList();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print(">>");
			String input = sc.nextLine().trim();
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			
			
			for(String num : phoneNumArr) {
				String tmp = num.replace("-","");
				if (tmp.contains(input))
					list.add(num);
			}
			
			
			if(list.size()>0) {
				System.out.println(list);
				list.clear();
			} else {
				System.out.println("일치하는 번호가 없습니다."); 
			}
		}
	} // main
}