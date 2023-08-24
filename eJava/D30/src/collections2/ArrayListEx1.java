package collections2;

import java.util.ArrayList;
import java.util.Collections;

class ArrayListEx1{
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(10);
		list1.add(Integer.valueOf(5));
		list1.add(Integer.valueOf(4));
		list1.add(Integer.valueOf(2));
		list1.add(Integer.valueOf(0));
		list1.add(Integer.valueOf(1));
		list1.add(Integer.valueOf(3));

		ArrayList list2 = new ArrayList<>(list1.subList(1,4)); 
		print(list1, list2);
		// list1:[5, 4, 2, 0, 1, 3]
		// list2:[4, 2, 0]

		Collections.sort(list1);	
		Collections.sort(list2);	
		print(list1, list2);
		// list1:[0, 1, 2, 3, 4, 5]
		// list2:[0, 2, 4]

		System.out.println(list1.containsAll(list2));	//true 

		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		// list1:[0, 1, 2, 3, 4, 5]
		// list2:[0, 2, 4, A, B, C]		

		list2.set(3, "AA");
		print(list1, list2);
		// list1:[0, 1, 2, 3, 4, 5]
		// list2:[0, 2, 4, AA, B, C]
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println(list1.retainAll(list2)); // true	
		// reatinAll의 호출결과로 list1이 변했다면 true를 반환한다.
		print(list1, list2);
		// list1:[0, 2, 4]
		// list2:[0, 2, 4, AA, B, C]
		
		//  list2에서 list1에 포함된 객체들을 삭제한다.
		//  앞에서부터 지우면, idx가 땡겨지니까 확인하지 못하는 index가 생길 수 있기때문에
		for(int i= list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
		// list1:[0, 2, 4]
		// list2:[AA, B, C]
	} 

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();		
	}
} 

