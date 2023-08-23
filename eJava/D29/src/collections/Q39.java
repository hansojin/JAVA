package collections;

import java.util.Iterator;
import java.util.TreeSet;

class Animal implements Comparable<Animal>{
	String ani;
	Animal(String ani){
		this.ani = ani;
	}
	public String toString() {
		return ani;
	}
	@Override
	public int compareTo(Animal o) {
		return this.ani.length()-o.ani.length();
	}
	
}
public class Q39 {
	public static void main(String[] args) {
		TreeSet<Animal> set = new TreeSet<>();
		set.add(new Animal("Dog"));
		set.add(new Animal("Elephant"));
		set.add(new Animal("Panda"));
		set.add(new Animal("Rabbit"));
		
		Iterator<Animal> iter = set.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		iter=set.descendingIterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
}
