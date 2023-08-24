package sort;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class StringBinarySearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Box");
        list.add("Robot");
        list.add("Apple");

        // 정렬 -> 탐색
        Collections.sort(list);        
        int idx = Collections.binarySearch(list, "Robot");
 
        // 탐색 결과 출력
        System.out.println(list.get(idx));
        System.out.println(idx);
    }
}

/*
실행 결과
2
Robot

	public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
		-> list에서 key를 찾아 그 인덱스 값 반환, 못 찾으면 음의 정수 반환
		
	binarySearch 메소드
	이 메소드는 이진 탐색이라는 알고리즘을 기반으로 탐색을 진행한다. 
	그런데 이 알고리즘을 적용하기 위해서는 "해당 컬렉션 인스턴스가 정렬된 상태이어야 한다."
	이진 탐색은 정렬된 리스트 자료구조를 대상으로 적용하는 알고리즘이기 때문이다.
	
*/
