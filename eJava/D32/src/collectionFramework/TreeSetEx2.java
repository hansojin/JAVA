package collectionFramework;

import java.util.*;

class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

		for(int i=0; i < score.length; i++)
//			set.add(new Integer(score[i]));
			set.add(Integer.valueOf(score[i]));

//		System.out.println("50보다 작은 값 :"	+ set.headSet(new Integer(50)));
//		System.out.println("50보다 큰 값 :"	+ set.tailSet(new Integer(50)));
		System.out.println("50보다 작은 값 :"	+ set.headSet(Integer.valueOf(50)));
		System.out.println("50보다 큰 값 :"	+ set.tailSet(Integer.valueOf(50)));
	}
}

/*
as, tree 형으로 저장 되어 있기 때문에, 
headSet() -> TreeSet에 저장된 객체 중 지정된 기준보다 작은 객체
tailSet() -> 지정된 기준을 포함하여 큰 객체들을 얻을 수 있다.
*/
