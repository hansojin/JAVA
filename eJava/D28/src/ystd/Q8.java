package ystd;

class Rox<T> {
	private T ob;     
	public void set(T o) { ob = o; }
	public T get() { return ob; }
}

class Q8 {
	// Rox에 con과 동일한 내용물이 들었는지 확인
//	public static <T> boolean compRox(Rox<T> Rox, T con) {
	public static <T> boolean compRox(Rox<? extends T> Rox, T con) {
		T bc = Rox.get();
//		Rox.set(con);		// 프로그래머의 실수로 삽입된 문장, 때문에 내용물이 바뀐다.
		return bc.equals(con);
	}

	public static void main(String[] args) {
		Rox<Integer> Rox1 = new Rox<>();
		Rox1.set(24);

		Rox<String> Rox2 = new Rox<>();
		Rox2.set("Poly");

		if(compRox(Rox1, 25))
			System.out.println("상자 안에 25 저장");

		if(compRox(Rox2, "Moly"))
			System.out.println("상자 안에 Moly 저장");

		System.out.println(Rox1.get());
		System.out.println(Rox2.get());
	}
}