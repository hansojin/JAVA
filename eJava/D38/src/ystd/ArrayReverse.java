package ystd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrayReverse {
	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,3,5,7,9);
		arr=new ArrayList<>(arr);
		
		Consumer<List<Integer>> c = Collections::reverse;
		c.accept(arr);
		System.out.println(arr);
	}
}
