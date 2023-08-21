package generic5;

class Box6<T> {
	private T ob;     
	public void set(T o) { ob = o; }
	public T get() { return ob; }
}

class Toy6 {
	@Override 
	public String toString() { 
		return "Toy6";
	}
}

class Box6Handler {
	public static void outBox6(Box6<? extends Toy6> Box6) {
		Toy6 t = Box6.get();    // 박스에서 꺼내기
		System.out.println(t);
	}

	public static void inBox6(Box6<? super Toy6> Box6, Toy6 n) {
		Box6.set(n);    // 박스에 넣기
	} 
}

class BoundedWildcardUsage2 {
	public static void main(String[] args) {
		Box6<Toy6> Box6 = new Box6<>();
		Box6Handler.inBox6(Box6, new Toy6());
		Box6Handler.outBox6(Box6); 
	}
}