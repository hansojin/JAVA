package ystd;

interface Prlntable {
	void print(String s);
}

//class Prlnter implements Prlntable {
//	public void print(String s) {
//		System.out.println(s);
//	}
//}

class Lambda1 {
	public static void main(String[] args) {
		//        Prlntable prn = new Prlnter();.
		Prlntable prn = new Prlntable() {
			public void print(String s) {
				System.out.println(s);
			}
		};
		prn.print("What is Lambda?");
		
		Prlntable prn2 = s -> System.out.println(s);
		prn2.print("What is Lambda2?");
	}
}