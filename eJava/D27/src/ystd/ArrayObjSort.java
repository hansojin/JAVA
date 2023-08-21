package ystd;

import java.util.Arrays;

class PerSort implements Comparable<PerSort>{
    
	private String name;
    private int age;

    public PerSort(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
//    나이 정렬
//    @Override
//    public int compareTo(PerSort p) {
//		return this.age - p.age;
//	}
    
    // 이름 정렬
    @Override
    public int compareTo(PerSort p) {
    	return this.name.compareTo(p.name);
    }
    
    @Override
    public String toString() {
        return name + ": " + age;
    }
}

class ArrayObjSort {
    public static void main(String[] args) {
        PerSort[] ar = new PerSort[3];

        ar[0] = new PerSort("Lee", 29);
        ar[1] = new PerSort("Goo", 15);
        ar[2] = new PerSort("Soo", 37);

        Arrays.sort(ar);
        
        for(PerSort p : ar) 
            System.out.println(p);
    }
}