package ArraysClass;

import java.util.Arrays;

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}    

//	@Override
//	public int compareTo(Person p) {
// 		나이 오름차순 정렬		
//		1.
//		if(this.age > p.age)
//			return 1;
//		else if(this.age < p.age)
//			return -1;
//		else
//			return 0;
//		2.		
//		return age-p.age;
//	}
	
//	@Override
//	public int compareTo(Person p) {
//		// 이름 길이 오름차순 정렬
//		if(this.name.length() > p.name.length())
//			return 1;
//		else if(this.name.length() < p.name.length())
//			return -1;
//		else
//			return 0;
//	}
	
	@Override
	public int compareTo(Person p) {
		// 이름 정렬
//		return (this.name.compareTo(p.name));
		
		// 이름 역순 정렬
	    return (p.name.compareTo(this.name));
	}

	@Override
	public String toString() {
		return name + ": " + age;
	}
}

class ArrayObjSort {
	public static void main(String[] args) {
		Person[] ar = new Person[3];

		ar[0] = new Person("Lee", 29);
		ar[1] = new Person("Gooo", 15);
		ar[2] = new Person("So", 37);

		Arrays.sort(ar);

		for(Person p : ar) 
			System.out.println(p);
	}
}