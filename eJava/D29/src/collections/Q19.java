package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class Q19 {
	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<>();
		link.add("first");
		link.add("second");
		link.add("third");
		link.add("fourth");
		
		Iterator<String> iter = link.iterator();
		while(iter.hasNext()) {
			String comp = iter.next();
			System.out.println(comp);
			if (comp.equals("third"))
				iter.remove();
			
		}
		iter = link.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		for (String st : link)
			System.out.println(st);
	}
}
