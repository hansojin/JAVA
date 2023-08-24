package collections;

import java.util.HashSet;

class Num {
	private int num;
	
	public Num(int n) {
		num = n;
	}
	@Override
	public String toString() {
		return String.valueOf(num);
	}
}

class HashSetEqualityOne {
	public static void main(String[] args) {    
		HashSet<Num> set = new HashSet<>();
		set.add(new Num(7799));
		set.add(new Num(9955));
		set.add(new Num(7799));
		// set.add(7799); XXX
		// The method add(Num) in the type HashSet<Num> is not applicable for the arguments (int)

		System.out.println("인스턴스 수: " + set.size());

		for(Num n : set)
			System.out.print(n.toString() + '\t');

		System.out.println();
	}
}


/*
실행결과
인스턴스 수: 3
7799	7799	9955	
 */
