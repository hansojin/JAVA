package lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class SLenComparator2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Robot");
		list.add("Lambda");
		list.add("Box");

		Collections.sort(list, (s1,s2)-> s1.length()-s2.length()); 

		for(String s : list)
			System.out.println(s);
	}
}

