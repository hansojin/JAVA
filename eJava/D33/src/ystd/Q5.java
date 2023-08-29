package ystd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		map.forEach((key,value)->{
			System.out.println(key + " " + value);
		});
		
		Scanner sc = new Scanner(System.in);
		String id, pw;
		System.out.print("Enter id : ");
		id=sc.nextLine();
		System.out.print("Enter pw : ");
		pw=sc.nextLine();
		
		if (!map.containsKey(id)) 
			System.out.println("NO SUCH AN ID");
		else {
			if (map.get(id).equals(pw))
				System.out.println("LOGIN");
			else
				System.out.println("CHECK YOUR PW");
			
		}
		sc.close();
	}
}
