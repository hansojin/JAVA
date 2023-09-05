package ystd;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

class PredicateDemo2 {
	public static int sum(IntPredicate p, List<Integer> lst) {
		int summ=0;
		for (int n : lst) {
			if (p.test(n))
				summ+=n;
		}
		return summ;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);

		int s;
		s = sum(n->n%2==0, list);
		System.out.println("짝수 합: " + s);

		s = sum(n->n%2!=0, list);
		System.out.println("홀수 합: " + s);

	}
}
