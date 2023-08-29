package ystd;

import java.util.HashMap;

public class Q7 {
	static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<>();

	public static void printList() {
		phoneBook.forEach((key,value)->{
			System.out.println(">> " + key + " ["+ value.size() + "]");
			value.forEach((k,v)->{
				System.out.println(v+ " " + k);
			});
			System.out.println();
		});
	}
	
	public static void addCate(String cate) {
		if(!phoneBook.containsKey(cate))
			phoneBook.put(cate, new HashMap<String,String>());
	}
	public static void addPhoneNo(String cate, String name, String phone) {
		addCate(cate);
		HashMap<String, String> group = phoneBook.get(cate);
		group.put(phone, name);
	}

	public static void addPhoneNo(String name,String phone) {
		addPhoneNo("ETC",name,phone);
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
