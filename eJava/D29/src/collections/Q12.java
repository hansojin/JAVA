package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Q12 {
	public static void main(String[] args) {
		ArrayList<Integer> tw = new ArrayList<>();
		tw.add(11);
		tw.add(22);
		tw.add(33);
		
		Iterator<Integer> iter = tw.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		tw.remove(0);
		iter = tw.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
