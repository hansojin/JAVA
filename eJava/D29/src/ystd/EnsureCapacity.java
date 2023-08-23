package ystd;

import java.util.ArrayList;

class EnsureCapacity {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.ensureCapacity(500);
		al.ensureCapacity(al.size()*2);
	}
}
