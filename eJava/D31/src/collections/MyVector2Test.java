package collections;

import java.util.*;

class MyVector2Test {
	public static void main(String args[]) {
		MyVector2 v = new MyVector2();
		v.add("0");
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");

		System.out.println("삭제 전 : " + v);	// [0, 1, 2, 3, 4]
		Iterator it = v.iterator();
		it.next();
		it.remove();
		it.next();
		it.remove();

		System.out.println("삭제 후 : " + v);	//[2, 3, 4]
	}
}

/*
if(lastRet == -1) {
	throw new IllegalStateException();
} else {
	remove(lastRet);
//	cursor--;			// 주석처리한다.
	lastRet = -1;
}

MyVector2.java의 remove()에서 위와 같이 주석처리하면, MyVector2Test.java의 실행결과는 다음과 같이 될 것이다. 
0과 1, 첫 번째와 두 번째 요소가 순서대로 삭제되지 않고, 첫 번째와 세 번째 요소인 0과 2가 삭제된 것을 알 수 있다.

삭제 전:[0,1,2,3,4]
삭제 후:[1,3,4]

 */
