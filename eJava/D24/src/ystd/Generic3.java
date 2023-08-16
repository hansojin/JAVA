package ystd;

import java.util.*;

class Animal3{
	public void cry(){
		System.out.println("Animal");
	}
}

class cat3 extends Animal3{
	@Override
	public void cry() {
		System.out.println("미야옹");
	}
}
class dog3 extends Animal3{
	@Override
	public void cry() {
		System.out.println("왈왈");
	}
}


class Animal3List<T>{
	ArrayList<T> al = new ArrayList<T>();
	
	public static void cryList(Animal3List<? extends Animal3> al) {
		Animal3 la = al.get(0);
		la.cry();
	}
	
	void add(T Animal3) {
		al.add(Animal3);
	}
	T get(int index) {
		return al.get(index);
	}
	boolean remove(T Animal3) {
		return al.remove(Animal3);
	}
	int size() {
		return al.size();
	}
}

public class Generic3 {
	public static void main(String[] args) {
		Animal3List<cat3> catList = new Animal3List<cat3>();
		catList.add(new cat3());
		
		Animal3List<dog3> dogList = new Animal3List<dog3>();
		dogList.add(new dog3());
		
		Animal3List.cryList(catList);
		Animal3List.cryList(dogList);
		
	}
}
