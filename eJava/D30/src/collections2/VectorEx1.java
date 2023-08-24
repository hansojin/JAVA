package collections2;

import java.util.*;

class VectorEx1 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>(5);	// 용량(capacity)이 5인 Vector를 생성한다.
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);

		// [1, 2, 3]
		// size :3
		// capacity :5

		v.trimToSize();	// 빈 공간을 없앤다 -> 용량과 크기가 같아진다.
		System.out.println("=== After trimToSize() ===");
		print(v);

		// === After trimToSize() ===
		// [1, 2, 3]
		// size :3
		// capacity :3

		v.ensureCapacity(6);
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);

		// === After ensureCapacity(6) ===
		// [1, 2, 3]
		// size :3
		// capacity :6

		v.setSize(7);
		System.out.println("=== After setSize(7) ===");
		print(v);

		// === After setSize(7) ===
		// [1, 2, 3, null, null, null, null]
		// size :7
		// capacity :12		

		v.clear();
		System.out.println("=== After clear() ===");
		print(v);

		// === After clear() ===
		// []
		// size :0
		// capacity :12
	}

	public static void print(Vector<String> v) {
		System.out.println(v);
		System.out.println("size :" + v.size());
		System.out.println("capacity :" + v.capacity());
	}
}

/*
ArrayList나 Vector 같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는 데는 효율이 좋지만, 
용량을 변경해야할 때는 새로운 배열을 생성한 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사해야하기 때문에 
상당히 효율이 떨어진다는 단점을 가지고있다. 그래서 처음에 인스턴스를 생성할 때, 
저장할 데이터의 개수를 잘 고려하여 충분한 용량의 인스턴스를 생성하는 것이 좋다.
*/
