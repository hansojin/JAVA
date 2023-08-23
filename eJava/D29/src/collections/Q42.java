package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


public class Q42 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<>(new Comparator<>(){
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		set.add("Dog");
		set.add("Elephant");
		set.add("Panda");
		set.add("Rabbit");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		
	}
}
