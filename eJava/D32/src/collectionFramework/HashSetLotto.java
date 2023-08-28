package collectionFramework;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class HashSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		while(set.size() < 6) {
			int num = (int)(Math.random()*45) + 1;
			set.add(num);
		}

		List<Integer> list = new LinkedList<>(set);	// LinkedList(Collection c)
		Collections.sort(list);						// Collections.sort(List list)
		System.out.println(list);
	}
}


// [참고] Collection은 인터페이스고 Collections는 클래스임에 주의하자.

