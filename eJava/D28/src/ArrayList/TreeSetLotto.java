package ArrayList;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetLotto {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<>();
		while  (lotto.size()<6) {
			int num = (int)(Math.random()*45)+1;
			lotto.add(num);
		}
		
		Iterator<Integer> iter = lotto.iterator();
		while(iter.hasNext())
			System.out.print(iter.next()+" ");
		
		// or just
		System.out.println(lotto);
	}
}
