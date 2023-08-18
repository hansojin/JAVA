package ArraysClass;

import java.util.Arrays;

class Personn implements Comparable<Personn> {
	private String name;
	private int age;

	public Personn(String name, int age) {
		this.name = name;
		this.age = age;
	}    

//    @Override
//	  나이 기준 탐색
//    public int compareTo(Personn p) {
//        return this.age - p.age;
//    }

	@Override
	public int compareTo(Personn p) {
		return this.name.compareTo(p.name);
	}

	@Override
	public String toString() {
		return name + ": " + age;
	}
}


class ArrayObjSearch {
	public static void main(String[] args) {
		Personn[] ar = new Personn[3];

		ar[0] = new Personn("Lee", 29);
		ar[1] = new Personn("Goo", 15);
		ar[2] = new Personn("Soo", 37);

		Arrays.sort(ar);
		
		// 나이 기준 탐색
		//int idx = Arrays.binarySearch(ar, new Personn("Who are you?", 37));
		// 사실 이름은 어떻게 넣던, 내가 찾을껀 나이로만 찾을거니가 상관 없어보임
		
		// 이름 기준 탐색
		int idx = Arrays.binarySearch(ar, new Personn("Goo",15));
		System.out.println(ar[idx]);
	}
}
