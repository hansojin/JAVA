package collections;

import java.util.ArrayList;

public class Q13 {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.ensureCapacity(500);
		al.ensureCapacity(al.size()*2);
	}
}
