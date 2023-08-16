package ystd;

import java.util.*;

class Animal{
	public void cry(){
		System.out.println("animal");
	}
}

class cat extends Animal{
	@Override
	public void cry() {
		System.out.println("미야옹");
	}
}
class dog extends Animal{
	@Override
	public void cry() {
		System.out.println("왈왈");
	}
}
class bird extends Animal{
	@Override
	public void cry() {
		System.out.println("짹짹");
	}
}

class AnimalList<T>{
	ArrayList<T> al = new ArrayList<T>();
	
	void add(T animal) {
		al.add(animal);
	}
	T get(int index) {
		return al.get(index);
	}
	boolean remove(T animal) {
		return al.remove(animal);
	}
	int size() {
		return al.size();
	}
}

public class Generic1 {
	public static void main(String[] args) {
		AnimalList<Animal> nml = new AnimalList<Animal>();
		nml.add(new Animal());
		nml.add(new cat());
		nml.add(new dog());
		
		for(int i=0;i<nml.size();i++)
			nml.get(i).cry();
		
		
	}
}
