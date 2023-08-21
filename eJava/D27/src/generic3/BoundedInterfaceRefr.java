package generic3;

interface Eatable {
	public String eat();    
}

class Banana implements Eatable {
	public String toString() {
		return "I am an Banana.";
	}

	@Override
	public String eat() {
		return "Banana is long.";
	}
}

class Refr<T extends Eatable> {
	private T ob;

	public void set(T o) {
		ob = o;
	}

	public T get() {
		System.out.println(ob.eat());	
		return ob;
	}    
}

class BoundedInterfaceRefr {
	public static void main(String[] args) {
		Refr<Banana> Refr = new Refr<>();
		Refr.set(new Banana());		

		Banana ban = Refr.get();		
		System.out.println(ban);
	}
}
