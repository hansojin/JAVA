package collections;

import java.util.Iterator;
import java.util.TreeSet;

class MyString implements Comparable<MyString>{
	String name;
	int age;
	
	MyString(String name, int age){
		this.name= name;
		this.age= age;
	}
	public String toString() {
		return name + " " + age;
	}
	@Override
	public int compareTo(MyString o) {
		//return this.age-o.age;
		return this.name.compareTo(o.name);
	}
	
}

class Q37 {
	public static void main(String[] args) {
		TreeSet<MyString> set = new TreeSet<>();
		set.add(new MyString("Lee",24));
		set.add(new MyString("Hong",29));
		set.add(new MyString("Choii",21));
		
		Iterator<MyString> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
