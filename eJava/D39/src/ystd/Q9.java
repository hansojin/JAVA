package ystd;

import java.util.Arrays;
import java.util.List;

class Nine<T>{
	private T ob;
	public Nine(T o) { ob = o; }
	public T get() { return ob; }
}

public class Q9 {
	public static void main(String[] args) {
		List<Nine<String>> ls = Arrays.asList(new Nine<>("Robot"), new Nine<>("Simple"));
		// 이 위치에 스트림의 생성 및 맵핑 연산을 진행하는 문장 구성
		ls.stream().mapToInt(n->n.get().length()).forEach(System.out::println);
	}
}

