package ystd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Q2 {
	public static void main(String[] args) {
		List<String> lst = Arrays.asList("Box","Toy","Box","Toy");
		for(Iterator<String> iter = lst.iterator();iter.hasNext();)
			System.out.print(iter.next()+" ");
		System.out.println();
		HashSet<String> set = new HashSet<>(lst);
		for(Iterator<String> iter = set.iterator();iter.hasNext();)
			System.out.print(iter.next()+" ");
		
		
	}
}
