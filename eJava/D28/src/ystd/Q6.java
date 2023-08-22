package ystd;

class Box<T> {
    private T ob;
    
    public void set(T o) { 
        ob = o; 
    }
    
    public T get() { 
        return ob; 
    }
}

class Q6{
	// 이 위치에 swapBox 메소드 정의하자.
	public static <T> void swapBox(Box<T> b, Box<T> x) {
		T tmp = b.get();
		b.set(x.get());
		x.set(tmp);
	}

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>();
        box1.set(99);

        Box<Integer> box2 = new Box<>();
        box2.set(55);

        System.out.println(box1.get() + " & " + box2.get());
        swapBox(box1, box2);	// 정의해야 할 swapBox 메소드
        System.out.println(box1.get() + " & " + box2.get());
    }
}
