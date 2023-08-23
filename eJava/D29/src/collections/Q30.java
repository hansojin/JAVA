package collections;

import java.util.HashSet;
import java.util.Iterator;

class SimpleNumber{
	int num;
	public SimpleNumber(int n){
		num=n;
	}
	public String toString(){
		return String.valueOf(num);
	}
	public int hashCode() {
		return num%3;
	}
	public boolean equals(Object obj) {
		return ((SimpleNumber)obj).num == this.num;
	}
	
}

class Q30 {
	public static void main(String[] args){
		HashSet<SimpleNumber> hSet=new HashSet<SimpleNumber>();
		hSet.add(new SimpleNumber(10));
		hSet.add(new SimpleNumber(20));
		hSet.add(new SimpleNumber(20));
		
		System.out.println("저장된 데이터 수: "+hSet.size());
		
		Iterator<SimpleNumber> itr=hSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
