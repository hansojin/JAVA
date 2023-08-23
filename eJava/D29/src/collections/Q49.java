package collections;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class Q49 {
	public static void main(String[] args) {
		TreeMap<Integer,String> map = new TreeMap<>();
		map.put(3,"three");
		map.put(5,"five");
		map.put(4,"four");
				
		NavigableSet<Integer> navi = map.navigableKeySet();
		System.out.println(navi);	// [3,4,5]
		
		Iterator<Integer> iter = navi.iterator();
		while(iter.hasNext())
			//System.out.println(iter.next());		// 3 4 5
			System.out.println(map.get(iter.next())); // three four five
		
		iter = navi.descendingIterator();
		while(iter.hasNext())
			System.out.println(map.get(iter.next()));
	}
}
