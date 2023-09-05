package lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class SLenComp implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
}

class SLenComparator {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Robot");
		list.add("Lambda");
		list.add("Box");

		Collections.sort(list, new SLenComp());    // 정렬

		for(String s : list)
			System.out.println(s);
	}
}


/*
	인스턴스보다 기능 하나가 필요한 상황을 위한 람다
	Comparator<T> 인터페이스의 구현이 필요한 상황을 그 예로 들 수 있는데, 이와 관련하여 위의 예제를 보자.
	위 예제에서 Collections.sort 메소드를 호출하면서 두 번째 인자로 정렬의 기준을 갖고 있는 인스턴스를 생성해서 전달하고 있다. 인스턴스를 전달하는 형태이지만 내용을 보면 메소드, 즉 기능을 전달하는 것에 해당한다.
 */