package langUtilCh9;

import java.util.*;
import java.util.regex.*;

class Exercise9_14_1 {
	public static void main(String[] args) {
		String[] phoneNumArr = {
				"012-3456-7890",
				"099-2456-7980",
				"088-2346-9870",
				"013-3456-7890"
		};
		
		Vector list = new Vector(); 
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(">>");
			String input = s.nextLine().trim(); 
			if(input.equals("")) {
				continue;
			} else if(input.equalsIgnoreCase("Q")) {
				System.exit(0);
			}
			
			
			String pattern = ".*"+input+".*"; 
			Pattern p = Pattern.compile(pattern);
			for(int i=0; i< phoneNumArr.length;i++) {
				String phoneNum = phoneNumArr[i];
				String tmp = phoneNum.replace("-",""); 
				Matcher m = p.matcher(tmp);
				if(m.find()) {
					list.add(phoneNum);
				}
			}
			
//			m.find() _ 해당 패턴을 검색하여 일치하는 패턴이 일부라도 존재하면 true를 리턴 
//			m.matches() _ 대상 문자열 전체가 해당 패턴과 일치하면 true를 리턴한다.
			
			if(list.size()>0) { 
				System.out.println(list); 
				list.clear(); 
			} else {
				System.out.println("일치하는 번호가 없습니다."); 
			}
		}
	} 
}
