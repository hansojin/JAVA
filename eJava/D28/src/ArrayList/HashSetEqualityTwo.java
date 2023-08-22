package ArrayList;

import java.util.Iterator;
import java.util.HashSet;

class SimpleNumbr{
	int num;
	public SimpleNumbr(int n)	{
		num=n;
	}
	public String toString()	{
		return String.valueOf(num);
	}
	public int hashCode()	{
		return num%3;
	}
	public boolean equals(Object obj)	{
		SimpleNumbr comp=(SimpleNumbr)obj;
		return num==comp.num;
		/*
		if(comp.num==num)
			return true;
		else
			return false;		
		*/
	}
}

class HashSetEqualityTwo{
	public static void main(String[] args)	{
		HashSet<SimpleNumbr> hSet=new HashSet<SimpleNumbr>();
		hSet.add(new SimpleNumbr(10));
		hSet.add(new SimpleNumbr(20));
		hSet.add(new SimpleNumbr(20));
		
		System.out.println("저장된 데이터 수: "+hSet.size());
		
		Iterator<SimpleNumbr> itr=hSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}