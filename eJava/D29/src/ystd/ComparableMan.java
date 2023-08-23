package ystd;

import java.util.Iterator;
import java.util.TreeSet;

class Man implements Comparable<Man>
{
    String name;
    int age;

    public Man(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public void showData()
    {
    	System.out.printf("%s %d \n", name, age);
    }
    public int compareTo(Man p)
    {
    	/*
        if(age>p.age)
            return 1;
        else if(age<p.age)
            return -1;
        else	
            return 0;
        */
    	return this.name.compareTo(p.name);
    }
}

class ComparableMan 
{
	public static void main(String[] args)
	{
		TreeSet<Man> sTree=new TreeSet<Man>();
		sTree.add(new Man("Lee", 24));
		sTree.add(new Man("Hong", 29));
		sTree.add(new Man("Choi", 21));
		
		Iterator<Man> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}