package ArrayList;

import java.util.TreeSet;
import java.util.Iterator;

class MyString implements Comparable<MyString>{
	String str;

	public MyString(String str)	{
		this.str=str;
	}

	public int getLength()	{
		return str.length();
	}

	public int compareTo(MyString mStr)	{
		if(getLength()>mStr.getLength())
			return 1;
		else if(getLength()<mStr.getLength())
			return -1;
		else
			return 0;

//		 return getLength()-mStr.getLength();
	}

	public String toString()	{
		return str;
	}
}

class ComparableMyString{
	public static void main(String[] args)	{
		/*
		// 얘는 알파벳 순으로 정렬
		TreeSet<String> tSet=new TreeSet<String>();		
		tSet.add("Orange");
		tSet.add("Apple");
		tSet.add("Dog");
		tSet.add("Individual");

		Iterator<String> itr=tSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		*/
		
		// 근데 만약 단어 길이순으로 저장하고 싶다면?
		TreeSet<MyString> tSet=new TreeSet<MyString>();		
		tSet.add(new MyString("Orange"));
		tSet.add(new MyString("Apple"));
		tSet.add(new MyString("Dog"));
		tSet.add(new MyString("Individual"));

		Iterator<MyString> itr=tSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());

	}
}
