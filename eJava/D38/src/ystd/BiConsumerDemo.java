package ystd;

import java.util.function.BiConsumer;

class Box<T>{
	private T ob;
	public void set(T o) { 
		ob = o;
	}
	public T get() { 
		return ob;
	}
}

class BiConsumerDemo {
	public static void main(String[] args) {
		BiConsumer<Box<Integer>,Integer> b1 = (b,i) -> b.set(i);
		BiConsumer<Box<Double>,Double> b2 = (b,i) -> b.set(i);

		Box<Integer> bi = new Box<>();
		Box<Double> bd = new Box<>();
		
		b1.accept(bi,525);
		b2.accept(bd, 9.48);
		
		System.out.println(bi.get());
		System.out.println(bd.get());
		
		
	}
}
