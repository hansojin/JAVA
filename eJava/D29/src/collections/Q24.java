package collections;

import java.util.HashSet;
import java.util.Iterator;

public class Q24 {
	public static void main(String[] args) {

		HashSet<String> link = new HashSet<>();
		link.add("first");
		link.add("second");
		link.add("first");
		link.add("third");
		link.add("fourth");
		System.out.println(link.size()+"\n");
		Iterator<String> iter = link.iterator();
		while(iter.hasNext()) {
			String comp = iter.next();
			System.out.println(comp);
			if (comp.equals("third"))
				iter.remove();
			
		}
		System.out.println();
		for (String st : link)
			System.out.println(st);
	}
}
