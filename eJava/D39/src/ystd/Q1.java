package ystd;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		int[] ar = {1, 2, 3, 4, 5};
		int summ= Arrays.stream(ar).filter(n->n%2==1).sum();
		System.out.println(summ);
	}
}
