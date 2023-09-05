package ystd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrIgnoreCaseComp {

	public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		list.add("robot");
		list.add("Lambda");
		list.add("box");
//		Collections.sort(list, (s1, s2)->s1.compareToIgnoreCase(s2));
		Collections.sort(list, String::compareToIgnoreCase);
		System.out.println(list);
	}

}
