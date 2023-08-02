class Q18{
	//Member Call
	int iv = 10;
	static int cv = 20;

	int iv2 = cv;
	// static int cv2 = iv; // A 라인 -> static은 인스턴스 변수를 참조할수 없음

	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv); // B 라인 -> static method안에는 static 변수만 가능
	}

	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv); // C 라인
	}

	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1(); // D 라인 -> static method 안에서 call 하는 
		//			        method가 non static임
	}

	void instanceMethod2() {
		staticMethod1(); // E 라인
		instanceMethod1();
	}
}