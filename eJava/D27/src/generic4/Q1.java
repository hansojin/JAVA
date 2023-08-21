package generic4;

class DBox<L, R>{
	private L left;
	private R right;
	public void set(L o, R r) {
		left = o;
		right = r;
	}
	public String toString() { 
		return left + " & " + right; 
	}
}

class DDBox<T,U>{
	private T box1;
	private U box2;
	
	public void set(T box1, U box2) {
		this.box1=(T)box1;
		this.box2=(U)box2;
	}
	public String toString() { 
		return box1.toString() + " \n" + box2.toString(); 
	}
	
}

class Q1 {

	public static void main(String[] args) {
		DBox<String, Integer> box1 = new DBox<>();
		box1.set("Apple", 25);
		DBox<String, Integer> box2 = new DBox<>();
		box2.set("Orange", 33);
		DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
		ddbox.set(box1, box2);	
		System.out.println(ddbox);	
	}
}
