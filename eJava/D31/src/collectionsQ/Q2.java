package collectionsQ;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

//HashSet과 LinkedHashSet을 이용하여 5 * 5 빙고를 만들어 출력하자. 번호는 1이상 50이하
//HashSet은 내부적으로 sorting 되는 시스템

public class Q2 {
	public static void printBingo(Set<Integer> bingo) {
		int i=0;
		for(Iterator<Integer>iter=bingo.iterator();iter.hasNext();) {
			System.out.print(iter.next()+ "\t");
			i++;
			if(i%5==0) System.out.println();
		}
	}
	
	public static Set<Integer> makeBingo(Set<Integer> bingo) {
		while(bingo.size()<25) {
			bingo.add((int)(Math.random()*50)+1);
		}
		return bingo;
	}
	
	public static void main(String[] args) {
		System.out.println(">> HashSet");
		HashSet<Integer> bingo = new HashSet<>();
		makeBingo(bingo);
		printBingo(bingo);
		System.out.println(">> LinkedHashSet");
		LinkedHashSet<Integer> bgo = new LinkedHashSet<>();
		makeBingo(bgo);
		printBingo(bgo);
	}
}
