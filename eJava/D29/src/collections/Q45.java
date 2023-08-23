package collections;

import java.util.HashMap;

class Q45 {
	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(3,"three");
		map.put(5,"five");
		map.put(4,"four");
		
		System.out.println(map.get(3));
		map.remove(5);
		System.out.println(map.get(5));
		
	}
}
