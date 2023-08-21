package ystd;

import java.util.Arrays;

class PerSearch implements Comparable<PerSearch>{
    private String name;
    private int age;

    public PerSearch(String name, int age) {
        this.name = name;
        this.age = age;
    }    

    @Override
	public int compareTo(PerSearch o) {
		return this.name.compareTo(o.name);
	}

	@Override
    public String toString() {
        return name + ": " + age;
    }
}


class ArrayObjSearch {
    public static void main(String[] args) {
        PerSearch[] ar = new PerSearch[3];

        ar[0] = new PerSearch("Lee", 29);
        ar[1] = new PerSearch("Goo", 15);
        ar[2] = new PerSearch("Soo", 37);

        Arrays.sort(ar);
        
        int idx = Arrays.binarySearch(ar, new PerSearch("Lee",29));
        System.out.println(ar[idx]);
        
    }
}
