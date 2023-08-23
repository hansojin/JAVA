package collections;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Q50 {
	public static void main(String[] args) {
		/*
		String grade;
		int point = 94;

		if (point >= 90)
		  grade = "수";
		else if (point >= 80)
		  grade = "우";
		else if (point >= 70)
		  grade = "미";
		else if (point >= 60)
		  grade = "양";
		else
		  grade = "가";

		System.out.println("Grade : " + grade);
		*/
		NavigableMap<Integer, String> map = new TreeMap<>();
		map.put(100, "수");
		map.put(89, "우");
		map.put(79, "미");
		map.put(69, "양");
		map.put(59, "가");
		String grade = map.ceilingEntry(94).getValue();
		System.out.println(grade);
	}
}
