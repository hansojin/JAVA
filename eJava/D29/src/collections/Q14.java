package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class Q14 {
	public static void main(String[] args) {
		LinkedList<Integer> link = new LinkedList<>();
		link.add(11);
		link.add(22);
		link.add(33);
		
		Iterator<Integer> iter = link.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		link.remove(0);
		
		iter = link.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
