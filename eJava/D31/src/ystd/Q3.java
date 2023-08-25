package ystd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q3 {
	public static void main(String[] args) {
		String src = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
			List<String> dest = new ArrayList<>();
			int slen=src.length();
			int limit = 10;
			for(int i=0;i<slen;i+=limit) {
				if (i+limit <slen)
					dest.add(src.substring(i,i+limit));
				else
					dest.add(src.substring(i));
			}
			for(Iterator<String> iter = dest.iterator();iter.hasNext();)
				System.out.println(iter.next());
	}
}
