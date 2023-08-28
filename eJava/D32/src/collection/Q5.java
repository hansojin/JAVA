package collection;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		HashMap<String,String> login = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String id, pw;
		
		login.put("myId", "1234");
		login.put("asdf", "1111");
		login.put("asdf", "1234");	// key가 있으면 value 가 변경됨

		// 참고용 출력
		for(Entry<String,String> set : login.entrySet())
			System.out.println(set.getKey() + " " + set.getValue());
		
		System.out.print("Enter ID : ");
		id = sc.nextLine();
		boolean flag = false;
		for(String key: login.keySet()) {
			if (id.equals(key)) {
				flag = true;
				System.out.print("Enter password : ");
				pw = sc.nextLine();
				if(pw.equals(login.get(key)))
					System.out.println("일치");
				else
					System.out.println("불일치");
				break;
			}
		}
		if (flag==false)
			System.out.println("id 없음");
		sc.close();
	}
}
