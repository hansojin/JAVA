package collections;

class Box<T>{
	T item;
	Box<T> nxt;
	
	public void store(T item) {
		this.item = item;
	}
	public T pull() {
		return item;
	}
}

class Q16 {
	public static void main(String[] args) {
		Box<String> head = new Box<>();
		head.store("first");
		
		head.nxt=new Box<>();
		head.nxt.store("second");
		head.nxt.nxt=new Box<>();
		head.nxt.nxt.store("third");
		
		Box<String> tmp= head;
		System.out.println(tmp.pull());
		tmp= head.nxt;
		System.out.println(tmp.pull());
		tmp=head.nxt.nxt;
		System.out.println(tmp.pull());
		
	}

}
