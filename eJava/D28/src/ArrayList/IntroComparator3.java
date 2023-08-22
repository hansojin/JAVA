package ArrayList;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Comparator;


class Prsn implements Comparable<Prsn>{
	String name;
	int age;

	public Prsn(String name, int age){
		this.name=name;
		this.age=age;
	}
	public void showData(){
		System.out.printf("%s %d \n", name, age);
	}
	public int compareTo(Prsn p){
		return age - p.age;
	}
	public String getName() {
		return name;
	}
	
}
/*
class PrsnComparator implements Comparator<Prsn>{
	public int compare(Prsn p1, Prsn p2){
		return p1.getName().compareTo(p2.getName());
	}
}
*/
// Anonymous Class 로 변경하기 ! 
class IntroComparator3{
	public static void main(String[] args){
		
		TreeSet<Prsn> sTree=new TreeSet<Prsn>(new Comparator<Prsn>() {
			public int compare(Prsn p1, Prsn p2){
				return p1.getName().compareTo(p2.getName());
			}
		});
		
		// 람다 를 쓰면 더 쉽게 쓸 수 있다-
		// TreeSet<Prsn> sTree = new TreeSet<Prsn>((p1,p2)-> p1.getName().compareTo(p2.getName()));
		
		sTree.add(new Prsn("Lee", 24));
		sTree.add(new Prsn("Hong", 29));
		sTree.add(new Prsn("Choi", 21));
		
		Iterator<Prsn> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}
