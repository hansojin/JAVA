package collectionsQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Q7 {
	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>();
	static Set<String> cate = new HashSet<>();
	
	public static void addPhoneNo(String categ, String name, String phone) {
		phoneBook.put(phone, new HashMap<String,String>());
		phoneBook.get(phone).put(name,categ);
		cate.add(categ);
	}
	public static void addPhoneNo(String categ,  String phone) {
		phoneBook.put(phone, new HashMap<String,String>());
		phoneBook.get(phone).put("",categ);
		cate.add(categ);
	}
	
	public static void printList() {
		Set<String> key = phoneBook.keySet();
		for (String dist : cate) {
			int cnt=0;
			System.out.println("\n>> 분류 : " + dist);
			for(String phone : key) {
				if(String.valueOf(dist).equals(String.valueOf(phoneBook.get(phone).values()).substring(1,3))) {
					cnt+=1;
					
					if(String.valueOf(phoneBook.get(phone).keySet()).length()>2)
						System.out.print(String.valueOf(phoneBook.get(phone).keySet()).substring(1,4)+ " ");
					System.out.println(phone);
				}
			}
			System.out.println("Total : " + cnt);
		}
		
	}
	
	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");
		printList();
		
	}
}
