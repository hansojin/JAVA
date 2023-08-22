package ystd;

class Dox<T> {
	private T ob;     
	public void set(T o) { 
		ob = o; 
	}
	public T get() {
		return ob; 
	}
}

class Q7 {
//	public static void addDob(Dox<Integer> b1,Dox<Integer> b2,Dox<Integer> b3 )
	public static void addDox(Dox<? super Integer> b1, Dox<? extends Integer> b2, Dox<? extends Integer> b3) {
		b1.set(b2.get() + b3.get());	// 프로그래머의 실수가 있는 부분 _ result.get()시 0 이 출력
		// 받는 곳은 하한 제한, 나머지에는 상한 제한을 해서 실수가 인지되도록
	}

	public static void main(String[] args) {
		Dox<Integer> Dox1 = new Dox<>();
		Dox1.set(24);
		Dox<Integer> Dox2 = new Dox<>();
		Dox2.set(37);        
		Dox<Integer> result = new Dox<>();
		result.set(0);

		addDox(result, Dox1, Dox2);    	// result에 24 + 37의 결과 저장     
		System.out.println(result.get());    // 61 출력 
	}
}

