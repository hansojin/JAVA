package ArrayList;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;


class Prson implements Comparable<Prson>{
	String name;
	int age;

	public Prson(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void showData(){
		System.out.printf("%s %d \n", name, age);
	}
	public int compareTo(Prson p){
		return age - p.age;
	}
	public String getName() {
		return name;
	}
	
}

class PrsonComparator implements Comparator<Prson>{
	public int compare(Prson p1, Prson p2){
		return p1.getName().compareTo(p2.getName());
	}
}

class IntroComparator2{
	public static void main(String[] args){
		TreeSet<Prson> sTree=new TreeSet<Prson>(new PrsonComparator());
		sTree.add(new Prson("Lee", 24));
		sTree.add(new Prson("Hong", 29));
		sTree.add(new Prson("Choi", 21));
		
		Iterator<Prson> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}