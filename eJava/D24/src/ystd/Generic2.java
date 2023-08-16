package ystd;

import java.util.*;

class Animal2{
	public void cry(){
		System.out.println("Animal");
	}
}

class cat2 extends Animal2{
	@Override
	public void cry() {
		System.out.println("미야옹");
	}
}
class dog2 extends Animal2{
	@Override
	public void cry() {
		System.out.println("왈왈");
	}
}


class Animal2List<T extends Animal2>{
	ArrayList<T> al = new ArrayList<T>();
	
	void add(T Animal2) {
		al.add(Animal2);
	}
	T get(int index) {
		return al.get(index);
	}
	boolean remove(T Animal2) {
		return al.remove(Animal2);
	}
	int size() {
		return al.size();
	}
}

public class Generic2 {
	public static void main(String[] args) {
		Animal2List<Animal2> nml = new Animal2List<Animal2>();
		nml.add(new Animal2());
		nml.add(new cat2());
		nml.add(new dog2());
		
		for(int i=0;i<nml.size();i++)
			nml.get(i).cry();
		
		
	}
}
