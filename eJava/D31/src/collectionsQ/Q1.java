package collectionsQ;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

//HashSet과 LinkedList를 이용하여 로또번호 만들기.(정렬하여 출력)

public class Q1 {
	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<>();
		while(lotto.size()<6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
		
		LinkedList<Integer> slotto = new LinkedList<>(lotto);
		Collections.sort(slotto);
		System.out.println(slotto);
	}
}
