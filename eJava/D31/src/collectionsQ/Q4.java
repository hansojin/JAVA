package collectionsQ;

import java.util.TreeSet;

public class Q4 {
	public static void main(String[] args) {
		TreeSet<Integer> lotto = new TreeSet<>();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
		
	}
}
