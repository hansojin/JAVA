package collections;

import java.util.TreeMap;
import java.util.Set;
import java.util.Comparator;

class TreeMapIteration3 {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>(new Comparator<Integer>() {
        	 public int compare(Integer n1, Integer n2) {
        	        return n2.intValue() - n1.intValue(); 
        	    }
        });
        
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