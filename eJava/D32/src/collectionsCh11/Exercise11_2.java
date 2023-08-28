package collectionsCh11;

import java.util.*;
class Exercise11_2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		HashSet<Integer> set = new HashSet<>(list);
		TreeSet<Integer> tset = new TreeSet<>(set);
		Stack<Integer> stack = new Stack<>();
		stack.addAll(tset);	// 2 3 6 7
		while(!stack.empty())
			System.out.println(stack.pop());	// 7 6 3 2
	}
}