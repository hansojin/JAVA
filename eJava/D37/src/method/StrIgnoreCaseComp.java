package method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrIgnoreCaseComp {
	public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		list.add("robot");
		list.add("Lambda");
		list.add("box");
		
		//Collections.sort(list, (s1, s2)->s1.compareToIgnoreCase(s2));
		Collections.sort(list,String::compareToIgnoreCase);

		System.out.println(list);
	}

}

/*
참고로 Collections.sort 메소드가 다음과 같으니,
	public static <T> void sort(List<T> list, Comparator<? super T> c)
다음 문장을 메소드 참조 기반으로 수정한다고 생각하면 편하다.
	Comparator<? super T> c = (s1, s2) -> s1.compareToIgnoreCase(s2)
*/