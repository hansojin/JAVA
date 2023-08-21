package generic4;

class BBox<L, R>{
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


class Q2 {

	public static void main(String[] args) {
		BBox<String, Integer> box1 = new BBox<>();
		box1.set("Apple",25);
		BBox<String, Integer> box2 = new BBox<>();
		box2.set("Orange",33);
		BBox<BBox<String, Integer>, BBox<String, Integer>> dbBox = new BBox<>();
		dbBox.set(box1, box2);	
		System.out.println(dbBox);	
	}
}
