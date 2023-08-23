package collections;

import java.util.Iterator;
import java.util.TreeSet;

public class Q32 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(2);
		set.add(4);
		set.add(3);
		set.add(2);
		
		System.out.println(set.size()+"\n");
		
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
