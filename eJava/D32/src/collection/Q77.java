package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Q77 {
	static HashMap<String, HashMap<String, String>> phoneBook = new HashMap<>();

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

	// 그룹을 추가하는 메서드
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap<String, String>());
	}

	// 그룹에 전화번호를 추가하는 메서드
	static void addPhoneNo(String groupName, String name, String phone) {
		addGroup(groupName);
		HashMap<String, String> group = phoneBook.get(groupName);
		group.put(phone, name);	
		// 이름은 중복될 수 있으니 전화번호를 key로 저장한다.
	}

	static void addPhoneNo(String name, String phone) {
		addPhoneNo("기타", name, phone);
	}

	// 전화번호부 전체를 출력하는 메서드
	static void printList() {
		Set<Entry<String, HashMap<String, String>>> set = phoneBook.entrySet();
		Iterator<Entry<String, HashMap<String, String>>> it = set.iterator();	

		while(it.hasNext()) {
			Map.Entry<String,HashMap<String,String>> e = it.next();

			Set<Entry<String, String>> subSet = e.getValue().entrySet();
			Iterator<Entry<String, String>> subIt = subSet.iterator();	

			System.out.println(" * "+e.getKey()+" ["+subSet.size()+"]");

			while(subIt.hasNext()) {
				
				Map.Entry<String, String> subE = subIt.next();
				String phoneNo = subE.getKey();
				String name = subE.getValue();
				System.out.println(name + " " + phoneNo );
			}
			System.out.println();
		}
	} 
}
