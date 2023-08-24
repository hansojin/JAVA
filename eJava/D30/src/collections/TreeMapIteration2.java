package collections;

import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

class AgeComparator implements Comparator<Integer> {
    public int compare(Integer n1, Integer n2) {
        return n2.intValue() - n1.intValue(); 
    }
}

class TreeMapIteration2 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());
        
        map.put(45, "Brown");
        map.put(23, "James");
        map.put(37, "Martin");

        Set<Integer> ks = map.keySet();

        // 전체 Key 역순 출력 (for-each문 기반)
        for(Integer n : ks)
            System.out.print(n.toString() + '\t');
        System.out.println();

        
    }
}

/*
실행 결과
45	37	23	

TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());

그리고 AgeComparator 클래스가 Comparator<T>를 구현하면서 T를 Integer로 결정한 이유는 정렬 대상인 Key가 Integer이기 때문이다.
*/