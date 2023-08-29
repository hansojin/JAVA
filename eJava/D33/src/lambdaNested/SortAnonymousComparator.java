package lambdaNested;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


class SortAnonymousComparator {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ROBOT");
		list.add("APPLE");
		list.add("BOX");

		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});    // 정렬
		System.out.println(list);
	}
}

