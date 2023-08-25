package ystd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q4 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>(100000); 
		LinkedList<String> ll = new LinkedList<>();
		add(al);
		add(ll);
		access(al);
		access(ll);
	}

	public static void add(List<String> list) {
		for(int i=0;i<100000;i++)
			list.add(i+"");
	}
	public static void access(List<String> list) {
		long start = System.currentTimeMillis();
		for(int i=0;i<100000;i++)
			list.get(i);
		long end =System.currentTimeMillis();
		System.out.println(end-start);
	}
}
