package ystd;

import java.util.Arrays;
import java.util.List;

class Seven<T>{
	private T ob;
	public Seven(T o) { ob = o; }
	public T get() { return ob; }
}

public class Q7 {
	public static void main(String[] args) {
		List<Seven<String>> ls = Arrays.asList(new Seven<>("Robot"), new Seven<>("Simple"));
		// 이 위치에 스트림의 생성 및 맵핑 연산을 진행하는 문장 구성
		ls.stream().map(n->n.get()).forEach(System.out::println);
	}
}

